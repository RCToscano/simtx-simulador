package br.gov.caixa.simtx.simulador.testes.base;

public class RespostaErroSIMTX {

	private Long nsu;

	private String codigoRetorno;

	private String origemRetorno;

	private RespostaErroMensagem mensagem;

	public Long getNsu() {
		return nsu;
	}

	public void setNsu(Long nsu) {
		this.nsu = nsu;
	}

	public String getCodigoRetorno() {
		return codigoRetorno;
	}

	public void setCodigoRetorno(String codigoRetorno) {
		this.codigoRetorno = codigoRetorno;
	}

	public String getOrigemRetorno() {
		return origemRetorno;
	}

	public void setOrigemRetorno(String origemRetorno) {
		this.origemRetorno = origemRetorno;
	}

	public RespostaErroMensagem getMensagem() {
		return mensagem;
	}

	public void setMensagem(RespostaErroMensagem mensagem) {
		this.mensagem = mensagem;
	}

}
