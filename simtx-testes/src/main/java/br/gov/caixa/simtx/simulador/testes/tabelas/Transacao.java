package br.gov.caixa.simtx.simulador.testes.tabelas;

import java.util.Date;

public class Transacao {

	private Long nsuTransacao;

	private Long nsuTransacaoOrigem;

	private int icSituacao;

	private int icEnvio;

	private int icRetorno;

	private String coTransacaoExterna;

	private Date dtReferencia;
	
	public Transacao(Long nsuTransacao, int icSituacao) {
		super();
		this.nsuTransacao = nsuTransacao;
		this.icSituacao = icSituacao;
	}
	
	public Transacao(Long nsuTransacao, Long nsuTransacaoOrigem, int icSituacao, int icEnvio, int icRetorno,
			String coTransacaoExterna, Date dtReferencia) {
		super();
		this.nsuTransacao = nsuTransacao;
		this.nsuTransacaoOrigem = nsuTransacaoOrigem;
		this.icSituacao = icSituacao;
		this.icEnvio = icEnvio;
		this.icRetorno = icRetorno;
		this.coTransacaoExterna = coTransacaoExterna;
		this.dtReferencia = dtReferencia;
	}



	public Long getNsuTransacao() {
		return nsuTransacao;
	}

	public void setNsuTransacao(Long nsuTransacao) {
		this.nsuTransacao = nsuTransacao;
	}

	public Long getNsuTransacaoOrigem() {
		return nsuTransacaoOrigem;
	}

	public void setNsuTransacaoOrigem(Long nsuTransacaoOrigem) {
		this.nsuTransacaoOrigem = nsuTransacaoOrigem;
	}

	public int getIcSituacao() {
		return icSituacao;
	}

	public void setIcSituacao(int icSituacao) {
		this.icSituacao = icSituacao;
	}

	public int getIcEnvio() {
		return icEnvio;
	}

	public void setIcEnvio(int icEnvio) {
		this.icEnvio = icEnvio;
	}

	public int getIcRetorno() {
		return icRetorno;
	}

	public void setIcRetorno(int icRetorno) {
		this.icRetorno = icRetorno;
	}

	public String getCoTransacaoExterna() {
		return coTransacaoExterna;
	}

	public void setCoTransacaoExterna(String coTransacaoExterna) {
		this.coTransacaoExterna = coTransacaoExterna;
	}

	public Date getDtReferencia() {
		return dtReferencia;
	}

	public void setDtReferencia(Date dtReferencia) {
		this.dtReferencia = dtReferencia;
	}
}
