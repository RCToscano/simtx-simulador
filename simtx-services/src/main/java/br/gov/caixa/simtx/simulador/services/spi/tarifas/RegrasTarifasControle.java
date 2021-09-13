package br.gov.caixa.simtx.simulador.services.spi.tarifas;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;

import org.apache.log4j.Logger;

import br.gov.caixa.simtx.simulador.services.controle.Controle;

@Path("/tarifas")
@Consumes("application/json")
@Produces("application/json")
public class RegrasTarifasControle extends Controle {

	private static final Logger logger = Logger.getLogger(RegrasTarifasControle.class);
	
	private static final String PATH = "regras_tarifas";
	

	@GET
	@Path("/v1/regras-tarifas")
	public Response validarServico(@Context HttpServletRequest httpRequest, @QueryParam("fluxo-transacao") String fluxoTransacao) {
		try {
			if(fluxoTransacao != null && !fluxoTransacao.isEmpty()) {
				String resposta = recuperarJson(BASE_PATH_JSON + PATH + "/V1/200.json");
				return Response.ok().header("Content-Type", "application/json; charset=utf-8").entity(resposta).build();
			}
			else {
				String resposta = recuperarJson(BASE_PATH_JSON + PATH + "/V1/400.json");
				return Response.status(Response.Status.BAD_REQUEST).entity(resposta).build();
			}
		} 
		catch (Exception e) {
			logger.error(e);
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
					.entity(montarMsgErro(BASE_PATH_JSON + PATH + "/V1/400.json", e.getMessage())).build();
		}
	}
	
}
