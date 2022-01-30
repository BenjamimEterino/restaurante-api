package com.alves.restaurante.domain.exception;

public class EntidadeNaoEncontrada extends NegocioException{

	private static final long serialVersionUID = 1L;
	
	public EntidadeNaoEncontrada(String mensagem) {
		super(mensagem);
	}

}
