package br.gov.caixa.simtx.simulador.services.feriados;

import java.util.List;

public class FeriadosVO {

	private List<Feriados> feriados;

	public List<Feriados> getFeriados() {
		return feriados;
	}

	public void setFeriados(List<Feriados> feriados) {
		this.feriados = feriados;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("FeriadosVO [feriados=");
		builder.append(feriados);
		builder.append("]");
		return builder.toString();
	}
}
