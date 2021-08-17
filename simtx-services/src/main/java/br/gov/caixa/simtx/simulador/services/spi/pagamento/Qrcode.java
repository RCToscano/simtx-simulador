package br.gov.caixa.simtx.simulador.services.spi.pagamento;

import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class Qrcode {

	@NotNull(message = "revisao nao informada")
	@Min(value = 1, message = "revisao deve ser informada")
	private Long revisao;

	@NotNull(message = "calendario nao informado")
	@Valid
	private Calendario calendario;

	@NotNull(message = "devedor nao informado")
	@Valid
	private Devedor devedor;

	@NotNull(message = "recebedor nao informado")
	@Valid
	private Recebedor recebedor;

	@NotNull(message = "valor nao informado")
	@Valid
	private Valor valor;

	@NotNull(message = "chave nao informada")
	@Size(min = 1, message = "chave nao informada corretamente")
	private String chave;

	@NotNull(message = "txId nao informado")
	@Size(min = 1, message = "txId nao informado corretamente")
	private String txid;

	@NotNull(message = "solicitacaoPagador nao informada")
	@Size(min = 1, message = "solicitacaoPagador nao informada corretamente")
	private String solicitacaoPagador;

	@NotNull(message = "infoAdicionais nao informado")
	@Valid
	private List<InfoAdicionais> infoAdicionais;



	public Long getRevisao() {
		return revisao;
	}

	public void setRevisao(Long revisao) {
		this.revisao = revisao;
	}

	public Calendario getCalendario() {
		return calendario;
	}

	public void setCalendario(Calendario calendario) {
		this.calendario = calendario;
	}

	public Devedor getDevedor() {
		return devedor;
	}

	public void setDevedor(Devedor devedor) {
		this.devedor = devedor;
	}

	public Recebedor getRecebedor() {
		return recebedor;
	}

	public void setRecebedor(Recebedor recebedor) {
		this.recebedor = recebedor;
	}

	public Valor getValor() {
		return valor;
	}

	public void setValor(Valor valor) {
		this.valor = valor;
	}

	public String getChave() {
		return chave;
	}

	public void setChave(String chave) {
		this.chave = chave;
	}

	public String getTxid() {
		return txid;
	}

	public void setTxid(String txid) {
		this.txid = txid;
	}

	public String getSolicitacaoPagador() {
		return solicitacaoPagador;
	}

	public void setSolicitacaoPagador(String solicitacaoPagador) {
		this.solicitacaoPagador = solicitacaoPagador;
	}

	public List<InfoAdicionais> getInfoAdicionais() {
		return infoAdicionais;
	}

	public void setInfoAdicionais(List<InfoAdicionais> infoAdicionais) {
		this.infoAdicionais = infoAdicionais;
	}

}
