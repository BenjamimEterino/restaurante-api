package com.alves.restaurante.domain.model;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Produto {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String produto;
	private double valor;
	
	@Enumerated(EnumType.STRING)
	private StatusDisponibilidade disponivel;
	
	@ManyToOne
	private Categoria categoria;

}
