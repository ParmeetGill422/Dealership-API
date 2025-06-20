package com.pluralsight.dealership.dao;

import com.pluralsight.dealership.model.SalesContract;
import java.util.List;

public interface SalesContractDao {
    SalesContract getById(int id);
    void add(SalesContract contract);
    List<SalesContract> getAll();
}
