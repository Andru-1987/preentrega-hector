package com.coderhouse.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.coderhouse.entidades.Cajero;

@Repository
public interface CajeroRepository extends JpaRepository<Cajero, Integer>{

}
