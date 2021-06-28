package br.gov.caixa.simtx.simulador.services.limite.validar;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

public class ContaDestino {

	@Min(value = 1, message = "ispb deve ser informado e ter no maximo 8 caracteres")
	@Max(value = 99999999, message = "ispb deve ser informado e ter no maximo 8 caracteres")
	private Integer ispb;

	private Integer banco;

	@Max(value = 99999, message= "agencia deve ter no maximo 5 caracteres")
	private Integer agencia;

	@Max(value = 9999, message= "agencia deve ter no maximo 4 caracteres")
	private Integer produto;

	@NotNull(message = "numero nao informado")
	@Min(value = 1, message= "numero deve ser informado e ter no maximo 12 caracteres")
	@Max(value = 999999999999l, message= "numero deve ser informado e ter no maximo 12 caracteres")
	private Long numero;

	@NotNull(message = "dv nao informado")
	@Min(value = 0, message= "dv deve ser informado e ter 1 caracter")
	@Max(value = 9, message= "dv deve ser informado e ter 1 caracter")
	private String dv;

	public Integer getIspb() {
		return ispb;
	}

	public void setIspb(Integer ispb) {
		this.ispb = ispb;
	}

	public Integer getBanco() {
		return banco;
	}

	public void setBanco(Integer banco) {
		this.banco = banco;
	}

	public Integer getAgencia() {
		return agencia;
	}

	public void setAgencia(Integer agencia) {
		this.agencia = agencia;
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

	public String getDv() {
		return dv;
	}

	public void setDv(String dv) {
		this.dv = dv;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("ContaDestino [ispb=");
		builder.append(ispb);
		builder.append(", banco=");
		builder.append(banco);
		builder.append(", agencia=");
		builder.append(agencia);
		builder.append(", produto=");
		builder.append(produto);
		builder.append(", numero=");
		builder.append(numero);
		builder.append(", dv=");
		builder.append(dv);
		builder.append("]");
		return builder.toString();
	}
}
