package br.gov.caixa.simtx.simulador.services.pagamentospi;

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

@Path("/")
@Consumes("application/json")
@Produces("application/json")
public class AtualizacaoSPIControle extends Controle {

	private static final Logger logger = Logger.getLogger(AtualizacaoSPIControle.class);
	
	@PUT
	@Path("/v1/pagamentos/{nsuTransacao}")
	public Response validarServicoV1(@Context HttpServletRequest httpRequest, @PathParam("nsuTransacao") Long nsuTransacao, String json) {
		try {
			logger.info(nsuTransacao);
			logger.info(json);
			
			RequisicaoAtualizacao requisicao = mapper.readerFor(RequisicaoAtualizacao.class).readValue(json);
			validarAtributosCampos(requisicao);
			
			return Response.ok().header("Content-Type", "application/json; charset=utf-8").build();
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
	
	@PUT
	@Path("/v2/pagamentos/{nsuTransacao}")
	public Response validarServicoV2(@Context HttpServletRequest httpRequest, @PathParam("nsuTransacao") Long nsuTransacao, String json) {
		try {
			logger.info(nsuTransacao);
			logger.info(json);
			
			RequisicaoAtualizacao requisicao = mapper.readerFor(RequisicaoAtualizacao.class).readValue(json);
			validarAtributosCampos(requisicao);
			
			return Response.ok().header("Content-Type", "application/json; charset=utf-8").build();
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
