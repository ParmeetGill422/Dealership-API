package com.pluralsight.dealership.dao;

import com.pluralsight.dealership.model.LeaseContract;
import java.util.List;

public interface LeaseContractDao {
    LeaseContract getById(int id);
    List<LeaseContract> getAll();
    void add(LeaseContract contract);
    void deleteByVin(String vin);
}
