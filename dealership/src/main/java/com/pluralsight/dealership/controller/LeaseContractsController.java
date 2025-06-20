package com.pluralsight.dealership.controller;

import com.pluralsight.dealership.dao.LeaseContractDao;
import com.pluralsight.dealership.model.LeaseContract;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/lease-contracts")
public class LeaseContractsController {

    private final LeaseContractDao leaseContractDao;

    @Autowired
    public LeaseContractsController(LeaseContractDao leaseContractDao) {
        this.leaseContractDao = leaseContractDao;
    }

    // GET lease contract by ID
    @GetMapping("/{id}")
    public ResponseEntity<LeaseContract> getById(@PathVariable int id) {
        LeaseContract contract = leaseContractDao.getById(id);
        if (contract == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(contract);
    }

    // POST new lease contract
    @PostMapping
    public ResponseEntity<Void> add(@RequestBody LeaseContract contract) {
        leaseContractDao.add(contract);
        return ResponseEntity.ok().build();
    }
}
