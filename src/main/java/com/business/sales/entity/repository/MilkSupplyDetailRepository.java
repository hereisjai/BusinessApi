package com.business.sales.entity.repository;
import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.business.sales.entity.MilkSupplyDetail;
import com.business.sales.entity.Suppliers;

public interface MilkSupplyDetailRepository extends JpaRepository<MilkSupplyDetail, Integer> {
    List<MilkSupplyDetail> findBySupplierAndSupplyDateBetween(Suppliers supplier, LocalDate atStartOfDay,
    LocalDate atTime);
}

