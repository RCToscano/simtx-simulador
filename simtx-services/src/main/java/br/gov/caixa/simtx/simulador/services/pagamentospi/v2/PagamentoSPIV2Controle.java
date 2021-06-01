package br.gov.caixa.simtx.simulador.services.pagamentospi.v2;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.ejb.Asynchronous;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.apache.log4j.Logger;

import br.gov.caixa.simtx.simulador.services.controle.Controle;
import br.gov.caixa.simtx.simulador.services.pagamentospi.Calendario;
import br.gov.caixa.simtx.simulador.services.pagamentospi.Devedor;
import br.gov.caixa.simtx.simulador.services.pagamentospi.InfoAdicionais;
import br.gov.caixa.simtx.simulador.services.pagamentospi.Qrcode;
import br.gov.caixa.simtx.simulador.services.pagamentospi.Recebedor;
import br.gov.caixa.simtx.simulador.services.pagamentospi.RequisicaoAtualizacao;
import br.gov.caixa.simtx.simulador.services.pagamentospi.SituacaoPagamentoSPIEnum;
import br.gov.caixa.simtx.simulador.services.pagamentospi.Valor;
import br.gov.caixa.simtx.simulador.util.data.DataUtil;
import br.gov.caixa.simtx.simulador.util.exception.ControleException;
import br.gov.caixa.simtx.simulador.util.jwt.JWTUtil;

@Path("/sispi-api-war/api")
@Consumes("application/json")
@Produces("application/json")
public class PagamentoSPIV2Controle extends Controle {

	private static final Logger logger = Logger.getLogger(PagamentoSPIV2Controle.class);
	
	private static final String PATH = "pix/pagamento";
	
	private static final String PACOTE = "/pagamentos-instantaneos";
	
	private static final String PACOTE_AGENDAMENTO = "/pagamento-instantaneo-api";
	
	private RequisicaoPagamentoSpiV2 requisicao;
	
	private String token;
	
	private String uri;

	@POST
	@Path("/v2/ordens-pagamento")
	public Response validarServico(@Context HttpServletRequest httpRequest, String json) {
		try {
			requisicao = mapper.readerFor(RequisicaoPagamentoSpiV2.class).readValue(json);
			validarAtributosCampos(requisicao);

			token = httpRequest.getHeader(JWTUtil.TOKEN_HEADER);
			uri = httpRequest.getRequestURL().toString();
			
			new Thread(new Runnable() {
			    public void run() {
			    	if(requisicao.getTipoPrioridadePagamento().equals(TipoPrioridadePagamentoEnum.PAGAGD)) {
			    		executarAgendamentoV1();
			    	}
			    	else {
			    		executarAtualizaV2();
			    	}
			    }
			}).start();

			return Response.status(Status.CREATED).header("Content-Type", "application/json; charset=utf-8").build();
		} 
		catch (ControleException e) {
			logger.error(e.getMensagem());
			String msg = montarMsgErro(BASE_PATH_JSON + PATH + "/V2/400.json", e.getMensagem());
			msg = msg.replace("{DATAHORA}",
					DataUtil.getDataFormatada(new Date(), DataUtil.FORMATO_DATA_YYYY_MM_DD_HIFEN_JSON));
			return Response.status(Response.Status.BAD_REQUEST).entity(msg).build();
		} 
		catch (Exception e) {
			logger.error(SIMULADOR_ERRO, e);
			String msg = montarMsgErro(BASE_PATH_JSON + PATH + "/V2/500.json", e.getMessage());
			msg = msg.replace("{DATAHORA}",
					DataUtil.getDataFormatada(new Date(), DataUtil.FORMATO_DATA_YYYY_MM_DD_HIFEN_JSON));
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(msg).build();
		}
	}

	public void executarAgendamentoV1() {
		try {
			Thread.sleep(5000);
			logger.info("[SIMULADOR] Executando Atualiza Agendamento Pagamento Instantaneo V1");
			RequisicaoAtualizacao atualizacao = new RequisicaoAtualizacao();
			atualizacao.setDataTransacao(DataUtil.getDataFormatada(new Date(), DataUtil.FORMATO_DATA_XML));
			atualizacao.setDataHora(DataUtil.getDataFormatada(new Date(), DataUtil.FORMATO_DATA_YYYY_MM_DD_HIFEN_JSON));
			atualizacao.setIdFimAFim(requisicao.getIdFimAFim());
			
			if (requisicao.getInformacoesEntreUsuarios() == null || requisicao.getInformacoesEntreUsuarios() != null
					&& requisicao.getInformacoesEntreUsuarios().contains("ACSC")) {
				atualizacao.setSituacaoDaTransacao(SituacaoPagamentoSPIEnum.ACSC);
				atualizacao.setDataContabil(DataUtil.getDataFormatada(new Date(), DataUtil.FORMATO_DATA_YYYY_MM_DD_HIFEN_JSON));
				atualizacao.setDataHoraLiquidacao(DataUtil.getDataFormatada(new Date(), DataUtil.FORMATO_DATA_YYYY_MM_DD_HIFEN_JSON));
				
				Valor valor = new Valor(requisicao.getValor().toString(), "0", "0", "0", "0",
						requisicao.getValor().toString());
				
				Recebedor recebedor = null;
				if(requisicao.getUsuarioRecebedor().getCnpj() != null) {
					recebedor = new Recebedor(requisicao.getUsuarioRecebedor().getCpf().toString(),
							requisicao.getUsuarioRecebedor().getCnpj().toString(),
							requisicao.getUsuarioRecebedor().getNome(),
							requisicao.getUsuarioRecebedor().getNome() + " FANTASIA", "LOGR", "SAO PAULO", "SP",
							"99999999");
				}
				else {
					recebedor = new Recebedor(requisicao.getUsuarioRecebedor().getCpf().toString(),
							requisicao.getUsuarioRecebedor().getNome(), "LOGR", "SAO PAULO", "SP", "99999999");
				}
				
				Devedor devedor = null;
				if (requisicao.getUsuarioPagador().getCnpj() != null) {
					devedor = new Devedor(requisicao.getUsuarioPagador().getCpf().toString(),
							requisicao.getUsuarioPagador().getCnpj().toString(),
							requisicao.getUsuarioPagador().getNome());
				} 
				else {
					devedor = new Devedor(requisicao.getUsuarioPagador().getCpf().toString(),
							requisicao.getUsuarioPagador().getNome());
				}
				
				Calendario calendario = new Calendario("Y", "X", 9L, DataUtil.getDataFormatada(new Date(), DataUtil.FORMATO_DATA_XML), 9L);
				
				InfoAdicionais infoAdicionais1 = new InfoAdicionais(requisicao.getUsuarioPagador().getNome(), "DESC1");
				InfoAdicionais infoAdicionais2 = new InfoAdicionais(requisicao.getUsuarioRecebedor().getNome(), "DESC2");
				List<InfoAdicionais> infoAdicionais = new ArrayList<>();
				infoAdicionais.add(infoAdicionais1);
				infoAdicionais.add(infoAdicionais2);

				Qrcode qrCode = new Qrcode();
				qrCode.setRevisao(99l);
				qrCode.setChave(requisicao.getUsuarioPagador().getCpf().toString() + requisicao.getIdFimAFim());
				qrCode.setSolicitacaoPagador("S");
				qrCode.setTxid(requisicao.getTxId());
				qrCode.setCalendario(calendario);
				qrCode.setDevedor(devedor);
				qrCode.setRecebedor(recebedor);
				qrCode.setValor(valor);
				qrCode.setInfoAdicionais(infoAdicionais);
				atualizacao.setQrCode(qrCode);
				
			} 
			else if (requisicao.getInformacoesEntreUsuarios() != null
					&& requisicao.getInformacoesEntreUsuarios().contains("HOLD")) {
				atualizacao.setSituacaoDaTransacao(SituacaoPagamentoSPIEnum.HOLD);
			} 
			else {
				atualizacao.setSituacaoDaTransacao(SituacaoPagamentoSPIEnum.RJCT);
				atualizacao.setCodigoDeErro("99RJCT");
				atualizacao.setDetalhamentoDoErro("Rejeitado pelo simulador");
			}
			
			String[] url = uri.split("/");
			uri = url[0].concat("//").concat(url[2]).concat(PACOTE_AGENDAMENTO + "/v1/agendamentos/").concat(requisicao.getNsu().toString());
			
			requisicaoHttpHttps(uri, "PUT", token, gson.toJson(atualizacao));
			
		} 
		catch (InterruptedException e) {
			logger.error(SIMULADOR_ERRO, e);
			Thread.currentThread().interrupt();
		}
		catch (Exception e) {
			logger.error(SIMULADOR_ERRO, e);
		}
	}
	
	@Asynchronous
	public void executarAtualizaV2() {
		try {
			Thread.sleep(5000);
			logger.info("[SIMULADOR] Executando Atualiza Pagamento Instantaneo V3");
			RequisicaoAtualizacao atualizacao = new RequisicaoAtualizacao();
			atualizacao.setDataTransacao(DataUtil.getDataFormatada(new Date(), DataUtil.FORMATO_DATA_XML));
			atualizacao.setDataHora(DataUtil.getDataFormatada(new Date(), DataUtil.FORMATO_DATA_YYYY_MM_DD_HIFEN_JSON));
			atualizacao.setIdFimAFim(requisicao.getIdFimAFim());
			
			if (requisicao.getInformacoesEntreUsuarios() == null || requisicao.getInformacoesEntreUsuarios() != null
					&& requisicao.getInformacoesEntreUsuarios().contains("ACSC")) {
				atualizacao.setSituacaoDaTransacao(SituacaoPagamentoSPIEnum.ACSC);
				atualizacao.setDataContabil(DataUtil.getDataFormatada(new Date(), DataUtil.FORMATO_DATA_YYYY_MM_DD_HIFEN_JSON));
				atualizacao.setDataHoraLiquidacao(DataUtil.getDataFormatada(new Date(), DataUtil.FORMATO_DATA_YYYY_MM_DD_HIFEN_JSON));
				
				Valor valor = new Valor(requisicao.getValor().toString(), "0", "0", "0", "0",
						requisicao.getValor().toString());
				
				Recebedor recebedor = null;
				if(requisicao.getUsuarioRecebedor().getCnpj() != null) {
					recebedor = new Recebedor(requisicao.getUsuarioRecebedor().getCpf().toString(),
							requisicao.getUsuarioRecebedor().getCnpj().toString(),
							requisicao.getUsuarioRecebedor().getNome(),
							requisicao.getUsuarioRecebedor().getNome() + " FANTASIA", "LOGR", "SAO PAULO", "SP",
							"99999999");
				}
				else {
					recebedor = new Recebedor(requisicao.getUsuarioRecebedor().getCpf().toString(),
							requisicao.getUsuarioRecebedor().getNome(), "LOGR", "SAO PAULO", "SP", "99999999");
				}
				
				Devedor devedor = null;
				if (requisicao.getUsuarioPagador().getCnpj() != null) {
					devedor = new Devedor(requisicao.getUsuarioPagador().getCpf().toString(),
							requisicao.getUsuarioPagador().getCnpj().toString(),
							requisicao.getUsuarioPagador().getNome());
				} 
				else {
					devedor = new Devedor(requisicao.getUsuarioPagador().getCpf().toString(),
							requisicao.getUsuarioPagador().getNome());
				}
				
				Calendario calendario = new Calendario("Y", "X", 9L, DataUtil.getDataFormatada(new Date(), DataUtil.FORMATO_DATA_XML), 9L);
				
				InfoAdicionais infoAdicionais1 = new InfoAdicionais(requisicao.getUsuarioPagador().getNome(), "DESC1");
				InfoAdicionais infoAdicionais2 = new InfoAdicionais(requisicao.getUsuarioRecebedor().getNome(), "DESC2");
				List<InfoAdicionais> infoAdicionais = new ArrayList<>();
				infoAdicionais.add(infoAdicionais1);
				infoAdicionais.add(infoAdicionais2);

				Qrcode qrCode = new Qrcode();
				qrCode.setRevisao(99l);
				qrCode.setChave(requisicao.getUsuarioPagador().getCpf().toString() + requisicao.getIdFimAFim());
				qrCode.setSolicitacaoPagador("S");
				qrCode.setTxid(requisicao.getTxId());
				qrCode.setCalendario(calendario);
				qrCode.setDevedor(devedor);
				qrCode.setRecebedor(recebedor);
				qrCode.setValor(valor);
				qrCode.setInfoAdicionais(infoAdicionais);
				atualizacao.setQrCode(qrCode);
				
			} 
			else if (requisicao.getInformacoesEntreUsuarios() != null
					&& requisicao.getInformacoesEntreUsuarios().contains("HOLD")) {
				atualizacao.setSituacaoDaTransacao(SituacaoPagamentoSPIEnum.HOLD);
			} 
			else {
				atualizacao.setSituacaoDaTransacao(SituacaoPagamentoSPIEnum.RJCT);
				atualizacao.setCodigoDeErro("99RJCT");
				atualizacao.setDetalhamentoDoErro("Rejeitado pelo simulador");
			}
			
			String[] url = uri.split("/");
			uri = url[0].concat("//").concat(url[2]).concat(PACOTE + "/v3/pagamentos/").concat(requisicao.getNsu().toString());
			
			requisicaoHttpHttps(uri, "PUT", token, gson.toJson(atualizacao));
			
		} 
		catch (InterruptedException e) {
			logger.error(SIMULADOR_ERRO, e);
			Thread.currentThread().interrupt();
		}
		catch (Exception e) {
			logger.error(SIMULADOR_ERRO, e);
		}
	}
	
	
	
}
