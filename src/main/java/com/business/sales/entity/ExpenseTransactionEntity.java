package com.business.sales.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.util.Date;

@Entity
public class ExpenseTransactionEntity {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;
        private Date date;
        private String description;
        private Double amountRecevied;
        private Double expenseAmount;
        private String remarks;
        private Double balanceAmount;
        private String expenseType;
        public Long getId() {
            return id;
        }
        public void setId(Long id) {
            this.id = id;
        }
        public Date getDate() {
            return date;
        }
        public void setDate(Date date) {
            this.date = date;
        }
        public String getDescription() {
            return description;
        }
        public void setDescription(String description) {
            this.description = description;
        }
        public Double getAmountRecevied() {
            return amountRecevied;
        }
        public void setAmountRecevied(Double amountRecevied) {
            this.amountRecevied = amountRecevied;
        }
        public Double getExpenseAmount() {
            return expenseAmount;
        }
        public void setExpenseAmount(Double expenseAmount) {
            this.expenseAmount = expenseAmount;
        }
        public String getRemarks() {
            return remarks;
        }
        public void setRemarks(String remarks) {
            this.remarks = remarks;
        }
        public Double getBalanceAmount() {
            return balanceAmount;
        }
        public void setBalanceAmount(Double balanceAmount) {
            this.balanceAmount = balanceAmount;
        }
        public String getExpenseType() {
            return expenseType;
        }
        public void setExpenseType(String expenseType) {
            this.expenseType = expenseType;
        }
    }
    

