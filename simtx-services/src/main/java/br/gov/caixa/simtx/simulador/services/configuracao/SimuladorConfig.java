package br.gov.caixa.simtx.simulador.services.configuracao;

import java.util.Set;

import javax.ws.rs.core.Application;

@javax.ws.rs.ApplicationPath("")
public class SimuladorConfig extends Application {
	@Override
	public Set<Class<?>> getClasses() {
		final Set<Class<?>> resources = new java.util.HashSet<>();
		resources.add(br.gov.caixa.simtx.simulador.services.permissao.ValidaPermissaoControle.class);
		resources.add(br.gov.caixa.simtx.simulador.services.assinatura.simples.ValidaAssinaturaSimplesControle.class);
		resources.add(br.gov.caixa.simtx.simulador.services.assinatura.simples.v2.ValidaAssinaturaSimplesV2Controle.class);
		resources.add(br.gov.caixa.simtx.simulador.services.assinatura.multipla.ValidaAssinaturaMultiplaControle.class);
		resources.add(br.gov.caixa.simtx.simulador.services.assinatura.multipla.v2.ValidaAssinaturaMultiplaV2Controle.class);
		resources.add(br.gov.caixa.simtx.simulador.services.comprovante.DetalheComprovanteControle.class);
		resources.add(br.gov.caixa.simtx.simulador.services.feriados.ConsultaFeriadosControle.class);
		resources.add(br.gov.caixa.simtx.simulador.services.spi.pagamento.PagamentoSPIControle.class);
		resources.add(br.gov.caixa.simtx.simulador.services.pagamentospi.v2.PagamentoSPIV2Controle.class);
		resources.add(br.gov.caixa.simtx.simulador.services.pagamentospi.v3.PagamentoSPIV3Controle.class);
		resources.add(br.gov.caixa.simtx.simulador.services.spi.pagamento.AtualizacaoSPIControle.class);
		resources.add(br.gov.caixa.simtx.simulador.services.spi.tarifas.RegrasTarifasControle.class);
		resources.add(br.gov.caixa.simtx.simulador.services.consultaconta.ConsultaContaControle.class);
		resources.add(br.gov.caixa.simtx.simulador.services.validamarcas.ValidaMarcasControle.class);
		resources.add(br.gov.caixa.simtx.simulador.services.titular.ValidaTitularControle.class);
		resources.add(br.gov.caixa.simtx.simulador.services.limite.validar.ValidaLimiteControle.class);
		resources.add(br.gov.caixa.simtx.simulador.services.limite.efetivar.EfetivaLimiteControle.class);
		resources.add(br.gov.caixa.simtx.simulador.services.limite.desfazer.DesfazLimiteControle.class);
		resources.add(br.gov.caixa.simtx.simulador.services.enviopush.EnvioPushCanalControle.class);
		resources.add(br.gov.caixa.simtx.simulador.services.qrcode.consulta.ConsultaQRCodeControle.class);
		resources.add(br.gov.caixa.simtx.simulador.services.atualizasituacaosssinaturamultipla.AtualizaSituacaoAssinaturaMultiplaApiControle.class);
		resources.add(br.gov.caixa.simtx.simulador.services.assinatura.multipla.lista.ListaAssinaturaMultiplaControle.class);
		resources.add(br.gov.caixa.simtx.simulador.services.spi.cancelamento.controle.CancelamentoSPIControle.class);
		resources.add(br.gov.caixa.simtx.simulador.services.openbaking.AtrualizaPixOpenBankingControle.class);
		resources.add(br.gov.caixa.simtx.simulador.services.diautil.ConsultaDiaUtil.class);
		return resources;
	}
}
