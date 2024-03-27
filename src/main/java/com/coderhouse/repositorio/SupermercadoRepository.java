package com.coderhouse.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.coderhouse.entidades.Supermercado;

@Repository
public interface SupermercadoRepository extends JpaRepository<Supermercado , Integer>{

}
