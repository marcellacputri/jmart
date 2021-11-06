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
        for(int a = 0; a < list.size(); a++){
            if(minPrice <= 0.0){
                if(list.get(a).price <= maxPrice){
                    products.add(list.get(a));
                }
            }else if(maxPrice <= 0.0){
                if(list.get(a).price >= minPrice){
                    products.add(list.get(a));
                }
            }else{
                if(list.get(a).price >= minPrice && list.get(a).price <= maxPrice){
                    products.add(list.get(a));
                }
            }
        }
        return products;
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
	            // sesuaikan argument method read sesuai dengan lokasi resource
	            List<Product> list = read("C:/Users/Samuel/Desktop/OOP Git/jmart/src/randomProductList.json");
	            List<Product> filtered = filterByPrice(list, 20000.0, 25000.0);
	            filtered.forEach(product -> System.out.println(product.price));
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
