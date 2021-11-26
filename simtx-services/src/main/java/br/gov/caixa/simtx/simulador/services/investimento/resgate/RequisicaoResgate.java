package br.gov.caixa.simtx.simulador.services.investimento.resgate;

import java.math.BigDecimal;
import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class RequisicaoResgate {

	private Integer produto;
	private BigDecimal valor;
	private ResgateTotalEnum resgateTotal;
	private String dataAgendamento;
	
	public Integer getProduto() {
		return produto;
	}
	public void setProduto(Integer produto) {
		this.produto = produto;
	}
	public BigDecimal getValor() {
		return valor;
	}
	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}
	public ResgateTotalEnum getResgateTotal() {
		return resgateTotal;
	}
	public void setResgateTotal(ResgateTotalEnum resgateTotal) {
		this.resgateTotal = resgateTotal;
	}
	public String getDataAgendamento() {
		return dataAgendamento;
	}
	public void setDataAgendamento(String dataAgendamento) {
		this.dataAgendamento = dataAgendamento;
	}	
}
