package com.alves.restaurante.domain.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.alves.restaurante.domain.exception.EntidadeNaoEncontrada;
import com.alves.restaurante.domain.model.Adicional;
import com.alves.restaurante.domain.repository.AdicionalRepository;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class AdicionalService {
	private AdicionalRepository adicionalRepository;
	
	
	public List<Adicional> buscar() {
		return adicionalRepository.findAll();
	}

	public Adicional buscarById(Long adicionalId) {
		return adicionalRepository.findById(adicionalId)
				.orElseThrow(() -> new EntidadeNaoEncontrada("Item nao encontrada"));
	}

	public Adicional salvar(Adicional adicional) {
		adicionalRepository.save(adicional);
		return adicional;
	}

	public void excluir(Long adicionalId) {
		// adicional = this.buscarById(adicionalId);
		adicionalRepository.deleteById(adicionalId);
		
		//return adicional;
	}

	public boolean existsById(Long adicionalId) {
		if (adicionalRepository.existsById(adicionalId)) {
			return true;
		} else {
			return false;
		}
	}
}
