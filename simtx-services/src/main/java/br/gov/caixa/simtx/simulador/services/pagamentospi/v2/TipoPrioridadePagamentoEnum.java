package br.gov.caixa.simtx.simulador.services.pagamentospi.v2;

public enum TipoPrioridadePagamentoEnum {

	PAGPRI("PAGPRI"),
	PAGFRD("PAGFRD"),
	PAGAGD("PAGAGD");

	private String value;

	private TipoPrioridadePagamentoEnum(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}

}
