package com.alves.restaurante.domain.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.alves.restaurante.domain.exception.EntidadeNaoEncontrada;
import com.alves.restaurante.domain.model.Categoria;
import com.alves.restaurante.domain.repository.CategoriaRepository;

import lombok.AllArgsConstructor;


@AllArgsConstructor
@Service
public class CategoriaService {
	private CategoriaRepository categoriaRepository;
	
	public List<Categoria> buscar() {
		return categoriaRepository.findAll();
	}
	
	public Categoria buscarId(Long categoriaID) {
		return categoriaRepository.findById(categoriaID)
				.orElseThrow(() -> new EntidadeNaoEncontrada("Categoria nao encontrada") );
	}
	
	public Categoria salvar(Categoria categoria) {
		categoriaRepository.save(categoria);		
		return categoria;
	}
	
	public Categoria excluir(Long categoriaId) {
		categoriaRepository.deleteById(categoriaId);
		
		return this.buscarId(categoriaId);
	}
}
