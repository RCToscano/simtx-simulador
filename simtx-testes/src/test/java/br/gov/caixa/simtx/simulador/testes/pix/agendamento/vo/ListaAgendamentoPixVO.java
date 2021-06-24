package br.gov.caixa.simtx.simulador.testes.pix.agendamento.vo;

import java.math.BigDecimal;

import javax.validation.constraints.NotNull;

public class ListaAgendamentoPixVO {

	@NotNull
	private long nsuTransacao;
	private String dataAgendamento;
	private String dataEfetivacao;
	private String canalOrigem;
	private BigDecimal valorTransacao;
	private String servico;
	private String identificacaoTransacao;
	private String situacaoTransacao;

	public long getNsuTransacao() {
		return nsuTransacao;
	}

	public void setNsuTransacao(long nsuTransacao) {
		this.nsuTransacao = nsuTransacao;
	}

	public String getDataAgendamento() {
		return dataAgendamento;
	}

	public void setDataAgendamento(String dataAgendamento) {
		this.dataAgendamento = dataAgendamento;
	}

	public String getDataEfetivacao() {
		return dataEfetivacao;
	}

	public void setDataEfetivacao(String dataEfetivacao) {
		this.dataEfetivacao = dataEfetivacao;
	}

	public String getCanalOrigem() {
		return canalOrigem;
	}

	public void setCanalOrigem(String canalOrigem) {
		this.canalOrigem = canalOrigem;
	}

	public BigDecimal getValorTransacao() {
		return valorTransacao;
	}

	public void setValorTransacao(BigDecimal valorTransacao) {
		this.valorTransacao = valorTransacao;
	}

	public String getServico() {
		return servico;
	}

	public void setServico(String servico) {
		this.servico = servico;
	}

	public String getIdentificacaoTransacao() {
		return identificacaoTransacao;
	}

	public void setIdentificacaoTransacao(String identificacaoTransacao) {
		this.identificacaoTransacao = identificacaoTransacao;
	}

	public String getSituacaoTransacao() {
		return situacaoTransacao;
	}

	public void setSituacaoTransacao(String situacaoTransacao) {
		this.situacaoTransacao = situacaoTransacao;
	}
}
