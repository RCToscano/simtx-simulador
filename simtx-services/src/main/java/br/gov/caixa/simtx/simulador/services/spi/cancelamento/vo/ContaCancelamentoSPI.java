package br.gov.caixa.simtx.simulador.services.spi.cancelamento.vo;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class ContaCancelamentoSPI {

	@Size(max = 4, message = "produto ter no maximo 4 caracteres")
	private String agencia;

	@NotNull(message = "numeroConta obrigatorio")
	@Size(min = 1, max = 13, message = "numeroConta deve ser informado e ter no maximo 13 caracteres")
	private String numeroConta;

	@Size(max = 4, message = "produto deve ter no maximo 4 caracteres")
	private String produto;

	public String getAgencia() {
		return agencia;
	}

	public void setAgencia(String agencia) {
		this.agencia = agencia;
	}

	public String getNumeroConta() {
		return numeroConta;
	}

	public void setNumeroConta(String numeroConta) {
		this.numeroConta = numeroConta;
	}

	public String getProduto() {
		return produto;
	}

	public void setProduto(String produto) {
		this.produto = produto;
	}

}
