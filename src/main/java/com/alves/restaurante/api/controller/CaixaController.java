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

import com.alves.restaurante.domain.model.Caixa;
import com.alves.restaurante.domain.service.CaixaService;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping("/caixa")
public class CaixaController {
	
	private final CaixaService caixaService;
	
	@GetMapping
	public ResponseEntity<List<Caixa>> listar() {
		return ResponseEntity.ok().body(caixaService.buscar());
	}
	
	@PostMapping
	public Caixa salvar(@RequestBody Caixa caixa) {
		return caixaService.salvar(caixa);
	}
	
	@DeleteMapping("/{caixaId}")
	public ResponseEntity<Void> excluir(@PathVariable Long CaixaId) {
		if (!caixaService.existsById(CaixaId)) {
			return ResponseEntity.notFound().build();
		}
		
		caixaService.excluir(CaixaId);
		
		return ResponseEntity.noContent().build();
	}
	
	@GetMapping("/{ciaxaId}")
	public ResponseEntity<Caixa> buscar(@PathVariable Long CaixaID) {
		if(caixaService.existsById(CaixaID)) {
			return ResponseEntity.ok().body(caixaService.buscarById(CaixaID));
		} 
		return ResponseEntity.notFound().build();
	}
	
	@PutMapping("/{ciaxaId}")
	public ResponseEntity<Caixa> actualizar(@PathVariable Long CaixaID, @RequestBody Caixa caixa) {
		if (!caixaService.existsById(CaixaID)) {
			return ResponseEntity.notFound().build();
		}
		
		caixa.setId(CaixaID);
		
		caixa = caixaService.salvar(caixa);
		
		return ResponseEntity.ok(caixa);
	}

}
