package br.gov.caixa.simtx.simulador.services.diautil;

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

@Path("/sibar/rotinas-comuns")
@Consumes("application/json")
@Produces("application/json")
public class ConsultaDiaUtil extends Controle {

	private static final Logger logger = Logger.getLogger(ConsultaDiaUtil.class);


	@GET
	@Path("/v1/data-util")
	public Response validarServico(@Context HttpServletRequest httpRequest, @QueryParam("unidade") String unidade, @QueryParam("data") String data) {
		try {
			logger.info(String.format("[SIMULADOR] Mensagem recebida: unidade %s data %s", unidade, data));
			return Response.ok().header("Content-Type", "application/json; charset=utf-8").entity("{\"data_util\":\""+data+"\"}").build();
		} 
		catch (Exception e) {
			logger.error(e);
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
		}
	}
	
}
