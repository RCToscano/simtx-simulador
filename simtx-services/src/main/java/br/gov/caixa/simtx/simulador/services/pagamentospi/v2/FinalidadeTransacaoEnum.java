package br.gov.caixa.simtx.simulador.services.pagamentospi.v2;

public enum FinalidadeTransacaoEnum {
	
	IPAY("IPAY"),
	GSCB("GSCB"),
	OTHR("OTHR");
	
	private String value;

	private FinalidadeTransacaoEnum(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}

}
