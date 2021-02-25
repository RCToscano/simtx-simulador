package br.gov.caixa.simtx.simulador.services.pagamentospi;

public enum MetodoLiquidacaoEnum {

	CLRG("CLRG");
	
	private String value;
	

	private MetodoLiquidacaoEnum(String value) {
		this.value = value;
	}
	
	public static MetodoLiquidacaoEnum obterTarefa(String value) {
		MetodoLiquidacaoEnum retorno = null;
		for(MetodoLiquidacaoEnum values : values()) {
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
