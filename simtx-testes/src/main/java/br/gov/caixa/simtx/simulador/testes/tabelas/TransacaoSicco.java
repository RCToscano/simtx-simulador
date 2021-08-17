package br.gov.caixa.simtx.simulador.testes.tabelas;

import java.math.BigDecimal;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonCreator;

public class TransacaoSicco {

	private Long nsuTransacao;

	private Long nsuTransacaoOrigem;

	private Long nsuCoordenador;

	private int icSituacao;

	private int nuCanal;

	private int nuServico;

	private int nuVersaoServico;

	private Long nsuTransacaoCanal;

	private BigDecimal valorTransacao;

	private int nuUnidade;

	private int nuProduto;

	private Long nuConta;

	private int nuDv;

	private int tipoConta;

	private Long nuCpf;

	private Long nuCnpj;

	private Date dhTransacaoCanal;

	private Date dhMultiCanal;

	private Date dhCoordenador;

	private Date dtReferencia;

	public TransacaoSicco(Long nsuTransacao, int icSituacao) {
		super();
		this.nsuTransacao = nsuTransacao;
		this.icSituacao = icSituacao;
	}

	@JsonCreator
	public TransacaoSicco(Long nsuTransacao, Long nsuTransacaoOrigem, Long nsuCoordenador, int icSituacao, int nuCanal,
			int nuServico, int nuVersaoServico, Long nsuTransacaoCanal, BigDecimal valorTransacao, int nuUnidade,
			int nuProduto, Long nuConta, int nuDv, int tipoConta, Long nuCpf, Long nuCnpj,
			java.sql.Date dhTransacaoCanal, java.sql.Date dhMultiCanal, java.sql.Date dhCoordenador,
			java.sql.Date dtReferencia) {
		super();
		this.nsuTransacao = nsuTransacao;
		this.nsuTransacaoOrigem = nsuTransacaoOrigem;
		this.nsuCoordenador = nsuCoordenador;
		this.icSituacao = icSituacao;
		this.nuCanal = nuCanal;
		this.nuServico = nuServico;
		this.nuVersaoServico = nuVersaoServico;
		this.nsuTransacaoCanal = nsuTransacaoCanal;
		this.valorTransacao = valorTransacao;
		this.nuUnidade = nuUnidade;
		this.nuProduto = nuProduto;
		this.nuConta = nuConta;
		this.nuDv = nuDv;
		this.tipoConta = tipoConta;
		this.nuCpf = nuCpf;
		this.nuCnpj = nuCnpj;
		this.dhTransacaoCanal = new java.util.Date(dhTransacaoCanal.getTime());
		this.dhMultiCanal = new java.util.Date(dhMultiCanal.getTime());
		this.dhCoordenador = new java.util.Date(dhCoordenador.getTime());
		this.dtReferencia = new java.util.Date(dtReferencia.getTime());
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

	public Long getNsuCoordenador() {
		return nsuCoordenador;
	}

	public void setNsuCoordenador(Long nsuCoordenador) {
		this.nsuCoordenador = nsuCoordenador;
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

	public Long getNsuTransacaoCanal() {
		return nsuTransacaoCanal;
	}

	public void setNsuTransacaoCanal(Long nsuTransacaoCanal) {
		this.nsuTransacaoCanal = nsuTransacaoCanal;
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

	public Long getNuCnpj() {
		return nuCnpj;
	}

	public void setNuCnpj(Long nuCnpj) {
		this.nuCnpj = nuCnpj;
	}

	public Date getDhTransacaoCanal() {
		return dhTransacaoCanal;
	}

	public void setDhTransacaoCanal(Date dhTransacaoCanal) {
		this.dhTransacaoCanal = dhTransacaoCanal;
	}

	public Date getDhMultiCanal() {
		return dhMultiCanal;
	}

	public void setDhMultiCanal(Date dhMultiCanal) {
		this.dhMultiCanal = dhMultiCanal;
	}

	public Date getDhCoordenador() {
		return dhCoordenador;
	}

	public void setDhCoordenador(Date dhCoordenador) {
		this.dhCoordenador = dhCoordenador;
	}

	public Date getDtReferencia() {
		return dtReferencia;
	}

	public void setDtReferencia(Date dtReferencia) {
		this.dtReferencia = dtReferencia;
	}
}
