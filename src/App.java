import Classes.Cart;
import Classes.CheckoutService;
import Classes.Customer;
// import Classes.ExpirableProduct;
// import Classes.Product;
import Classes.ShippableExpirableProduct;
// import Classes.ShippableProduct;
import java.util.Date;


public class App {
    public static void main(String[] args) throws Exception {

        ShippableExpirableProduct cheese = new ShippableExpirableProduct("Cheese", 100.0, 10, 200.0, new Date(System.currentTimeMillis() + 86400000)); 
        ShippableExpirableProduct biscuits = new ShippableExpirableProduct("Biscuits", 150.0, 5, 700.0,new Date(System.currentTimeMillis() + 86400000));

        // ExpirableProduct biscuits = new ExpirableProduct("Biscuits", 150.0, 5, new Date(System.currentTimeMillis() + 86400000));
        // ShippableProduct tv = new ShippableProduct("TV", 200.0, 3, 1500.0);
        // Product scratchCard = new Product("Mobile Scratch Card", 50.0, 20); 

        Customer customer = new Customer("Sharaf", 1000);
        Cart cart = new Cart();

        cart.add(cheese, 2);
        cart.add(biscuits, 1);
        // cart.add(scratchCard, 1);
        // cart.add(tv, 2);

        CheckoutService checkoutService = new CheckoutService();
        checkoutService.checkout(customer, cart);
    }
}
