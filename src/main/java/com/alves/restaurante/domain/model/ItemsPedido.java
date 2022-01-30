package com.alves.restaurante.domain.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class ItemsPedido {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne
	private Pedido pedido;
	
	@ManyToOne
	private Produto produto;
	
	private int quantidade;
	private double valorUnitario;
	private double ValorTotal;
	private String observacao;

}
