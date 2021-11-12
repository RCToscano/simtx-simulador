package br.gov.caixa.simtx.simulador.services.pagamentospi.v5;

public enum ModalidadeAgenteEnum {
	
	AGTEC("AGTEC"),
	AGTOT("AGTOT"),
	AGPSS("AGPSS");
	
	private String value;

	private ModalidadeAgenteEnum(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}

}
