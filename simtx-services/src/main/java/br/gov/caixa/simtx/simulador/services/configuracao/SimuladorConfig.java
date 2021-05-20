package br.gov.caixa.simtx.simulador.services.configuracao;

import java.util.Set;

import javax.ws.rs.core.Application;

@javax.ws.rs.ApplicationPath("")
public class SimuladorConfig extends Application {
	@Override
	public Set<Class<?>> getClasses() {
		final Set<Class<?>> resources = new java.util.HashSet<>();
		resources.add(br.gov.caixa.simtx.simulador.services.permissao.ValidaPermissaoControle.class);
		resources.add(br.gov.caixa.simtx.simulador.services.assinatura.simples.AssinaturaSimplesControle.class);
		resources.add(br.gov.caixa.simtx.simulador.services.assinatura.multipla.ValidaAssinaturaControle.class);
		resources.add(br.gov.caixa.simtx.simulador.services.comprovante.DetalheComprovanteControle.class);
		resources.add(br.gov.caixa.simtx.simulador.services.feriados.ConsultaFeriadosControle.class);
		resources.add(br.gov.caixa.simtx.simulador.services.pagamentospi.PagamentoSPIControle.class);
		resources.add(br.gov.caixa.simtx.simulador.services.pagamentospi.v2.PagamentoSPIV2Controle.class);
		resources.add(br.gov.caixa.simtx.simulador.services.pagamentospi.AtualizacaoSPIControle.class);
		resources.add(br.gov.caixa.simtx.simulador.services.consultaconta.ConsultaContaControle.class);
		resources.add(br.gov.caixa.simtx.simulador.services.validamarcas.ValidaMarcasControle.class);
		resources.add(br.gov.caixa.simtx.simulador.services.titular.ValidaTitularControle.class);
		resources.add(br.gov.caixa.simtx.simulador.services.limite.validar.ValidaLimiteControle.class);
		return resources;
	}
}
