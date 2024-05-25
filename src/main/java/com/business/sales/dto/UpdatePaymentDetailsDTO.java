package com.business.sales.dto;

import java.util.Date;

public class UpdatePaymentDetailsDTO {
    
    private Integer paymentId;
    private Date paymentDate;
    private Double amountPaid;
    private Double amountOwed;
    private String modeOfPayment;
    private String paymentRef;
    private String remarks;
    public Integer getPaymentId() {
        return paymentId;
    }
    public void setPaymentId(Integer paymentId) {
        this.paymentId = paymentId;
    }
    public Date getPaymentDate() {
        return paymentDate;
    }
    public void setPaymentDate(Date paymentDate) {
        this.paymentDate = paymentDate;
    }
    public Double getAmountPaid() {
        return amountPaid;
    }
    public void setAmountPaid(Double amountPaid) {
        this.amountPaid = amountPaid;
    }
    public Double getAmountOwed() {
        return amountOwed;
    }
    public void setAmountOwed(Double amountOwed) {
        this.amountOwed = amountOwed;
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

    // Getters and Setters
}