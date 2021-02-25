package br.gov.caixa.simtx.simulador.services.pagamentospi;

public enum FormaIniciacaoPagamentoEnum {

	MANUAL_SEM_CHAVE("MANUAL_SEM_CHAVE"),
	MANUAL_COM_CHAVE("MANUAL_COM_CHAVE"),
	QR_CODE_ESTATICO("QR_CODE_ESTATICO"),
	QR_CODE_DINAMICO("QR_CODE_DINAMICO"),
	QR_CODE_DINAMICO_PIX_COBRANCA("QR_CODE_DINAMICO_PIX_COBRANCA");
	
	private String value;
	

	private FormaIniciacaoPagamentoEnum(String value) {
		this.value = value;
	}
	
	public static FormaIniciacaoPagamentoEnum obterTarefa(String value) {
		FormaIniciacaoPagamentoEnum retorno = null;
		for(FormaIniciacaoPagamentoEnum values : values()) {
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
