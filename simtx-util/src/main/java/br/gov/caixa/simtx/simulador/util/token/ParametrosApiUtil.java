package br.gov.caixa.simtx.simulador.util.token;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import br.gov.caixa.simtx.simulador.util.vo.ContaSIBAR;

public class ParametrosApiUtil {

	
	private ParametrosApiUtil() {}
		
	/**
	 * @param idConta
	 * @return Conta com agência
	 */
	public static ContaSIBAR converterParaConta(String idConta) {
		String[] vConta = new String[4];
		ContaSIBAR conta = new ContaSIBAR();
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
		conta.setNumero(Long.parseLong(vConta[2]));
		conta.setDv(Integer.parseInt(vConta[3]));
		
		return conta;
	}
	
	public static String adicionarZerosEsquerdaIdConta(ContaSIBAR vConta) {
		String agencia = vConta.getUnidade().toString();
		String conta = vConta.getNumero().toString();
		String produto = vConta.getProduto().toString();
		String dv = vConta.getDv().toString();
		String nuAg = (agencia.length() != 4) ? ("0000"+ agencia).substring(agencia.length()) : agencia;
		String nuConta = (conta.length() != 12) ? ("000000000000"+conta).substring(conta.length()): conta;
		String nuProduto = (produto.length() != 4) ? ("0000"+produto).substring(produto.length()): produto;
		return nuAg + "-" + nuProduto +"-" + nuConta+"-" + dv;	
	}
	
	public static String converterParaIDConta(ContaSIBAR conta) {
		String agencia = String.valueOf(conta.getUnidade());
		String nuConta = String.valueOf(conta.getNumero());
		String produto = String.valueOf(conta.getProduto());
		String dv = String.valueOf(conta.getDv());
		StringBuilder idConta = new StringBuilder();
		idConta.append(agencia).append("-");
		idConta.append(produto).append("-");
		idConta.append(nuConta).append("-");
		idConta.append(dv);
		return idConta.toString();
	}
}
