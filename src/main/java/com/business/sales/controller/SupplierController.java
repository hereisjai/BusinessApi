package com.business.sales.controller;

import com.business.sales.dto.DailySupplySummaryDTO;
import com.business.sales.dto.SupplierInfoResponse;
import com.business.sales.dto.UpdatePaymentAndSupplyDTO;
import com.business.sales.entity.Suppliers;
import com.business.sales.services.SupplierInfoService;
import com.business.sales.services.SupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/suppliers")
public class SupplierController {
    @Autowired
    private SupplierService supplierService;


    @Autowired
    private SupplierInfoService supplierInfoService;

    @GetMapping
    public List<Suppliers> getAllSuppliers() {
        return supplierService.getAllSuppliers();
    }



    @GetMapping("/{id}")
    public Suppliers getSupplierById(@PathVariable Integer id) {
        return supplierService.getSupplierById(id);
    }

    @PostMapping
    public Suppliers createSupplier(@RequestBody Suppliers supplier) {
        return supplierService.createSupplier(supplier);
    }

    @PutMapping("/{id}")
    public Suppliers updateSupplier(@PathVariable Integer id, @RequestBody Suppliers supplier) {
        supplier.setSupplierID(id);
        return supplierService.updateSupplier(supplier);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteSupplier(@PathVariable Integer id) {
         supplierService.deleteSupplier(id);
         return ResponseEntity.ok("Supplier deleted successfully.");
    }

    @DeleteMapping("/deleteSupplyWithIds")
    public ResponseEntity<String> deleteSuppliers(@RequestBody List<Integer> supplierIds) {
        supplierService.deleteSuppliersByIds(supplierIds);
        return ResponseEntity.ok("Suppliers deleted successfully.");
    }

    @GetMapping("/{year}/{month}/{supplierId}")
    public ResponseEntity<SupplierInfoResponse> getSupplierInfoForMonth(
                @PathVariable int year,
                @PathVariable int month,
                @PathVariable int supplierId
    ) {
            // Implement logic to retrieve supplier information for the specified month, year, and supplierId
            SupplierInfoResponse response = supplierInfoService.getSupplierInfoForMonthAndSupplier(year, month, supplierId);
            return ResponseEntity.ok(response);
        }

        @PostMapping("/update-supply-payment-details")
        public ResponseEntity<Void> updateSupplierDetails(@RequestBody UpdatePaymentAndSupplyDTO updatePaymentAndSupplyDTO) {
            supplierInfoService.updateSupplierDetails(updatePaymentAndSupplyDTO);
            return ResponseEntity.ok().build();
        }

        
    @GetMapping("/{supplierId}/supply-summary/{year}/{month}")
    public ResponseEntity<List<DailySupplySummaryDTO>> getDailySupplySummary(
            @PathVariable int supplierId,
            @PathVariable int year,
            @PathVariable int month) {
        List<DailySupplySummaryDTO> dailySummary = supplierInfoService.getDailySummary(supplierId, year, month);
        return ResponseEntity.ok(dailySummary);
    }
    }

