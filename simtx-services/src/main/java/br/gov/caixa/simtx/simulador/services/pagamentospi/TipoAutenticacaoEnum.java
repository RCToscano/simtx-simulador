package br.gov.caixa.simtx.simulador.services.pagamentospi;

public enum TipoAutenticacaoEnum {

	SIMPLES("SIMPLES"),
	CERTIFICADO_DIGITAL("CERTIFICADO_DIGITAL"),
	QRCODE("QRCODE"),
	MOBILE_FORTE("MOBILE_FORTE"),
	ASSINATURA_MULTIPLA("ASSINATURA_MULTIPLA");
	
	private String value;
	

	private TipoAutenticacaoEnum(String value) {
		this.value = value;
	}
	
	public static TipoAutenticacaoEnum obterTarefa(String value) {
		TipoAutenticacaoEnum retorno = null;
		for(TipoAutenticacaoEnum values : values()) {
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
