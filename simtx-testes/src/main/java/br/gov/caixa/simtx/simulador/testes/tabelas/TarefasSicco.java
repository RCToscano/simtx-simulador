package br.gov.caixa.simtx.simulador.testes.tabelas;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonCreator;

public class TarefasSicco {

	private Long nsuTransacao;

	private int nuTarefa;

	private int nuVersao;

	private Long nsuCorporativo;

	private String coRetornoTarefa;

	private int nuRetornoStatus;

	private String xmlRequisicao;

	private String xmlResposta;

	private int nuMensagem;

	private Date dtReferencia;


	@JsonCreator
	public TarefasSicco(Long nsuTransacao, int nuTarefa, int nuVersao, Long nsuCorporativo, String coRetornoTarefa,
			int nuRetornoStatus, String xmlRequisicao, String xmlResposta, int nuMensagem, java.sql.Date dtReferencia) {
		super();
		this.nsuTransacao = nsuTransacao;
		this.nuTarefa = nuTarefa;
		this.nuVersao = nuVersao;
		this.nsuCorporativo = nsuCorporativo;
		this.coRetornoTarefa = coRetornoTarefa;
		this.nuRetornoStatus = nuRetornoStatus;
		this.xmlRequisicao = xmlRequisicao;
		this.xmlResposta = xmlResposta;
		this.nuMensagem = nuMensagem;
		this.dtReferencia = new java.util.Date(dtReferencia.getTime());
	}

	public Long getNsuTransacao() {
		return nsuTransacao;
	}

	public void setNsuTransacao(Long nsuTransacao) {
		this.nsuTransacao = nsuTransacao;
	}

	public int getNuTarefa() {
		return nuTarefa;
	}

	public void setNuTarefa(int nuTarefa) {
		this.nuTarefa = nuTarefa;
	}

	public int getNuVersao() {
		return nuVersao;
	}

	public void setNuVersao(int nuVersao) {
		this.nuVersao = nuVersao;
	}

	public Long getNsuCorporativo() {
		return nsuCorporativo;
	}

	public void setNsuCorporativo(Long nsuCorporativo) {
		this.nsuCorporativo = nsuCorporativo;
	}

	public String getCoRetornoTarefa() {
		return coRetornoTarefa;
	}

	public void setCoRetornoTarefa(String coRetornoTarefa) {
		this.coRetornoTarefa = coRetornoTarefa;
	}

	public int getNuRetornoStatus() {
		return nuRetornoStatus;
	}

	public void setNuRetornoStatus(int nuRetornoStatus) {
		this.nuRetornoStatus = nuRetornoStatus;
	}

	public String getXmlRequisicao() {
		return xmlRequisicao;
	}

	public void setXmlRequisicao(String xmlRequisicao) {
		this.xmlRequisicao = xmlRequisicao;
	}

	public String getXmlResposta() {
		return xmlResposta;
	}

	public void setXmlResposta(String xmlResposta) {
		this.xmlResposta = xmlResposta;
	}

	public int getNuMensagem() {
		return nuMensagem;
	}

	public void setNuMensagem(int nuMensagem) {
		this.nuMensagem = nuMensagem;
	}

	public Date getDtReferencia() {
		return dtReferencia;
	}

	public void setDtReferencia(Date dtReferencia) {
		this.dtReferencia = dtReferencia;
	}

}
