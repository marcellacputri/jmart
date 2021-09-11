package MarcellaJmartKD;

public class Jmart
{
    public static int  getPromo() {
        return 0;
    }
    
    public static String getCustomer() {
        return "oop";
    }
    
    public static float getDiscountPercentage (int before, int after){
        if (before > after){
            float Discount = before-after;
            return Discount;
        }
        else {
            return 0.0f;
        }
    }
    
    public static float getDiscountedPrice (int price, float discountPercentage) {
        if (discountPercentage > 100.0) {
            discountPercentage = 100;
        }
        
        float totalprice = price - (discountPercentage*price /100);
        return price;
    }
}
    
    
