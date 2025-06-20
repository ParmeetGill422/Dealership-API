package com.pluralsight.dealership.model;

import java.time.LocalDateTime;
import java.math.BigDecimal;

public class SalesContract {
    private int salesContractId;
    private String customerName;
    private int dealershipId;
    private int vehicleId;
    private LocalDateTime when;
    private BigDecimal totalPrice;
    private BigDecimal monthlyPayment;

    // Getters and Setters
    public int getSalesContractId() {
        return salesContractId;
    }
    public void setSalesContractId(int salesContractId) {
        this.salesContractId = salesContractId;
    }
    public String getCustomerName() {
        return customerName;
    }
    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }
    public int getDealershipId() {
        return dealershipId;
    }
    public void setDealershipId(int dealershipId) {
        this.dealershipId = dealershipId;
    }
    public int getVehicleId() {
        return vehicleId;
    }
    public void setVehicleId(int vehicleId) {
        this.vehicleId = vehicleId;
    }
    public LocalDateTime getWhen() {
        return when;
    }
    public void setWhen(LocalDateTime when) {
        this.when = when;
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
}
