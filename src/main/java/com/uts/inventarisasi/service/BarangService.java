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
import java.util.List;
public interface BarangService {
    public void createBarang(BarangDto barangDto);
    public List<BarangDto> getBarangs();
    

    public List<BarangDto> searchBarangs(String keyword);
}