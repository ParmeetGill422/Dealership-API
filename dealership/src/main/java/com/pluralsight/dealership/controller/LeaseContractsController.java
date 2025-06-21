package com.pluralsight.dealership.controller;

import com.pluralsight.dealership.dao.LeaseContractDao;
import com.pluralsight.dealership.model.LeaseContract;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/lease-contracts")
public class LeaseContractsController {

    private final LeaseContractDao leaseContractDao;

    @Autowired
    public LeaseContractsController(LeaseContractDao leaseContractDao) {
        this.leaseContractDao = leaseContractDao;
    }

    @GetMapping("/{id}")
    public LeaseContract getById(@PathVariable int id) {
        return leaseContractDao.getById(id);
    }

    @GetMapping
    public List<LeaseContract> getAll() {
        return leaseContractDao.getAll();
    }

    @PostMapping
    public void add(@RequestBody LeaseContract contract) {
        leaseContractDao.add(contract);
    }

    @DeleteMapping("/vin/{vin}")
    public void deleteByVin(@PathVariable String vin) {
        leaseContractDao.deleteByVin(vin);
    }
}
