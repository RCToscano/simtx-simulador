package br.gov.caixa.simtx.simulador.testes.tabelas;

public class Regra {
	
	private int nuRegra;
	
    private String noCampoDependencia;
	
    private String noServicoOrigem;
	
    private String noOperacaoOrigem;
	
    private String deCaminhoInformacao;

	
	
	public int getNuRegra() {
		return nuRegra;
	}

	public void setNuRegra(int nuRegra) {
		this.nuRegra = nuRegra;
	}
	
	public String getNoCampoDependencia() {
		return noCampoDependencia;
	}

	public void setNoCampoDependencia(String noCampoDependencia) {
		this.noCampoDependencia = noCampoDependencia;
	}

	public String getNoServicoOrigem() {
		return noServicoOrigem;
	}

	public void setNoServicoOrigem(String noServicoOrigem) {
		this.noServicoOrigem = noServicoOrigem;
	}

	public String getNoOperacaoOrigem() {
		return noOperacaoOrigem;
	}

	public void setNoOperacaoOrigem(String noOperacaoOrigem) {
		this.noOperacaoOrigem = noOperacaoOrigem;
	}

	public String getDeCaminhoInformacao() {
		return deCaminhoInformacao;
	}

	public void setDeCaminhoInformacao(String deCaminhoInformacao) {
		this.deCaminhoInformacao = deCaminhoInformacao;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + nuRegra;
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
		Regra other = (Regra) obj;
		if (nuRegra != other.nuRegra)
			return false;
		return true;
	}
	
}
