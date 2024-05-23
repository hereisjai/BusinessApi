package com.business.sales.controller;

import com.business.sales.entity.Suppliers;
import com.business.sales.services.SupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/suppliers")
public class SupplierController {
    @Autowired
    private SupplierService supplierService;

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
    public void deleteSupplier(@PathVariable Integer id) {
        supplierService.deleteSupplier(id);
    }
}
