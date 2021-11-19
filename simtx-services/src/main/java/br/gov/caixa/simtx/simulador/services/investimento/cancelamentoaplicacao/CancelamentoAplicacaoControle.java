package br.gov.caixa.simtx.simulador.services.investimento.cancelamentoaplicacao;

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

@Path("/sibar/investimentos/resgate/fundos")
@Consumes("application/json")
@Produces("application/json")
public class CancelamentoAplicacaoControle extends Controle {

	private static final Logger logger = Logger.getLogger(CancelamentoAplicacaoControle.class);
	
	private static final String PATH = "fundo_investimentos/cancelamento_aplicacao";

	@POST
	@Path("/v1/contas/{id_conta}/aplicacoes/cancelar")
	public Response validarServico(@Context HttpServletRequest httpRequest, @PathParam("id_conta") String idConta, String json) {
		try {
			RequisicaoCancelamentoAplicacao requisicao = gson.fromJson(json, RequisicaoCancelamentoAplicacao.class);
			validarAtributosCampos(requisicao);
			
			String resposta = "";

			InputStream input = getClass().getClassLoader().getResourceAsStream(BASE_PATH_JSON + PATH + "/V1/200.json");
			resposta = IOUtils.toString(input, StandardCharsets.UTF_8);
			
			resposta = resposta.replace("{DATA_TRANSACAO}", DataUtil.getDataFormatada(new Date(), DataUtil.FORMATO_DATA_XML));

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
