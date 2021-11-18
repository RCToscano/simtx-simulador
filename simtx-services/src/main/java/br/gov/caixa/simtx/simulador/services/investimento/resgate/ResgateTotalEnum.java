package br.gov.caixa.simtx.simulador.services.investimento.resgate;

public enum ResgateTotalEnum {

	SIM("SIM"),
	NAO("NAO");

	private String descricao;

	private ResgateTotalEnum(String descricao) {
		this.descricao = descricao;
	}
}
