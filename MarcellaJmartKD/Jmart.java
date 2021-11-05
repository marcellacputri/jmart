package MarcellaJmartKD;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import com.google.gson.*;

class Jmart {
	class Country{
		public String name;
		public int population;
		public List<String> listOfStates;
	}
	
	public static void main (String[] args) {
		String filepath = "D:/jmart/city.json";
		Gson gson = new Gson();
		try {
			BufferedReader br = new BufferedReader (new FileReader (filepath));
			Country input = gson.fromJson(br, Country.class);
			System.out.println("name: " + input.name);
			System.out.println("population: " + input.population);
			System.out.println("states: ");
			input.listOfStates.forEach(state -> System.out.println(state));
		}
		catch (IOException e) {
			e.printStackTrace();
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
