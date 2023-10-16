/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.uts.inventarisasi.repository;

import com.uts.inventarisasi.entity.Peminjaman;
import java.util.List;
/**
 *
 * @author AFNAN
 */
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.repository.CrudRepository;

@RepositoryRestResource(collectionResourceRel = "peminjaman", path = "peminjaman")
public interface PeminjamanRepository extends JpaRepository<Peminjaman,Long>, CrudRepository<Peminjaman, Long> {
    List<Peminjaman> searchByStatusContaining(String keyword);
}

