package com.business.sales.entity;
import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Suppliers {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Integer supplierID;
    
        private String name;
        private String phoneNumber;
        private String address;
        private String typeOfFarmer;
        private Date dateOfJoining;
        private String bankNameOfCustomer;
        private String bankingAccountNumber;
        private String bankTypeOfAccount;
        private String bankIFSCCode;
        private String bankNameOfBank;
        private String bankNameOfBranch;
        private String bankLocation;
        
        public Integer getSupplierID() {
            return supplierID;
        }
        public void setSupplierID(Integer supplierID) {
            this.supplierID = supplierID;
        }
        public String getName() {
            return name;
        }
        public void setName(String name) {
            this.name = name;
        }
        public String getPhoneNumber() {
            return phoneNumber;
        }
        public void setPhoneNumber(String phoneNumber) {
            this.phoneNumber = phoneNumber;
        }
        public String getAddress() {
            return address;
        }
        public void setAddress(String address) {
            this.address = address;
        }
        public String getTypeOfFarmer() {
            return typeOfFarmer;
        }
        public void setTypeOfFarmer(String typeOfFarmer) {
            this.typeOfFarmer = typeOfFarmer;
        }
        public Date getDateOfJoining() {
            return dateOfJoining;
        }
        public void setDateOfJoining(Date dateOfJoining) {
            this.dateOfJoining = dateOfJoining;
        }
        public String getBankNameOfCustomer() {
            return bankNameOfCustomer;
        }
        public void setBankNameOfCustomer(String bankNameOfCustomer) {
            this.bankNameOfCustomer = bankNameOfCustomer;
        }
        public String getBankingAccountNumber() {
            return bankingAccountNumber;
        }
        public void setBankingAccountNumber(String bankingAccountNumber) {
            this.bankingAccountNumber = bankingAccountNumber;
        }
        public String getBankTypeOfAccount() {
            return bankTypeOfAccount;
        }
        public void setBankTypeOfAccount(String bankTypeOfAccount) {
            this.bankTypeOfAccount = bankTypeOfAccount;
        }
        public String getBankIFSCCode() {
            return bankIFSCCode;
        }
        public void setBankIFSCCode(String bankIFSCCode) {
            this.bankIFSCCode = bankIFSCCode;
        }
        public String getBankNameOfBank() {
            return bankNameOfBank;
        }
        public void setBankNameOfBank(String bankNameOfBank) {
            this.bankNameOfBank = bankNameOfBank;
        }
        public String getBankNameOfBranch() {
            return bankNameOfBranch;
        }
        public void setBankNameOfBranch(String bankNameOfBranch) {
            this.bankNameOfBranch = bankNameOfBranch;
        }
        public String getBankLocation() {
            return bankLocation;
        }
        public void setBankLocation(String bankLocation) {
            this.bankLocation = bankLocation;
        }
      


}
