package MarcellaJmartKD;

import java.util.Date;
import java.util.ArrayList;
 
/**
 * Write a description of class Invoice here.
 *
 * @author Marcella Cinninthya Putri
 * @version (27/09/2021)
 */

public abstract class Invoice extends Serializable 
{
    public enum Status
    {
        WAITING_CONFIRMATION,
        CANCELLED,
        ON_PROGRESS,
        ON_DELIVERY,
        COMPLAINT,
        FINISHED,
        FAILED
    }

    public enum Rating
    {
        NONE,
        BAD,
        NEUTRAL,
        GOOD
    }
    
    public Date date;
    public int buyerId;
    public int productId;
    public int complaintId;
    public Rating rating;
    public Status status;
    //public ArrayList<Record> history = new ArrayList<Record>();
    
    class Record
    {
        public Status status;
        public String message;
        public Date date;
    }
    
    protected Invoice(int buyerId, int productId)
    {
        this.buyerId = buyerId;
        this.productId = productId;
        this.date = new Date();
        this.rating = Rating.NONE;
        this.complaintId = -1;
    }

    public abstract double getTotalPay(Product product);
}
    
  