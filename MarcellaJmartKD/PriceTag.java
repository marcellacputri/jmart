package MarcellaJmartKD;

public class PriceTag
{
  public static final double COMMISSION_MULTIPLIER = 0.05d;
  public static final double BOTTOM_PRICE = 20000;
  public static final double BOTTOM_FEE = 1000;
  public 
  double discount, price;
  public PriceTag (double price){
      this.price = price;
  }
  
  public PriceTag (double price, double discount){
      this.price = price;
      this.discount = discount;
  }
  
  private double getDiscountedPrice(){
        if (discount >= 100.0) {
            return 0.0;
       }
        else {
            double priceTotal = price - ((discount/100) * price);
            return priceTotal;
        }
    }       
    
    public double getAdminFee(){
        double discountPrice = getDiscountedPrice();
        if (discountPrice < BOTTOM_PRICE){
            return BOTTOM_FEE;
        }
        else {
            return discountPrice - COMMISSION_MULTIPLIER;
        }
    }
    
    public double getAdjustedPrice (){
        double adjustedPrice = getDiscountedPrice() + getAdminFee();
        return adjustedPrice;
    }
    
    
    
    
}
