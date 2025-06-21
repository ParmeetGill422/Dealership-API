package com.pluralsight.dealership.dao;

import com.pluralsight.dealership.model.Vehicle;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Component
public class MySqlVehicleDao implements VehicleDao {

    private final JdbcTemplate jdbcTemplate;

    public MySqlVehicleDao(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public Vehicle getById(int id) {
        String sql = "SELECT * FROM vehicles WHERE vehicle_id = ?";
        return jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<>(Vehicle.class), id);
    }

    @Override
    public List<Vehicle> search(BigDecimal minPrice, BigDecimal maxPrice, String make, String model,
                                Integer minYear, Integer maxYear, String color,
                                Integer minMiles, Integer maxMiles, String type) {
        StringBuilder sql = new StringBuilder("SELECT * FROM vehicles WHERE 1=1");
        List<Object> params = new ArrayList<>();

        if (minPrice != null) {
            sql.append(" AND price >= ?");
            params.add(minPrice);
        }
        if (maxPrice != null) {
            sql.append(" AND price <= ?");
            params.add(maxPrice);
        }
        if (make != null && !make.isEmpty()) {
            sql.append(" AND make LIKE ?");
            params.add("%" + make + "%");
        }
        if (model != null && !model.isEmpty()) {
            sql.append(" AND model LIKE ?");
            params.add("%" + model + "%");
        }
        if (minYear != null) {
            sql.append(" AND year >= ?");
            params.add(minYear);
        }
        if (maxYear != null) {
            sql.append(" AND year <= ?");
            params.add(maxYear);
        }
        if (color != null && !color.isEmpty()) {
            sql.append(" AND color LIKE ?");
            params.add("%" + color + "%");
        }
        if (minMiles != null) {
            sql.append(" AND odometer >= ?");
            params.add(minMiles);
        }
        if (maxMiles != null) {
            sql.append(" AND odometer <= ?");
            params.add(maxMiles);
        }
        if (type != null && !type.isEmpty()) {
            sql.append(" AND type LIKE ?");
            params.add("%" + type + "%");
        }

        return jdbcTemplate.query(sql.toString(), params.toArray(), new BeanPropertyRowMapper<>(Vehicle.class));
    }

    @Override
    public void add(Vehicle vehicle) {
        String sql = "INSERT INTO vehicles (vin, make, model, year, color, price, odometer, type) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        jdbcTemplate.update(sql,
                vehicle.getVin(),
                vehicle.getMake(),
                vehicle.getModel(),
                vehicle.getYear(),
                vehicle.getColor(),
                vehicle.getPrice(),
                vehicle.getOdometer(),
                vehicle.getType());
    }

    @Override
    public void update(Vehicle vehicle) {
        String sql = "UPDATE vehicles SET make = ?, model = ?, year = ?, color = ?, price = ?, odometer = ?, type = ? WHERE vin = ?\n";
        jdbcTemplate.update(sql,
                vehicle.getMake(),
                vehicle.getModel(),
                vehicle.getYear(),
                vehicle.getColor(),
                vehicle.getPrice(),
                vehicle.getOdometer(),
                vehicle.getType(),
                vehicle.getVin());

    }

    @Override
    public void delete(String vin) {
        String sql = "DELETE FROM vehicles WHERE vin = ?";
        jdbcTemplate.update(sql, vin);
    }
}
