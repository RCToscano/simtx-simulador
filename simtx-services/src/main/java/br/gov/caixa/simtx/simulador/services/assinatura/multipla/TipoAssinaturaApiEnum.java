package br.gov.caixa.simtx.simulador.services.assinatura.multipla;

public enum TipoAssinaturaApiEnum {

	SIMPLES("SIMPLES"),
	MULTIPLA("MULTIPLA"),
	QRCODE("QRCODE"),
	BIOMETRIA("BIOMETRIA"),
	SENHA_CONTA("SENHA_CONTA"),
	SEQUENCIA_ASSINATURA_MULTIPLA("SEQUENCIA_ASSINATURA_MULTIPLA"),
	NAO_IDENTIFICADO("NAO_IDENTIFICADO");
	
	private String value;
	

	private TipoAssinaturaApiEnum(String value) {
		this.value = value;
	}
	
	public static TipoAssinaturaApiEnum obterTarefa(String value) {
		TipoAssinaturaApiEnum retorno = null;
		for(TipoAssinaturaApiEnum values : values()) {
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
