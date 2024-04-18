package org.example.service;

import org.example.exceptions.NoClientWithGivenIdException;
import org.example.models.Client;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.example.common.ExceptionMessages.*;

public class ClientService {
    private Map<Integer, Client> clients;

    public ClientService() {
        this.clients = new HashMap<>();
    }

    public ClientService(Map<Integer, Client> clients) {
        this.clients = clients;
    }

    public void setClients(Map<Integer, Client> clients) {
        this.clients = clients;
    }

    public void addClient(Client client) {
        this.clients.put(client.getId(), client);
    }

    public Client findClientById(Integer id) {
        Client client = clients.get(id);

        if (client == null) {
            throw new NoClientWithGivenIdException(NO_CLIENT_WITH_GIVEN_ID);
        }

        return client;
    }

    public Map<Integer, Client> getClientsFromFile(String filename) throws IOException {
        Map<Integer, Client> clients = new HashMap<>();

        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;
            String section = "";

            while ((line = br.readLine()) != null) {
                if (line.equals("Clients")) {
                    section = "Clients";
                    continue;
                }

                if (section.equals("Clients")) {
                    String[] parts = line.split(";");
                    int id = Integer.parseInt(parts[0]);
                    String name = parts[1];
                    double basicDiscount = Double.parseDouble(parts[2]);
                    double volumeDiscountAbove10k = Double.parseDouble(parts[3]);
                    double volumeDiscountAbove30k = Double.parseDouble(parts[4]);
                    Client client = new Client(id, name, basicDiscount, volumeDiscountAbove10k, volumeDiscountAbove30k);
                    clients.put(id, client);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return clients;
    }

}
