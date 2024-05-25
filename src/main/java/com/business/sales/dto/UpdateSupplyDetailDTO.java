package com.business.sales.dto;

import java.util.Date;

public class UpdateSupplyDetailDTO {
    private Integer supplyId;
    private Date supplyDate;
    private Double morningSupplyMilkAmt;
    private Double morningSupplyFatAmt;
    private Double eveningSupplyMilkAmt;
    private Double eveningSupplyFatAmt;
    private Double ratePerLiter;
    public Integer getSupplyId() {
        return supplyId;
    }
    public void setSupplyId(Integer supplyId) {
        this.supplyId = supplyId;
    }
    public Date getSupplyDate() {
        return supplyDate;
    }
    public void setSupplyDate(Date supplyDate) {
        this.supplyDate = supplyDate;
    }
    public Double getMorningSupplyMilkAmt() {
        return morningSupplyMilkAmt;
    }
    public void setMorningSupplyMilkAmt(Double morningSupplyMilkAmt) {
        this.morningSupplyMilkAmt = morningSupplyMilkAmt;
    }
    public Double getMorningSupplyFatAmt() {
        return morningSupplyFatAmt;
    }
    public void setMorningSupplyFatAmt(Double morningSupplyFatAmt) {
        this.morningSupplyFatAmt = morningSupplyFatAmt;
    }
    public Double getEveningSupplyMilkAmt() {
        return eveningSupplyMilkAmt;
    }
    public void setEveningSupplyMilkAmt(Double eveningSupplyMilkAmt) {
        this.eveningSupplyMilkAmt = eveningSupplyMilkAmt;
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

    // Getters and Setters
}