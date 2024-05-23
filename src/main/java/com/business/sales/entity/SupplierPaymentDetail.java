package com.business.sales.entity;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class SupplierPaymentDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer paymentID;

    @ManyToOne
    @JoinColumn(name = "supplierID", nullable = false)
    private Suppliers supplier;

    private Date paymentDate;
    private Double amountPaid;
    private Double amountOwed;
    private String modeOfPayment;
    private String paymentRef;
    private String remarks;
    public Integer getPaymentID() {
        return paymentID;
    }
    public void setPaymentID(Integer paymentID) {
        this.paymentID = paymentID;
    }
    public Suppliers getSupplier() {
        return supplier;
    }
    public void setSupplier(Suppliers supplier) {
        this.supplier = supplier;
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

}
