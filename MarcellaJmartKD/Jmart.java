package MarcellaJmartKD; 

public class Jmart
{
 
    //public static void main(String[] args){
        //System.out.println(create());
    //}
    

    //public static Product create(){
        //return new Product("Dilan", 5, false, new PriceTag(20000L), ProductCategory.BOOK);
    //}
    
    public static void main (String[] args){
    }
    
    public static Product createProduct(){
        PriceTag priceTag = new PriceTag(10000);
        Product product = new Product("PISAU", 2, false, priceTag, ProductCategory.KITCHEN);
        return product;
    }
    
    public static Coupon createCoupun(){
        Coupon coupon = new Coupon ("Diskon 5.5 SALE", 1, Coupon.Type.DISCOUNT, 20, 5000);
        return coupon;
    }
    
    public static ShipmentDuration createShipmentDuration(){
        return new ShipmentDuration(ShipmentDuration.REGULER, ShipmentDuration.SAME_DAY);
    }
}
        
     
    
