package com.business.sales.services;

import org.springframework.stereotype.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.business.sales.entity.Suppliers;
import com.business.sales.entity.repository.SupplierRepository;

@Service
public class SupplierService {
    @Autowired
    private SupplierRepository supplierRepository;

    public List<Suppliers> getAllSuppliers() {
        return supplierRepository.findAll();
    }

    public Suppliers getSupplierById(Integer id) {
        return supplierRepository.findById(id).orElse(null);
    }

    public Suppliers createSupplier(Suppliers supplier) {
        return supplierRepository.save(supplier);
    }

    public Suppliers updateSupplier(Suppliers supplier) {
        return supplierRepository.save(supplier);
    }

    public void deleteSupplier(Integer id) {
        supplierRepository.deleteById(id);
    }

    public void deleteSuppliersByIds(List<Integer> supplierIds) {
        supplierRepository.deleteAllById(supplierIds);
    }
}
