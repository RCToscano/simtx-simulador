package br.gov.caixa.simtx.simulador.services.limite.desfazer;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;

import org.apache.log4j.Logger;

import br.gov.caixa.simtx.simulador.services.controle.Controle;
import br.gov.caixa.simtx.simulador.util.exception.ControleException;

@Path("/sibar/limites-debito")
@Consumes("application/json")
@Produces("application/json")
public class DesfazLimiteControle extends Controle {

	private static final Logger logger = Logger.getLogger(DesfazLimiteControle.class);
	
	private static final String PATH = "desfaz_limite";
	

	@POST
	@Path("/v1/{conta}/efetivar")
	public Response validarServico(@Context HttpServletRequest httpRequest, @PathParam("id_conta") String conta, String json) {
		try {
			RequisicaoDesfazLimite requisicao = gson.fromJson(json, RequisicaoDesfazLimite.class);
			String resposta = simuladorGenerico(requisicao, PATH + "/V1");
			return Response.ok().header("Content-Type", "application/json; charset=utf-8").entity(resposta).build();
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
