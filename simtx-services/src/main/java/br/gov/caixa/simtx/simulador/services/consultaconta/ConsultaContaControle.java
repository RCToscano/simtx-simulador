package br.gov.caixa.simtx.simulador.services.consultaconta;

import java.io.InputStream;
import java.nio.charset.StandardCharsets;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;

import org.apache.commons.io.IOUtils;
import org.apache.log4j.Logger;

import br.gov.caixa.simtx.simulador.services.controle.Controle;
import br.gov.caixa.simtx.simulador.util.conta.ContaUtil;
import br.gov.caixa.simtx.simulador.util.exception.ControleException;

@Path("/sibar/consulta-conta")
@Consumes("application/json")
@Produces("application/json")
public class ConsultaContaControle extends Controle {

	private static final Logger logger = Logger.getLogger(ConsultaContaControle.class);
	
	private static final String PATH = "consulta_conta";
	

	@POST
	@Path("/v1")
	public Response consultaConta(@Context HttpServletRequest httpRequest, @QueryParam("unidade") String unidade,
			@QueryParam("produto") String produto, @QueryParam("conta") String conta, @QueryParam("dv") String dv,
			@QueryParam("titular") String titular, @QueryParam("offset") String offset,
			@QueryParam("tipo_conta") String tipoConta) {
		try {
			RequisicaoConsultaConta requisicao = new RequisicaoConsultaConta(unidade, conta, produto, dv, titular,
					offset, tipoConta);
			validarAtributosCampos(requisicao);
			
			String resposta = "";
			
			if(titular != null && !titular.isEmpty() && titular.equals("PRIMEIRO")) {
				InputStream input = getClass().getClassLoader().getResourceAsStream(BASE_PATH_JSON + PATH + "/V1/200_primeiro.json");
				resposta = IOUtils.toString(input, StandardCharsets.UTF_8);
			}
			else {
				InputStream input = getClass().getClassLoader().getResourceAsStream(BASE_PATH_JSON + PATH + "/V1/200_todos.json");
				resposta = IOUtils.toString(input, StandardCharsets.UTF_8);
			}
			resposta = resposta.replace("{CONTA}", conta);
			resposta = resposta.replace("{DV}", dv);
			resposta = resposta.replace("{TIPO}", ContaUtil.buscarIcContaSolucao(conta, Integer.parseInt(produto)) == 1 ? "SIDEC" : "NSGD");
			return Response.ok().header("Content-Type", "application/json; charset=utf-8")
					.entity(resposta).build();
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
