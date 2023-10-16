/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.uts.inventarisasi.service;

/**
 *
 * @author AFNAN
 */
import com.uts.inventarisasi.dto.BarangDto;
import com.uts.inventarisasi.entity.Barang;
import com.uts.inventarisasi.mapper.BarangMapper;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.uts.inventarisasi.repository.BarangRepository;

@Service
public class BarangServiceImpl implements BarangService{
    @Autowired
    private BarangRepository barangRepository;

    @Override
    public void createBarang(BarangDto barangDto) {
        barangRepository.save(BarangMapper.mapToBarang(barangDto));
    }

    @Override
    public List<BarangDto> getBarangs() {
        List<Barang> barangs = barangRepository.findAll();
        List<BarangDto> barangDtos = barangs.stream()
        .map((product) -> (BarangMapper.mapToBarangDto(product)))
        .collect(Collectors.toList());
        return barangDtos;
    }


    @Override
    public List<BarangDto> searchBarangs(String keyword) {
        List<Barang> barangs = barangRepository.findByAuthorContainingOrTitleContaining(keyword, keyword);
        List<BarangDto> searchResult = barangs.stream()
            .map((product) -> (BarangMapper.mapToBarangDto(product)))
            .collect(Collectors.toList());
        return searchResult;
    }
}
