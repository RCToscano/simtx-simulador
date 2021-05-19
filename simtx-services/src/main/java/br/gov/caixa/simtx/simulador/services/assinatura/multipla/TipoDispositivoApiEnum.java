package br.gov.caixa.simtx.simulador.services.assinatura.multipla;

public enum TipoDispositivoApiEnum {

	ANDROID_PHONE("ANDROID_PHONE"),
	ANDROID_TABLET("ANDROID_TABLET"),
	IOS_PHONE("IOS_PHONE"),
	IOS_TABLET("IOS_TABLET"),
	WINDOWS_PHONE("WINDOWS_PHONE"),
	WINDOWS_TABLET("WINDOWS_TABLET"),
	OUTROS("OUTROS");
	
	private String value;
	

	private TipoDispositivoApiEnum(String value) {
		this.value = value;
	}
	
	public static TipoDispositivoApiEnum obterTipo(String value) {
		TipoDispositivoApiEnum retorno = null;
		for(TipoDispositivoApiEnum values : values()) {
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
