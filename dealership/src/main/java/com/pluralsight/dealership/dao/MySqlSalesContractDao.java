package com.pluralsight.dealership.dao;

import com.pluralsight.dealership.model.SalesContract;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import javax.sql.DataSource;
import java.util.List;

@Repository
public class MySqlSalesContractDao implements SalesContractDao {

    private final JdbcTemplate jdbcTemplate;

    public MySqlSalesContractDao(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
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
    public List<SalesContract> getByVin(String vin) {
        String sql = "SELECT * FROM sales_contracts WHERE vin = ?";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(SalesContract.class), vin);
    }
    @Override
    public List<SalesContract> getAll() {
        String sql = "SELECT * FROM sales_contracts";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(SalesContract.class));
    }
    @Override
    public void deleteByVin(String vin) {
        String sql = "DELETE FROM lease_contracts WHERE vin = ?";
        jdbcTemplate.update(sql, vin);
    }
}
