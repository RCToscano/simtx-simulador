package br.gov.caixa.simtx.simulador.services.limite.desfazer;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.gson.annotations.SerializedName;

import br.gov.caixa.simtx.simulador.services.limite.validar.RequisicaoValidaLimite;

public class RequisicaoDesfazLimite extends RequisicaoValidaLimite {

	@NotNull(message = "sistema_origem nao informada")
	@Size(min = 3, message = "sistema_origem deve ser informado")
	@JsonProperty("sistema_origem")
	@SerializedName("sistema_origem")
	private String sistemaOrigem;



	public String getSistemaOrigem() {
		return sistemaOrigem;
	}

	public void setSistemaOrigem(String sistemaOrigem) {
		this.sistemaOrigem = sistemaOrigem;
	}

}
