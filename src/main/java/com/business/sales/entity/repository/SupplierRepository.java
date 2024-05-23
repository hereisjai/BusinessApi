package com.business.sales.entity.repository;

import com.business.sales.entity.Suppliers;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SupplierRepository extends JpaRepository<Suppliers, Integer> {
}
