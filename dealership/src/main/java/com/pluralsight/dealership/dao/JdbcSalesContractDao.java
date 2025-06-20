package com.pluralsight.dealership.dao;

import com.pluralsight.dealership.model.SalesContract;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.util.List;

public class JdbcSalesContractDao implements SalesContractDao {

    private final JdbcTemplate jdbcTemplate;

    public JdbcSalesContractDao(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public SalesContract getById(int id) {
        String sql = "SELECT * FROM sales_contracts WHERE id = ?";
        return jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<>(SalesContract.class), id);
    }

    @Override
    public void add(SalesContract contract) {
        String sql = "INSERT INTO sales_contracts " +
                "(vin, customer_name, customer_email, sales_tax, recording_fee, processing_fee, total_price, monthly_payment, date_sold) " +
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
                contract.getDateSold());
    }

    @Override
    public List<SalesContract> getAll() {
        String sql = "SELECT * FROM sales_contracts";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(SalesContract.class));
    }
}
