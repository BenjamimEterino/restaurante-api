package com.alves.restaurante.domain.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.alves.restaurante.domain.model.Garcom;
import com.alves.restaurante.domain.model.Mesa;

@Repository
public interface GarcomRepository extends JpaRepository<Garcom, Long>{
	Optional<Garcom> findById(Long id);
}
