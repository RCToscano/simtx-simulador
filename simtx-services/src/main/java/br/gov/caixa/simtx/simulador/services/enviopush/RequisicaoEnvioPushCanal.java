package br.gov.caixa.simtx.simulador.services.enviopush;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class RequisicaoEnvioPushCanal {

	@NotNull(message = "identificador nao informado")
	@Size(min = 11, max = 21, message = "identificador deve ser informado e ter no maximo 21 caracteres")
	private String identificador;

	@NotNull(message = "canal nao informado")
	@Size(min = 1, message = "canal deve ser informado")
	private String canal;

	@NotNull(message = "icMensagem nao informado")
	@Valid
	private IcMensagemEnvioPushCanal icMensagem;

	@NotNull(message = "parametros nao informado")
	@Valid
	private Object parametros;



	public String getIdentificador() {
		return identificador;
	}

	public void setIdentificador(String identificador) {
		this.identificador = identificador;
	}

	public String getCanal() {
		return canal;
	}

	public void setCanal(String canal) {
		this.canal = canal;
	}

	public IcMensagemEnvioPushCanal getIcMensagem() {
		return icMensagem;
	}

	public void setIcMensagem(IcMensagemEnvioPushCanal icMensagem) {
		this.icMensagem = icMensagem;
	}

	public Object getParametros() {
		return parametros;
	}

	public void setParametros(Object parametros) {
		this.parametros = parametros;
	}

}
