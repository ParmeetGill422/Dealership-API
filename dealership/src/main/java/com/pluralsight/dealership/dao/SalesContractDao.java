package com.pluralsight.dealership.dao;

import com.pluralsight.dealership.model.SalesContract;
import java.util.List;

public interface SalesContractDao {
    List<SalesContract> getByVin(String vin);
    void add(SalesContract contract);
    List<SalesContract> getAll();
    void deleteByVin(String vin);

}
