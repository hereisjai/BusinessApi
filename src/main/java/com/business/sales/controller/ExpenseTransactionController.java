package com.business.sales.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.business.sales.entity.ExpenseTransactionEntity;
import com.business.sales.services.ExpenseTransactionService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/expenseTransactions")
public class ExpenseTransactionController {

    @Autowired
    private ExpenseTransactionService transactionService;

    @GetMapping
    public List<ExpenseTransactionEntity> getAllTransactions() {
        return transactionService.getAllTransactions();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ExpenseTransactionEntity> getTransactionById(@PathVariable Long id) {
        Optional<ExpenseTransactionEntity> transaction = transactionService.getTransactionById(id);
        return transaction.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping("/by-expense-type")
    public List<ExpenseTransactionEntity> getTransactionsByExpenseType(@RequestParam String expenseType) {
        return transactionService.getTransactionsByExpenseType(expenseType);
    }

    @GetMapping("/by-month")
    public ResponseEntity<List<ExpenseTransactionEntity>> getTransactionsByMonthAndYear(
            @RequestParam int month, @RequestParam int year) {
        List<ExpenseTransactionEntity> transactions = transactionService.getTransactionsByMonthAndYear(month, year);
        return ResponseEntity.ok(transactions);
    }

    @PostMapping
    public ExpenseTransactionEntity createTransaction(@RequestBody ExpenseTransactionEntity  transaction) {
        return transactionService.createTransaction(transaction);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTransaction(@PathVariable Long id) {
        transactionService.deleteTransaction(id);
        return ResponseEntity.ok().build();
    }
}
