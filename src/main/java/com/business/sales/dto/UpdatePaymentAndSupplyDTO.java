package com.business.sales.dto;

import java.util.List;

public class UpdatePaymentAndSupplyDTO {
    
    private Integer supplierId;
    private List<UpdateSupplyDetailDTO> supplyDetails;
    private List<UpdatePaymentDetailsDTO> paymentDetails;
    public Integer getSupplierId() {
        return supplierId;
    }
    public void setSupplierId(Integer supplierId) {
        this.supplierId = supplierId;
    }
    public List<UpdateSupplyDetailDTO> getSupplyDetails() {
        return supplyDetails;
    }
    public void setSupplyDetails(List<UpdateSupplyDetailDTO> supplyDetails) {
        this.supplyDetails = supplyDetails;
    }
    public List<UpdatePaymentDetailsDTO> getPaymentDetails() {
        return paymentDetails;
    }
    public void setPaymentDetails(List<UpdatePaymentDetailsDTO> paymentDetails) {
        this.paymentDetails = paymentDetails;
    }

    // Getters and Setters
}
