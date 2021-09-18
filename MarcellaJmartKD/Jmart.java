package MarcellaJmartKD; 

public class Jmart
{
 
    public static void main(String[] args){
        System.out.println(create());
    }
    

    public static Product create(){
        return new Product("Dilan", 5, false, new PriceTag(20000L), ProductCategory.BOOK);
    }
}
        
     
    
