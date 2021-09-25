package MarcellaJmartKD;

public class ProductRating
{
    private long total, count;
    
    public ProductRating(){
        this.total = 0;
        this.count = 0;
    }
    
    public void insert (int rating){
        total = rating + total;
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
    
