package com.pluralsight.dealership.dao;

import com.pluralsight.dealership.model.LeaseContract;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.List;

@Repository
public class MySqlLeaseContractDao implements LeaseContractDao {

    private final JdbcTemplate jdbcTemplate;

    public MySqlLeaseContractDao(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public LeaseContract getById(int id) {
        String sql = "SELECT * FROM lease_contracts WHERE id = ?";
        return jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<>(LeaseContract.class), id);
    }

    @Override
    public List<LeaseContract> getAll() {
        String sql = "SELECT * FROM lease_contracts";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(LeaseContract.class));
    }

    @Override
    public void add(LeaseContract contract) {
        String sql = "INSERT INTO lease_contracts (vin, customer_name, customer_email, lease_fee, total_price, monthly_payment, end_date) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?)";
        jdbcTemplate.update(sql,
                contract.getVin(),
                contract.getCustomerName(),
                contract.getCustomerEmail(),
                contract.getLeaseFee(),
                contract.getTotalPrice(),
                contract.getMonthlyPayment(),
                contract.getEndDate());
    }

    @Override
    public void deleteByVin(String vin) {
        String sql = "DELETE FROM lease_contracts WHERE vin = ?";
        jdbcTemplate.update(sql, vin);
    }
}
