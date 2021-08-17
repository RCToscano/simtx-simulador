package br.gov.caixa.simtx.simulador.services.spi.pagamento;

import javax.validation.Valid;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class ContaSPI {

	private String chave;

	@Size(max = 4, message = "agencia deve ter no maximo 4 caracteres")
	private String agencia;

	@NotNull(message = "numeroConta nao informada")
	@Size(min = 1, max = 13, message = "numeroConta com dv deve ser informada e ter no maximo 13 caracteres")
	private String numeroConta;

	@Max(value = 9999, message = "produto deve ter no maximo 4 caracteres")
	private String produto;

	@NotNull(message = "tipoConta nao informado")
	@Valid
	private TipoContaEnum tipoConta;

	@NotNull(message = "ispb nao informado")
	@Size(min = 1, max = 8, message = "ispb deve ser informado e ter no maximo 8 caracteres")
	private String ispb;



	public String getChave() {
		return chave;
	}

	public void setChave(String chave) {
		this.chave = chave;
	}

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

	public TipoContaEnum getTipoConta() {
		return tipoConta;
	}

	public void setTipoConta(TipoContaEnum tipoConta) {
		this.tipoConta = tipoConta;
	}

	public String getIspb() {
		return ispb;
	}

	public void setIspb(String ispb) {
		this.ispb = ispb;
	}

}
