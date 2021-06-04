package br.gov.caixa.simtx.simulador.services.enviopush;

public enum IcMensagemEnvioPushCanal {
	
	PIX_024("PIX_024"),
	PIX_025("PIX_025"),
	PIX_029("PIX_029"),
	PIX_030("PIX_030");
	
	private String value;

	private IcMensagemEnvioPushCanal(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}

}
