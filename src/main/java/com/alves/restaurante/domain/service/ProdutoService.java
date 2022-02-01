package com.alves.restaurante.domain.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.alves.restaurante.domain.exception.EntidadeNaoEncontrada;
import com.alves.restaurante.domain.model.Produto;
import com.alves.restaurante.domain.repository.ProdutoRepository;

import lombok.AllArgsConstructor;


@AllArgsConstructor
@Service
public class ProdutoService {
	private ProdutoRepository produtoRepository;
	
	public List<Produto> buscar() {
		return produtoRepository.findAll();
	}
	
	public Produto buscarById(Long produtoId) {
		return produtoRepository.findById(produtoId)
				.orElseThrow(() -> new EntidadeNaoEncontrada("Produto nao encontrado") );
	}
	
	public Produto salvar(Produto produto) {
		produtoRepository.save(produto);		
		return produto;
	}
	
	
	public void excluir(Long produtoId) {
		produtoRepository.deleteById(produtoId);
	}

	public boolean existsById(Long produtoId) {
		if (produtoRepository.existsById(produtoId)) {
			return true;
		} else {
			return false;
		}
	}
}
