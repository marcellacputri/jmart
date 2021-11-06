package MarcellaJmartKD;

/**
 * Write a description of class PriceTag here.
 *
 * @author Marcella Cinninthya Putri
 * @version (18/09/2021)
 */

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
    
    public double getAverage(){
    	if (count == 0) {
    		return 0;
    	}
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
    
