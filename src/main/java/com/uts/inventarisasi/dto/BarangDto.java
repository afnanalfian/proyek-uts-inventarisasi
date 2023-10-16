/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.uts.inventarisasi.dto;

/**
 *
 * @author AFNAN
 */
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor

public class BarangDto {
    private Long id;
    @NotEmpty(message = "Nama barang wajib diisi.")

    private String nama;
    @NotNull(message = "Lokasi barang wajib diisi.")

    private String lokasi;

    private String jumlah;
}