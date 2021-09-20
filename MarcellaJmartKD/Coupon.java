package MarcellaJmartKD;



public class Coupon
{
    public final String name;
    public final int code;
    public final double cut, minimum;
    public final Type type;
    private boolean used;
    
    public enum Type
    {
        DISCOUNT, REBATE;
        }
    
    
    public Coupon (String name, int code, Type type, double cut, double minimum){
        this.name = name;
        this.code = code;
        this.type = type;
        this.cut = cut;
        this.minimum = minimum;
        this.used = used = false;
    }
    
    public boolean isUsed(){
        return used;
    }
    
    public boolean canApply(PriceTag priceTag) {
        if ((priceTag.getAdjustedPrice() >= minimum)  && (used == false)){
            return true;
        }
        else {
            return false;
        }
    }
    
    public double apply (PriceTag priceTag){
       this.used = true;
       
       if (this.type == Type.DISCOUNT){
           return (priceTag.getAdjustedPrice() * ((100 - this.cut)/100));
       }
       else{
           return (priceTag.getAdjustedPrice() - this.cut);
       }
   }
}
    
    
    

