package br.gov.caixa.simtx.simulador.services.qrcode.consulta;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;

import org.apache.log4j.Logger;

import br.gov.caixa.simtx.simulador.services.controle.Controle;
import br.gov.caixa.simtx.simulador.util.data.DataUtil;

@Path("/sispi-qrcode-war/api")
@Consumes("application/json")
@Produces("application/json")
public class ConsultaQRCodeControle extends Controle {

	private static final Logger logger = Logger.getLogger(ConsultaQRCodeControle.class);

	private static final String PATH = "qrcode";


	@GET
	@Path("/v1/qrcode/{txid}")
	public Response validarServico(@Context HttpServletRequest httpRequest, @PathParam("txid") String txid) {
		try {
			logger.info("[SIMULADOR] Mensagem recebida: "+ txid);
			String resposta = recuperarJson(BASE_PATH_JSON + PATH + "/V1/200.json");
			resposta = resposta.replace("{DATAHORA}", DataUtil.getDataFormatada(new Date(), DataUtil.FORMATO_DATA_PADRAO_BR_HORA));
			return Response.ok().entity(resposta).build();
		} 
		catch (Exception e) {
			logger.error(e);
			return Response.status(Response.Status.FORBIDDEN)
					.entity(montarMsgErro(BASE_PATH_JSON + PATH + "/V1/403.json", e.getMessage())).build();
		}
	}
	
	
	
	
}
