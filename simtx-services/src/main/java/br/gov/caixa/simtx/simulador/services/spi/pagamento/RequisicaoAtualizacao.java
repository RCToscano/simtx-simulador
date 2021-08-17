package br.gov.caixa.simtx.simulador.services.spi.pagamento;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class RequisicaoAtualizacao {
	
	@Size(min = 10, max = 10, message = "dataTransacao deve ser informada e ter o seguinte formato yyyy-MM-dd")
	private String dataTransacao;

	@NotNull(message = "dataHora nao informada")
	@Size(min = 23, max = 23, message = "dataHora deve ser informada e ter o seguinte formato yyyy-MM-ddTHH:mm:ss.sss")
	private String dataHora;

	@NotNull(message = "idFimAFim nao informado")
	@Size(min = 10, message = "idFimAFim nao informado corretamente")
	private String idFimAFim;

	@NotNull(message = "situacaoDaTransacao nao informada")
	@Valid
	private SituacaoPagamentoSPIEnum situacaoDaTransacao;

	private String codigoDeErro;

	private String detalhamentoDoErro;

	@Size(min = 23, max = 23, message = "dataHoraLiquidacao deve ter o seguinte formato yyyy-MM-ddTHH:mm:ss.sss")
	private String dataHoraLiquidacao;

	@Size(min = 23, max = 23, message = "dataContabil deve ter o seguinte formato yyyy-MM-ddTHH:mm:ss.sss")
	private String dataContabil;

	@Valid
	private Qrcode qrCode;


	public String getDataTransacao() {
		return dataTransacao;
	}

	public void setDataTransacao(String dataTransacao) {
		this.dataTransacao = dataTransacao;
	}

	public String getDataHora() {
		return dataHora;
	}

	public void setDataHora(String dataHora) {
		this.dataHora = dataHora;
	}

	public String getIdFimAFim() {
		return idFimAFim;
	}

	public void setIdFimAFim(String idFimAFim) {
		this.idFimAFim = idFimAFim;
	}

	public SituacaoPagamentoSPIEnum getSituacaoDaTransacao() {
		return situacaoDaTransacao;
	}

	public void setSituacaoDaTransacao(SituacaoPagamentoSPIEnum situacaoDaTransacao) {
		this.situacaoDaTransacao = situacaoDaTransacao;
	}

	public String getCodigoDeErro() {
		return codigoDeErro;
	}

	public void setCodigoDeErro(String codigoDeErro) {
		this.codigoDeErro = codigoDeErro;
	}

	public String getDetalhamentoDoErro() {
		return detalhamentoDoErro;
	}

	public void setDetalhamentoDoErro(String detalhamentoDoErro) {
		this.detalhamentoDoErro = detalhamentoDoErro;
	}

	public String getDataHoraLiquidacao() {
		return dataHoraLiquidacao;
	}

	public void setDataHoraLiquidacao(String dataHoraLiquidacao) {
		this.dataHoraLiquidacao = dataHoraLiquidacao;
	}

	public String getDataContabil() {
		return dataContabil;
	}

	public void setDataContabil(String dataContabil) {
		this.dataContabil = dataContabil;
	}

	public Qrcode getQrCode() {
		return qrCode;
	}

	public void setQrCode(Qrcode qrCode) {
		this.qrCode = qrCode;
	}

}
