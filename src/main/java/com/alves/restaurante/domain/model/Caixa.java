package com.alves.restaurante.domain.model;

import java.time.OffsetDateTime;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Caixa {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private double saldoInicial;
	private double saldoFinal;
	private OffsetDateTime horaInicial;
	private OffsetDateTime horaFinal;
	private String observcao;
	
	@Enumerated(EnumType.STRING)
	private StatusCaixa status;
	

}
