package org.example.models;

public class Client {
    private int id;
    private String name;
    private double basicDiscount;
    private double volumeDiscountAbove10k;
    private double volumeDiscountAbove30k;

    public Client() {

    }

    public Client(int id, String name, double basicDiscount, double volumeDiscountAbove10k, double volumeDiscountAbove30k) {
        this.id = id;
        this.name = name;
        this.basicDiscount = basicDiscount;
        this.volumeDiscountAbove10k = volumeDiscountAbove10k;
        this.volumeDiscountAbove30k = volumeDiscountAbove30k;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getBasicDiscount() {
        return basicDiscount;
    }

    public void setBasicDiscount(double basicDiscount) {
        this.basicDiscount = basicDiscount;
    }

    public double getVolumeDiscountAbove10k() {
        return volumeDiscountAbove10k;
    }

    public void setVolumeDiscountAbove10k(double volumeDiscountAbove10k) {
        this.volumeDiscountAbove10k = volumeDiscountAbove10k;
    }

    public double getVolumeDiscountAbove30k() {
        return volumeDiscountAbove30k;
    }

    public void setVolumeDiscountAbove30k(double volumeDiscountAbove30k) {
        this.volumeDiscountAbove30k = volumeDiscountAbove30k;
    }
}
