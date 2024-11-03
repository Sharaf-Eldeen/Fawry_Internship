package Classes;

import java.util.Date;

public class ExpirableProduct extends Product {
    private Date expiryDate;

    public ExpirableProduct(String productName,Double productPrice, int productQuantity, Date productExpiryDate) {
        super(productName, productPrice, productQuantity);
        this.expiryDate = productExpiryDate;

    }

    public boolean isExpired() {
        return expiryDate.before(new Date());
    }    

    @Override
    public boolean isAvailable(int requiredQuantity) {
        return super.isAvailable(requiredQuantity) && !isExpired();
    }
}
