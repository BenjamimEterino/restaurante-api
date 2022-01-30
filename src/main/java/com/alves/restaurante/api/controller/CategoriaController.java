package com.alves.restaurante.api.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alves.restaurante.domain.model.Categoria;
import com.alves.restaurante.domain.service.CategoriaService;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping("/categoria")
public class CategoriaController {
	
	private final CategoriaService categoriaService;
	
	@GetMapping("/todas")
	public ResponseEntity<List<Categoria>> listar() {
		return ResponseEntity.ok().body(categoriaService.buscar());
	}

}
