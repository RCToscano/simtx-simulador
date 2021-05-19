package br.gov.caixa.simtx.simulador.services.assinatura.multipla;

import com.fasterxml.jackson.annotation.JsonValue;

public enum ClassificacaoAssinaturaEnum {

	NAO_UTILIZADO("NAO_UTILIZADO"),

	PRIMEIRA_ASSINATURA("PRIMEIRA_ASSINATURA"),

	ASSINATURA_INTERMEDIARIA("ASSINATURA_INTERMEDIARIA"),

	ASSINATURA_FINAL("ASSINATURA_FINAL");

	private String value;

	ClassificacaoAssinaturaEnum(String value) {
		this.value = value;
	}
	
	public String getValue() {
		return value;
	}

	@Override
	@JsonValue
	public String toString() {
		return String.valueOf(value);
	}

}
