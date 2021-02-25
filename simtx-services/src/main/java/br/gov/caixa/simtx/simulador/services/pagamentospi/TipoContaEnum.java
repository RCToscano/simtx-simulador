package br.gov.caixa.simtx.simulador.services.pagamentospi;

public enum TipoContaEnum {

	CACC("CACC"),
	SLRY("SLRY"),
	SVGS("SVGS");
	
	private String value;
	

	private TipoContaEnum(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}
	
}
