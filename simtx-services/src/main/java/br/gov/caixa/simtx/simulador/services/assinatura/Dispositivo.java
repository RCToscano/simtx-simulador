package br.gov.caixa.simtx.simulador.services.assinatura;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.gson.annotations.SerializedName;

public class Dispositivo {
	
	@NotNull(message = "sistema_operacional nao informado")
	@Valid
	@JsonProperty("sistema_operacional")
	@SerializedName("sistema_operacional")
	private TipoDispositivoApiEnum sistemaOperacional;

	@NotNull(message = "codigo dispositivo nao informado")
	@Size(min = 1, max = 16, message= "codigo dispositivo deve ser informado e ter no maximo 16 caracteres")
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
