package br.gov.caixa.simtx.simulador.services.investimento.cancelamentoresgate;

import java.math.BigDecimal;

public class RequisicaoCancelamentoResgate {

	private BigDecimal saldo;
	private Long nsu;
	
	public BigDecimal getSaldo() {
		return saldo;
	}
	public void setSaldo(BigDecimal saldo) {
		this.saldo = saldo;
	}
	public Long getNsu() {
		return nsu;
	}
	public void setNsu(Long nsu) {
		this.nsu = nsu;
	}	
}
