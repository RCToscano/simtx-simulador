package br.gov.caixa.simtx.simulador.testes.tabelas;

import java.math.BigDecimal;
import java.util.Date;

public class TransacaoAgendamento {

	private long nuNsuTransacaoAgendamento;

	private Long nuNsuEfetivacao;

	private Date dtReferencia;

	private Date dtEfetivacao;

	private String deIdentificacaoTransacao;

	private int icSituacaoAgendamento;

	private int nuServico;

	private int nuVersaoServico;

	private long nuCanal;

	private BigDecimal valorTransacao;

	private int nuUnidade;

	private int nuProduto;

	private long nuConta;

	private int dvConta;

	private int icTipoConta;

	private String deXmlAgendamento;

	private Integer nuCategoriaMensagem051;

	private Date dhUltimaExecucao;

	private String deXmlEfetivacao;

	public TransacaoAgendamento(long nuNsuTransacaoAgendamento, Long nuNsuEfetivacao, java.sql.Date dtReferencia,
			java.sql.Date dtEfetivacao, String deIdentificacaoTransacao, int icSituacaoAgendamento, int nuServico,
			int nuVersaoServico, long nuCanal, BigDecimal valorTransacao, int nuUnidade, int nuProduto, long nuConta,
			int dvConta, int icTipoConta) {
		super();
		this.nuNsuTransacaoAgendamento = nuNsuTransacaoAgendamento;
		this.nuNsuEfetivacao = nuNsuEfetivacao;
		this.dtReferencia = new java.util.Date(dtReferencia.getTime());
		this.dtEfetivacao = new java.util.Date(dtEfetivacao.getTime());
		this.deIdentificacaoTransacao = deIdentificacaoTransacao;
		this.icSituacaoAgendamento = icSituacaoAgendamento;
		this.nuServico = nuServico;
		this.nuVersaoServico = nuVersaoServico;
		this.nuCanal = nuCanal;
		this.valorTransacao = valorTransacao;
		this.nuUnidade = nuUnidade;
		this.nuProduto = nuProduto;
		this.nuConta = nuConta;
		this.dvConta = dvConta;
		this.icTipoConta = icTipoConta;
	}

	public long getNuNsuTransacaoAgendamento() {
		return nuNsuTransacaoAgendamento;
	}

	public void setNuNsuTransacaoAgendamento(long nuNsuTransacaoAgendamento) {
		this.nuNsuTransacaoAgendamento = nuNsuTransacaoAgendamento;
	}

	public Long getNuNsuEfetivacao() {
		return nuNsuEfetivacao;
	}

	public void setNuNsuEfetivacao(Long nuNsuEfetivacao) {
		this.nuNsuEfetivacao = nuNsuEfetivacao;
	}

	public Date getDtReferencia() {
		return dtReferencia;
	}

	public void setDtReferencia(Date dtReferencia) {
		this.dtReferencia = dtReferencia;
	}

	public Date getDtEfetivacao() {
		return dtEfetivacao;
	}

	public void setDtEfetivacao(Date dtEfetivacao) {
		this.dtEfetivacao = dtEfetivacao;
	}

	public String getDeIdentificacaoTransacao() {
		return deIdentificacaoTransacao;
	}

	public void setDeIdentificacaoTransacao(String deIdentificacaoTransacao) {
		this.deIdentificacaoTransacao = deIdentificacaoTransacao;
	}

	public int getIcSituacaoAgendamento() {
		return icSituacaoAgendamento;
	}

	public void setIcSituacaoAgendamento(int icSituacaoAgendamento) {
		this.icSituacaoAgendamento = icSituacaoAgendamento;
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

	public long getNuCanal() {
		return nuCanal;
	}

	public void setNuCanal(long nuCanal) {
		this.nuCanal = nuCanal;
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

	public long getNuConta() {
		return nuConta;
	}

	public void setNuConta(long nuConta) {
		this.nuConta = nuConta;
	}

	public int getDvConta() {
		return dvConta;
	}

	public void setDvConta(int dvConta) {
		this.dvConta = dvConta;
	}

	public int getIcTipoConta() {
		return icTipoConta;
	}

	public void setIcTipoConta(int icTipoConta) {
		this.icTipoConta = icTipoConta;
	}

	public String getDeXmlAgendamento() {
		return deXmlAgendamento;
	}

	public void setDeXmlAgendamento(String deXmlAgendamento) {
		this.deXmlAgendamento = deXmlAgendamento;
	}

	public Integer getNuCategoriaMensagem051() {
		return nuCategoriaMensagem051;
	}

	public void setNuCategoriaMensagem051(Integer nuCategoriaMensagem051) {
		this.nuCategoriaMensagem051 = nuCategoriaMensagem051;
	}

	public Date getDhUltimaExecucao() {
		return dhUltimaExecucao;
	}

	public void setDhUltimaExecucao(Date dhUltimaExecucao) {
		this.dhUltimaExecucao = dhUltimaExecucao;
	}

	public String getDeXmlEfetivacao() {
		return deXmlEfetivacao;
	}

	public void setDeXmlEfetivacao(String deXmlEfetivacao) {
		this.deXmlEfetivacao = deXmlEfetivacao;
	}

}
