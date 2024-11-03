package Classes;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ShippingService {

    private double getTotalWeight(List<ShippableProduct> items) {
        double totalWeight = 0;

        for (int i = 0; i < items.size(); i++) {
            totalWeight += (items.get(i).getWeight());
        }

        return (totalWeight / 1000);
    }


    public double calculateShippingFees(List<ShippableProduct> items) {
        double shippingFees = 0;

        for (int i = 0; i < items.size(); i++) {
            shippingFees += (items.get(i).getWeight()) * 0.0272727273;
        }

        return shippingFees;
    }

    
    public void printShipmentNotice(List<ShippableProduct> items) {
        Map<String, Integer> quantityMap = new HashMap<>();
        Map<String, Double> weightMap = new HashMap<>();

    for (ShippableProduct item : items) {
        String itemName = item.getName();
        quantityMap.put(itemName, quantityMap.getOrDefault(itemName, 0) + 1);
        weightMap.put(itemName, item.getWeight());
    }

    System.out.println("** Shipment notice **");
    
    quantityMap.forEach((name, quantity) -> {
        double weight = weightMap.get(name);
        System.out.println(quantity + "x " + name + " " + (weight * quantity) + "g");
    });

    System.out.println("Total package weight " + getTotalWeight(items) + "kg");
    }
    
}
