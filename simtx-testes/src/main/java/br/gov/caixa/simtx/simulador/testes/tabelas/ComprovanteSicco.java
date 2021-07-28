package br.gov.caixa.simtx.simulador.testes.tabelas;

import java.math.BigDecimal;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonCreator;

public class ComprovanteSicco {

	private Long nsuTransacao;

	private int icSituacao;

	private int nuCanal;

	private int nuServico;

	private int nuVersaoServico;

	private BigDecimal valorTransacao;

	private int nuUnidade;

	private int nuProduto;

	private Long nuConta;

	private int nuDv;

	private int tipoConta;

	private Long nuCpf;

	private String deIdentificacao;

	private String xmlTransacao;

	private Date dtReferencia;

	@JsonCreator
	public ComprovanteSicco(Long nsuTransacao, int icSituacao, int nuCanal, int nuServico, int nuVersaoServico,
			BigDecimal valorTransacao, int nuUnidade, int nuProduto, Long nuConta, int nuDv, int tipoConta, Long nuCpf,
			String deIdentificacao, String xmlTransacao, java.sql.Date dtReferencia) {
		super();
		this.nsuTransacao = nsuTransacao;
		this.icSituacao = icSituacao;
		this.nuCanal = nuCanal;
		this.nuServico = nuServico;
		this.nuVersaoServico = nuVersaoServico;
		this.valorTransacao = valorTransacao;
		this.nuUnidade = nuUnidade;
		this.nuProduto = nuProduto;
		this.nuConta = nuConta;
		this.nuDv = nuDv;
		this.tipoConta = tipoConta;
		this.nuCpf = nuCpf;
		this.deIdentificacao = deIdentificacao;
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

	public int getNuCanal() {
		return nuCanal;
	}

	public void setNuCanal(int nuCanal) {
		this.nuCanal = nuCanal;
	}

	public int getNuServico() {
		return nuServico;
	}

	public void setNuServico(int nuServico) {
		this.nuServico = nuServico;
	}

	public int getNuVersaoServico() {
		return nuVersaoServico;
	}

	public void setNuVersaoServico(int nuVersaoServico) {
		this.nuVersaoServico = nuVersaoServico;
	}

	public BigDecimal getValorTransacao() {
		return valorTransacao;
	}

	public void setValorTransacao(BigDecimal valorTransacao) {
		this.valorTransacao = valorTransacao;
	}

	public int getNuUnidade() {
		return nuUnidade;
	}

	public void setNuUnidade(int nuUnidade) {
		this.nuUnidade = nuUnidade;
	}

	public int getNuProduto() {
		return nuProduto;
	}

	public void setNuProduto(int nuProduto) {
		this.nuProduto = nuProduto;
	}

	public Long getNuConta() {
		return nuConta;
	}

	public void setNuConta(Long nuConta) {
		this.nuConta = nuConta;
	}

	public int getNuDv() {
		return nuDv;
	}

	public void setNuDv(int nuDv) {
		this.nuDv = nuDv;
	}

	public int getTipoConta() {
		return tipoConta;
	}

	public void setTipoConta(int tipoConta) {
		this.tipoConta = tipoConta;
	}

	public Long getNuCpf() {
		return nuCpf;
	}

	public void setNuCpf(Long nuCpf) {
		this.nuCpf = nuCpf;
	}

	public String getDeIdentificacao() {
		return deIdentificacao;
	}

	public void setDeIdentificacao(String deIdentificacao) {
		this.deIdentificacao = deIdentificacao;
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
