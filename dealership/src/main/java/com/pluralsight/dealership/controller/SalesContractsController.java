package com.pluralsight.dealership.controller;

import com.pluralsight.dealership.dao.SalesContractDao;
import com.pluralsight.dealership.model.SalesContract;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/sales-contracts")
public class SalesContractsController {

    private final SalesContractDao salesContractDao;

    @Autowired
    public SalesContractsController(SalesContractDao salesContractDao) {
        this.salesContractDao = salesContractDao;
    }

    // GET by ID
    @GetMapping("/{id}")
    public ResponseEntity<SalesContract> getById(@PathVariable int id) {
        SalesContract contract = salesContractDao.getById(id);
        if (contract == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(contract);
    }

    // POST new contract
    @PostMapping
    public ResponseEntity<Void> add(@RequestBody SalesContract contract) {
        salesContractDao.add(contract);
        return ResponseEntity.ok().build();
    }
}
