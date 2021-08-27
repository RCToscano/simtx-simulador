package br.gov.caixa.simtx.simulador.services.openbaking;

import java.util.Date;

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
import br.gov.caixa.simtx.simulador.util.data.DataUtil;
import br.gov.caixa.simtx.simulador.util.exception.ControleException;
import br.gov.caixa.simtx.simulador.util.jwt.JWTUtil;


@Path("/open-banking/gestao-pagamentos")
@Consumes("application/json")
@Produces("application/json")
public class AtrualizaPixOpenBankingControle extends Controle {
	
	
	private static final Logger logger = Logger.getLogger(AtrualizaPixOpenBankingControle.class);
	
	private static final String PATH = "openbanking/atualiza";
	
	@PUT
	@Path("/v1/pix/{endToEndId}")
	public Response atualizar(@Context HttpServletRequest httpRequest, @PathParam("endToEndId") String endToEndId,String json) {
		try {
			RequisicaoAtualizacaoPixOpenBanking requisicao = mapper.readerFor(RequisicaoAtualizacaoPixOpenBanking.class).readValue(json);
			requisicao.setEndToEndId(endToEndId);
			validarAtributosCampos(requisicao);

			String token = httpRequest.getHeader(JWTUtil.TOKEN_HEADER);
			String uri = httpRequest.getRequestURL().toString();
			
			if(requisicao.getRejectionReason().equals("200")) {
				String msg = recuperarJson(BASE_PATH_JSON + PATH + "/v1/200.json");
				return Response.status(Response.Status.OK).entity(msg).build();
			}else {
				String msg = recuperarJson(BASE_PATH_JSON + PATH + "/v1/erro.json");
				return Response.status(Integer.parseInt(requisicao.getRejectionReason())).entity(msg).build();
			}
			
		} 
		catch (ControleException e) {
			logger.error(e.getMensagem());
			String msg = montarMsgErro(BASE_PATH_JSON + PATH + "/V1/erro.json", e.getMensagem());
			return Response.status(Response.Status.BAD_REQUEST).entity(msg).build();
		} 
		catch (Exception e) {
			logger.error(SIMULADOR_ERRO, e);
			String msg = montarMsgErro(BASE_PATH_JSON + PATH + "/V1/erro.json", e.getMessage());
			msg = msg.replace("{DATAHORA}",
					DataUtil.getDataFormatada(new Date(), DataUtil.FORMATO_DATA_YYYY_MM_DD_HIFEN_JSON));
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(msg).build();
		}
	}


}
