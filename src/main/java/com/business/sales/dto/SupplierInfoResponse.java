package com.business.sales.dto;

public class SupplierInfoResponse {
    private int month;
    private int year;
    private SupplierInfoDTO supplier;


    public SupplierInfoResponse(int year, int month, SupplierInfoDTO supplierInfo) {
        this.year = year;
        this.month = month;
        this.supplier= supplierInfo;
    }
    
    public int getMonth() {
        return month;
    }
    public void setMonth(int month) {
        this.month = month;
    }
    public SupplierInfoDTO getSuppliers() {
        return supplier;
    }
    public void setSuppliers(SupplierInfoDTO supplier) {
        this.supplier = supplier;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    // Constructor, getters, and setters
}
