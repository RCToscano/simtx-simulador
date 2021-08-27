package br.gov.caixa.simtx.simulador.services.pagamentospi.v3;

import javax.validation.constraints.Size;

import br.gov.caixa.simtx.simulador.services.pagamentospi.v2.RequisicaoPagamentoSpiV2;

public class RequisicaoPagamentoSpiV3 extends RequisicaoPagamentoSpiV2 {

	@Size(min = 14, max = 14, message = "cnpjIniciadorPagamento invalido, tamanho deve ser no maximo 14")
	private String cnpjIniciadorPagamento;

	@Size(min = 1, max = 100, message = "paymentId invalido, tamanho deve ser no maximo 100")
	private String paymentId;



	public String getCnpjIniciadorPagamento() {
		return cnpjIniciadorPagamento;
	}

	public void setCnpjIniciadorPagamento(String cnpjIniciadorPagamento) {
		this.cnpjIniciadorPagamento = cnpjIniciadorPagamento;
	}

	public String getPaymentId() {
		return paymentId;
	}

	public void setPaymentId(String paymentId) {
		this.paymentId = paymentId;
	}

}
