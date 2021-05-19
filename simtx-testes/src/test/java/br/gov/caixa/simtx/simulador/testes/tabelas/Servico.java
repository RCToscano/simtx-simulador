package br.gov.caixa.simtx.simulador.testes.tabelas;

import java.util.List;

public class Servico {
	
	private int nuServico;
	
	private int nuVersaoServico;
	
    private String deXsdRequisicao;

    private String deXsdResposta;

    private String deXsltRequisicao;

    private String deXsltResposta;

    private int icSituacaoServico;
    
    private int icSituacaoVersaoServico;
    
    private int icServicoMigrado;
	
	private List<Tarefa> listaTarefas;

	
	
	public int getNuServico() {
		return nuServico;
	}

	public void setNuServico(int nuServico) {
		this.nuServico = nuServico;
	}

	public int getNuVersaoServico() {
		return nuVersaoServico;
	}

	public void setNuVersaoServico(int nuVersaoServico) {
		this.nuVersaoServico = nuVersaoServico;
	}

	public String getDeXsdRequisicao() {
		return deXsdRequisicao;
	}

	public void setDeXsdRequisicao(String deXsdRequisicao) {
		this.deXsdRequisicao = deXsdRequisicao;
	}

	public String getDeXsdResposta() {
		return deXsdResposta;
	}

	public void setDeXsdResposta(String deXsdResposta) {
		this.deXsdResposta = deXsdResposta;
	}

	public String getDeXsltRequisicao() {
		return deXsltRequisicao;
	}

	public void setDeXsltRequisicao(String deXsltRequisicao) {
		this.deXsltRequisicao = deXsltRequisicao;
	}

	public String getDeXsltResposta() {
		return deXsltResposta;
	}

	public void setDeXsltResposta(String deXsltResposta) {
		this.deXsltResposta = deXsltResposta;
	}

	public int getIcSituacaoServico() {
		return icSituacaoServico;
	}

	public void setIcSituacaoServico(int icSituacaoServico) {
		this.icSituacaoServico = icSituacaoServico;
	}

	public int getIcSituacaoVersaoServico() {
		return icSituacaoVersaoServico;
	}

	public void setIcSituacaoVersaoServico(int icSituacaoVersaoServico) {
		this.icSituacaoVersaoServico = icSituacaoVersaoServico;
	}

	public int getIcServicoMigrado() {
		return icServicoMigrado;
	}

	public void setIcServicoMigrado(int icServicoMigrado) {
		this.icServicoMigrado = icServicoMigrado;
	}

	public List<Tarefa> getListaTarefas() {
		return listaTarefas;
	}

	public void setListaTarefas(List<Tarefa> listaTarefas) {
		this.listaTarefas = listaTarefas;
	}
	
}
