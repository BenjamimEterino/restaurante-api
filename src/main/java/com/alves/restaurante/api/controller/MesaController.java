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

import com.alves.restaurante.domain.model.Mesa;
import com.alves.restaurante.domain.service.MesaService;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping("/mesa")
public class MesaController {
	
	private final MesaService mesaService;
	
	@GetMapping("/todas")
	public ResponseEntity<List<Mesa>> listar() {
		return ResponseEntity.ok().body(mesaService.buscar());
	}
	
	@PostMapping
	public Mesa salvar(@RequestBody Mesa mesa) {
		return mesaService.salvar(mesa);
	}
	
	@DeleteMapping("/{mesaId}")
	public ResponseEntity<Void> excluir(@PathVariable Long mesaId) {
		if (!mesaService.existsById(mesaId)) {
			return ResponseEntity.notFound().build();
		}
		
		mesaService.excluir(mesaId);
		
		return ResponseEntity.noContent().build();
	}
	
	@GetMapping("/{mesaId}")
	public ResponseEntity<Mesa> buscar(@PathVariable Long mesaId) {
		if(mesaService.existsById(mesaId)) {
			return ResponseEntity.ok().body(mesaService.buscarById(mesaId));
		} 
		return ResponseEntity.notFound().build();
	}
	
	@PutMapping("/{mesaId}")
	public ResponseEntity<Mesa> actualizar(@PathVariable Long mesaId, @RequestBody Mesa mesa) {
		if (!mesaService.existsById(mesaId)) {
			return ResponseEntity.notFound().build();
		}
		
		mesa.setId(mesaId);
		
		mesa = mesaService.salvar(mesa);
		
		return ResponseEntity.ok(mesa);
	}

}
