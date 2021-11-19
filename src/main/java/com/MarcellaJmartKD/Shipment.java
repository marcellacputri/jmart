package com.MarcellaJmartKD;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Write a description of class PriceTag here.
 *
 * @author Marcella Cinninthya Putri
 * @version (27/09/2021)
 */

public class Shipment
{
    public String address;
    public int shipmentCost;
    public byte plan;
    public String receipt;
    
    static class Plan {
    	public final byte bit;
    	private Plan (byte bit) {
    		this.bit = bit;
    	}
    }
    
    public static final SimpleDateFormat ESTIMATION_FORMAT = new SimpleDateFormat("E MMMM dd yyyy");
    public static final Plan INSTANT = new Plan((byte)(1 << 0));
    public static final Plan SAME_DAY = new Plan((byte)(1 << 1));
    public static final Plan NEXT_DAY = new Plan((byte)(1 << 2));
    public static final Plan REGULER = new Plan((byte)(1 << 3));
    public static final Plan KARGO = new Plan((byte)(1 << 4));
    
    public Shipment(String address, int shipmentCost, byte plan, String receipt){
        this.address = address;
        this.shipmentCost = shipmentCost;
        this.plan = plan;
        this.receipt = receipt;
    }
    

    public String getEstimatedArrival(Date reference){
    	if((plan & INSTANT.bit) != 0 || (plan & SAME_DAY.bit) != 0){
            return ESTIMATION_FORMAT.format(reference);
        }
    	else if((plan & NEXT_DAY.bit) != 0){
            return ESTIMATION_FORMAT.format(reference.getDay() + 1);
        }
    	else if((plan & REGULER.bit) != 0){
            return ESTIMATION_FORMAT.format(reference.getDay() + 2);
        }
    	else {
            return ESTIMATION_FORMAT.format(reference.getDay() + 5); //KARGO
        }
    }
    
        
    public boolean isDuration(Plan reference){
    	if((plan & reference.bit) != 0){
            return true;
        }
        else{
            return false;
        }
    }

        public static boolean isDuration(byte object, Plan reference)
        {
            if((object & reference.bit) != 0){
                return true;
            }
            else{
                return false;
            }
        }
}
  
