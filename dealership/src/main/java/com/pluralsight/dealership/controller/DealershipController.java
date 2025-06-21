package com.pluralsight.dealership.controller;

import com.pluralsight.dealership.model.Dealership;
import com.pluralsight.dealership.service.DealershipService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/dealerships")
public class DealershipController {

    private final DealershipService dealershipService;

    @Autowired
    public DealershipController(DealershipService dealershipService) {
        this.dealershipService = dealershipService;
    }

    @GetMapping("/{id}")
    public Dealership getDealership(@PathVariable int id) {
        return dealershipService.getDealershipWithInventory(id);
    }
}
