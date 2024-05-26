package com.business.sales.services;

import com.business.sales.entity.MilkSupplyDetail;
import com.business.sales.entity.repository.MilkSupplyDetailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MilkSupplyDetailService {
    @Autowired
    private MilkSupplyDetailRepository milkSupplyDetailRepository;

    public List<MilkSupplyDetail> getAllMilkSupplyDetails() {
        return milkSupplyDetailRepository.findAll();
    }

    public MilkSupplyDetail getMilkSupplyDetailById(Integer id) {
        return milkSupplyDetailRepository.findById(id).orElse(null);
    }

    public MilkSupplyDetail createMilkSupplyDetail(MilkSupplyDetail milkSupplyDetail) {
        return milkSupplyDetailRepository.save(milkSupplyDetail);
    }

    public MilkSupplyDetail updateMilkSupplyDetail(MilkSupplyDetail milkSupplyDetail) {
        return milkSupplyDetailRepository.save(milkSupplyDetail);
    }

    public void deleteMilkSupplyDetail(Integer id) {
        milkSupplyDetailRepository.deleteById(id);
    }

    public void deleteSuppliersByIds(List<Integer> supplyIds) {
        milkSupplyDetailRepository.deleteAllById(supplyIds);
    }
}