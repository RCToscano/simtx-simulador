package br.gov.caixa.simtx.simulador.services.spi.cancelamento.vo;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class RequisicaoCancelamentoSpi {
	
	@NotNull(message = "idFimAFim nao informado")
	@Size(min = 10, message = "idFimAFim nao informado corretamente")
	private String idFimAFim;

	@NotNull(message = "conta nao informada")
	@Valid
	private ContaCancelamentoSPI conta;


	public String getIdFimAFim() {
		return idFimAFim;
	}

	public void setIdFimAFim(String idFimAFim) {
		this.idFimAFim = idFimAFim;
	}

	public ContaCancelamentoSPI getConta() {
		return conta;
	}

	public void setConta(ContaCancelamentoSPI conta) {
		this.conta = conta;
	}

}
