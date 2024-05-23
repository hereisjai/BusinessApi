package com.business.sales.controller;

import com.business.sales.entity.SupplierPaymentDetail;
import com.business.sales.services.SupplierPaymentDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/supplier-payment-details")
public class SupplierPaymentDetailController {
    @Autowired
    private SupplierPaymentDetailService supplierPaymentDetailService;

    @GetMapping
    public List<SupplierPaymentDetail> getAllSupplierPaymentDetails() {
        return supplierPaymentDetailService.getAllSupplierPaymentDetails();
    }

    @GetMapping("/{id}")
    public SupplierPaymentDetail getSupplierPaymentDetailById(@PathVariable Integer id) {
        return supplierPaymentDetailService.getSupplierPaymentDetailById(id);
    }

    @PostMapping
    public SupplierPaymentDetail createSupplierPaymentDetail(@RequestBody SupplierPaymentDetail supplierPaymentDetail) {
        return supplierPaymentDetailService.createSupplierPaymentDetail(supplierPaymentDetail);
    }

    @PutMapping("/{id}")
    public SupplierPaymentDetail updateSupplierPaymentDetail(@PathVariable Integer id, @RequestBody SupplierPaymentDetail supplierPaymentDetail) {
        supplierPaymentDetail.setPaymentID(id);
        return supplierPaymentDetailService.updateSupplierPaymentDetail(supplierPaymentDetail);
    }

    @DeleteMapping("/{id}")
    public void deleteSupplierPaymentDetail(@PathVariable Integer id) {
        supplierPaymentDetailService.deleteSupplierPaymentDetail(id);
    }
}
