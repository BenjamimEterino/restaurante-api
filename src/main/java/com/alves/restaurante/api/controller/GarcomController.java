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

import com.alves.restaurante.domain.model.Garcom;
import com.alves.restaurante.domain.model.Mesa;
import com.alves.restaurante.domain.service.GarcomService;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping("/garcom")
public class GarcomController {
	
	private final GarcomService garcomService;
	
	@GetMapping
	public ResponseEntity<List<Garcom>> listar() {
		return ResponseEntity.ok().body(garcomService.buscar());
	}
	
	@PostMapping
	public Garcom salvar(@RequestBody Garcom garcom) {
		return garcomService.salvar(garcom);
	}
	
	@DeleteMapping("/{garcomId}")
	public ResponseEntity<Void> excluir(@PathVariable Long garcomId) {
		if (!garcomService.existsById(garcomId)) {
			return ResponseEntity.notFound().build();
		}
		
		garcomService.excluir(garcomId);
		
		return ResponseEntity.noContent().build();
	}
	
	@GetMapping("/{garcomId}")
	public ResponseEntity<Garcom> buscar(@PathVariable Long garcomId) {
		if(garcomService.existsById(garcomId)) {
			return ResponseEntity.ok().body(garcomService.buscarById(garcomId));
		} 
		return ResponseEntity.notFound().build();
	}
	
	@PutMapping("/{garcomId}")
	public ResponseEntity<Garcom> actualizar(@PathVariable Long garcomId, @RequestBody Garcom garcom) {
		if (!garcomService.existsById(garcomId)) {
			return ResponseEntity.notFound().build();
		}
		
		garcom.setId(garcomId);
		
		garcom = garcomService.salvar(garcom);
		
		return ResponseEntity.ok(garcom);
	}

}
