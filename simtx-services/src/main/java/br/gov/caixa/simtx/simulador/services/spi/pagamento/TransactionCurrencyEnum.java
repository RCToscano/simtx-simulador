package br.gov.caixa.simtx.simulador.services.spi.pagamento;

public enum TransactionCurrencyEnum {

	BRL("BRL");
	
	private String value;
	

	private TransactionCurrencyEnum(String value) {
		this.value = value;
	}
	
	public static TransactionCurrencyEnum obterTarefa(String value) {
		TransactionCurrencyEnum retorno = null;
		for(TransactionCurrencyEnum values : values()) {
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
