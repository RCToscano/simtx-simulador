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
	private Parametros parametros;



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

	public Parametros getParametros() {
		return parametros;
	}

	public void setParametros(Parametros parametros) {
		this.parametros = parametros;
	}

	class Parametros {

		private String additionalProp1;

		private String additionalProp2;

		private String additionalProp3;

		public String getAdditionalProp1() {
			return additionalProp1;
		}

		public void setAdditionalProp1(String additionalProp1) {
			this.additionalProp1 = additionalProp1;
		}

		public String getAdditionalProp2() {
			return additionalProp2;
		}

		public void setAdditionalProp2(String additionalProp2) {
			this.additionalProp2 = additionalProp2;
		}

		public String getAdditionalProp3() {
			return additionalProp3;
		}

		public void setAdditionalProp3(String additionalProp3) {
			this.additionalProp3 = additionalProp3;
		}

	}
}
