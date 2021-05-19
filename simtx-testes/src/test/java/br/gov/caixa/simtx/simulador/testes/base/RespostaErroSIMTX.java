package br.gov.caixa.simtx.simulador.testes.base;

import javax.validation.Valid;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class RespostaErroSIMTX {

	@Min(value = 1, message = "nsuTransacao deve ser informado e ter no maximo 15 caracteres")
	@Max(value = 999999999999999l, message = "nsuTransacao deve ser informado e ter no maximo 15 caracteres")
	private Long nsu;

	@NotNull(message = "codigoRetorno nao informada")
	@Size(min = 2, max = 3, message = "codigoRetorno deve ser informado e ter no maximo 3 caracteres")
	private String codigoRetorno;

	@NotNull(message = "origemRetorno nao informada")
	@Size(min = 5, max = 5, message = "origemRetorno deve ser informado e ter 5 caracteres")
	private String origemRetorno;

	@NotNull(message = "mensagem nao informado")
	@Valid
	private RespostaErroMensagem mensagem;

	public Long getNsu() {
		return nsu;
	}

	public void setNsu(Long nsu) {
		this.nsu = nsu;
	}

	public String getCodigoRetorno() {
		return codigoRetorno;
	}

	public void setCodigoRetorno(String codigoRetorno) {
		this.codigoRetorno = codigoRetorno;
	}

	public String getOrigemRetorno() {
		return origemRetorno;
	}

	public void setOrigemRetorno(String origemRetorno) {
		this.origemRetorno = origemRetorno;
	}

	public RespostaErroMensagem getMensagem() {
		return mensagem;
	}

	public void setMensagem(RespostaErroMensagem mensagem) {
		this.mensagem = mensagem;
	}

}
