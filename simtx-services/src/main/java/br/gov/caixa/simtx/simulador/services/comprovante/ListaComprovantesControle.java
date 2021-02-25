package br.gov.caixa.simtx.simulador.services.comprovante;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;

import org.apache.log4j.Logger;

import br.gov.caixa.simtx.simulador.services.controle.Controle;
import br.gov.caixa.simtx.simulador.util.exception.ControleException;

@Path("/sicco-comprovantes")
@Consumes("application/json")
@Produces("application/json")
public class ListaComprovantesControle extends Controle {

	private static final Logger logger = Logger.getLogger(ListaComprovantesControle.class);
	
	private static final String PATH = "comprovante/lista";
	

	@POST
	@Path("/v1/transacoes")
	public Response validarServico(@Context HttpServletRequest httpRequest, String json) {
		try {
			RequisicaoListaComprovante requisicao = gson.fromJson(json, RequisicaoListaComprovante.class);
			String resposta = simuladorGenerico(requisicao, PATH + "/V1");
			resposta = resposta.replace("{DATA}", requisicao.getDataInicio());
			return Response.ok().header("Content-Type", "application/json; charset=utf-8").entity(resposta).build();
		} 
		catch (ControleException e) {
			logger.error(e.getMensagem());
			return Response.status(Response.Status.BAD_REQUEST)
					.entity(montarMsgErro(BASE_PATH_JSON + PATH + "/500.json", e.getMensagem())).build();
		} 
		catch (Exception e) {
			logger.error(e);
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
					.entity(montarMsgErro(BASE_PATH_JSON + PATH + "/500.json", e.getMessage())).build();
		}
	}
	
	
	
	
}
