package br.gov.caixa.simtx.simulador.services.configuracao;

import java.util.Set;

import javax.ws.rs.core.Application;

@javax.ws.rs.ApplicationPath("")
public class RestApiConfig extends Application {
	@Override
	public Set<Class<?>> getClasses() {
		final Set<Class<?>> resources = new java.util.HashSet<>();
		resources.add(br.gov.caixa.simtx.simulador.services.permissao.ValidaPermissaoControle.class);
		return resources;
	}
}
