package com.alves.restaurante.domain.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.alves.restaurante.domain.model.Mesa;

@Repository
public interface MesaRepository extends JpaRepository<Mesa, Long>{
	Optional<Mesa> findById(Long id);
}
