package br.gov.caixa.simtx.simulador.services.assinatura.multipla;

import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.Date;

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
import br.gov.caixa.simtx.simulador.util.data.DataUtil;
import br.gov.caixa.simtx.simulador.util.exception.ControleException;

@Path("/sibar/contas/assinaturas-eletronicas")
@Consumes("application/json")
@Produces("application/json")
public class ValidaAssinaturaMultiplaControle extends Controle {

	private static final Logger logger = Logger.getLogger(ValidaAssinaturaMultiplaControle.class);
	
	private static final String PATH = "assinatura_multipla";
	

	@POST
	@Path("/V2/assinatura-multipla/{cpf}/validar")
	public Response validarServico(@Context HttpServletRequest httpRequest, @PathParam("cpf") String cpf, String json) {
		try {
			RequisicaoValidaAssinaturaMultipla requisicao = gson.fromJson(json, RequisicaoValidaAssinaturaMultipla.class);
			validarAtributosCampos(requisicao);
			
			String resposta = "";
			if (ClassificacaoAssinaturaEnum.PRIMEIRA_ASSINATURA.equals(requisicao.getClassificacao())
					&& !requisicao.getAssinatura().equals(ClassificacaoAssinaturaEnum.ASSINATURA_FINAL.getValue())) {

				InputStream input = getClass().getClassLoader().getResourceAsStream(BASE_PATH_JSON + PATH + "/V2/200.json");
				resposta = IOUtils.toString(input, StandardCharsets.UTF_8);
			} 
			else if ((ClassificacaoAssinaturaEnum.PRIMEIRA_ASSINATURA.equals(requisicao.getClassificacao())
					|| ClassificacaoAssinaturaEnum.ASSINATURA_INTERMEDIARIA.equals(requisicao.getClassificacao()))
					&& requisicao.getAssinatura().equals(ClassificacaoAssinaturaEnum.ASSINATURA_FINAL.getValue())) {

				InputStream input = getClass().getClassLoader().getResourceAsStream(BASE_PATH_JSON + PATH + "/V2/200_assinatura_final.json");
				resposta = IOUtils.toString(input, StandardCharsets.UTF_8);
			} 
			else if (ClassificacaoAssinaturaEnum.ASSINATURA_INTERMEDIARIA.equals(requisicao.getClassificacao())
					&& !requisicao.getAssinatura().equals(ClassificacaoAssinaturaEnum.ASSINATURA_FINAL.getValue())) {

				InputStream input = getClass().getClassLoader().getResourceAsStream(BASE_PATH_JSON + PATH + "/V2/200_assinatura_intermediaria.json");
				resposta = IOUtils.toString(input, StandardCharsets.UTF_8);
			}

			resposta = resposta.replace("{DATA_TRANSACAO}", DataUtil.getDataFormatada(new Date(), DataUtil.FORMATO_DATA_XML));
			resposta = resposta.replace("{TOKEN}", requisicao.getToken());

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
