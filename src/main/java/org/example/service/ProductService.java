package org.example.service;

import org.example.exceptions.NoProductWithGivenIdException;
import org.example.models.Client;
import org.example.models.PricingInfo;
import org.example.models.Product;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.example.common.ExceptionMessages.*;


public class ProductService {
    private Map<Integer, Product> products;

    public ProductService() {
        this.products = new HashMap<>();
    }

    public ProductService(Map<Integer, Product> products) {
        this.products = products;
    }

    public Map<Integer, Product> getProducts() {
        return products;
    }

    public void setProducts(Map<Integer, Product> products) {
        this.products = products;
    }

    public void addProducts(Map<Integer, Product> products) {
        this.products.putAll(products);
    }

    public void addProduct(Product product) {
        products.put(product.getId(), product);
    }

    public Product findProductById(Integer id) {
        Product product = products.get(id);

        if(product == null) {
            throw new NoProductWithGivenIdException(NO_PRODUCT_WITH_GIVEN_ID);
        }

        return product;
    }

    public Map<Integer, Product> getProductsFromFile(String filename) throws IOException {
        Map<Integer, Product> products = new HashMap<>();

        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;
            String section = "";

            while ((line = br.readLine()) != null) {
                if (line.equals("Products")) {
                    section = "Products";
                    continue;
                }

                if (section.equals("Products")) {
                    String[] parts = line.split(";");

                    int id = Integer.parseInt(parts[0]);
                    String name = parts[1];
                    double unitCost = Double.parseDouble(parts[2]);
                    boolean isMarkupPercentage = Boolean.parseBoolean(parts[3]);
                    double markupValue = Double.parseDouble(parts[4]);
                    boolean isPromotionPercentage = Boolean.parseBoolean(parts[5]);
                    double promotionValue = Double.parseDouble(parts[6]);

                    PricingInfo pricingInfo = new PricingInfo(unitCost, isMarkupPercentage, markupValue, isPromotionPercentage, promotionValue);
                    Product product = new Product(id, name, pricingInfo);
                    products.put(id, product);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return products;
    }
}
