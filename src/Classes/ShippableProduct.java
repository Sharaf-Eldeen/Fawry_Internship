package Classes;

import Interfaces.Shippable;

public class ShippableProduct extends Product implements Shippable  {
    private double weight;

    public ShippableProduct(String productName, Double productPrice, int productQuantity, double productWeight) {
        super(productName, productPrice, productQuantity);
        this.weight = productWeight;
    }

    @Override
    public double getWeight() {
        return weight;
    }

    @Override 
    public String getName() {
        return name;
    }
    
}
