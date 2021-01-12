package br.gov.caixa.simtx.simulador.util.vo;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

public class ContaSIBAR {

	@NotNull(message = "unidade nao informada")
	@Max(value = 99999l, message= "unidade deve ser informada e ter no maximo 5 caracteres")
	private Integer unidade;

	@NotNull(message = "numero nao informado")
	@Min(value = 0, message= "numero nao informado")
	@Max(value = 999999999999l, message= "numero deve ser informado e ter no maximo 12 caracteres")
	private Long numero;

	@NotNull(message = "produto nao informado")
	@Min(value = 0, message= "produto nao informado")
	@Max(value = 9999, message= "produto deve ser informado e ter no maximo 4 caracteres")
	private Integer produto;

	@NotNull(message = "dv nao informado")
	@Min(value = 0, message= "dv nao informado")
	@Max(value = 9, message= "dv deve ser informado e ter no maximo 1 caracteres")
	private Integer dv;



	public Integer getUnidade() {
		return unidade;
	}

	public void setUnidade(Integer unidade) {
		this.unidade = unidade;
	}

	public Long getNumero() {
		return numero;
	}

	public void setNumero(Long numero) {
		this.numero = numero;
	}

	public Integer getProduto() {
		return produto;
	}

	public void setProduto(Integer produto) {
		this.produto = produto;
	}

	public Integer getDv() {
		return dv;
	}

	public void setDv(Integer dv) {
		this.dv = dv;
	}
	
}
