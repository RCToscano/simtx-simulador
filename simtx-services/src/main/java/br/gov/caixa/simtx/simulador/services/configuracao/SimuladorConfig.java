package br.gov.caixa.simtx.simulador.services.configuracao;

import java.util.Set;

import javax.ws.rs.core.Application;

@javax.ws.rs.ApplicationPath("")
public class SimuladorConfig extends Application {
	@Override
	public Set<Class<?>> getClasses() {
		final Set<Class<?>> resources = new java.util.HashSet<>();
		resources.add(br.gov.caixa.simtx.simulador.services.permissao.ValidaPermissaoControle.class);
		resources.add(br.gov.caixa.simtx.simulador.services.assinatura.AssinaturaSimplesControle.class);
		resources.add(br.gov.caixa.simtx.simulador.services.comprovante.DetalheComprovanteControle.class);
		resources.add(br.gov.caixa.simtx.simulador.services.feriados.ConsultaFeriadosControle.class);
		return resources;
	}
}
