package br.gov.caixa.simtx.simulador.util.http;

public enum TipoGeracaoToken {

	NOVO_TOKEN("client_credentials"),
	REFRESH_TOKEN("refresh_token");
	
	private String paramBody;
	
	private TipoGeracaoToken(String paramBody) {
		this.paramBody = paramBody;
	}
	
	public String getParamBody() {
		return paramBody;
	}
}
