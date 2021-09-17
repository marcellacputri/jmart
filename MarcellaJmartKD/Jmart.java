package MarcellaJmartKD; 

public class Jmart
{
    public static void main (String[] args){
        
    }
    
    public static int  getPromo() {
        return 0;
    }
    
    public static String getCustomer() {
        return "oop";
    }
    
    public static float getDiscountPercentage (int before, int after){
	float discountPercentage;
        if (before > after){
            float discount = before-after;
            return discountPercentage = (discount / before) *100;
        }
        else {
            return 0.0f;
        }
    }
    
    public static int getDiscountedPrice (int price, float discountPercentage) {
        if (discountPercentage > 100.0f) {
            discountPercentage = 100;
        }
        
        float discountedPrice = price - ((discountPercentage/100) * price);
        return (int) discountedPrice;

    }
    
    public static int getOriginalPrice (int discountedPrice, float discountPercentage){       
        float originalPrice = (discountedPrice * 100)/ (100 - discountPercentage);
        return (int) originalPrice;
    }
    
    public static float getCommissionMultiplier (){
        return 0.05f;
    }
    
    public static int getAdjustedPrice (int price) {
        float priceFloat = price + (price * getCommissionMultiplier());
        int priceInt = (int) priceFloat;
        return priceInt;
    }
     
    public static int getAdminFee (int price){
        float adminFee = price * getCommissionMultiplier();
        return (int) adminFee;
    }
    
    

}
    
    
