package com.alves.restaurante.domain.model;

import java.time.OffsetDateTime;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Preparo {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private int pedido;
	private String mesa;
	private String produto;
	private int observacao;
	private String hora;
	
	@Enumerated(EnumType.STRING)
	private StatusPreparo status;

}
