/*******************************************************************************
 * Copyright (C)  2017 - CAIXA Econômica Federal 
 * 
 * Todos os direitos reservados
 ******************************************************************************/
package br.gov.caixa.simtx.simulador.util.exception;

public class ControleException extends Exception {
	private static final long serialVersionUID = 6215361465016735503L;

	private final String sistemaOrigem;
	private final String mensagem;

	public ControleException(String mensagem, String sistemaOrigem) {
		super();
		this.sistemaOrigem = sistemaOrigem;
		this.mensagem = mensagem;
	}
	
	public String getSistemaOrigem() {
		return sistemaOrigem;
	}

	public String getMensagem() {
		return mensagem;
	}
	
}
