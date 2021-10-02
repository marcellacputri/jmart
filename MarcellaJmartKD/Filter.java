package MarcellaJmartKD;

import java.util.ArrayList;
public class Filter
{

    public static ArrayList<PriceTag> filterPriceTag(PriceTag[] list, double value, boolean less){
        ArrayList<PriceTag> priceTags = new ArrayList<>();
        for (PriceTag p : list){
            if (less && p.getAdjustedPrice() < value || !less && p.getAdjustedPrice() >= value){
                priceTags.add(p);
            }
        }
        return priceTags;
    }
    
    
    public static void filterProductRating(ArrayList<ProductRating> list, double value, boolean less){
    for (int i=0; i<list.size(); ++i){
        final ProductRating p = list.get(i);
            if (less && p.getAverage()<value || !less && p.getAverage()>= value){
                list.remove(i);
            }
        }
    }
}

