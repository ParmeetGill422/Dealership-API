package com.pluralsight.dealership.controller;
import java.util.List;
import com.pluralsight.dealership.dao.SalesContractDao;
import com.pluralsight.dealership.model.SalesContract;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/sales-contracts")
public class SalesContractsController {

    private final SalesContractDao salesContractDao;

    @Autowired
    public SalesContractsController(SalesContractDao salesContractDao) {
        this.salesContractDao = salesContractDao;
    }

    @GetMapping("/vin/{vin}")
    public List<SalesContract> getByVin(@PathVariable String vin) {
        return salesContractDao.getByVin(vin);
    }

    @PostMapping
    public void add(@RequestBody SalesContract contract) {
        salesContractDao.add(contract);
    }
    @GetMapping
    public List<SalesContract> getAll() {
        return salesContractDao.getAll();
    }
    @DeleteMapping("/vin/{vin}")
    public void deleteByVin(@PathVariable String vin) {
        salesContractDao.deleteByVin(vin);
    }


}
