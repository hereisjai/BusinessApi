package com.business.sales.dto;

import java.sql.Date;

public class DailySupplySummaryDTO {
    private Date date;
    private Double totalMorningMilkSupply;
    private Double totalEveningMilkSupply;
    private Double totalMilk;
    private Double morningSupplyFatAmt;
    private Double eveningSupplyFatAmt;
    private Double ratePerLiter;
    private Double totalAmount;
    private Double amountPaid;
    private String modeOfPayment;
    private String paymentRef;
    private String remarks;
    
    public DailySupplySummaryDTO(Date date, Double totalMorningMilkSupply, Double totalEveningMilkSupply) {
        this.date = date;
        this.totalMorningMilkSupply = totalMorningMilkSupply;
        this.totalEveningMilkSupply = totalEveningMilkSupply;
    }
    
    public DailySupplySummaryDTO(Date date, Double totalMorningMilkSupply, Double totalEveningMilkSupply,
            Double totalMilk, Double morningSupplyFatAmt,
            Double eveningSupplyFatAmt, Double ratePerLiter, Double totalAmount, Double amountPaid,
            String modeOfPayment, String paymentRef, String remarks) {
        this.date = date;
        this.totalMorningMilkSupply = totalMorningMilkSupply;
        this.totalEveningMilkSupply = totalEveningMilkSupply;
        this.totalMilk = totalMilk;
        this.morningSupplyFatAmt = morningSupplyFatAmt;
        this.eveningSupplyFatAmt = eveningSupplyFatAmt;
        this.ratePerLiter = ratePerLiter;
        this.totalAmount = totalAmount;
        this.amountPaid = amountPaid;
        this.modeOfPayment = modeOfPayment;
        this.paymentRef = paymentRef;
        this.remarks = remarks;
    }

    public Date getDate() {
        return date;
    }
    public void setDate(Date date) {
        this.date = date;
    }

    public Double getTotalMorningMilkSupply() {
        return totalMorningMilkSupply;
    }
    public void setTotalMorningMilkSupply(Double totalMorningMilkSupply) {
        this.totalMorningMilkSupply = totalMorningMilkSupply;
    }
    public Double getTotalEveningMilkSupply() {
        return totalEveningMilkSupply;
    }
    public void setTotalEveningMilkSupply(Double totalEveningMilkSupply) {
        this.totalEveningMilkSupply = totalEveningMilkSupply;
    }
    public Double getTotalMilk() {
        return totalMilk;
    }
    public void setTotalMilk(Double totalMilk) {
        this.totalMilk = totalMilk;
    }
    public Double getMorningSupplyFatAmt() {
        return morningSupplyFatAmt;
    }
    public void setMorningSupplyFatAmt(Double morningSupplyFatAmt) {
        this.morningSupplyFatAmt = morningSupplyFatAmt;
    }
    public Double getEveningSupplyFatAmt() {
        return eveningSupplyFatAmt;
    }
    public void setEveningSupplyFatAmt(Double eveningSupplyFatAmt) {
        this.eveningSupplyFatAmt = eveningSupplyFatAmt;
    }
    public Double getRatePerLiter() {
        return ratePerLiter;
    }
    public void setRatePerLiter(Double ratePerLiter) {
        this.ratePerLiter = ratePerLiter;
    }
    public Double getTotalAmount() {
        return totalAmount;
    }
    public void setTotalAmount(Double totalAmount) {
        this.totalAmount = totalAmount;
    }
    public Double getAmountPaid() {
        return amountPaid;
    }
    public void setAmountPaid(Double amountPaid) {
        this.amountPaid = amountPaid;
    }
    public String getModeOfPayment() {
        return modeOfPayment;
    }
    public void setModeOfPayment(String modeOfPayment) {
        this.modeOfPayment = modeOfPayment;
    }
    public String getPaymentRef() {
        return paymentRef;
    }
    public void setPaymentRef(String paymentRef) {
        this.paymentRef = paymentRef;
    }
    public String getRemarks() {
        return remarks;
    }
    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    // Constructor, getters, and setters
}
