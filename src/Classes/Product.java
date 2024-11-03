package Classes;

public class Product {
    protected String name;
    protected Double price;
    protected int quantity;

    public Product(String productName,Double productPrice, int productQuantity) {
        this.name = productName;
        this.price = productPrice;
        this.quantity = productQuantity;
    }

    public String getName() {
        return name;
    }

    public Double getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setName(String productName) {
        this.name = productName;
    }

    public void setPrice(Double productPrice) {
        this.price = productPrice;
    }

    public void setQuantity(int productQuantity) {
         this.quantity = productQuantity;
    }

    public boolean isAvailable(int requiredQuantity) {
        return quantity >= requiredQuantity;
    }

    public double getTotalPrice(int quantity) {
        return quantity * price ;
    }

    public void reduceQuantity(int Requestedquantity) {
        this.quantity = quantity - Requestedquantity;
    }

}
