package br.gov.caixa.simtx.simulador.services.pagamentospi.v2;

public enum TipoPrioridadePagamentoEnum {
	
	IPAY("IPAY"),
	GSCB("GSCB"),
	OTHR("OTHR");
	
	private String value;

	private TipoPrioridadePagamentoEnum(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}

}
