package br.gov.caixa.simtx.simulador.services.assinatura.simples;

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

@Path("/sibar/contas/assinaturas-eletronicas")
@Consumes("application/json")
@Produces("application/json")
public class AssinaturaSimplesControleV2 extends Controle {

	private static final Logger logger = Logger.getLogger(AssinaturaSimplesControleV2.class);

	private static final String PATH = "assinatura_simples";


	@POST
	@Path("/v2/assinatura-simples/{cpf}/validar")
	public Response validarServico(@Context HttpServletRequest httpRequest, @PathParam("cpf") String cpf, String json) {
		try {
			RequisicaoAssinaturaSimplesV2 requisicao = gson.fromJson(json, RequisicaoAssinaturaSimplesV2.class);
			requisicao.setCpf(cpf);

			String resposta = simuladorGenerico(requisicao, PATH + "/V2");
			resposta = resposta.replace("{DATA_TRANSACAO}", DataUtil.getDataFormatada(new Date(), DataUtil.FORMATO_DATA_XML));
			resposta = resposta.replace("{TOKEN}", requisicao.getToken());

			return Response.ok().entity(resposta).build();
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
