/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.uts.inventarisasi.repository;

/**
 *
 * @author AFNAN
 */
import com.uts.inventarisasi.entity.Barang;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "barang", path = "barang")
public interface BarangRepository extends JpaRepository<Barang, Long>{

    List<Barang> findByAuthorContainingOrTitleContaining(String lokasi, String nama);  
}
