package com.pluralsight.dealership.dao;

import com.pluralsight.dealership.model.LeaseContract;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.util.List;

public class JdbcLeaseContractDao implements LeaseContractDao {

    private final JdbcTemplate jdbcTemplate;

    public JdbcLeaseContractDao(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public LeaseContract getById(int id) {
        String sql = "SELECT * FROM lease_contracts WHERE id = ?";
        return jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<>(LeaseContract.class), id);
    }

    @Override
    public void add(LeaseContract contract) {
        String sql = "INSERT INTO lease_contracts " +
                "(vin, customer_name, customer_email, sales_tax, recording_fee, processing_fee, total_price, monthly_payment, date_leased) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
        jdbcTemplate.update(sql,
                contract.getVin(),
                contract.getCustomerName(),
                contract.getCustomerEmail(),
                contract.getSalesTax(),
                contract.getRecordingFee(),
                contract.getProcessingFee(),
                contract.getTotalPrice(),
                contract.getMonthlyPayment(),
                contract.getDateLeased());
    }

    @Override
    public List<LeaseContract> getAll() {
        String sql = "SELECT * FROM lease_contracts";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(LeaseContract.class));
    }
}
