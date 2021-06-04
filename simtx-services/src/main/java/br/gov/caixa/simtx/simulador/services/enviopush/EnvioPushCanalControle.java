package br.gov.caixa.simtx.simulador.services.enviopush;

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

@Path("/api")
@Consumes("application/json")
@Produces("application/json")
public class EnvioPushCanalControle extends Controle {

	private static final Logger logger = Logger.getLogger(EnvioPushCanalControle.class);


	@POST
	@Path("/Envio/v2")
	public Response validarServico(@Context HttpServletRequest httpRequest, String json) {
		try {
			RequisicaoEnvioPushCanal requisicao = gson.fromJson(json, RequisicaoEnvioPushCanal.class);
			logger.info("[SIMULADOR] Mensagem recebida: "+ gson.toJson(requisicao));
			validarAtributosCampos(requisicao);
			return Response.ok().header("Content-Type", "application/json; charset=utf-8").build();
		} 
		catch (ControleException e) {
			logger.error(e.getMensagem());
			return Response.status(Response.Status.BAD_REQUEST).build();
		} 
		catch (Exception e) {
			logger.error(e);
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
		}
	}
	
	
	
	
}
