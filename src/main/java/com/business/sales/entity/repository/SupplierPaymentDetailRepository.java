package com.business.sales.entity.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.business.sales.entity.SupplierPaymentDetail;
import com.business.sales.entity.Suppliers;

public interface SupplierPaymentDetailRepository extends JpaRepository<SupplierPaymentDetail, Integer> {
      List<SupplierPaymentDetail> findBySupplierAndPaymentDateBetween(
            Suppliers supplier, LocalDate startDate, LocalDate endDate);
}

