package br.gov.caixa.simtx.simulador.services.siatr.valida;

import javax.jws.WebService;

import org.apache.log4j.Logger;

import br.gov.caixa.simtx.simulador.services.siatr.valida.req.WsAtrwsvclReq;
import br.gov.caixa.simtx.simulador.services.siatr.valida.resp.WsAtrwsvclResp;



@WebService(
          serviceName = "ValidaConta",
          targetNamespace = "http://caixa.gov.br/siatr/limite/valida",
          endpointInterface = "br.gov.caixa.simtx.simulador.services.siatr.valida.ValidaContaSIATRService")
public class ValidaContaSIATR implements ValidaContaSIATRService {

    private static final Logger logger = Logger.getLogger(ValidaContaSIATR.class);

    public WsAtrwsvclResp valida(WsAtrwsvclReq parameters) { 
    	logger.info("Executando valida");
        
        try {
        	WsAtrwsvclResp resposta = new WsAtrwsvclResp();
            return resposta;
        
        } 
        catch (Exception ex) {
            ex.printStackTrace();
            throw new RuntimeException(ex);
        }
    }

}

