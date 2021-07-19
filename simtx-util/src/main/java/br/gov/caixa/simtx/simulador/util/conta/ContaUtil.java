package br.gov.caixa.simtx.simulador.util.conta;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import br.gov.caixa.simtx.simulador.util.vo.Conta;

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
	
	public static Conta converterParaConta(String idConta) {
		String[] vConta = new String[4];
		Conta conta = new Conta();
		final String regex = "[^-]*[^-]";

		final Pattern pattern = Pattern.compile(regex, Pattern.MULTILINE);
		final Matcher matcher = pattern.matcher(idConta);

		int i = 0;
		while (matcher.find()) {
			vConta[i] = matcher.group(0);
			i++;
		}
		
		conta.setUnidade(Integer.parseInt(vConta[0]));
		conta.setProduto(Integer.parseInt(vConta[1]));
		conta.setConta(Long.parseLong(vConta[2]));
		conta.setDv(Integer.parseInt(vConta[3]));
		return conta;
	}
	
}
