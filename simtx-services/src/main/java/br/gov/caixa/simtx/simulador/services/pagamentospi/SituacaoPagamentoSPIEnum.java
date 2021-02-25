package br.gov.caixa.simtx.simulador.services.pagamentospi;

public enum SituacaoPagamentoSPIEnum {

	ACSC("ACSC"),
	HOLD("HOLD"),
	RJCT("RJCT");
	
	private String value;
	

	private SituacaoPagamentoSPIEnum(String value) {
		this.value = value;
	}
	
	public static SituacaoPagamentoSPIEnum obterTarefa(String value) {
		SituacaoPagamentoSPIEnum retorno = null;
		for(SituacaoPagamentoSPIEnum values : values()) {
			if (values.getValue().equals(value)) {
				retorno = values;
				break;
			}
		}
		return retorno;
	}

	public String getValue() {
		return value;
	}
	
}
