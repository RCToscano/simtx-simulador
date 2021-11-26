//package br.gov.caixa.simtx.simulador.testes;
//
//import java.security.KeyManagementException;
//import java.security.NoSuchAlgorithmException;
//import java.security.cert.CertificateException;
//
//import javax.net.ssl.HostnameVerifier;
//import javax.net.ssl.HttpsURLConnection;
//import javax.net.ssl.SSLContext;
//import javax.net.ssl.SSLSession;
//import javax.net.ssl.TrustManager;
//import javax.net.ssl.X509TrustManager;
//import javax.security.cert.X509Certificate;
//import javax.xml.soap.MessageFactory;
//import javax.xml.soap.MimeHeaders;
//import javax.xml.soap.SOAPBody;
//import javax.xml.soap.SOAPConnection;
//import javax.xml.soap.SOAPConnectionFactory;
//import javax.xml.soap.SOAPElement;
//import javax.xml.soap.SOAPEnvelope;
//import javax.xml.soap.SOAPException;
//import javax.xml.soap.SOAPMessage;
//import javax.xml.soap.SOAPPart;
//
//public class ConsultaSituacaoWs {
//
//	public static void main(String args[]) {
//		/*
//		 * The example below requests from the Web Service at:
//		 * http://www.webservicex.net/uszip.asmx?op=GetInfoByCity
//		 * 
//		 * 
//		 * To call other WS, change the parameters below, which are: - the SOAP Endpoint
//		 * URL (that is, where the service is responding from) - the SOAP Action
//		 * 
//		 * Also change the contents of the method createSoapEnvelope() in this class. It
//		 * constructs the inner part of the SOAP envelope that is actually sent.
//		 */
//		String soapEndpointUrl = "https://cicsweb.des.caixa:2587/siatr/limite/valida";
//		String soapAction = "valida";
//
//		callSoapWebService(soapEndpointUrl, soapAction);
//	}
//
//	private static void createSoapEnvelope(SOAPMessage soapMessage) throws SOAPException {
//		SOAPPart soapPart = soapMessage.getSOAPPart();
//
//		String myNamespace = "req";
//		String myNamespaceURI = "http://caixa.gov.br/siatr/limite/valida";
//
//		// SOAP Envelope
//		SOAPEnvelope envelope = soapPart.getEnvelope();
//		envelope.addNamespaceDeclaration(myNamespace, myNamespaceURI);
//
//		/*
//		 * Constructed SOAP Request Message: <SOAP-ENV:Envelope
//		 * xmlns:SOAP-ENV="http://schemas.xmlsoap.org/soap/envelope/"
//		 * xmlns:myNamespace="http://www.webserviceX.NET"> <SOAP-ENV:Header/>
//		 * <SOAP-ENV:Body> <myNamespace:GetInfoByCity> <myNamespace:USCity>New
//		 * York</myNamespace:USCity> </myNamespace:GetInfoByCity> </SOAP-ENV:Body>
//		 * </SOAP-ENV:Envelope>
//		 */
//
//		// SOAP Body
//		SOAPBody soapBody = envelope.getBody();
//		SOAPElement soapBodyElem = soapBody.addChildElement("valida", myNamespace);
//		SOAPElement soapBodyElem1 = soapBodyElem.addChildElement("ws_atrwsvcl");
//		SOAPElement soapBodyElem2 = soapBodyElem1.addChildElement("wsvcl_entrada");
//		
//		SOAPElement soapBodyElem3 = soapBodyElem2.addChildElement("wsvcl_e_versao");
//		soapBodyElem3.addTextNode("1");
//		
//		SOAPElement soapBodyElem4 = soapBodyElem2.addChildElement("wsvcl_e_tipo_solicitacao");
//		soapBodyElem4.addTextNode("5");
//		
//		SOAPElement soapBodyElem5 = soapBodyElem2.addChildElement("wsvcl_e_sigla_serv");
//		soapBodyElem5.addTextNode("PEG");
//		
//		SOAPElement soapBodyElem6 = soapBodyElem2.addChildElement("wsvcl_e_sg_canal_origem");
//		soapBodyElem6.addTextNode("SIIBC");
//		
//		SOAPElement soapBodyElem7 = soapBodyElem2.addChildElement("wsvcl_e_nu_nsu_mtx");
//		soapBodyElem7.addTextNode("2428");
//		
//		SOAPElement soapBodyElem8 = soapBodyElem2.addChildElement("wsvcl_e_agencia");
//		soapBodyElem8.addTextNode("1679");
//		
//		SOAPElement soapBodyElem9 = soapBodyElem2.addChildElement("wsvcl_e_produto");
//		soapBodyElem9.addTextNode("1");
//		
//		SOAPElement soapBodyElem10 = soapBodyElem2.addChildElement("wsvcl_e_conta");
//		soapBodyElem10.addTextNode("88501264");
//		
//		SOAPElement soapBodyElem11 = soapBodyElem2.addChildElement("wsvcl_e_dv_conta");
//		soapBodyElem11.addTextNode("3");
//		
//		SOAPElement soapBodyElem12 = soapBodyElem2.addChildElement("wsvcl_e_vr_transacao");
//		soapBodyElem12.addTextNode("10");
//		
//		SOAPElement soapBodyElem13 = soapBodyElem2.addChildElement("wsvcl_e_dt_transacao");
//		soapBodyElem13.addTextNode("20210831");
//		
//		SOAPElement soapBodyElem14 = soapBodyElem2.addChildElement("wsvcl_e_dt_movimento");
//		soapBodyElem14.addTextNode("20210831");
//		
//		SOAPElement soapBodyElem15 = soapBodyElem2.addChildElement("wsvcl_e_tp_autenticacao");
//		soapBodyElem15.addTextNode("1");
//		
//		SOAPElement soapBodyElem16 = soapBodyElem2.addChildElement("wsvcl_e_ic_agendamento");
//		soapBodyElem16.addTextNode("0");
//		
//	}
//
//	private static void callSoapWebService(String soapEndpointUrl, String soapAction) {
//		try {
//			// Create SOAP Connection
//			SOAPConnectionFactory soapConnectionFactory = SOAPConnectionFactory.newInstance();
//			SOAPConnection soapConnection = soapConnectionFactory.createConnection();
//
//			// Send SOAP Message to SOAP Server
//			SOAPMessage soapResponse = soapConnection.call(createSOAPRequest(soapAction), soapEndpointUrl);
//
//			// Print the SOAP Response
//			System.out.println("Response SOAP Message:");
//			soapResponse.writeTo(System.out);
//			System.out.println();
//
//			soapConnection.close();
//		} catch (Exception e) {
//			System.err.println(
//					"\nError occurred while sending SOAP Request to Server!\nMake sure you have the correct endpoint URL and SOAPAction!\n");
//			e.printStackTrace();
//		}
//	}
//
//	private static SOAPMessage createSOAPRequest(String soapAction) throws Exception {
//		certificadoInvalido();
//		MessageFactory messageFactory = MessageFactory.newInstance();
//		SOAPMessage soapMessage = messageFactory.createMessage();
//
//		createSoapEnvelope(soapMessage);
//		
//		String authorization = new sun.misc.BASE64Encoder().encode(("f965271:Caneta20").getBytes());
//
//		MimeHeaders headers = soapMessage.getMimeHeaders();
//		headers.addHeader("SOAPAction", soapAction);
//		headers.addHeader("Authorization", "Basic " + authorization);
//
//		soapMessage.saveChanges();
//
//		/* Print the request message, just for debugging purposes */
//		System.out.println("Request SOAP Message:");
//		soapMessage.writeTo(System.out);
//		System.out.println("\n");
//
//		return soapMessage;
//	}
//	
//	
//	@SuppressWarnings("unused")
//	public static void certificadoInvalido() {
//		try {
//			// Create a trust manager that does not validate certificate chains
//			TrustManager[] trustAllCerts = new TrustManager[] { new X509TrustManager() {
//				public java.security.cert.X509Certificate[] getAcceptedIssuers() {
//					return null;
//				}
//
//				public void checkClientTrusted(X509Certificate[] certs, String authType) {
//				}
//
//				public void checkServerTrusted(X509Certificate[] certs, String authType) {
//				}
//
//				@Override
//				public void checkClientTrusted(java.security.cert.X509Certificate[] arg0, String arg1)
//						throws CertificateException {
//					
//				}
//
//				@Override
//				public void checkServerTrusted(java.security.cert.X509Certificate[] arg0, String arg1)
//						throws CertificateException {
//					
//				}
//			}};
//
//			// Install the all-trusting trust manager
//			SSLContext sc = SSLContext.getInstance("SSL");
//			sc.init(null, trustAllCerts, new java.security.SecureRandom());
//			HttpsURLConnection.setDefaultSSLSocketFactory(sc.getSocketFactory());
//
//			// Create all-trusting host name verifier
//			HostnameVerifier allHostsValid = new HostnameVerifier() {
//				public boolean verify(String hostname, SSLSession session) {
//					return true;
//				}
//			};
//
//			// Install the all-trusting host verifier
//			HttpsURLConnection.setDefaultHostnameVerifier(allHostsValid);
//		} 
//		catch (NoSuchAlgorithmException | KeyManagementException e) {
//			//erro
//		}
//	}
//
//}
