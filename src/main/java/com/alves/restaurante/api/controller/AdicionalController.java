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

import com.alves.restaurante.domain.model.Adicional;
import com.alves.restaurante.domain.service.AdicionalService;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping("/adicional")
public class AdicionalController {
	
	private final AdicionalService adicionalService;
	
	@GetMapping
	public ResponseEntity<List<Adicional>> listar() {
		return ResponseEntity.ok().body(adicionalService.buscar());
	}
	
	@PostMapping
	public Adicional salvar(@RequestBody Adicional adicional) {
		return adicionalService.salvar(adicional);
	}
	
	@DeleteMapping("/{adicionalId}")
	public ResponseEntity<Void> excluir(@PathVariable Long adicionalId) {
		if (!adicionalService.existsById(adicionalId)) {
			return ResponseEntity.notFound().build();
		}	
		
		adicionalService.excluir(adicionalId);
		return ResponseEntity.noContent().build();
				//.ok().body(adicionalService.excluir(adicionalId));
	}
	
	@GetMapping("/{adicionalId}")
	public ResponseEntity<Adicional> buscar(@PathVariable Long adicionalId) {
		if(adicionalService.existsById(adicionalId)) {
			return ResponseEntity.ok().body(adicionalService.buscarById(adicionalId));
		} 
		return ResponseEntity.notFound().build();
	}
	
	@PutMapping("/{adicionalId}")
	public ResponseEntity<Adicional> actualizar(@PathVariable Long adicionalId, @RequestBody Adicional adicional) {
		if (!adicionalService.existsById(adicionalId)) {
			return ResponseEntity.notFound().build();
		}
		
		adicional.setId(adicionalId);
		
		adicional = adicionalService.salvar(adicional);
		
		return ResponseEntity.ok(adicional);
	}

}
