package br.gov.caixa.simtx.simulador.services.assinatura.multipla;

import javax.validation.Valid;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.gson.annotations.SerializedName;

public class Dispositivo {
	
	@Valid
	@JsonProperty("sistema_operacional")
	@SerializedName("sistema_operacional")
	private TipoDispositivoApiEnum sistemaOperacional;

	@Size(max = 16, message= "codigo dispositivo deve ser informado e ter no maximo 16 caracteres")
	private String codigo;


	public TipoDispositivoApiEnum getSistemaOperacional() {
		return sistemaOperacional;
	}

	public void setSistemaOperacional(TipoDispositivoApiEnum sistemaOperacional) {
		this.sistemaOperacional = sistemaOperacional;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

}
