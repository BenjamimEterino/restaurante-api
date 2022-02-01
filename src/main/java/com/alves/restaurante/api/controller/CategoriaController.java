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

import com.alves.restaurante.domain.model.Categoria;
import com.alves.restaurante.domain.repository.CategoriaRepository;
import com.alves.restaurante.domain.service.CategoriaService;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping("/categoria")
public class CategoriaController {
	
	private CategoriaRepository categoriaRepository;
	private final CategoriaService categoriaService;
	
	@GetMapping
	public ResponseEntity<List<Categoria>> listar() {
		return ResponseEntity.ok().body(categoriaService.buscar());
	}
	
	@PostMapping
	public Categoria salvar(@RequestBody Categoria categoria) {
		return categoriaService.salvar(categoria);
	}
	
	@GetMapping("/{categoriaId}")
	public ResponseEntity<Categoria> buscar(@PathVariable Long categoriaId) {
		return categoriaRepository.findById(categoriaId).map(ResponseEntity::ok)
				.orElse(ResponseEntity.notFound().build());
	}
	
	@DeleteMapping("/{categoriaId}")
	public ResponseEntity<Void> excluir(@PathVariable Long categoriaId) {
		if (!categoriaService.existsById(categoriaId)) {
			return ResponseEntity.notFound().build();
		}
		
		categoriaService.excluir(categoriaId);
		
		return ResponseEntity.noContent().build();
	}
	

	@PutMapping("/{categoriaId}")
	public ResponseEntity<Categoria> actualizar(@PathVariable Long categoriaId, @RequestBody Categoria categoria) {
		if (!categoriaService.existsById(categoriaId)) {
			return ResponseEntity.notFound().build();
		}
		
		categoria.setId(categoriaId);
		
		categoria = categoriaService.salvar(categoria);
		
		return ResponseEntity.ok(categoria);
	}

}
