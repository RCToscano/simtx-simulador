package br.gov.caixa.simtx.simulador.services.investimento.cancelamentoaplicacao;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class RequisicaoCancelamentoAplicacao {

	private Integer produto;	
	private Long nsuAplicacao;	
	private BigDecimal valor;	
	private String dataAgendamento;
	
	public Integer getProduto() {
		return produto;
	}
	public void setProduto(Integer produto) {
		this.produto = produto;
	}
	public Long getNsuAplicacao() {
		return nsuAplicacao;
	}
	public void setNsuAplicacao(Long nsuAplicacao) {
		this.nsuAplicacao = nsuAplicacao;
	}
	public BigDecimal getValor() {
		return valor;
	}
	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}
	public String getDataAgendamento() {
		return dataAgendamento;
	}
	public void setDataAgendamento(String dataAgendamento) {
		this.dataAgendamento = dataAgendamento;
	}
	
}
