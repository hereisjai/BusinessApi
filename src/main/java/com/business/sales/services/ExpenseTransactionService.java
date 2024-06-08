package com.business.sales.services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.business.sales.entity.ExpenseTransactionEntity;
import com.business.sales.entity.repository.ExpenseTransactionRepository;

import java.util.List;
import java.util.Optional;

@Service
public class ExpenseTransactionService {
    @Autowired
    private ExpenseTransactionRepository expenseTransactionRepository;

    public List<ExpenseTransactionEntity> getAllTransactions() {
        return expenseTransactionRepository.findAll();
    }

    public Optional<ExpenseTransactionEntity> getTransactionById(Long id) {
        return expenseTransactionRepository.findById(id);
    }

    public ExpenseTransactionEntity createTransaction(ExpenseTransactionEntity transaction) {
        return expenseTransactionRepository.save(transaction);
    }

    public void deleteTransaction(Long id) {
        expenseTransactionRepository.deleteById(id);
    }


    public List<ExpenseTransactionEntity> getTransactionsByExpenseType(String expenseType) {
        return expenseTransactionRepository.findByExpenseType(expenseType);
    }
}
