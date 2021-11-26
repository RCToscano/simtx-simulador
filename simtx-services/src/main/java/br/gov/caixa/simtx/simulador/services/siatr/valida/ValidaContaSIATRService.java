package br.gov.caixa.simtx.simulador.services.siatr.valida;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;

import br.gov.caixa.simtx.simulador.services.siatr.valida.req.WsAtrwsvclReq;
import br.gov.caixa.simtx.simulador.services.siatr.valida.resp.WsAtrwsvclResp;



@WebService
@SOAPBinding(parameterStyle = SOAPBinding.ParameterStyle.BARE)
public interface ValidaContaSIATRService {

    @WebMethod(action = "http://caixa.gov.br/siatr/limite/valida/req")
    @WebResult(name = "SERVICO_SAIDA", targetNamespace = "http://caixa.gov.br/siatr/limite/valida/resp", partName = "parameters")
    public WsAtrwsvclResp valida(
        @WebParam(partName = "parameters", name = "SERVICO_ENTRADA", targetNamespace = "http://caixa.gov.br/siatr/limite/valida/req")
        WsAtrwsvclReq parameters
    );
}

