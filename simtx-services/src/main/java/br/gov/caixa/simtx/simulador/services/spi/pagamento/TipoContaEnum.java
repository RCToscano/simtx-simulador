package br.gov.caixa.simtx.simulador.services.spi.pagamento;

public enum TipoContaEnum {

	CACC("CACC"),
	SLRY("SLRY"),
	SVGS("SVGS"),
	TRAN("TRAN");
	
	private String value;
	

	private TipoContaEnum(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}
	
}
