package br.gov.caixa.simtx.simulador.services.comprovante;

import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import br.gov.caixa.simtx.simulador.util.vo.Conta;

public class RequisicaoListaComprovante {

	@NotNull(message = "conta nao informada")
	@Valid
	private Conta conta;

	@NotNull(message = "dataInicio nao informada")
	@Size(min = 10, max = 10, message = "dataInicio deve ser informada e ter o seguinte formato aaaa-mm-dd")
	private String dataInicio;

	@NotNull(message = "dataFim nao informada")
	@Size(min = 10, max = 10, message = "dataFim deve ser informada e ter o seguinte formato aaaa-mm-dd")
	private String dataFim;

	@NotNull(message = "listNuServico nao informada")
	private List<Long> listNuServico;



	public Conta getConta() {
		return conta;
	}

	public void setConta(Conta conta) {
		this.conta = conta;
	}

	public String getDataInicio() {
		return dataInicio;
	}

	public void setDataInicio(String dataInicio) {
		this.dataInicio = dataInicio;
	}

	public String getDataFim() {
		return dataFim;
	}

	public void setDataFim(String dataFim) {
		this.dataFim = dataFim;
	}

	public List<Long> getListNuServico() {
		return listNuServico;
	}

	public void setListNuServico(List<Long> listNuServico) {
		this.listNuServico = listNuServico;
	}

}
