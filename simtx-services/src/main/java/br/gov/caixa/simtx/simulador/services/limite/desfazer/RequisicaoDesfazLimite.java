package br.gov.caixa.simtx.simulador.services.limite.desfazer;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.gson.annotations.SerializedName;

import br.gov.caixa.simtx.simulador.services.limite.validar.RequisicaoValidaLimite;
import br.gov.caixa.simtx.simulador.services.validation.NotEqual;

public class RequisicaoDesfazLimite extends RequisicaoValidaLimite {

	@JsonProperty("sistema_origem")
	@SerializedName("sistema_origem")
	@NotEqual(secondValue = "SIMTX", message = "clientIdCanal nao pode ser do simtx")
	private String sistemaOrigem;


	public String getSistemaOrigem() {
		return sistemaOrigem;
	}

	public void setSistemaOrigem(String sistemaOrigem) {
		this.sistemaOrigem = sistemaOrigem;
	}

}
