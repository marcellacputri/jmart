package MarcellaJmartKD;

public class Product{
    public int id;
    private static int idCounter = 0;
    public String name;
    public int weight;
    public boolean conditionUsed;
    public PriceTag priceTag;
    public  ProductCategory category;
    public ProductRating rating;
    
    public Product (String name, int weight, boolean conditionUsed, PriceTag priceTag, ProductCategory category){
    this.name = name;
    this.weight = weight;
    this.conditionUsed = conditionUsed;
    this.priceTag = priceTag;
    this.category = category;
    id = idCounter;
    idCounter++;
    }
}

