package com.business.sales.entity.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.business.sales.entity.Customer;

public interface CustomerRepository extends JpaRepository<Customer,Integer> {
}