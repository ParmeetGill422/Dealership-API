package com.pluralsight.dealership.model;

import java.math.BigDecimal;
import java.time.LocalDate;

public class SalesContract {
    private int id;
    private String vin;
    private String customerName;
    private String customerEmail;
    private BigDecimal salesTax;
    private BigDecimal recordingFee;
    private BigDecimal processingFee;
    private BigDecimal totalPrice;
    private BigDecimal monthlyPayment;
    private LocalDate dateSold;

    // Getters and setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getVin() { return vin; }
    public void setVin(String vin) { this.vin = vin; }

    public String getCustomerName() { return customerName; }
    public void setCustomerName(String customerName) { this.customerName = customerName; }

    public String getCustomerEmail() { return customerEmail; }
    public void setCustomerEmail(String customerEmail) { this.customerEmail = customerEmail; }

    public BigDecimal getSalesTax() { return salesTax; }
    public void setSalesTax(BigDecimal salesTax) { this.salesTax = salesTax; }

    public BigDecimal getRecordingFee() { return recordingFee; }
    public void setRecordingFee(BigDecimal recordingFee) { this.recordingFee = recordingFee; }

    public BigDecimal getProcessingFee() { return processingFee; }
    public void setProcessingFee(BigDecimal processingFee) { this.processingFee = processingFee; }

    public BigDecimal getTotalPrice() { return totalPrice; }
    public void setTotalPrice(BigDecimal totalPrice) { this.totalPrice = totalPrice; }

    public BigDecimal getMonthlyPayment() { return monthlyPayment; }
    public void setMonthlyPayment(BigDecimal monthlyPayment) { this.monthlyPayment = monthlyPayment; }

    public LocalDate getDateSold() { return dateSold; }
    public void setDateSold(LocalDate dateSold) { this.dateSold = dateSold; }
}
