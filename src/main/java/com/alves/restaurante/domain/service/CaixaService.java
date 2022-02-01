package com.alves.restaurante.domain.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.alves.restaurante.domain.exception.EntidadeNaoEncontrada;
import com.alves.restaurante.domain.model.Caixa;
import com.alves.restaurante.domain.model.StatusCaixa;
import com.alves.restaurante.domain.repository.CaixaRepository;

import lombok.AllArgsConstructor;


@AllArgsConstructor
@Service
public class CaixaService {
	private CaixaRepository caixaRepository;
	
	public List<Caixa> buscar() {
		return caixaRepository.findAll();
	}
	
	public Caixa buscarById(Long caixaID) {
		return caixaRepository.findById(caixaID)
				.orElseThrow(() -> new EntidadeNaoEncontrada("Caixa nao encontrado") );
	}
	
	public Caixa salvar(Caixa caixa) {		
		caixa.setStatus(StatusCaixa.INACTIVO);
		caixaRepository.save(caixa);		
		return caixa;
	}
	
	public void excluir(Long caixaId) {
		caixaRepository.deleteById(caixaId);
	}

	public boolean existsById(Long caixaId) {
		if (caixaRepository.existsById(caixaId)) {
			return true;
		} else {
			return false;
		}
	}
}
