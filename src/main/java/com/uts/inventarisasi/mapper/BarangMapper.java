/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.uts.inventarisasi.mapper;

/**
 *
 * @author AFNAN
 */
import com.uts.inventarisasi.dto.BarangDto;
import com.uts.inventarisasi.entity.Barang;

public class BarangMapper {
    
    public static Barang mapToBarang(BarangDto barangDto){
        return Barang.builder()
        .id(barangDto.getId())
        .nama(barangDto.getNama())
        .jumlah(barangDto.getJumlah())
        .lokasi(barangDto.getLokasi())
        .build();
    }
    
    public static BarangDto mapToBarangDto(Barang barang){
        return BarangDto.builder()
        .id(barang.getId())
        .nama(barang.getNama())
        .jumlah(barang.getJumlah())
        .lokasi(barang.getLokasi())
        .build();
    }
}

