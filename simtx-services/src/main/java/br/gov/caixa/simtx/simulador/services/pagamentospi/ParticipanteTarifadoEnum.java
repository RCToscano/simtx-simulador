package br.gov.caixa.simtx.simulador.services.pagamentospi;

public enum ParticipanteTarifadoEnum {

	SLEV("SLEV");
	
	private String value;
	

	private ParticipanteTarifadoEnum(String value) {
		this.value = value;
	}
	
	public static ParticipanteTarifadoEnum obterTarefa(String value) {
		ParticipanteTarifadoEnum retorno = null;
		for(ParticipanteTarifadoEnum values : values()) {
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
