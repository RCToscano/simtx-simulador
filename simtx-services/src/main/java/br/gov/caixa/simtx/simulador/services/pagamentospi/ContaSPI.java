package br.gov.caixa.simtx.simulador.services.pagamentospi;

import javax.validation.Valid;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class ContaSPI {

	@NotNull(message = "chave nao informada")
	@Size(min = 1, message = "chave nao informada corretamente")
	private String chave;

	@Min(value = 1, message = "agencia deve ter no maximo 4 caracteres")
	@Max(value = 9999, message = "agencia deve ter no maximo 4 caracteres")
	private Integer agencia;

	@NotNull(message = "numeroConta nao informada")
	@Min(value = 1, message = "numeroConta com dv deve ser informada e ter no maximo 13 caracteres")
	@Max(value = 9999999999999l, message = "numeroConta com dv deve ser informada e ter no maximo 13 caracteres")
	private Long numeroConta;

	@Min(value = 1, message = "produto deve ter no maximo 4 caracteres")
	@Max(value = 9999, message = "produto deve ter no maximo 4 caracteres")
	private Integer produto;

	@NotNull(message = "tipoConta nao informado")
	@Valid
	private TipoContaEnum tipoConta;

	@NotNull(message = "ispb nao informado")
	@Min(value = 1, message = "ispb deve ser informado e ter no maximo 8 caracteres")
	@Max(value = 99999999, message = "ispb deve ser informado e ter no maximo 8 caracteres")
	private Integer ispb;



	public String getChave() {
		return chave;
	}

	public void setChave(String chave) {
		this.chave = chave;
	}

	public Integer getAgencia() {
		return agencia;
	}

	public void setAgencia(Integer agencia) {
		this.agencia = agencia;
	}

	public Long getNumeroConta() {
		return numeroConta;
	}

	public void setNumeroConta(Long numeroConta) {
		this.numeroConta = numeroConta;
	}

	public Integer getProduto() {
		return produto;
	}

	public void setProduto(Integer produto) {
		this.produto = produto;
	}

	public TipoContaEnum getTipoConta() {
		return tipoConta;
	}

	public void setTipoConta(TipoContaEnum tipoConta) {
		this.tipoConta = tipoConta;
	}

	public Integer getIspb() {
		return ispb;
	}

	public void setIspb(Integer ispb) {
		this.ispb = ispb;
	}

}
