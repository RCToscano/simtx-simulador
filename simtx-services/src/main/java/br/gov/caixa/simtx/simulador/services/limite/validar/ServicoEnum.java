package br.gov.caixa.simtx.simulador.services.limite.validar;

public enum ServicoEnum {
	
	TEV("TEV"),
	TED("TED"),
	DOC("DOC"),
	PBQ("PBQ"),
	HAB("HAB"),
	DSP("DSP");
	
	private String value;

	private ServicoEnum(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}

}
