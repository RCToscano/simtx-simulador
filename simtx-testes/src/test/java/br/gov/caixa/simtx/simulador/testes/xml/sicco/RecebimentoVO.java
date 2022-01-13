package br.gov.caixa.simtx.simulador.testes.xml.sicco;

import java.math.BigDecimal;

public class RecebimentoVO {
	
	private Long nsuTransacao;
	
	private int dv;
    
	private int produto;
    
    private long conta;
    
    private int agencia;
    
    private Long cpf;
    
    private String codBarras;
    
    private BigDecimal valor;
    
    
	public RecebimentoVO(Long nsuTransacao, int dv, int produto, long conta, int agencia, Long cpf, String codBarras,
			BigDecimal valor) {
		super();
		this.nsuTransacao = nsuTransacao;
		this.dv = dv;
		this.produto = produto;
		this.conta = conta;
		this.agencia = agencia;
		this.cpf = cpf;
		this.codBarras = codBarras;
		this.valor = valor;
	}

	public Long getNsuTransacao() {
		return nsuTransacao;
	}

	public void setNsuTransacao(Long nsuTransacao) {
		this.nsuTransacao = nsuTransacao;
	}

	public int getDv() {
		return dv;
	}

	public void setDv(int dv) {
		this.dv = dv;
	}

	public int getProduto() {
		return produto;
	}

	public void setProduto(int produto) {
		this.produto = produto;
	}

	public long getConta() {
		return conta;
	}

	public void setConta(long conta) {
		this.conta = conta;
	}

	public int getAgencia() {
		return agencia;
	}

	public void setAgencia(int agencia) {
		this.agencia = agencia;
	}

	public Long getCpf() {
		return cpf;
	}

	public void setCpf(Long cpf) {
		this.cpf = cpf;
	}

	public String getCodBarras() {
		return codBarras;
	}

	public void setCodBarras(String codBarras) {
		this.codBarras = codBarras;
	}

	public BigDecimal getValor() {
		return valor;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}

}
