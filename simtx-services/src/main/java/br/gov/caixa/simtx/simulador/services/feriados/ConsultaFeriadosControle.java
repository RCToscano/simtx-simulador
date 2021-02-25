package br.gov.caixa.simtx.simulador.services.feriados;

import java.util.Date;

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
import br.gov.caixa.simtx.simulador.util.data.DataUtil;
import br.gov.caixa.simtx.simulador.util.exception.ControleException;

@Path("/sibar/corporativo/administrativo")
@Consumes("application/json")
@Produces("application/json")
public class ConsultaFeriadosControle extends Controle {

	private static final Logger logger = Logger.getLogger(ConsultaFeriadosControle.class);
	
	private static final String PATH = "consulta_feriados";
	

	@GET
	@Path("/v1/feriados")
	public Response validarServico(@Context HttpServletRequest httpRequest, @QueryParam("abrangencia") String abrangencia,
			@QueryParam("data_inicial") String dataInicial, @QueryParam("data_final") String dataFinal) {
		try {
			if (abrangencia != null && !abrangencia.isEmpty() && dataInicial != null && !dataInicial.isEmpty()
					&& dataFinal != null && !dataFinal.isEmpty()) {

				String resposta = simuladorGenerico(null, PATH + "/V1");
				resposta = resposta.replace("{DATA_SIMULADA}",
						DataUtil.getDataFormatada(new Date(), DataUtil.FORMATO_DATA_XML));
				return Response.ok().header("Content-Type", "application/json; charset=utf-8").entity(resposta).build();
			} 
			else {
				logger.error("Campos obrigatorios nao informados");
				return Response.status(Response.Status.BAD_REQUEST)
						.entity(montarMsgErro(BASE_PATH_JSON + "/erro_generico_sibar.json",
								"Campos obrigatorios nao informados"))
						.build();
			}
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
