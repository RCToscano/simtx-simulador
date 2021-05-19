package br.gov.caixa.simtx.simulador.util.http;


public class PropriedadesHTTP {
	
	public static final String METODO_PUT = "PUT";
	
	public static final String METODO_GET = "GET";
	
	public static final String METODO_POST = "POST";
	
	
	private String chave;
	
	private String valor;

	
	public PropriedadesHTTP(String chave, String valor) {
		super();
		this.chave = chave;
		this.valor = valor;
	}
	
	public String getChave() {
		return chave;
	}

	public void setChave(String chave) {
		this.chave = chave;
	}

	public String getValor() {
		return valor;
	}

	public void setValor(String valor) {
		this.valor = valor;
	}
}
