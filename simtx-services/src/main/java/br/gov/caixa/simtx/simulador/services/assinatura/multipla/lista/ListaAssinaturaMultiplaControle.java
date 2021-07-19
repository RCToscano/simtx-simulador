package br.gov.caixa.simtx.simulador.services.assinatura.multipla.lista;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;

import org.apache.log4j.Logger;

import br.gov.caixa.simtx.simulador.services.controle.Controle;
import br.gov.caixa.simtx.simulador.util.conta.ContaUtil;
import br.gov.caixa.simtx.simulador.util.exception.ControleException;
import br.gov.caixa.simtx.simulador.util.vo.Conta;

@Path("/sibar/contas/assinaturas-eletronicas")
@Consumes("application/json")
@Produces("application/json")
public class ListaAssinaturaMultiplaControle extends Controle {

	private static final Logger logger = Logger.getLogger(ListaAssinaturaMultiplaControle.class);
	
	private static final String PATH = "assinatura_multipla/lista";
	

	@GET
	@Path("/v1/assinatura-multipla/{id_conta}/transacoes-pendentes")
	public Response consultar(@Context HttpServletRequest httpRequest, @PathParam("id_conta") String idConta) {
		try {
			Conta conta = ContaUtil.converterParaConta(idConta);
			
			RequisicaoListaAssinaturas requisicao = new RequisicaoListaAssinaturas(conta.getUnidade(),
					conta.getProduto(), conta.getConta(), conta.getDv());
			String resposta = simuladorGenerico(requisicao, PATH + "/V1");
			return Response.ok().header("Content-Type", "application/json; charset=utf-8")
					.entity(resposta).build();
		} 
		catch (ControleException e) {
			logger.error(e.getMensagem());
			return Response.status(Response.Status.BAD_REQUEST)
					.entity(montarMsgErro(BASE_PATH_JSON + "/erro_generico_sibar.json", e.getMensagem())).build();
		} 
		catch (Exception e) {
			logger.error(e);
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
					.entity(montarMsgErro(BASE_PATH_JSON + "/erro_generico_sibar.json", e.getMessage())).build();
		}
	}
	
}
