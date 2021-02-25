package br.gov.caixa.simtx.simulador.util.conta;

public class ContaUtil {

	private ContaUtil() {}
	
	public static Integer buscarIcContaSolucao(String conta, Integer produto) {
		if (conta.length() > 8 && produto != 20 && produto != 93) {
			return 2;
		} 
		else {
			return 1;
		}
	}
}
