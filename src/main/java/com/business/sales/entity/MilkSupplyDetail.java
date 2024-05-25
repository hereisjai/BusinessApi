package com.business.sales.entity;

import java.sql.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class MilkSupplyDetail {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Integer supplyID;
    
        @ManyToOne
        @JoinColumn(name = "supplierID", nullable = false)
        private Suppliers supplier;
    
        private Date supplyDate;
        private Double morningSupplyMilkAmt;
        private Double morningSupplyFatAmt;
        private Double eveningSupplyMilkAmt;
        private Double eveningSupplyFatAmt;
        private Double ratePerLiter;
        public Integer getSupplyID() {
            return supplyID;
        }
        public void setSupplyID(Integer supplyID) {
            this.supplyID = supplyID;
        }
        public Suppliers getSupplier() {
            return supplier;
        }
        public void setSupplier(Suppliers supplier) {
            this.supplier = supplier;
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
    

}
