package com.pluralsight.dealership.dao;

import com.pluralsight.dealership.model.Vehicle;

import java.math.BigDecimal;
import java.util.List;

public interface VehicleDao {
    Vehicle getById(int id);
    List<Vehicle> search(BigDecimal minPrice, BigDecimal maxPrice, String make, String model,
                         Integer minYear, Integer maxYear, String color,
                         Integer minMiles, Integer maxMiles, String type);
    void add(Vehicle vehicle);
    void update(Vehicle vehicle);
    void delete(String vin);
}
