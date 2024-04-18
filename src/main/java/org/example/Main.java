package org.example;

import org.example.models.Client;
import org.example.models.Order;
import org.example.models.PricingInfo;
import org.example.models.Product;
import org.example.service.ClientService;
import org.example.service.OrderService;
import org.example.service.ProductService;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        //<--- LOADING WITH HARDCODED DATA --->
        //ClientService clientService = new ClientService(getInitialClients());
        //ProductService productService = new ProductService(getInitialProducts());
        //<----------------------------------->

        ClientService clientService = new ClientService();
        ProductService productService = new ProductService();

        Map<Integer, Client> clientsFromFile = new HashMap<>();
        Map<Integer, Product> productsFromFile = new HashMap<>();

        try {
            clientsFromFile = clientService.getClientsFromFile("D:\\Java Projects\\Exercising\\src\\clients.txt");
            productsFromFile = productService.getProductsFromFile("D:\\Java Projects\\Exercising\\src\\products.txt");
        } catch (IOException e) {
            e.printStackTrace();
        }

        //<--- LOADING WITH DATA FROM FILE --->
        clientService.setClients(clientsFromFile);
        productService.setProducts(productsFromFile);
        //<----------------------------------->

        String input = "5,1=10000,4=20000";
        String[] orderDetails = input.split(",");

        int clientId = Integer.parseInt(orderDetails[0]);

        Order order = new Order();
        order.setClient(clientService.findClientById(clientId));

        for (int i = 1; i < orderDetails.length; i++) {
            String[] itemDetails = orderDetails[i].split("=");
            int productId = Integer.parseInt(itemDetails[0]);
            int quantity = Integer.parseInt(itemDetails[1]);
            Product product = productService.findProductById(productId);
            order.addProduct(product, quantity);
        }

        OrderService orderService = new OrderService(order.getProducts());

        orderService.calculateLineTotal(order);
    }

    public static Map<Integer, Client> getInitialClients() {
        Map<Integer, Client> clients = new HashMap<>();

        Client client1 = new Client(1, "ABC Distribution", 0.05, 0.0, 0.02);
        Client client2 = new Client(2, "DEF Foods", 0.04, 0.01, 0.02);
        Client client3 = new Client(3, "GHI Trade", 0.03, 0.01, 0.03);
        Client client4 = new Client(4, "JKL Kiosks", 0.02, 0.03, 0.05);
        Client client5 = new Client(5, "MNO Vending", 0.0, 0.05, 0.07);

        clients.put(client1.getId(), client1);
        clients.put(client2.getId(), client2);
        clients.put(client3.getId(), client3);
        clients.put(client4.getId(), client4);
        clients.put(client5.getId(), client5);

        return clients;
    }

    public static Map<Integer, Product> getInitialProducts() {

        PricingInfo pricingInfo1 = new PricingInfo(0.52, true, 0.80, false, 0.0);
        PricingInfo pricingInfo2 = new PricingInfo(0.38, true, 1.20, true, 0.30);
        PricingInfo pricingInfo3 = new PricingInfo(0.41, false, 0.90, false, 0.0);
        PricingInfo pricingInfo4 = new PricingInfo(0.60, false, 1.00, true, 0.66);

        Product product1 = new Product(1, "Danish Muffin", pricingInfo1);
        Product product2 = new Product(2, "Granny’s Cup Cake", pricingInfo2);
        Product product3 = new Product(3, "Frenchy’s Croissant", pricingInfo3);
        Product product4 = new Product(4, "Crispy Chips", pricingInfo4);

        Map<Integer, Product> products = new HashMap<>();

        products.put(product1.getId(), product1);
        products.put(product2.getId(), product2);
        products.put(product3.getId(), product3);
        products.put(product4.getId(), product4);

        return products;
    }
}