package br.gov.caixa.simtx.simulador.services.spi.pagamento;

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

	@NotNull(message = "validadeAposVencimento nao informado")
	@Min(value = 0, message = "validadeAposVencimento nao informado")
	private Long validadeAposVencimento;

	public Calendario() {}

	public Calendario(String criacao, String apresentacao, Long expiracao, String dataDeVencimento,
			Long validadeAposVencimento) {
		super();
		this.criacao = criacao;
		this.apresentacao = apresentacao;
		this.expiracao = expiracao;
		this.dataDeVencimento = dataDeVencimento;
		this.validadeAposVencimento = validadeAposVencimento;
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

	public Long getValidadeAposVencimento() {
		return validadeAposVencimento;
	}

	public void setValidadeAposVencimento(Long validadeAposVencimento) {
		this.validadeAposVencimento = validadeAposVencimento;
	}

}
