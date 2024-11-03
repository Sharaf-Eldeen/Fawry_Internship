package Classes;

import java.text.DecimalFormat;
import java.util.List;

public class CheckoutService {
    private ShippingService shippingService = new ShippingService();

    public void checkout(Customer customer, Cart cart) throws Exception {
        if(cart.isEmpty()) throw new Exception("Cart is empty.");

        double subTotal = cart.calculateSubTotal();
        List<ShippableProduct> shippableItems = cart.getShippableItems();
        double shippingFees = shippingService.calculateShippingFees(shippableItems);
        double total = subTotal + shippingFees;

        if(!customer.canAfford(total)) throw new Exception("Insufficient balance.");
        customer.deductBalance(total);

        shippingService.printShipmentNotice(shippableItems);
        System.out.println();
        System.out.println("** Checkout receipt **");
        cart.getCartItems().forEach(item -> System.out.println(item.getQuantity() + "x " + item.getProduct().getName() + " " + item.getProduct().price * item.getQuantity()));
        DecimalFormat df = new DecimalFormat("0.00");
        System.out.println("----------------------");
        System.out.println("Subtotal         " + df.format(subTotal));
        System.out.println("Shipping         " + df.format(shippingFees));
        System.out.println("Amount           " + df.format(total));
    }
    
}
