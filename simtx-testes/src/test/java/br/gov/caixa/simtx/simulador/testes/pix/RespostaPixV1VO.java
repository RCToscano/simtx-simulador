package br.gov.caixa.simtx.simulador.testes.pix;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class RespostaPixV1VO {

	@NotNull(message = "idFimAFim nao informado")
	@Size(min = 10, message = "idFimAFim nao informado corretamente")
	private String idFimAFim;

	@NotNull(message = "nsuTransacao nao informado")
	@Min(value = 1, message = "nsuTransacao deve ser informado e ter no maximo 15 caracteres")
	@Max(value = 999999999999999l, message = "nsuTransacao deve ser informado e ter no maximo 15 caracteres")
	private Long nsuTransacao;

	public String getIdFimAFim() {
		return idFimAFim;
	}

	public void setIdFimAFim(String idFimAFim) {
		this.idFimAFim = idFimAFim;
	}

	public Long getNsuTransacao() {
		return nsuTransacao;
	}

	public void setNsuTransacao(Long nsuTransacao) {
		this.nsuTransacao = nsuTransacao;
	}

}
