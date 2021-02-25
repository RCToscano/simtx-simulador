package br.gov.caixa.simtx.simulador.services.pagamentospi;

public enum PrioridadePagamentoEnum {

	LOW("LOW"),
	HIGH("HIGH");
	
	private String value;
	

	private PrioridadePagamentoEnum(String value) {
		this.value = value;
	}
	
	public static PrioridadePagamentoEnum obterTarefa(String value) {
		PrioridadePagamentoEnum retorno = null;
		for(PrioridadePagamentoEnum values : values()) {
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
