package br.gov.caixa.simtx.simulador.services.assinatura;

import java.io.InputStream;
import java.nio.charset.StandardCharsets;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;

import org.apache.commons.io.IOUtils;
import org.apache.log4j.Logger;

import br.gov.caixa.simtx.simulador.services.controle.Controle;
import br.gov.caixa.simtx.simulador.util.exception.ControleException;

@Path("/sibar/valida-permissao")
@Consumes("application/json")
@Produces("application/json")
public class ValidaAssinaturaControle extends Controle {

	private static final Logger logger = Logger.getLogger(ValidaAssinaturaControle.class);
	
	private static final String PATH = "valida_assinatura";
	

	@POST
	@Path("/v1/assinatura-multipla/{cpf}/validar")
	public Response validarServico(@Context HttpServletRequest httpRequest, @PathParam("cpf") String cpf, String json) {
		try {
			RequisicaoValidaAssinatura requisicao = gson.fromJson(json, RequisicaoValidaAssinatura.class);
			validarAtributosCampos(requisicao);
			
			String resposta = "";
			if(requisicao.getClassificacao().equals(ClassificacaoAssinaturaEnum.PRIMEIRA_ASSINATURA)) {
				
				InputStream input = getClass().getClassLoader().getResourceAsStream(BASE_PATH_JSON + PATH + "/V1/200.json");
				resposta = IOUtils.toString(input, StandardCharsets.UTF_8);
				
				
			}
			else if(requisicao.getClassificacao().equals(ClassificacaoAssinaturaEnum.ASSINATURA_INTERMEDIARIA)) {
				
			}
			
			
			
			return Response.ok().header("Content-Type", "application/json; charset=utf-8")
					.entity("").build();
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
