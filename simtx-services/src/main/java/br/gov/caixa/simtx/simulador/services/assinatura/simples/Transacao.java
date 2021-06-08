package br.gov.caixa.simtx.simulador.services.assinatura.simples;

import java.math.BigDecimal;

import javax.validation.constraints.Digits;
import javax.validation.constraints.Size;

public class Transacao {
	
	private String resumo;
    
	@Size(min = 10, max = 10, message= "data transacao deve ter o seguinte formato aaaa-mm-dd")
	private String data;
    
	@Digits(integer = 12, fraction = 2, message = "valor invalido. espera-se <12 digitos>.<2 digitos>")
    private BigDecimal valor;

	public String getResumo() {
		return resumo;
	}

	public void setResumo(String resumo) {
		this.resumo = resumo;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public BigDecimal getValor() {
		return valor;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}
	
}
