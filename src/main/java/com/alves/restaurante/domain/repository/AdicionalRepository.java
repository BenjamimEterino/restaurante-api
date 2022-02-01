package com.alves.restaurante.domain.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.alves.restaurante.domain.model.Adicional;

@Repository
public interface AdicionalRepository extends JpaRepository<Adicional, Long>{
	Optional<Adicional> findById(Long id);
}
