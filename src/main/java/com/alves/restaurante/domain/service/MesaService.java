package com.alves.restaurante.domain.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.alves.restaurante.domain.exception.EntidadeNaoEncontrada;
import com.alves.restaurante.domain.model.Mesa;
import com.alves.restaurante.domain.model.StatusDisponibilidade;
import com.alves.restaurante.domain.repository.MesaRepository;

import lombok.AllArgsConstructor;


@AllArgsConstructor
@Service
public class MesaService {
	private MesaRepository mesaRepository;
	
	public List<Mesa> buscar() {
		return mesaRepository.findAll();
	}
	
	public Mesa buscarById(Long mesaID) {
		return mesaRepository.findById(mesaID)
				.orElseThrow(() -> new EntidadeNaoEncontrada("Mesa nao encontrada") );
	}
	
	public Mesa salvar(Mesa mesa) {
		
		mesa.setDisponivel(StatusDisponibilidade.DISPONIVEL);
		mesaRepository.save(mesa);		
		return mesa;
	}
	
	public void excluir(Long mesaId) {
		mesaRepository.deleteById(mesaId);
	}

	public boolean existsById(Long mesaId) {
		if (mesaRepository.existsById(mesaId)) {
			return true;
		} else {
			return false;
		}
	}
}
