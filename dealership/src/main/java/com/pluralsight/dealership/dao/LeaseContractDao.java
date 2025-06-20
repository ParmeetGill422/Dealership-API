package com.pluralsight.dealership.dao;

import com.pluralsight.dealership.model.LeaseContract;
import java.util.List;

public interface LeaseContractDao {
    LeaseContract getById(int id);
    void add(LeaseContract contract);
    List<LeaseContract> getAll();
}
