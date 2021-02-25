package br.gov.caixa.simtx.simulador.services.titular;

import java.util.Date;

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
import br.gov.caixa.simtx.simulador.util.data.DataUtil;
import br.gov.caixa.simtx.simulador.util.exception.ControleException;
import br.gov.caixa.simtx.simulador.util.token.ParametrosApiUtil;

@Path("/sibar/valida-permissao")
@Consumes("application/json")
@Produces("application/json")
public class ValidaTitularControle extends Controle {

	private static final Logger logger = Logger.getLogger(ValidaTitularControle.class);
	
	private static final String PATH = "valida_titular";
	

	@POST
	@Path("/v1/clientes/{cpf}/validar-servico")
	public Response validarServico(@Context HttpServletRequest httpRequest, @PathParam("cpf") String cpf, String json) {
		try {
			RequisicaoValidaPermissao requisicao = gson.fromJson(json, RequisicaoValidaPermissao.class);
			String resposta = simuladorGenerico(requisicao, PATH + "/V1");
			resposta = resposta.replace("{CONTA}", ParametrosApiUtil.converterParaIDConta(requisicao.getConta()));
			resposta = resposta.replace("{DATA_ATUAL}", DataUtil.getDataFormatada(new Date(), DataUtil.FORMATO_DATA_XML));
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
