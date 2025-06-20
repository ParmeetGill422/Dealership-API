package com.pluralsight.dealership.model;

import java.time.LocalDateTime;
import java.math.BigDecimal;

public class LeaseContract {
    private int leaseContractId;
    private String customerName;
    private int dealershipId;
    private int vehicleId;
    private LocalDateTime when;
    private BigDecimal totalPrice;
    private BigDecimal monthlyPayment;

    // Getters and Setters
    public int getLeaseContractId() {
        return leaseContractId;
    }
    public void setLeaseContractId(int leaseContractId) {
        this.leaseContractId = leaseContractId;
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
