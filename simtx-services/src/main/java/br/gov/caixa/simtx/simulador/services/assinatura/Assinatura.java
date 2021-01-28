package br.gov.caixa.simtx.simulador.services.assinatura;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class Assinatura {

	@NotNull(message = "tipo assinatura nao informada")
	@Valid
	private TipoAssinaturaApiEnum tipo;

	@NotNull(message = "codigo assinatura nao informada")
	@Size(min = 1, max = 16, message= "codigo assinatura deve ser informada e ter no maximo 16 caracteres")
	private String codigo;



	public TipoAssinaturaApiEnum getTipo() {
		return tipo;
	}

	public void setTipo(TipoAssinaturaApiEnum tipo) {
		this.tipo = tipo;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
}
