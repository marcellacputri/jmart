package MarcellaJmartKD; 
import java.text.SimpleDateFormat;
import java.util.Date;

public class Jmart
{
    public void main (String[] args){
        System.out.println(Shipment.Duration.INSTANT.getEstimatedArrival(new Date())); 
    }
    
    //public static Product create(){
        //return new Product("Dilan", 5, false, new PriceTag(20000L), ProductCategory.BOOK);
    //}
    
    public static Product createProduct(){
        return null;   
    }
    
    /*public static Coupon createCoupun(){
        Coupon coupon = new Coupon ("Diskon 5.5 SALE", 1, Coupon.Type.DISCOUNT, 20, 5000);
        return coupon;
    }
    */
   
   
    public static Coupon createCoupon(){
        return null;
    }
    
    public static Shipment.Duration createShipmentDuration(){
        return null;
    }
}

        
     
    
