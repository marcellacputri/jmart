package com.MarcellaJmartKD;

/**
 * Write a description of class PriceTag here.
 *
 * @author Marcella Cinninthya Putri
 * @version (20/09/2021)
 */

public class Coupon extends Serializable {
    public final String name;
    public final int code;
    public final double cut, minimum;
    public final Type type;
    private boolean used;
    
    public enum Type
    {
        DISCOUNT, REBATE;
     }
    
    public Coupon(String name, int code, Type type, double cut, double minimum){
        this.name = name;
        this.code = code;
        this.type = type;
        this.cut = cut;
        this.minimum = minimum;
        this.used = false;
   }
        
    public boolean canApply(double price, double discount) {
        if ((Treasury.getAdjustedPrice(price, discount) >= minimum)  && (used == false)){
            return true;
        }
        else {
            return false;
        }
    }
    
    public double apply(double price, double discount){
       used = true;
       if (type == Type.DISCOUNT){
           if (cut >= 100){
               return (Treasury.getAdjustedPrice(price, discount) - Treasury.getAdjustedPrice(price, discount)* (100/100));
            }
            else if (cut <= 0){
               return (Treasury.getAdjustedPrice(price, discount) - Treasury.getAdjustedPrice(price, discount) * 0/100);
            }
            else {
                return (Treasury.getAdjustedPrice(price, discount) - Treasury.getAdjustedPrice(price, discount) * cut/100);
            }
        }
       return (Treasury.getAdjustedPrice(price,cut) - cut);
       }
    
    public boolean isUsed() {
        return used;
    }
}
   

    
    
    

