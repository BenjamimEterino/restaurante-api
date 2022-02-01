package com.alves.restaurante.api.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alves.restaurante.domain.model.Produto;
import com.alves.restaurante.domain.service.ProdutoService;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping("/produto")
public class ProdutoController {
	
	private final ProdutoService produtoService;
	
	@GetMapping
	public ResponseEntity<List<Produto>> listar() {
		return ResponseEntity.ok().body(produtoService.buscar());
	}
	
	@PostMapping
	public Produto salvar(@RequestBody Produto produto) {
		return produtoService.salvar(produto);
	}
	
	@DeleteMapping("/{mesaId}")
	public ResponseEntity<Void> excluir(@PathVariable Long produtoId) {
		if (!produtoService.existsById(produtoId)) {
			return ResponseEntity.notFound().build();
		}
		
		produtoService.excluir(produtoId);
		
		return ResponseEntity.noContent().build();
	}
	
	@GetMapping("/{mesaId}")
	public ResponseEntity<Produto> buscar(@PathVariable Long produtoId) {
		if(produtoService.existsById(produtoId)) {
			return ResponseEntity.ok().body(produtoService.buscarById(produtoId));
		} 
		return ResponseEntity.notFound().build();
	}
	
	@PutMapping("/{mesaId}")
	public ResponseEntity<Produto> actualizar(@PathVariable Long produtoId, @RequestBody Produto produto) {
		if (!produtoService.existsById(produtoId)) {
			return ResponseEntity.notFound().build();
		}
		
		produto.setId(produtoId);
		
		produto = produtoService.salvar(produto);
		
		return ResponseEntity.ok(produto);
	}

}
