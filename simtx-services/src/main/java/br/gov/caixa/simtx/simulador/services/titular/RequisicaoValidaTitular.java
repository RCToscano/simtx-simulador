package br.gov.caixa.simtx.simulador.services.titular;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonProperty;

public class RequisicaoValidaTitular {

	@NotNull(message = "unidade nao informada")
	@Size(min = 1, max = 5, message = "unidade deve ser informado e ter no maximo 12 caracteres")
	private String unidade;

	@NotNull(message = "numero nao informado")
	@Size(min = 1, max = 12, message = "numero deve ser informado e ter no maximo 12 caracteres")
	@JsonProperty("conta")
	private String numero;

	@NotNull(message = "produto nao informado")
	@Size(min = 1, max = 4, message = "produto deve ser informado e ter no maximo 4 caracteres")
	private String produto;

	@NotNull(message = "dv nao informado")
	@Size(min = 1, max = 1, message = "dv deve ser informado e ter no maximo 1 caracter")
	private String dv;

	@Size(max = 11, message = "cpf deve ter no maximo 11 caracteres")
	private String cpf;
	
	public RequisicaoValidaTitular(String unidade, String numero, String produto, String dv, String cpf) {
		super();
		this.unidade = unidade;
		this.numero = numero;
		this.produto = produto;
		this.dv = dv;
		this.cpf = cpf;
	}

	public String getUnidade() {
		return unidade;
	}

	public void setUnidade(String unidade) {
		this.unidade = unidade;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getProduto() {
		return produto;
	}

	public void setProduto(String produto) {
		this.produto = produto;
	}

	public String getDv() {
		return dv;
	}

	public void setDv(String dv) {
		this.dv = dv;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

}
