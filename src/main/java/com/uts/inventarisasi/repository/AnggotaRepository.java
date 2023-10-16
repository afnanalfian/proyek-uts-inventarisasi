/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.uts.inventarisasi.repository;

/**
 *
 * @author AFNAN
 */
import com.uts.inventarisasi.entity.Anggota;
import java.util.List;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "anggota", path = "anggota")

public interface AnggotaRepository extends PagingAndSortingRepository<Anggota,Long>, CrudRepository<Anggota, Long> {
    List<Anggota> findByName(@Param("name") String name);
    List<Anggota> findByMemberID(@Param("member_id") String memberID);
}
