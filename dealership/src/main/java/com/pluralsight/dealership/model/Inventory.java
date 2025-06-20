package com.pluralsight.dealership.model;

import java.util.List;

public class Inventory {
    private List<Vehicle> vehicles;

    public Inventory() {
    }

    public Inventory(List<Vehicle> vehicles) {
        this.vehicles = vehicles;
    }

    // getters and setters
    public List<Vehicle> getVehicles() { return vehicles; }
    public void setVehicles(List<Vehicle> vehicles) { this.vehicles = vehicles; }
}
