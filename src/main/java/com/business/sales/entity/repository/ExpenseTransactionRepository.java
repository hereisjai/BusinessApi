package com.business.sales.entity.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.business.sales.entity.ExpenseTransactionEntity;

@Repository
public interface ExpenseTransactionRepository extends JpaRepository<ExpenseTransactionEntity, Long> {
    List<ExpenseTransactionEntity> findByExpenseType(String expenseType);
}
