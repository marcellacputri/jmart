package MarcellaJmartKD;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
 
public abstract class Invoice extends Recognizable implements FileParser
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
    public ArrayList<Record> history = new ArrayList<Record>();
    
    class Record
    {
        public Status status;
        public String message;
        public Date date;
    }
    
    protected Invoice(int id, int buyerId, int productId)
    {
        super(id);
        this.buyerId = buyerId;
        this.productId = productId;
        this.date = new Date();
        this.rating = Rating.NONE;
        this.status = status.WAITING_CONFIRMATION;
    }

    public double getTotalPay()
    {
        return 0.0;
    }
    
    @Override
    public boolean read(String content)
    {
        return true;
    }
    
    @Override
    public Object write()
    {
        return null;
    }
}