package br.gov.caixa.simtx.simulador.services.pagamentospi;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class Calendario {

	@NotNull(message = "criacao nao informado")
	@Size(min = 1, message = "criacao nao informado corretamente")
	private String criacao;

	@NotNull(message = "apresentacao nao informado")
	@Size(min = 1, message = "apresentacao nao informado corretamente")
	private String apresentacao;

	@NotNull(message = "expiracao nao informado")
	@Min(value = 0, message = "expiracao nao informado corretamente")
	private Long expiracao;

	@NotNull(message = "dataDeVencimento nao informado")
	@Size(min = 10, max = 10, message = "dataDeVencimento deve ser informada e ter o seguinte formato yyyy-MM-dd")
	private String dataDeVencimento;

	@NotNull(message = "validaAposVencimento nao informado")
	@Min(value = 0, message = "validaAposVencimento nao informado")
	private Long validaAposVencimento;

	public Calendario() {}

	public Calendario(String criacao, String apresentacao, Long expiracao, String dataDeVencimento,
			Long validaAposVencimento) {
		super();
		this.criacao = criacao;
		this.apresentacao = apresentacao;
		this.expiracao = expiracao;
		this.dataDeVencimento = dataDeVencimento;
		this.validaAposVencimento = validaAposVencimento;
	}

	public String getCriacao() {
		return criacao;
	}

	public void setCriacao(String criacao) {
		this.criacao = criacao;
	}

	public String getApresentacao() {
		return apresentacao;
	}

	public void setApresentacao(String apresentacao) {
		this.apresentacao = apresentacao;
	}

	public Long getExpiracao() {
		return expiracao;
	}

	public void setExpiracao(Long expiracao) {
		this.expiracao = expiracao;
	}

	public String getDataDeVencimento() {
		return dataDeVencimento;
	}

	public void setDataDeVencimento(String dataDeVencimento) {
		this.dataDeVencimento = dataDeVencimento;
	}

	public Long getValidaAposVencimento() {
		return validaAposVencimento;
	}

	public void setValidaAposVencimento(Long validaAposVencimento) {
		this.validaAposVencimento = validaAposVencimento;
	}

}
