package org.example.service;

import org.example.models.Client;
import org.example.models.Order;
import org.example.models.PricingInfo;
import org.example.models.Product;

import java.util.HashMap;
import java.util.Map;

public class OrderService {
    private Map<Product, Integer> products;

    public OrderService() {
        products = new HashMap<>();
    }

    public OrderService(Map<Product, Integer> products) {
        this.products = products;
    }

    public void calculateLineTotal(Order order) {
        double itemsTotal = 0;
        for (Map.Entry<Product, Integer> entry : products.entrySet()) {
            Product product = entry.getKey();
            PricingInfo pricingInfo = product.getPricingInfo();

            double unitCost;
            double unitCostAfterPromotion;

            if (product.getPricingInfo().isMarkupPercentage()) {
                unitCost = pricingInfo.getUnitCost() + ( (pricingInfo.getUnitCost()) * pricingInfo.getMarkupValue());
            } else {
                unitCost = pricingInfo.getUnitCost() + pricingInfo.getMarkupValue();
            }
            unitCostAfterPromotion = Math.round(unitCost * 100.0) / 100.0;
            if (product.getPricingInfo().isPromotionPercentage()) {
                unitCostAfterPromotion = unitCost * pricingInfo.isPromotionValue();
            }
            itemsTotal += unitCostAfterPromotion * entry.getValue();

            System.out.printf("Client:                       %s\n", order.getClient().getName());
            System.out.printf("Product:                      %s\n", product.getName());
            System.out.printf("Quantity:                     %d\n", entry.getValue());
            System.out.printf("Standard Unit Price:          EUR %.2f\n", unitCost);
            System.out.printf("Promotional Unit Price:       EUR %.2f\n", unitCostAfterPromotion);
            System.out.printf("Line Total:                   EUR %.2f\n\n", itemsTotal);
        }
        calculateOrderTotal(itemsTotal, order);
    }

    public static void calculateOrderTotal(double itemsTotal, Order order) {
        Client client = order.getClient();
        double discount = client.getBasicDiscount();
        double discountAmount;

        if (itemsTotal > 30000) {
            discount += client.getVolumeDiscountAbove30k();
        } else if (itemsTotal > 10000) {
            discount += client.getVolumeDiscountAbove10k();
        }

        discountAmount = itemsTotal * discount;

        System.out.printf("Total Before Client Discounts:               EUR %.2f\n", itemsTotal);
        System.out.printf("Additional Volume Discount at %.0f%%:            EUR %.2f\n", discount * 100, discountAmount);
        System.out.printf("Order Total Amount:                          EUR %.2f\n\n", itemsTotal - discountAmount);
    }
}
