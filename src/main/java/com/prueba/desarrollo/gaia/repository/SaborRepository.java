package com.prueba.desarrollo.gaia.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.prueba.desarrollo.gaia.entity.Sabor;

@Repository
public interface SaborRepository extends JpaRepository<Sabor, Long> {

}
