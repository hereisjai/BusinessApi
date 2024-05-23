package com.business.sales.dto;

import com.business.sales.entity.Suppliers;

import java.util.List;

import com.business.sales.entity.MilkSupplyDetail;
import com.business.sales.entity.SupplierPaymentDetail;

public class SupplierInfoDTO {
    private Suppliers supplier;
    private List<MilkSupplyDetail> supplyDetails;
    private List<SupplierPaymentDetail> paymentDetails;

    public SupplierInfoDTO(Suppliers supplier, List<MilkSupplyDetail> supplyDetails, List<SupplierPaymentDetail> paymentDetails) {
        this.supplier = supplier;
        this.supplyDetails = supplyDetails;
        this.paymentDetails = paymentDetails;
    }

    public Suppliers getSupplier() {
        return supplier;
    }
    public void setSupplier(Suppliers supplier) {
        this.supplier = supplier;
    }
    public List<MilkSupplyDetail> getSupplyDetails() {
        return supplyDetails;
    }
    public void setSupplyDetails(List<MilkSupplyDetail> supplyDetails) {
        this.supplyDetails = supplyDetails;
    }
    public List<SupplierPaymentDetail> getPaymentDetails() {
        return paymentDetails;
    }
    public void setPaymentDetails(List<SupplierPaymentDetail> paymentDetails) {
        this.paymentDetails = paymentDetails;
    }

}
