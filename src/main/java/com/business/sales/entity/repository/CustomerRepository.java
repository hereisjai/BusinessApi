package com.business.sales.entity.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.business.sales.entity.Customers;

public interface CustomerRepository extends JpaRepository<Customers,Long> {
}