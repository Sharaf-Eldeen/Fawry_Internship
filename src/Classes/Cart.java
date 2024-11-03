package Classes;

import java.util.ArrayList;
import java.util.List;

public class Cart {
    private List<CartItem> items = new ArrayList<>();

    public void add(Product product, int quantity) throws Exception {

        if(!product.isAvailable(quantity)) {
            throw new Exception (product.getName() + " out of stock.");
        }

        if(product instanceof ExpirableProduct && ((ExpirableProduct) product).isExpired()) {
            throw new Exception(product.getName() + " is expired.");
        }

        items.add(new CartItem(product, quantity));
        product.reduceQuantity(quantity);
    }

    public boolean isEmpty() {
        return items.isEmpty();
    }

    public double calculateSubTotal() {
        double subTotal = 0;

        for (int i = 0; i < items.size(); i++) {
            subTotal += items.get(i).getTotalItemPrice();
        }

        return subTotal;
    }

    public List<ShippableProduct> getShippableItems() {

        List<ShippableProduct> shippableItems = new ArrayList<>();

        for (CartItem item : items) {

            if(item.isShipple()) {
                for(int i = 0; i < item.getQuantity(); i++) {
                    shippableItems.add((ShippableProduct) item.getProduct());
                }
            }
          }

        return shippableItems;

    }

    public List<CartItem> getCartItems() {
        return items;
    }
    
    
}
