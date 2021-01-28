package br.gov.caixa.simtx.simulador.services.comprovante;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;

import org.apache.log4j.Logger;

import br.gov.caixa.simtx.simulador.services.controle.Controle;

@Path("/sicco-comprovantes")
@Consumes("application/json")
@Produces("application/json")
public class DetalheComprovanteControle extends Controle {

	private static final Logger logger = Logger.getLogger(DetalheComprovanteControle.class);
	
	private static final String PATH = "comprovante/detalhe";
	

	@POST
	@Path("/v1/transacoes/pix/{nsuTransacao}/{dataTransacao}")
	public Response detalhe(@Context HttpServletRequest httpRequest, @QueryParam("nsuTransacao") Long nsuTransacao,
			@QueryParam("dataTransacao") String dataTransacao) {
		try {
			String json = "";
			if (nsuTransacao == null || dataTransacao == null) {
				logger.warn("[SIMULADOR] Campos obrigatorios nao informados");
				return Response.status(Response.Status.BAD_REQUEST)
						.entity(montarMsgErro(BASE_PATH_JSON + PATH + "/500.json", "Campos obrigatorios nao informados"))
						.build();
			} 
			else if (dataTransacao.equals("2021-01-01")) {
				json = recuperarJson(BASE_PATH_JSON + PATH + "/200_pix.json");
			} 
			else if (dataTransacao.equals("2021-01-02")) {
				json = recuperarJson(BASE_PATH_JSON + PATH + "/200_devolucao_pix.json");
			} 
			else {
				logger.warn("[SIMULADOR] Comprovante nao implementado");
				return Response.status(Response.Status.BAD_REQUEST).entity(montarMsgErro(
						BASE_PATH_JSON + PATH + "/500.json",
						"Comprovante nao implementado. Informe a data 2021-01-01 para PIX e 2021-01-02 para Devolucao PIX"))
						.build();
			}

			json = json.replace("1355055", nsuTransacao.toString());
			return Response.ok().header("Content-Type", "application/json; charset=utf-8").entity(json).build();
		} 
		catch (Exception e) {
			logger.error(e);
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
					.entity(montarMsgErro(BASE_PATH_JSON + PATH + "/500.json", e.getMessage())).build();
		}
	}
	
	
	
	
}
