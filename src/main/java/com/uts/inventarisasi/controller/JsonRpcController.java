/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.uts.inventarisasi.controller;

/**
 *
 * @author AFNAN
 */
import com.fasterxml.jackson.databind.JsonNode;
import com.uts.inventarisasi.dto.BarangDto;
import com.uts.inventarisasi.rpc.JsonRpcRequest;
import com.uts.inventarisasi.rpc.JsonRpcResponse;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.uts.inventarisasi.service.BarangService;

@RestController
    public class JsonRpcController {
    @Autowired
    private BarangService barangService;
    @PostMapping("/jsonrpc")
    public ResponseEntity<Object> handleJsonRpcRequest(@RequestBody JsonRpcRequest request) {
        try {
            String method = request.getMethod();
            JsonNode params = request.getParams();
            System.out.println("Method: "+ method); 
            switch (method) {
                case "createBarang" -> {
                    String nama = params.get("nama").asText();
                    String lokasi = params.get("lokasi").asText();
                    String jumlah = params.get("jumlah").asText();
                    BarangDto barang = BarangDto.builder()
                            .nama(nama)
                            .jumlah(jumlah)
                            .lokasi(lokasi)
                            .build();
                    barangService.createBarang(barang);
                    return ResponseEntity.ok(new JsonRpcResponse("created", request.getId()));
                }

                case "getBarangs" -> {
                    List<BarangDto> barangs = barangService.getBarangs();
                    return ResponseEntity.ok(new JsonRpcResponse(barangs, request.getId()));
                }
                case "searchBarangs" -> {
                    String keyword = params.get("keyword").asText();
                    List<BarangDto> searchResult = barangService.searchBarangs(keyword);
                    return ResponseEntity.ok(new JsonRpcResponse(searchResult, request.getId()));
                }
                    
                default -> {
                    return ResponseEntity.badRequest().build();
                }
                }

            
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }
}
