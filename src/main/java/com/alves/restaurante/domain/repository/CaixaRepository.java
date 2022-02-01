package com.alves.restaurante.domain.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.alves.restaurante.domain.model.Caixa;

@Repository
public interface CaixaRepository extends JpaRepository<Caixa, Long>{
	Optional<Caixa> findById(Long id);
}
