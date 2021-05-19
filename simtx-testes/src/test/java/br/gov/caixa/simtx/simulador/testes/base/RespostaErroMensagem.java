package br.gov.caixa.simtx.simulador.testes.base;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class RespostaErroMensagem {

	@NotNull(message = "mensagemNegocial nao informada")
	@Size(min = 1, message = "mensagemNegocial nao informada")
	private String mensagemNegocial;

	private String mensagemTecnica;

	public String getMensagemNegocial() {
		return mensagemNegocial;
	}

	public void setMensagemNegocial(String mensagemNegocial) {
		this.mensagemNegocial = mensagemNegocial;
	}

	public String getMensagemTecnica() {
		return mensagemTecnica;
	}

	public void setMensagemTecnica(String mensagemTecnica) {
		this.mensagemTecnica = mensagemTecnica;
	}

}
