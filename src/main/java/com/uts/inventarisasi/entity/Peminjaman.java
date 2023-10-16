/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.uts.inventarisasi.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;
import java.util.Date;
import java.util.concurrent.TimeUnit;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

/**
 *
 * @author AFNAN
 */
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "peminjaman")

public class Peminjaman {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @ManyToOne
    @JoinColumn(name = "member_id")
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    private Anggota anggota;
   
    @JsonSetter("anggota")
    public void setMemberIdFromJson(@JsonProperty("memberID") Long memberId) {
        if (anggota == null) {
            anggota = new Anggota();
        }
        anggota.setId(memberId);
    }
    

    @ManyToOne
    @JoinColumn(name = "barang_id")
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    private Barang barang;

    
    @JsonSetter("barang")
    public void setBookIdFromJson(@JsonProperty("id") Long barangId) {
        if (barang == null) {
            barang = new Barang();
        }
        barang.setId(barangId);
    }
    
    @Column(nullable = true)
    private Date tanggalPinjam;
    
    @Column(nullable = true)
    private Date batasPengembalian;
    
    @Column(nullable = true)
    private Date tanggalPengembalian;
    
    @Column(nullable = true)
    private String status;
    
    @Column(nullable = true)
    private int lamaTelat;


    @PreUpdate
    public void calculateLamaTelat() {
        if (batasPengembalian != null && tanggalPengembalian != null) {
            long diffInMillies = Math.abs(tanggalPengembalian.getTime() - batasPengembalian.getTime());
            int diffInDays = (int) TimeUnit.DAYS.convert(diffInMillies, TimeUnit.MILLISECONDS);
            lamaTelat = Math.max(0, diffInDays);
        }
    }
    
    
}
