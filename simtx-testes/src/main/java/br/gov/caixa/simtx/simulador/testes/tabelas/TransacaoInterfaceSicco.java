package br.gov.caixa.simtx.simulador.testes.tabelas;

import java.math.BigDecimal;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonCreator;

public class TransacaoInterfaceSicco {

	private Long nsuTransacao;

	private Long nuParametroInterface;

	private int icSituacao;

	private BigDecimal valorTransacao;
	
	private String deConteudo;
	
	private Integer nuControleArquivo;
	
	private Long nuConcurso;

	private Date dtMovimento;

	private Date dtReferencia;

	public TransacaoInterfaceSicco(Long nsuTransacao, int icSituacao) {
		super();
		this.nsuTransacao = nsuTransacao;
		this.icSituacao = icSituacao;
	}

	@JsonCreator
	public TransacaoInterfaceSicco(Long nsuTransacao, Long nuParametroInterface, int icSituacao,
			BigDecimal valorTransacao, String deConteudo, int nuControleArquivo, Long nuConcurso,
			java.sql.Date dtMovimento, java.sql.Date dtReferencia) {
		super();
		this.nsuTransacao = nsuTransacao;
		this.nuParametroInterface = nuParametroInterface;
		this.icSituacao = icSituacao;
		this.valorTransacao = valorTransacao;
		this.deConteudo = deConteudo;
		this.nuControleArquivo = nuControleArquivo;
		this.nuConcurso = nuConcurso;
		this.dtMovimento = dtMovimento != null ? new java.util.Date(dtMovimento.getTime()) : null;
		this.dtReferencia = new java.util.Date(dtReferencia.getTime());
	}

	public Long getNsuTransacao() {
		return nsuTransacao;
	}

	public void setNsuTransacao(Long nsuTransacao) {
		this.nsuTransacao = nsuTransacao;
	}

	public Long getNuParametroInterface() {
		return nuParametroInterface;
	}

	public void setNuParametroInterface(Long nuParametroInterface) {
		this.nuParametroInterface = nuParametroInterface;
	}

	public int getIcSituacao() {
		return icSituacao;
	}

	public void setIcSituacao(int icSituacao) {
		this.icSituacao = icSituacao;
	}

	public BigDecimal getValorTransacao() {
		return valorTransacao;
	}

	public void setValorTransacao(BigDecimal valorTransacao) {
		this.valorTransacao = valorTransacao;
	}

	public String getDeConteudo() {
		return deConteudo;
	}

	public void setDeConteudo(String deConteudo) {
		this.deConteudo = deConteudo;
	}

	public Integer getNuControleArquivo() {
		return nuControleArquivo;
	}

	public void setNuControleArquivo(Integer nuControleArquivo) {
		this.nuControleArquivo = nuControleArquivo;
	}

	public Long getNuConcurso() {
		return nuConcurso;
	}

	public void setNuConcurso(Long nuConcurso) {
		this.nuConcurso = nuConcurso;
	}

	public Date getDtMovimento() {
		return dtMovimento;
	}

	public void setDtMovimento(Date dtMovimento) {
		this.dtMovimento = dtMovimento;
	}

	public Date getDtReferencia() {
		return dtReferencia;
	}

	public void setDtReferencia(Date dtReferencia) {
		this.dtReferencia = dtReferencia;
	}

	
}
