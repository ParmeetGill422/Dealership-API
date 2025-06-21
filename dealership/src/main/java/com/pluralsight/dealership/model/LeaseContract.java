package com.pluralsight.dealership.model;

import java.math.BigDecimal;
import java.time.LocalDate;

public class LeaseContract {
    private int id;
    private String vin;
    private String customerName;
    private String customerEmail;
    private BigDecimal leaseFee;       // add this
    private BigDecimal totalPrice;
    private BigDecimal monthlyPayment;
    private LocalDate endDate;          // add this

    // getters and setters for all fields

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public String getVin() {
        return vin;
    }
    public void setVin(String vin) {
        this.vin = vin;
    }

    public String getCustomerName() {
        return customerName;
    }
    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerEmail() {
        return customerEmail;
    }
    public void setCustomerEmail(String customerEmail) {
        this.customerEmail = customerEmail;
    }

    public BigDecimal getLeaseFee() {
        return leaseFee;
    }
    public void setLeaseFee(BigDecimal leaseFee) {
        this.leaseFee = leaseFee;
    }

    public BigDecimal getTotalPrice() {
        return totalPrice;
    }
    public void setTotalPrice(BigDecimal totalPrice) {
        this.totalPrice = totalPrice;
    }

    public BigDecimal getMonthlyPayment() {
        return monthlyPayment;
    }
    public void setMonthlyPayment(BigDecimal monthlyPayment) {
        this.monthlyPayment = monthlyPayment;
    }

    public LocalDate getEndDate() {
        return endDate;
    }
    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }
}
