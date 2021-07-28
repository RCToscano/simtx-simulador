package br.gov.caixa.simtx.simulador.services.spi.pagamento;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class Valor {

	@NotNull(message = "original nao informado")
	@Size(min = 1, message = "original nao informado corretamente")
	private String original;

	@NotNull(message = "abatimento nao informado")
	@Size(min = 1, message = "abatimento nao informado corretamente")
	private String abatimento;

	@NotNull(message = "desconto nao informado")
	@Size(min = 1, message = "desconto nao informado corretamente")
	private String desconto;

	@NotNull(message = "juros nao informado")
	@Size(min = 1, message = "juros nao informado corretamente")
	private String juros;

	@NotNull(message = "multa nao informado")
	@Size(min = 1, message = "multa nao informado corretamente")
	private String multa;

	@NotNull(message = "valorFinal nao informado")
	@Size(min = 1, message = "valorFinal nao informado corretamente")
	private String valorFinal;


	public Valor() {}
	
	public Valor(String original, String abatimento, String desconto, String juros, String multa, String valorFinal) {
		super();
		this.original = original;
		this.abatimento = abatimento;
		this.desconto = desconto;
		this.juros = juros;
		this.multa = multa;
		this.valorFinal = valorFinal;
	}

	public String getOriginal() {
		return original;
	}

	public void setOriginal(String original) {
		this.original = original;
	}

	public String getAbatimento() {
		return abatimento;
	}

	public void setAbatimento(String abatimento) {
		this.abatimento = abatimento;
	}

	public String getDesconto() {
		return desconto;
	}

	public void setDesconto(String desconto) {
		this.desconto = desconto;
	}

	public String getJuros() {
		return juros;
	}

	public void setJuros(String juros) {
		this.juros = juros;
	}

	public String getMulta() {
		return multa;
	}

	public void setMulta(String multa) {
		this.multa = multa;
	}

	public String getValorFinal() {
		return valorFinal;
	}

	public void setValorFinal(String valorFinal) {
		this.valorFinal = valorFinal;
	}

}
