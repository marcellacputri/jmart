package MarcellaJmartKD;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import com.google.gson.*;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import java.util.stream.Collectors;

/**
 * Write a description of class Complaint here.
 *
 * @author (Marcella Cinninthya Putri)
 * @version (11/09/2021)
 */

class Jmart {
	
	public static List<Product> filterByCategory(List<Product> list, ProductCategory category){
        List<Product> products = new ArrayList<>();
        for(Product product : list){
            if(product.category.equals(category)){
                products.add(product);
            }
        }
        return products;
    }
	
	public static List<Product> filterByPrice(List<Product> list, double minPrice, double maxPrice){
        List<Product> products = new ArrayList<>();
        for(int p = 0; p < list.size(); p++){
            if(minPrice <= 0.0){
                if(list.get(p).price <= maxPrice){
                    products.add(list.get(p));
                }
            }else if(maxPrice <= 0.0){
                if(list.get(p).price >= minPrice){
                    products.add(list.get(p));
                }
            }else{
                if(list.get(p).price >= minPrice && list.get(p).price <= maxPrice){
                    products.add(list.get(p));
                }
            }
        }
        return products;
    }
	
	public static List<Product> filterByName(List<Product> list, String search, int page, int pageSize) {
        Predicate<Product> predicate = named -> (named.name.toLowerCase().contains(search.toLowerCase()));
        return paginate(list, page, pageSize, predicate);
    }
	
	public static List<Product> filterByAccountId(List<Product> list, int accountId, int page, int pageSize) {
        Predicate<Product> predicate = acc -> (acc.accountId == accountId);
        return paginate(list, page, pageSize, predicate);
    }
	
	private static List<Product> paginate(List<Product> list, int page, int pageSize, Predicate<Product> pred) {
        if(page < 0){
            page = 0;
        }
        if(pageSize < 0){
            pageSize = 0;
        }
        return list.stream().filter(pagin -> pred.predicate(pagin)).skip(page * pageSize).limit(pageSize).collect(Collectors.toList());
    }
	
	public static List<Product> read(String filepath) throws FileNotFoundException {
        List<Product> products = new ArrayList<>();
        try{
            Gson gson = new Gson();
            JsonReader reader = new JsonReader(new FileReader(filepath));
            reader.beginArray();
            while(reader.hasNext()){
                products.add(gson.fromJson(reader, Product.class));
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return products;
    }
	
	  public static void main(String[] args)
	    {
	        try{
	            List<Product> list = read("D:/jmart/randomProductList.json");
	            List<Product> name = filterByName(list, "Ubuntu", 1, 5);
	            name.forEach(product -> System.out.println(product.name));
	            List<Product> account = filterByAccountId(list, 1, 0, 5);
	            account.forEach(product -> System.out.println(product.name));
	        }catch (Throwable t)
	        {
	            t.printStackTrace();
	        }
	    }
}

	
	
	/*public static void main(String[] args) {
		System.out.println(Shipment.Duration.INSTANT.getEstimatedArrival(new Date()));
		Account account = new Account(01, "Spiderman 007", "spiderman123@gmail.com", "mylovelymj");
		account.validate();
		System.out.print(account);
		Complaint complaint = new Complaint(001, "Kurir salah alamat.");
		System.out.print(complaint);
	}

	/*
	 * public static Product create(){ return new Product("Dilan", 5, false, new
	 * PriceTag(20000L), ProductCategory.BOOK); }
	 * 
	 * 
	 * public static Product createProduct(){ return null; }
	 * 
	 * /*public static Coupon createCoupun(){ Coupon coupon = new Coupon
	 * ("Diskon 5.5 SALE", 1, Coupon.Type.DISCOUNT, 20, 5000); return coupon; }
	 * 
	 * 
	 * public static Coupon createCoupon(){ return null; }
	 * 
	 * public static Shipment.Duration createShipmentDuration() { return null; }
	 */
