package br.gov.caixa.simtx.simulador.services.pagamentospi.v2;

import java.math.BigDecimal;

import javax.validation.Valid;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;

import br.gov.caixa.simtx.simulador.services.spi.pagamento.RequisicaoPagamentoSpi;

public class RequisicaoPagamentoSpiV2 extends RequisicaoPagamentoSpi {

	@NotNull(message = "tipoPrioridadePagamento nao informado")
	@Valid
	private TipoPrioridadePagamentoEnum tipoPrioridadePagamento;

	@NotNull(message = "finalidadeTransacao nao informada")
	private FinalidadeTransacaoEnum finalidadeTransacao;

	@Digits(integer = 12, fraction = 2, message = "valorCompra invalido. espera-se <12 digitos>.<2 digitos>")
	private BigDecimal valorCompra;

	@Digits(integer = 12, fraction = 2, message = "valorDinheiroEspecie invalido. espera-se <12 digitos>.<2 digitos>")
	private BigDecimal valorDinheiroEspecie;

	public TipoPrioridadePagamentoEnum getTipoPrioridadePagamento() {
		return tipoPrioridadePagamento;
	}

	public void setTipoPrioridadePagamento(TipoPrioridadePagamentoEnum tipoPrioridadePagamento) {
		this.tipoPrioridadePagamento = tipoPrioridadePagamento;
	}

	public FinalidadeTransacaoEnum getFinalidadeTransacao() {
		return finalidadeTransacao;
	}

	public void setFinalidadeTransacao(FinalidadeTransacaoEnum finalidadeTransacao) {
		this.finalidadeTransacao = finalidadeTransacao;
	}

	public BigDecimal getValorCompra() {
		return valorCompra;
	}

	public void setValorCompra(BigDecimal valorCompra) {
		this.valorCompra = valorCompra;
	}

	public BigDecimal getValorDinheiroEspecie() {
		return valorDinheiroEspecie;
	}

	public void setValorDinheiroEspecie(BigDecimal valorDinheiroEspecie) {
		this.valorDinheiroEspecie = valorDinheiroEspecie;
	}

}
