package br.gov.caixa.simtx.simulador.testes.tabelas;

public class Mensagem {
	
	private int nuNsuMensagem;
	
    private String coRetornoCorporativo;

    private String coRetornoCanal;

    private String deMensagemNegocial;

    private String deMensagemTecnica;

    private Integer icTipoMensagem;

    private String deMensagemResumida;
    
    private String noCampoRetorno;
    
    private CategoriaMensagem categoriaMensagem;

	
	
	public int getNuNsuMensagem() {
		return nuNsuMensagem;
	}

	public void setNuNsuMensagem(int nuNsuMensagem) {
		this.nuNsuMensagem = nuNsuMensagem;
	}
	
	public String getCoRetornoCorporativo() {
		return coRetornoCorporativo;
	}

	public void setCoRetornoCorporativo(String coRetornoCorporativo) {
		this.coRetornoCorporativo = coRetornoCorporativo;
	}

	public String getCoRetornoCanal() {
		return coRetornoCanal;
	}

	public void setCoRetornoCanal(String coRetornoCanal) {
		this.coRetornoCanal = coRetornoCanal;
	}

	public String getDeMensagemNegocial() {
		return deMensagemNegocial;
	}

	public void setDeMensagemNegocial(String deMensagemNegocial) {
		this.deMensagemNegocial = deMensagemNegocial;
	}

	public String getDeMensagemTecnica() {
		return deMensagemTecnica;
	}

	public void setDeMensagemTecnica(String deMensagemTecnica) {
		this.deMensagemTecnica = deMensagemTecnica;
	}

	public Integer getIcTipoMensagem() {
		return icTipoMensagem;
	}

	public void setIcTipoMensagem(Integer icTipoMensagem) {
		this.icTipoMensagem = icTipoMensagem;
	}

	public String getDeMensagemResumida() {
		return deMensagemResumida;
	}

	public void setDeMensagemResumida(String deMensagemResumida) {
		this.deMensagemResumida = deMensagemResumida;
	}
	
	public String getNoCampoRetorno() {
		return noCampoRetorno;
	}

	public void setNoCampoRetorno(String noCampoRetorno) {
		this.noCampoRetorno = noCampoRetorno;
	}

	public CategoriaMensagem getCategoriaMensagem() {
		return categoriaMensagem;
	}

	public void setCategoriaMensagem(CategoriaMensagem categoriaMensagem) {
		this.categoriaMensagem = categoriaMensagem;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + nuNsuMensagem;
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
		Mensagem other = (Mensagem) obj;
		if (nuNsuMensagem != other.nuNsuMensagem)
			return false;
		return true;
	}

}
