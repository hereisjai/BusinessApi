package com.business.sales.controller;
import com.business.sales.entity.MilkSupplyDetail;
import com.business.sales.services.MilkSupplyDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/milk-supply-details")
public class MilkSupplyDetailController {
    @Autowired
    private MilkSupplyDetailService milkSupplyDetailService;

    @GetMapping
    public List<MilkSupplyDetail> getAllMilkSupplyDetails() {
        return milkSupplyDetailService.getAllMilkSupplyDetails();
    }

    @GetMapping("/{id}")
    public MilkSupplyDetail getMilkSupplyDetailById(@PathVariable Integer id) {
        return milkSupplyDetailService.getMilkSupplyDetailById(id);
    }

    @PostMapping
    public MilkSupplyDetail createMilkSupplyDetail(@RequestBody MilkSupplyDetail milkSupplyDetail) {
        return milkSupplyDetailService.createMilkSupplyDetail(milkSupplyDetail);
    }

    @PutMapping("/{id}")
    public MilkSupplyDetail updateMilkSupplyDetail(@PathVariable Integer id, @RequestBody MilkSupplyDetail milkSupplyDetail) {
        milkSupplyDetail.setSupplyID(id);
        return milkSupplyDetailService.updateMilkSupplyDetail(milkSupplyDetail);
    }

    @DeleteMapping("/{id}")
    public void deleteMilkSupplyDetail(@PathVariable Integer id) {
        milkSupplyDetailService.deleteMilkSupplyDetail(id);
    }

    @DeleteMapping("/deleteSuppliersWithIds")
    public ResponseEntity<String> deleteSuppliers(@RequestBody List<Integer> supplyIds) {
        milkSupplyDetailService.deleteSuppliersByIds(supplyIds);
        return ResponseEntity.ok("Suppliers deleted successfully.");
    }
}
