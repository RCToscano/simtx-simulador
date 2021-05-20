package br.gov.caixa.simtx.simulador.testes.tabelas;

public class Canal {
	
    private int nuCanal;

    private int icSituacaoCanal;

    private String noCanal;

    private String noFilaRspCanal;

    private String noConexaoCanal;
    
    private String sigla;
    
    private int nuRedeTransmissora;
    
    private int nuSegmento;

    
    
	public int getNuCanal() {
		return nuCanal;
	}

	public void setNuCanal(int nuCanal) {
		this.nuCanal = nuCanal;
	}

	public int getIcSituacaoCanal() {
		return icSituacaoCanal;
	}

	public void setIcSituacaoCanal(int icSituacaoCanal) {
		this.icSituacaoCanal = icSituacaoCanal;
	}

	public String getNoCanal() {
		return noCanal;
	}

	public void setNoCanal(String noCanal) {
		this.noCanal = noCanal;
	}

	public String getNoFilaRspCanal() {
		return noFilaRspCanal;
	}

	public void setNoFilaRspCanal(String noFilaRspCanal) {
		this.noFilaRspCanal = noFilaRspCanal;
	}

	public String getNoConexaoCanal() {
		return noConexaoCanal;
	}

	public void setNoConexaoCanal(String noConexaoCanal) {
		this.noConexaoCanal = noConexaoCanal;
	}

	public String getSigla() {
		return sigla;
	}

	public void setSigla(String sigla) {
		this.sigla = sigla;
	}

	public int getNuRedeTransmissora() {
		return nuRedeTransmissora;
	}

	public void setNuRedeTransmissora(int nuRedeTransmissora) {
		this.nuRedeTransmissora = nuRedeTransmissora;
	}

	public int getNuSegmento() {
		return nuSegmento;
	}

	public void setNuSegmento(int nuSegmento) {
		this.nuSegmento = nuSegmento;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + nuCanal;
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
		Canal other = (Canal) obj;
		if (nuCanal != other.nuCanal)
			return false;
		return true;
	}
	
}
