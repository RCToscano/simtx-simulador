package br.gov.caixa.simtx.simulador.services.limite.desfazer;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.gson.annotations.SerializedName;

import br.gov.caixa.simtx.simulador.services.limite.validar.RequisicaoValidaLimite;

public class RequisicaoDesfazLimite extends RequisicaoValidaLimite {

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
