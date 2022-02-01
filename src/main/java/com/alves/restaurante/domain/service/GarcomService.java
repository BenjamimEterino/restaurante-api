package com.alves.restaurante.domain.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.alves.restaurante.domain.exception.EntidadeNaoEncontrada;
import com.alves.restaurante.domain.model.Garcom;
import com.alves.restaurante.domain.model.StatusDisponibilidade;
import com.alves.restaurante.domain.repository.GarcomRepository;

import lombok.AllArgsConstructor;


@AllArgsConstructor
@Service
public class GarcomService {
	private GarcomRepository garcomRepository;
	
	public List<Garcom> buscar() {
		return garcomRepository.findAll();
	}
	
	public Garcom buscarById(Long garcomId) {
		return garcomRepository.findById(garcomId)
				.orElseThrow(() -> new EntidadeNaoEncontrada("Garcom nao encontrado") );
	}
	
	public Garcom salvar(Garcom mesa) {
		garcomRepository.save(mesa);		
		return mesa;
	}
	
	public void excluir(Long garcomId) {
		garcomRepository.deleteById(garcomId);
	}

	public boolean existsById(Long garcomId) {
		if (garcomRepository.existsById(garcomId)) {
			return true;
		} else {
			return false;
		}
	}
}
