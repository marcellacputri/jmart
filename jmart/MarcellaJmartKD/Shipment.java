package MarcellaJmartKD;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Shipment implements FileParser
{
    public String address;
    public int shipmentCost;
    public Duration duration;
    public String receipt;
    
    public Shipment(String address, int shipmentCost, Duration duration, String receipt){
        this.address = address;
        this.shipmentCost = shipmentCost;
        this.duration = duration;
        this.receipt = receipt;
    }
    
    public boolean read(String content){
        return false;
    }
    
    public static class Duration
    {
        public static final SimpleDateFormat ESTIMATION_FORMAT = new SimpleDateFormat("E MMMM dd yyyy");
        public static final Duration INSTANT = new Duration((byte)(1 << 0));
        public static final Duration SAME_DAY = new Duration((byte)(1 << 1));
        public static final Duration NEXT_DAY = new Duration((byte)(1 << 2));
        public static final Duration REGULER = new Duration((byte)(1 << 3));
        public static final Duration KARGO = new Duration((byte)(1 << 4));
        public byte bit;

        private Duration(byte bit){
            this.bit = bit;
        }
        
        public String getEstimatedArrival(Date reference){
            Calendar C = Calendar.getInstance();
            C.setTime(reference);
    
            if(bit == Duration.INSTANT.bit || bit == Duration.SAME_DAY.bit){
                C.add(Calendar.DATE, 0);
            }
            else if (bit == Duration.NEXT_DAY.bit){
                C.add(Calendar.DATE, 1);
            }
            else if (bit == Duration.REGULER.bit){
                C.add(Calendar.DATE, 2);
            }
            else if (bit == Duration.KARGO.bit){
                C.add(Calendar.DATE, 5);
            }
            return ESTIMATION_FORMAT.format(C.getTime());
        }
    }
    
    public class MultiDuration{
        public byte bit;
        
        public MultiDuration(Duration... args)
        {
            byte flags = 0;
            for (Duration arg : args) { 
                flags |= arg.bit; 
            }
            this.bit = flags;
        }
        
        public boolean isDuration(Duration reference){
            return (bit & reference.bit) != 0;
        }
    }
}