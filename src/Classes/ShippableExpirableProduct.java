package Classes;
import java.util.Date;


public class ShippableExpirableProduct extends ShippableProduct {
    private Date expiryDate;

    public ShippableExpirableProduct(String productName, Double productPrice, int productQuantity, double productWeight, Date expiryDate) {
        super(productName, productPrice, productQuantity, productWeight);
        this.expiryDate = expiryDate;
    }

    public boolean isExpired() {
        return expiryDate.before(new Date());
    }    

    @Override
    public boolean isAvailable(int requiredQuantity) {
        return super.isAvailable(requiredQuantity) && !isExpired();
    }
   
}
