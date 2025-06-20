package com.pluralsight.dealership.service;

import com.pluralsight.dealership.dao.VehicleDao;
import com.pluralsight.dealership.model.Dealership;
import com.pluralsight.dealership.model.Vehicle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DealershipService {

    private final VehicleDao vehicleDao;

    @Autowired
    public DealershipService(VehicleDao vehicleDao) {
        this.vehicleDao = vehicleDao;
    }

    // Load all vehicles as dealership inventory
    public Dealership getDealershipWithInventory(int dealershipId) {
        // For simplicity, hardcoding dealership info; replace with DAO if needed
        Dealership dealership = new Dealership();
        dealership.setId(dealershipId);
        dealership.setName("Default Dealership");
        dealership.setLocation("Default Location");

        // Load inventory using DAO
        List<Vehicle> vehicles = vehicleDao.search(null, null, null, null, null, null, null, null, null, null);
        dealership.setInventory(vehicles);

        return dealership;
    }
}
