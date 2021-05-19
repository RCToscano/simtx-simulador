package br.gov.caixa.simtx.simulador.testes.tabelas;

public class MeioEntrada {
	
    private int nuMeioEntrada;

    private int icSituacao;

    private String noMeioEntrada;

    
    
	public int getNuMeioEntrada() {
		return nuMeioEntrada;
	}

	public void setNuMeioEntrada(int nuMeioEntrada) {
		this.nuMeioEntrada = nuMeioEntrada;
	}

	public int getIcSituacao() {
		return icSituacao;
	}

	public void setIcSituacao(int icSituacao) {
		this.icSituacao = icSituacao;
	}

	public String getNoMeioEntrada() {
		return noMeioEntrada;
	}

	public void setNoMeioEntrada(String noMeioEntrada) {
		this.noMeioEntrada = noMeioEntrada;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + nuMeioEntrada;
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
		MeioEntrada other = (MeioEntrada) obj;
		if (nuMeioEntrada != other.nuMeioEntrada)
			return false;
		return true;
	}
    
}
