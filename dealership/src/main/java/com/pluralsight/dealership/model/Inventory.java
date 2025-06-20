package com.pluralsight.dealership.model;

import java.util.ArrayList;
import java.util.List;

public class Inventory {
    private List<Vehicle> vehicles;

    public Inventory() {
        vehicles = new ArrayList<>();
    }

    public Inventory(List<Vehicle> vehicles) {
        this.vehicles = vehicles;
    }

    public List<Vehicle> getVehicles() {
        return vehicles;
    }

    public void setVehicles(List<Vehicle> vehicles) {
        this.vehicles = vehicles;
    }

    public void addVehicle(Vehicle vehicle) {
        vehicles.add(vehicle);
    }

    public void removeVehicle(Vehicle vehicle) {
        vehicles.remove(vehicle);
    }
}
