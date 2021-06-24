package br.gov.caixa.simtx.simulador.testes.pix.agendamento.vo;

public class RespostaAgendamentoPixV1VO {

	private String idFimAFim;

	private Long nsuTransacao;

	private String dataTransacao;

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

	public String getDataTransacao() {
		return dataTransacao;
	}

	public void setDataTransacao(String dataTransacao) {
		this.dataTransacao = dataTransacao;
	}

}
