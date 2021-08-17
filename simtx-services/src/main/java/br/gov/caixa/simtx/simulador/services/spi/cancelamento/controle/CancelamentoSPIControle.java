package br.gov.caixa.simtx.simulador.services.spi.cancelamento.controle;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.Consumes;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;

import org.apache.log4j.Logger;

import br.gov.caixa.simtx.simulador.services.controle.Controle;
import br.gov.caixa.simtx.simulador.services.spi.cancelamento.vo.RequisicaoCancelamentoSpi;
import br.gov.caixa.simtx.simulador.util.exception.ControleException;

@Path("/sispi-api-war/api")
@Consumes("application/json")
@Produces("application/json")
public class CancelamentoSPIControle extends Controle {

	private static final Logger logger = Logger.getLogger(CancelamentoSPIControle.class);
	
	private static final String PATH = "pix/cancelamento";
	

	@PUT
	@Path("/v1/ordens-pagamento/cancelar")
	public Response validarServico(@Context HttpServletRequest httpRequest, String json) {
		try {
			RequisicaoCancelamentoSpi requisicao = gson.fromJson(json, RequisicaoCancelamentoSpi.class);
			String resposta = simuladorGenerico(requisicao, PATH + "/V1");
			resposta = resposta.replace("{IDFIMAFIM}", requisicao.getIdFimAFim());
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
