package br.gov.caixa.simtx.simulador.services.titular;

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
import br.gov.caixa.simtx.simulador.util.conta.ContaUtil;
import br.gov.caixa.simtx.simulador.util.exception.ControleException;

@Path("/sibar/contas/valida")
@Consumes("application/json")
@Produces("application/json")
public class ValidaTitularControle extends Controle {

	private static final Logger logger = Logger.getLogger(ValidaTitularControle.class);
	
	private static final String PATH = "valida_titular";

	@GET
	@Path("/v1/titular")
	public Response validarServico(@Context HttpServletRequest httpRequest, @QueryParam("unidade") String unidade,
			@QueryParam("conta") String conta, @QueryParam("produto") String produto, @QueryParam("dv") String dv,
			@QueryParam("cpf") String cpf) {
		try {
			RequisicaoValidaTitular requisicao = new RequisicaoValidaTitular(unidade, conta, produto, dv, cpf);
			String resposta = simuladorGenerico(requisicao, PATH + "/V1");
			resposta = resposta.replace("{TIPO}", ContaUtil.buscarIcContaSolucao(requisicao.getNumero(),
					Integer.valueOf(requisicao.getProduto())) == 1 ? "SIDEC" : "NSGD");
			return Response.ok().header("Content-Type", "application/json; charset=utf-8").entity(resposta).build();
		} catch (ControleException e) {
			logger.error(e.getMensagem());
			return Response.status(Response.Status.BAD_REQUEST)
					.entity(montarMsgErro(BASE_PATH_JSON + "/erro_generico_sibar.json", e.getMensagem())).build();
		} catch (Exception e) {
			logger.error(e);
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
					.entity(montarMsgErro(BASE_PATH_JSON + "/erro_generico_sibar.json", e.getMessage())).build();
		}
	}
	
	
}
