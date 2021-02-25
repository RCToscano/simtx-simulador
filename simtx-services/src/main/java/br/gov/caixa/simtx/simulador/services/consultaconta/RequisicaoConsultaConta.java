package br.gov.caixa.simtx.simulador.services.consultaconta;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class RequisicaoConsultaConta {

	@NotNull(message = "unidade nao informada")
	@Size(min = 1, max = 5, message = "unidade deve ser informado e ter no maximo 5 caracteres")
	private String unidade;

	@NotNull(message = "numero nao informado")
	@Size(min = 1, max = 12, message = "numero deve ser informado e ter no maximo 12 caracteres")
	private String numero;

	@NotNull(message = "produto nao informado")
	@Size(min = 1, max = 4, message = "produto deve ser informado e ter no maximo 4 caracteres")
	private String produto;

	@NotNull(message = "dv nao informado")
	@Size(min = 0, max = 1, message = "dv deve ser informado e ter no maximo 1 caracter")
	private String dv;

	private String titular;

	@Size(min = 0, max = 2, message = "offset deve ter no maximo 2 caracteres")
	private String offset;

	private String tipoConta;


	public RequisicaoConsultaConta(String unidade, String numero, String produto, String dv, String titular,
			String offset, String tipoConta) {
		super();
		this.unidade = unidade;
		this.numero = numero;
		this.produto = produto;
		this.dv = dv;
		this.titular = titular;
		this.offset = offset;
		this.tipoConta = tipoConta;
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

	public String getTitular() {
		return titular;
	}

	public void setTitular(String titular) {
		this.titular = titular;
	}

	public String getOffset() {
		return offset;
	}

	public void setOffset(String offset) {
		this.offset = offset;
	}

	public String getTipoConta() {
		return tipoConta;
	}

	public void setTipoConta(String tipoConta) {
		this.tipoConta = tipoConta;
	}

}
