package br.gov.caixa.simtx.simulador.services.assinatura.multipla.lista;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

public class RequisicaoListaAssinaturas {

	@NotNull(message = "unidade nao informada")
	@Min(value = 1, message = "unidade deve ser informada e ter no maximo 5 caracteres")
	@Max(value = 99999, message = "unidade deve ser informada e ter no maximo 5 caracteres")
	private Integer unidade;

	@NotNull(message = "produto nao informado")
	@Min(value = 1, message = "produto deve ser informado e ter no maximo 4 caracteres")
	@Max(value = 9999, message = "produto deve ser informado e ter no maximo 4 caracteres")
	private Integer produto;

	@NotNull(message = "numero nao informado")
	@Min(value = 1, message = "numero deve ser informado e ter no maximo 12 caracteres")
	@Max(value = 999999999999l, message = "numero deve ser informado e ter no maximo 12 caracteres")
	private Long numero;

	@NotNull(message = "dv nao informado")
	@Min(value = 0, message = "dv deve ser informado e ter 1 caracter")
	@Max(value = 9, message = "dv deve ser informado e ter 1 caracter")
	private Integer dv;

	public RequisicaoListaAssinaturas(Integer unidade, Integer produto, Long numero, Integer dv) {
		super();
		this.unidade = unidade;
		this.produto = produto;
		this.numero = numero;
		this.dv = dv;
	}

	public Integer getUnidade() {
		return unidade;
	}

	public void setUnidade(Integer unidade) {
		this.unidade = unidade;
	}

	public Integer getProduto() {
		return produto;
	}

	public void setProduto(Integer produto) {
		this.produto = produto;
	}

	public Long getNumero() {
		return numero;
	}

	public void setNumero(Long numero) {
		this.numero = numero;
	}

	public Integer getDv() {
		return dv;
	}

	public void setDv(Integer dv) {
		this.dv = dv;
	}

}
