package MarcellaJmartKD;



public class Coupon extends Recognizable implements FileParser
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
    
    
   public Coupon(int id, String name, int code, Type type, double cut, double minimum){
        super(id);
        this.name = name;
        this.code = code;
        this.type = type;
        this.cut = cut;
        this.minimum = minimum;
        this.used = false;
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
       used = true;
       
       if (type == Type.DISCOUNT){
           if (cut >= 100){
               return (priceTag.getAdjustedPrice() - priceTag.getAdjustedPrice()* (100/100));
            }
            else if (cut <= 0){
               return priceTag.getAdjustedPrice() - priceTag.getAdjustedPrice() * 0/100;
            }
            else {
                return priceTag.getAdjustedPrice() - priceTag.getAdjustedPrice() * cut/100;
            }
        }
        else {
           return (priceTag.getAdjustedPrice() * this.cut / 100);
       }

        }
   
   @Override
   public boolean read(String content){
        return false;
   }
}
    
    
    

