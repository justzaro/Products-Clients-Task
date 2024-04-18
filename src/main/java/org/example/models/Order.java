package org.example.models;

import java.util.HashMap;
import java.util.Map;

public class Order {
    private Client client;
    private Map<Product, Integer> products = new HashMap<>();

    public Order() {

    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Map<Product, Integer> getProducts() {
        return products;
    }

    public void setProducts(Map<Product, Integer> products) {
        this.products = products;
    }

    // Methods to add products, calculate prices, and discounts
    public void addProduct(Product product, int quantity) {
        products.put(product, quantity);
    }

//    public double calculateTotalBeforeDiscounts() {
//        double total = 0.0;
//        for (Map.Entry<Product, Integer> entry : products.entrySet()) {
//            Product product = entry.getKey();
//            int quantity = entry.getValue();
//            double unitPrice = calculateUnitPrice(product);
//            total += unitPrice * quantity;
//        }
//        return total;
//    }

//    public double calculateDiscount() {
//        double totalBeforeDiscounts = calculateTotalBeforeDiscounts();
//        double discount = 0.0;
//        if (totalBeforeDiscounts > 10000) {
//            discount += client.getVolumeDiscountAbove10k() * totalBeforeDiscounts;
//        }
//        if (totalBeforeDiscounts > 30000) {
//            discount += client.getVolumeDiscountAbove30k() * totalBeforeDiscounts;
//        }
//        return discount;
//    }


    @Override
    public String toString() {
        return "Order{" +
                "client=" + client.getId() + " -> " + client.getName() +
                ", products=" + products +
                '}';
    }
}
