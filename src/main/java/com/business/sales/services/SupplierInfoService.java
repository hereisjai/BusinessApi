package com.business.sales.services;

import java.time.LocalDate;
import java.time.Month;
import java.time.temporal.TemporalAdjusters;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.business.sales.dto.SupplierInfoDTO;
import com.business.sales.dto.SupplierInfoResponse;
import com.business.sales.entity.MilkSupplyDetail;
import com.business.sales.entity.SupplierPaymentDetail;
import com.business.sales.entity.Suppliers;
import com.business.sales.entity.repository.MilkSupplyDetailRepository;
import com.business.sales.entity.repository.SupplierPaymentDetailRepository;
import com.business.sales.entity.repository.SupplierRepository;
import com.business.sales.exceptions.ResourceNotFoundException;

// Inside your method

@Service
public class SupplierInfoService {

        @Autowired
        private SupplierRepository supplierRepository;

        @Autowired
        private MilkSupplyDetailRepository milkSupplyDetailRepository;

        @Autowired
        private SupplierPaymentDetailRepository supplierPaymentDetailRepository;

        public SupplierInfoResponse getSupplierInfoForMonthAndSupplier(int year, int month, int supplierId) {
                // Implement logic to fetch supplier information for the specified month, year,
                // and supplierId

                LocalDate startDate = LocalDate.of(year, Month.of(month), 1);
                LocalDate endDate = startDate.with(TemporalAdjusters.lastDayOfMonth());

                Suppliers supplier = supplierRepository.findById(supplierId).orElseThrow(
                                () -> new ResourceNotFoundException("Supplier not found with id: " + supplierId));

                // Fetch supply details for the supplier within the specified month and year
                List<MilkSupplyDetail> supplyDetails = milkSupplyDetailRepository.findBySupplierAndSupplyDateBetween(
                                supplier, startDate, endDate);

                // Fetch payment details for the supplier within the specified month and year
                List<SupplierPaymentDetail> paymentDetails = supplierPaymentDetailRepository
                                .findBySupplierAndPaymentDateBetween(
                                                supplier, startDate, endDate);

                SupplierInfoDTO supplierInfoDTO = new SupplierInfoDTO(supplier, supplyDetails, paymentDetails);

                return new SupplierInfoResponse(year, month, supplierInfoDTO);
        }
}
