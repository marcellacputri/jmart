package MarcellaJmartKD;

/**
 * Write a description of class Payment here.
 *
 * @author (Marcella Cinninthya Putri)
 * @version (26/09/2021)
 */

public class Payment extends Invoice 
{
    public Shipment shipment;
    public int productCount;

    public Payment(int buyerId, int productId, int productCount, Shipment shipment){
        super(buyerId, productId);
        this.productCount = productCount;
        this.shipment = shipment;
    }

    @Override
    public double getTotalPay() {
        return 0.0;
    }
    
    /*@Override
    public boolean validate() {
        return false;
    }
    
    @Override
    public Invoice perform() {
        return null;
    }
    */
    
}
