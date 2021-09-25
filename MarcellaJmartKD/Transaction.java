package MarcellaJmartKD;
 
public class Transaction {
    
    enum Rating {
        NONE,
        BAD,
        NEUTRAL,
        GOOD
    }
    
    public String time = "Time";
    public int buyerId;
    public int storeId;
    public int id;
    public Rating rating = Rating.NONE;
    
   
    
}
    
   
