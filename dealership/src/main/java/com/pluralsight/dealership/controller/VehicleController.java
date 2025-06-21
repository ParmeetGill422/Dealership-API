package com.pluralsight.dealership.controller;

import com.pluralsight.dealership.dao.VehicleDao;
import com.pluralsight.dealership.model.Vehicle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping("/api/vehicles")
public class VehicleController {

    private final VehicleDao vehicleDao;

    @Autowired
    public VehicleController(VehicleDao vehicleDao) {
        this.vehicleDao = vehicleDao;
    }

    // GET with filters via query params
    @GetMapping
    public List<Vehicle> searchVehicles(
            @RequestParam(required = false) BigDecimal minPrice,
            @RequestParam(required = false) BigDecimal maxPrice,
            @RequestParam(required = false) String make,
            @RequestParam(required = false) String model,
            @RequestParam(required = false) Integer minYear,
            @RequestParam(required = false) Integer maxYear,
            @RequestParam(required = false) String color,
            @RequestParam(required = false) Integer minMiles,
            @RequestParam(required = false) Integer maxMiles,
            @RequestParam(required = false) String type
    ) {
        return vehicleDao.search(minPrice, maxPrice, make, model, minYear, maxYear, color, minMiles, maxMiles, type);
    }

    // POST to add vehicle
    @PostMapping
    public void addVehicle(@RequestBody Vehicle vehicle) {
        vehicleDao.add(vehicle);
    }

    // PUT to update vehicle
    @PutMapping("/{vin}")
    public void updateVehicle(@PathVariable String vin, @RequestBody Vehicle vehicle) {
        vehicle.setVin(vin);
        vehicleDao.update(vehicle);
    }

    // DELETE vehicle
    @DeleteMapping("/{vin}")
    public void deleteVehicle(@PathVariable String vin) {
        vehicleDao.delete(vin);
    }
}
