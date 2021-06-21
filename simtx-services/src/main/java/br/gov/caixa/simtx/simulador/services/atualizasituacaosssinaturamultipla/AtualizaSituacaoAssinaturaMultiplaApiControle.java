package br.gov.caixa.simtx.simulador.services.atualizasituacaosssinaturamultipla;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.Consumes;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;

import org.apache.log4j.Logger;

import br.gov.caixa.simtx.simulador.services.controle.Controle;
import br.gov.caixa.simtx.simulador.util.exception.ControleException;

@Path("sibar/contas/assinaturas-eletronicas/v1")
@Consumes("application/json")
@Produces("application/json")
public class AtualizaSituacaoAssinaturaMultiplaApiControle extends Controle {
	
	private static final Logger logger = Logger.getLogger(AtualizaSituacaoAssinaturaMultiplaApiControle.class);
	
	@PUT
	@Path("/assinatura-multipla/{id_conta}/transacoes-pendentes/{nsu_siper}")
	public Response validarServico(@Context HttpServletRequest httpRequest, @PathParam("id_conta") String idConta, @PathParam("nsu_siper") Integer nsuSiper, String json) {
		try {
			RequisicaoAtualizaSituacaoAssinatuaMultiplaApiV1 requisicao = gson.fromJson(json, RequisicaoAtualizaSituacaoAssinatuaMultiplaApiV1.class);
			requisicao.setNsuSiper(nsuSiper);
			requisicao.setIdConta(idConta);
			
			logger.info("[SIMULADOR] Mensagem recebida: "+ gson.toJson(requisicao));
			validarAtributosCampos(requisicao);
			return Response.ok().header("Content-Type", "application/json; charset=utf-8").build();
		} 
		catch (ControleException e) {
			logger.error(e.getMensagem());
			return Response.status(Response.Status.BAD_REQUEST).entity("{\"negocial\":[{\"origem\":\"string\",\"codigo\":\"strin\",\"mensagem\":\"string\"}],\"integracao\":{\"codigo\":\"strin\",\"mensagem\":\"string\",\"excecao\":{}}}").build();
		} 
		catch (Exception e) {
			logger.error(e);
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
		}
	}
	
	

}
