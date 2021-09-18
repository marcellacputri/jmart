package MarcellaJmartKD;

public class ProductRating
{
    private long total, count;
    
    public ProductRating(){
        long total;
        count = 0;
    }
    
    public void insert (int rating){
        long totalInsert = rating + total;
        count++;
    }
    
    public double getAverage (){
        double ratingAvg;
        return ratingAvg = total/count;
    }
    
    public long getCount(){
        return count;
    }
    
    public long getTotal(){
        return total;
    }
}
    
