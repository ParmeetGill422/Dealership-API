package com.pluralsight.dealership.model;

import java.util.ArrayList;
import java.util.List;

public class Dealership {
    private int id;
    private String name;
    private String location;
    private List<Vehicle> inventory;

    public Dealership() {
        inventory = new ArrayList<>();
    }

    public Dealership(int id, String name, String location) {
        this.id = id;
        this.name = name;
        this.location = location;
        this.inventory = new ArrayList<>();
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

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public List<Vehicle> getInventory() {
        return inventory;
    }

    public void setInventory(List<Vehicle> inventory) {
        this.inventory = inventory;
    }

    public void addVehicle(Vehicle vehicle) {
        inventory.add(vehicle);
    }

    public void removeVehicle(Vehicle vehicle) {
        inventory.remove(vehicle);
    }
}
