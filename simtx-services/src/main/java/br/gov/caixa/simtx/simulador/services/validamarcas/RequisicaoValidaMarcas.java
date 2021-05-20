package br.gov.caixa.simtx.simulador.services.validamarcas;

import java.util.List;

import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.gson.annotations.SerializedName;

public class RequisicaoValidaMarcas {

	@NotNull(message = "marcas_impeditivas nao informado")
	@JsonProperty("marcas_impeditivas")
	@SerializedName("marcas_impeditivas")
	private List<String> marcasImpeditivas;

	public List<String> getMarcasImpeditivas() {
		return marcasImpeditivas;
	}

	public void setMarcasImpeditivas(List<String> marcasImpeditivas) {
		this.marcasImpeditivas = marcasImpeditivas;
	}

}
