package br.gov.caixa.simtx.simulador.testes.tabelas;

import java.util.List;

public class Tarefa {
	
	private int nuTarefa;
	
	private int nuVersao;
	
    private String deXsdRequisicao;

    private String deXsdResposta;

    private String deXsltRequisicao;

    private String deXsltResposta;

    private int icAssincrono;

    private int icSituacaoVersaoTarefa;
    
    private String coVersaoBarramento;
    
	private int icImpedimento;

	private int icSituacaoServicoTarefa;

	private int nuSequenciaExecucao;
	
    private String noFilaRequisicao;

    private String noFilaResposta;

    private int nuTimeoutRequisicao;

    private int nuTimeoutResposta;
    
    private String noConexao;
    
    private String noModoIntegracao;
    
    private String noRecurso;
    
    private int qtdeTempoEspera;
	
	private List<Mensagem> listaMsg;
	
	private List<Regra> listaRegras;

	
	public Tarefa() {
	}
	
	public Tarefa(int nuTarefa, int nuVersao) {
		super();
		this.nuTarefa = nuTarefa;
		this.nuVersao = nuVersao;
	}

	public int getNuTarefa() {
		return nuTarefa;
	}

	public void setNuTarefa(int nuTarefa) {
		this.nuTarefa = nuTarefa;
	}

	public int getNuVersao() {
		return nuVersao;
	}

	public void setNuVersao(int nuVersao) {
		this.nuVersao = nuVersao;
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

	public int getIcAssincrono() {
		return icAssincrono;
	}

	public void setIcAssincrono(int icAssincrono) {
		this.icAssincrono = icAssincrono;
	}

	public int getIcSituacaoVersaoTarefa() {
		return icSituacaoVersaoTarefa;
	}

	public void setIcSituacaoVersaoTarefa(int icSituacaoVersaoTarefa) {
		this.icSituacaoVersaoTarefa = icSituacaoVersaoTarefa;
	}

	public String getCoVersaoBarramento() {
		return coVersaoBarramento;
	}

	public void setCoVersaoBarramento(String coVersaoBarramento) {
		this.coVersaoBarramento = coVersaoBarramento;
	}

	public int getIcImpedimento() {
		return icImpedimento;
	}

	public void setIcImpedimento(int icImpedimento) {
		this.icImpedimento = icImpedimento;
	}

	public int getIcSituacaoServicoTarefa() {
		return icSituacaoServicoTarefa;
	}

	public void setIcSituacaoServicoTarefa(int icSituacaoServicoTarefa) {
		this.icSituacaoServicoTarefa = icSituacaoServicoTarefa;
	}

	public int getNuSequenciaExecucao() {
		return nuSequenciaExecucao;
	}

	public void setNuSequenciaExecucao(int nuSequenciaExecucao) {
		this.nuSequenciaExecucao = nuSequenciaExecucao;
	}
	
	public String getNoFilaRequisicao() {
		return noFilaRequisicao;
	}

	public void setNoFilaRequisicao(String noFilaRequisicao) {
		this.noFilaRequisicao = noFilaRequisicao;
	}

	public String getNoFilaResposta() {
		return noFilaResposta;
	}

	public void setNoFilaResposta(String noFilaResposta) {
		this.noFilaResposta = noFilaResposta;
	}

	public int getNuTimeoutRequisicao() {
		return nuTimeoutRequisicao;
	}

	public void setNuTimeoutRequisicao(int nuTimeoutRequisicao) {
		this.nuTimeoutRequisicao = nuTimeoutRequisicao;
	}

	public int getNuTimeoutResposta() {
		return nuTimeoutResposta;
	}

	public void setNuTimeoutResposta(int nuTimeoutResposta) {
		this.nuTimeoutResposta = nuTimeoutResposta;
	}

	public String getNoConexao() {
		return noConexao;
	}

	public void setNoConexao(String noConexao) {
		this.noConexao = noConexao;
	}

	public String getNoModoIntegracao() {
		return noModoIntegracao;
	}

	public void setNoModoIntegracao(String noModoIntegracao) {
		this.noModoIntegracao = noModoIntegracao;
	}

	public String getNoRecurso() {
		return noRecurso;
	}

	public void setNoRecurso(String noRecurso) {
		this.noRecurso = noRecurso;
	}

	public int getQtdeTempoEspera() {
		return qtdeTempoEspera;
	}

	public void setQtdeTempoEspera(int qtdeTempoEspera) {
		this.qtdeTempoEspera = qtdeTempoEspera;
	}

	public List<Mensagem> getListaMsg() {
		return listaMsg;
	}

	public void setListaMsg(List<Mensagem> listaMsg) {
		this.listaMsg = listaMsg;
	}

	public List<Regra> getListaRegras() {
		return listaRegras;
	}

	public void setListaRegras(List<Regra> listaRegras) {
		this.listaRegras = listaRegras;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + nuTarefa;
		result = prime * result + nuVersao;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Tarefa other = (Tarefa) obj;
		if (nuTarefa != other.nuTarefa)
			return false;
		if (nuVersao != other.nuVersao)
			return false;
		return true;
	}

}
