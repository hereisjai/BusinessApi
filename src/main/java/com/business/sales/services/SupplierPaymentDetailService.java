package com.business.sales.services;



import com.business.sales.entity.SupplierPaymentDetail;
import com.business.sales.entity.repository.SupplierPaymentDetailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class SupplierPaymentDetailService {
    @Autowired
    private SupplierPaymentDetailRepository supplierPaymentDetailRepository;

    public List<SupplierPaymentDetail> getAllSupplierPaymentDetails() {
        return supplierPaymentDetailRepository.findAll();
    }

    public SupplierPaymentDetail getSupplierPaymentDetailById(Integer id) {
        return supplierPaymentDetailRepository.findById(id).orElse(null);
    }

    public SupplierPaymentDetail createSupplierPaymentDetail(SupplierPaymentDetail supplierPaymentDetail) {
        return supplierPaymentDetailRepository.save(supplierPaymentDetail);
    }

    public SupplierPaymentDetail updateSupplierPaymentDetail(SupplierPaymentDetail supplierPaymentDetail) {
        return supplierPaymentDetailRepository.save(supplierPaymentDetail);
    }

    public void deleteSupplierPaymentDetail(Integer id) {
        supplierPaymentDetailRepository.deleteById(id);
    }

    public void deleteSuppliersByIds(List<Integer> paymentIds) {
        supplierPaymentDetailRepository.deleteAllById(paymentIds);

    }
}