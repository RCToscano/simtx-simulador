package br.gov.caixa.simtx.simulador.services.openbaking;

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
import br.gov.caixa.simtx.simulador.util.exception.ControleException;

@Path("/open-banking/gestao-pagamentos")
@Consumes("application/json")
@Produces("application/json")
public class ConsultaPixPendenteBSAV1Controle extends Controle {

	private static final Logger logger = Logger.getLogger(ConsultaPixPendenteBSAV1Controle.class);
	
	private static final String PATH = "pix/consulta_pix_pendente";

	@GET
	@Path("/v1/payments/{paymentId}/pending")
	public Response consultar(@Context HttpServletRequest httpRequest, @PathParam("paymentId") String paymentId) {
		try {			
			String resposta = simuladorGenerico(null, PATH + "/V1");
			httpRequest.getHeader("apikey");
			httpRequest.getHeader("Authorization");
			logger.info("apikey " + httpRequest.getHeader("apikey"));
			logger.info("token " + httpRequest.getHeader("Authorization"));
			return Response.ok().header("Content-Type", "application/json; charset=utf-8")
					.entity(resposta).build();
		} 
		catch (ControleException e) {
			logger.error(e.getMensagem());
			return Response.status(Response.Status.BAD_REQUEST)
					.entity(montarMsgErro(PATH + "/V1/400.json", e.getMensagem())).build();
		} 
		catch (Exception e) {
			logger.error(e);
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
					.entity(montarMsgErro(PATH + "/V1/400.json", e.getMessage())).build();
		}
	}	
}
