package br.gov.caixa.simtx.simulador.testes.tabelas;

import java.util.Date;

public class TransacaoXmlSicco {

	private Long nsuTransacao;

	private int icSituacao;

	private String xmlTransacao;

	private Date dtReferencia;


	public TransacaoXmlSicco(Long nsuTransacao, int icSituacao, String xmlTransacao, java.sql.Date dtReferencia) {
		super();
		this.nsuTransacao = nsuTransacao;
		this.icSituacao = icSituacao;
		this.xmlTransacao = xmlTransacao;
		this.dtReferencia = new java.util.Date(dtReferencia.getTime());
	}

	public Long getNsuTransacao() {
		return nsuTransacao;
	}

	public void setNsuTransacao(Long nsuTransacao) {
		this.nsuTransacao = nsuTransacao;
	}

	public int getIcSituacao() {
		return icSituacao;
	}

	public void setIcSituacao(int icSituacao) {
		this.icSituacao = icSituacao;
	}

	public String getXmlTransacao() {
		return xmlTransacao;
	}

	public void setXmlTransacao(String xmlTransacao) {
		this.xmlTransacao = xmlTransacao;
	}

	public Date getDtReferencia() {
		return dtReferencia;
	}

	public void setDtReferencia(Date dtReferencia) {
		this.dtReferencia = dtReferencia;
	}

}
