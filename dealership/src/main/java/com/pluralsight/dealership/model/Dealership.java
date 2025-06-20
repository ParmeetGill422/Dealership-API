package com.pluralsight.dealership.model;

import java.util.List;

public class Dealership {
    private int id;
    private String name;
    private String location;

    // Inventory is represented as a list of vehicles loaded from DB via DAO
    private List<Vehicle> inventory;

    public Dealership() {
    }

    public Dealership(int id, String name, String location, List<Vehicle> inventory) {
        this.id = id;
        this.name = name;
        this.location = location;
        this.inventory = inventory;
    }

    // getters and setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getLocation() { return location; }
    public void setLocation(String location) { this.location = location; }

    public List<Vehicle> getInventory() { return inventory; }
    public void setInventory(List<Vehicle> inventory) { this.inventory = inventory; }
}
