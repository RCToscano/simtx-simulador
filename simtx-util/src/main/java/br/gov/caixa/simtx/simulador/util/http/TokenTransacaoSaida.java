package br.gov.caixa.simtx.simulador.util.http;

public class TokenTransacaoSaida {

	private String descr;

	private String codret;

	private String datahora;

	private String token;

	public String getDescr() {
		return descr;
	}

	public void setDescr(String descr) {
		this.descr = descr;
	}

	public String getCodret() {
		return codret;
	}

	public void setCodret(String codret) {
		this.codret = codret;
	}

	public String getDatahora() {
		return datahora;
	}

	public void setDatahora(String datahora) {
		this.datahora = datahora;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

}
