package com.business.sales.services;

import java.math.BigDecimal;
import java.sql.Date;
import java.time.LocalDate;
import java.time.Month;
import java.time.temporal.TemporalAdjusters;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.business.sales.dto.DailySupplySummaryDTO;
import com.business.sales.dto.SupplierInfoDTO;
import com.business.sales.dto.SupplierInfoResponse;
import com.business.sales.dto.UpdatePaymentAndSupplyDTO;
import com.business.sales.dto.UpdatePaymentDetailsDTO;
import com.business.sales.dto.UpdateSupplyDetailDTO;
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

                LocalDate localDate = LocalDate.of(year, Month.of(month), 1);
                Date startDate = Date.valueOf(localDate);
                Date endDate = Date.valueOf(localDate.with(TemporalAdjusters.lastDayOfMonth()));

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

        @Transactional
        public void updateSupplierDetails(UpdatePaymentAndSupplyDTO updatePaymentAndSupplyDTO) {
                Suppliers supplier = supplierRepository.findById(updatePaymentAndSupplyDTO.getSupplierId())
                                .orElseThrow(() -> new ResourceNotFoundException("Supplier not found for id: "
                                                + updatePaymentAndSupplyDTO.getSupplierId()));

                if (updatePaymentAndSupplyDTO.getSupplyDetails() != null) {
                        for (UpdateSupplyDetailDTO supplyDetailDTO : updatePaymentAndSupplyDTO.getSupplyDetails()) {
                                MilkSupplyDetail supplyDetail = new MilkSupplyDetail();
                                // milkSupplyDetailRepository.findById(supplyDetailDTO.getSupplyId())
                                // .orElseThrow(() -> new ResourceNotFoundException("Supply detail not found for
                                // id: " + supplyDetailDTO.getSupplyId()));
                                supplyDetail.setSupplier(supplier);
                                supplyDetail.setSupplyDate(supplyDetailDTO.getSupplyDate());
                                supplyDetail.setMorningSupplyMilkAmt(supplyDetailDTO.getMorningSupplyMilkAmt());
                                supplyDetail.setMorningSupplyFatAmt(supplyDetailDTO.getMorningSupplyFatAmt());
                                supplyDetail.setEveningSupplyMilkAmt(supplyDetailDTO.getEveningSupplyMilkAmt());
                                supplyDetail.setEveningSupplyFatAmt(supplyDetailDTO.getEveningSupplyFatAmt());
                                supplyDetail.setRatePerLiter(supplyDetailDTO.getRatePerLiter());

                                milkSupplyDetailRepository.save(supplyDetail);
                        }
                }

                if (updatePaymentAndSupplyDTO.getPaymentDetails() != null) {
                        for (UpdatePaymentDetailsDTO paymentDetailDTO : updatePaymentAndSupplyDTO.getPaymentDetails()) {
                                SupplierPaymentDetail paymentDetail = new SupplierPaymentDetail();
                                // supplierPaymentDetailRepository.findById(paymentDetailDTO.getPaymentId())
                                // .orElseThrow(() -> new ResourceNotFoundException("Payment detail not found
                                // for id: " + paymentDetailDTO.getPaymentId()));
                                paymentDetail.setSupplier(supplier);
                                paymentDetail.setPaymentDate(paymentDetailDTO.getPaymentDate());
                                paymentDetail.setAmountPaid(paymentDetailDTO.getAmountPaid());
                                paymentDetail.setAmountOwed(paymentDetailDTO.getAmountOwed());
                                paymentDetail.setModeOfPayment(paymentDetailDTO.getModeOfPayment());
                                paymentDetail.setPaymentRef(paymentDetailDTO.getPaymentRef());
                                paymentDetail.setRemarks(paymentDetailDTO.getRemarks());

                                supplierPaymentDetailRepository.save(paymentDetail);
                        }
                }
        }

        public List<DailySupplySummaryDTO> getDailySupplySummary(int supplierId, int year, int month) {
                // TODO Auto-generated method stub
                LocalDate firstDate = LocalDate.of(year, month, 1);
                Date startDate = Date.valueOf(firstDate);
                Date endDate = Date.valueOf(firstDate.with(TemporalAdjusters.lastDayOfMonth()));

                Suppliers supplier = supplierRepository.findById(supplierId)
                                .orElseThrow(() -> new ResourceNotFoundException(
                                                "Supplier not found for id: " + supplierId));

                List<MilkSupplyDetail> supplyDetails = milkSupplyDetailRepository
                                .findBySupplierAndSupplyDateBetween(supplier, startDate, endDate);

                // Group by date and calculate totals
                Map<Date, DailySupplySummaryDTO> dailySummaryMap = new HashMap<>();

                for (MilkSupplyDetail supplyDetail : supplyDetails) {
                        Date date = supplyDetail.getSupplyDate();
                        DailySupplySummaryDTO dailySummary = dailySummaryMap.getOrDefault(date,
                                        new DailySupplySummaryDTO(date, 0.0, 0.0));

                        dailySummary.setTotalMorningMilkSupply(dailySummary.getTotalMorningMilkSupply() +
                                        (supplyDetail.getMorningSupplyMilkAmt() != null
                                                        ? supplyDetail.getMorningSupplyMilkAmt()
                                                        : 0.0));

                        dailySummary.setTotalEveningMilkSupply(dailySummary.getTotalEveningMilkSupply()
                                        + (supplyDetail.getEveningSupplyMilkAmt() != null
                                                        ? supplyDetail.getEveningSupplyMilkAmt()
                                                        : 0.0));

                        dailySummaryMap.put(date, dailySummary);
                }

                return new ArrayList<>(dailySummaryMap.values());
        }

        public List<DailySupplySummaryDTO> getDailySummary(int supplierId, int year, int month) {
        
                LocalDate firstDate = LocalDate.of(year, month, 1);
                Date startDate = Date.valueOf(firstDate);
                Date endDate = Date.valueOf(firstDate.with(TemporalAdjusters.lastDayOfMonth()));

                Suppliers supplier = supplierRepository.findById(supplierId)
                        .orElseThrow(() -> new ResourceNotFoundException("Supplier not found for id: " + supplierId));
        
                List<MilkSupplyDetail> supplyDetails = milkSupplyDetailRepository
                        .findBySupplierAndSupplyDateBetween(supplier, startDate, endDate);
        
                List<SupplierPaymentDetail> paymentDetails = supplierPaymentDetailRepository
                        .findBySupplierAndPaymentDateBetween(supplier, startDate, endDate);
        
                // Group by date and calculate totals
                Map<Date, DailySupplySummaryDTO> dailySummaryMap = new HashMap<>();
        
                // Process supply details
                for (MilkSupplyDetail supplyDetail : supplyDetails) {
                    Date date = supplyDetail.getSupplyDate();
                    DailySupplySummaryDTO dailySummary = dailySummaryMap.getOrDefault(date, new DailySupplySummaryDTO(date, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0,0.0, "", "", ""));
        
                    dailySummary.setTotalMorningMilkSupply(dailySummary.getTotalMorningMilkSupply() + (supplyDetail.getMorningSupplyMilkAmt() != null ? supplyDetail.getMorningSupplyMilkAmt() : 0.0));
                    dailySummary.setTotalEveningMilkSupply(dailySummary.getTotalEveningMilkSupply() + (supplyDetail.getEveningSupplyMilkAmt() != null ? supplyDetail.getEveningSupplyMilkAmt() : 0.0));
                    dailySummary.setMorningSupplyFatAmt(dailySummary.getMorningSupplyFatAmt() + (supplyDetail.getMorningSupplyFatAmt() != null ? supplyDetail.getMorningSupplyFatAmt() : 0.0));
                    dailySummary.setEveningSupplyFatAmt(dailySummary.getEveningSupplyFatAmt() + (supplyDetail.getEveningSupplyFatAmt() != null ? supplyDetail.getEveningSupplyFatAmt() : 0.0));
                    dailySummary.setRatePerLiter(supplyDetail.getRatePerLiter() != null ? supplyDetail.getRatePerLiter() : 0.0);
        
                    // Update total milk and total amount
                    dailySummary.setTotalMilk(dailySummary.getTotalMorningMilkSupply() + dailySummary.getTotalEveningMilkSupply());
                    dailySummary.setTotalAmount(dailySummary.getTotalMilk() * dailySummary.getRatePerLiter());
        
                    dailySummaryMap.put(date, dailySummary);
                }
        
                // Process payment details
                for (SupplierPaymentDetail paymentDetail : paymentDetails) {
                    Date date = paymentDetail.getPaymentDate();
                    DailySupplySummaryDTO dailySummary = dailySummaryMap.getOrDefault(date, new DailySupplySummaryDTO(date, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, "", "", ""));
        
                    dailySummary.setAmountPaid(dailySummary.getAmountPaid() + (paymentDetail.getAmountPaid() != null ? paymentDetail.getAmountPaid() : 0.0));
        
                    // Concatenate mode of payment, payment reference, and remarks
                    String modeOfPayment = dailySummary.getModeOfPayment();
                    String paymentRef = dailySummary.getPaymentRef();
                    String remarks = dailySummary.getRemarks();
        
                    dailySummary.setModeOfPayment(modeOfPayment.isEmpty() ? paymentDetail.getModeOfPayment() : modeOfPayment + " | " + paymentDetail.getModeOfPayment());
                    dailySummary.setPaymentRef(paymentRef.isEmpty() ? paymentDetail.getPaymentRef() : paymentRef + " | " + paymentDetail.getPaymentRef());
                    dailySummary.setRemarks(remarks.isEmpty() ? paymentDetail.getRemarks() : remarks + " | " + paymentDetail.getRemarks());
        
                    dailySummaryMap.put(date, dailySummary);
                }
        
                return new ArrayList<>(dailySummaryMap.values());
            }
}
