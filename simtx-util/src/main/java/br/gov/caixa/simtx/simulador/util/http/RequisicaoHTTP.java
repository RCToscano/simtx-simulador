package br.gov.caixa.simtx.simulador.util.http;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.SocketTimeoutException;
import java.net.URL;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.X509Certificate;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;

import org.apache.commons.io.IOUtils;
import org.apache.http.HttpResponse;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.log4j.Logger;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientHandlerException;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;
import com.sun.jersey.api.json.JSONConfiguration;

import br.gov.caixa.simtx.simulador.util.exception.ControleException;

public class RequisicaoHTTP {
	
	private static final Logger logger = Logger.getLogger(RequisicaoHTTP.class);
	
	public static final String AUTHORIZATION = "Authorization";

	public static final String BEARER = "Bearer ";

	public static final String CONTENT_TYPE = "Content-Type";
	
	private static final String ERRO_TOKEN = "ERRO TOKEN";
	
	private static final String REQUEST = "Realizando request da url: ";

	private static final String REQUISICAO = "Requisicao: ";
	
	private static final String ERRO_ABRIR_CONEXAO = "Nao foi possivel abrir uma comunicacao com a API: ";
	
	private static final String FALHA_CONEXAO = "Falha na comunicacao com a API: ";
	
	private RequisicaoHTTP() {}
	
	public static RespostaHTTP realizarEnvioHttps(String uri, String dados, String metodo,
			PropriedadesHTTP... propriedadesHTTPs) throws ControleException {
		try {
			certificadoInvalido();
			
			URL url = new URL(uri);
			HttpsURLConnection connection = (HttpsURLConnection) url.openConnection();
			connection.setDoOutput(true);
			connection.setRequestMethod(metodo);
			connection.setRequestProperty("Content-Type", MediaType.APPLICATION_JSON);
			for (PropriedadesHTTP propriedadesHTTP : propriedadesHTTPs) {
				connection.setRequestProperty(propriedadesHTTP.getChave(), propriedadesHTTP.getValor());
			}
			connection.setConnectTimeout(10000);
			connection.setReadTimeout(60000);
			
			if (!dados.isEmpty()) {
				OutputStreamWriter out = new OutputStreamWriter(connection.getOutputStream());
				out.write(dados);
				out.close();
			}
			
			int status = connection.getResponseCode();
			if (status / 100 != 2) {
				return new RespostaHTTP(status, "");
			}
			else {
				return new RespostaHTTP(status, recebeMensagem(connection));
			}
		} 
		catch (Exception e) {
			logger.error(e);
			throw new ControleException(e.getMessage(), "ERRO REQUISICAO HTTP");
		} 
	}
	
	public static RespostaHTTP realizarEnvioHttpsSemCertificado(String uri, String dados, String metodo,
			PropriedadesHTTP... propriedadesHTTPs) throws ControleException {
		try {
			URL url = new URL(uri);
			HttpsURLConnection connection = (HttpsURLConnection) url.openConnection();
			connection.setDoOutput(true);
			connection.setRequestMethod(metodo);
			connection.setRequestProperty("Content-Type", MediaType.APPLICATION_JSON);
			for (PropriedadesHTTP propriedadesHTTP : propriedadesHTTPs) {
				connection.setRequestProperty(propriedadesHTTP.getChave(), propriedadesHTTP.getValor());
			}
			connection.setConnectTimeout(3000);
			connection.setReadTimeout(10000);
			
			if (!dados.isEmpty()) {
				OutputStreamWriter out = new OutputStreamWriter(connection.getOutputStream());
				out.write(dados);
				out.close();
			}
			
			int status = connection.getResponseCode();
			return new RespostaHTTP(status, recebeMensagem(connection));
		} 
		catch (Exception e) {
			logger.error(e);
			throw new ControleException(e.getMessage(), "ERRO REQUISICAO HTTP");
		} 
	}
	
	private static String recebeMensagem(HttpURLConnection connection) throws IOException {
		String retorno = "";
		
		InputStream in = connection.getInputStream();
		String encoding = connection.getContentEncoding();
		encoding = encoding == null ? "UTF-8" : encoding;
		retorno = IOUtils.toString(in, encoding);
		
//        try (BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()))) {
//			while ((retorno = reader.readLine()) != null) {
//				return retorno;
//			}
//		}
		System.out.println(retorno);
        return retorno;
	}
	
	public static ClientResponse requestPostApi(String uri, String token, String request, String meioEntrada, String antiFraude) {
		try {
			ClientConfig clientConfig = new DefaultClientConfig();
			((DefaultClientConfig) clientConfig).getFeatures().put(JSONConfiguration.FEATURE_POJO_MAPPING,
					Boolean.TRUE);

			Client client = Client.create(clientConfig);
			client.setConnectTimeout(3000);
			client.setReadTimeout(10000);
			WebResource webResource = client.resource(uri);

			return webResource.accept(MediaType.APPLICATION_JSON).type(MediaType.APPLICATION_JSON)
					.header("Authorization", "Bearer " + token)
					.header("meio-entrada", meioEntrada)
					.header("pagamentoSiaafDto", antiFraude)
					.post(ClientResponse.class, request);
		} 
		catch (Exception e) {
			logger.error(e);
			return null;
		}
	}
	
	public static ClientResponse requestPutApi(String uri, String token, String request) {
		try {
			ClientConfig clientConfig = new DefaultClientConfig();
			((DefaultClientConfig) clientConfig).getFeatures().put(JSONConfiguration.FEATURE_POJO_MAPPING,
					Boolean.TRUE);

			Client client = Client.create(clientConfig);
			client.setConnectTimeout(3000);
			client.setReadTimeout(10000);
			WebResource webResource = client.resource(uri);

			return webResource.accept(MediaType.APPLICATION_JSON).type(MediaType.APPLICATION_JSON)
					.header("Authorization", "Bearer " + token)
					.put(ClientResponse.class, request);
		} 
		catch (Exception e) {
			logger.error(e);
			return null;
		}
	}
	
	public static ClientResponse requestGetApi(String uri, String token, MultivaluedMap<String, String> parametros) {
		try {
			ClientConfig clientConfig = new DefaultClientConfig();
			((DefaultClientConfig) clientConfig).getFeatures().put(JSONConfiguration.FEATURE_POJO_MAPPING,
					Boolean.TRUE);

			Client client = Client.create(clientConfig);
			client.setConnectTimeout(1000);
			client.setReadTimeout(5000);
			WebResource webResource = client.resource(uri);

			return webResource.queryParams(parametros).accept(MediaType.APPLICATION_JSON)
					.type(MediaType.APPLICATION_JSON).header("Authorization", "Bearer " + token)
					.get(ClientResponse.class);
		} 
		catch (ClientHandlerException e) {
			if (e.getCause() instanceof SocketTimeoutException) {
				logger.error("Nao foi possivel se comunicar com a API: " + uri, e);
				return null;
		    }
			else {
				throw e;
			}		    
		}
		catch (Exception e) {
			logger.error("Ocorreu um erro na execucao da API: " + uri, e);
			return null;
		}
	}
	
	public static HttpResponse requestGet(String uri, String token, int timeout, PropriedadesHTTP... propriedadesHTTPs)
			throws ControleException {
		try {
			logger.info(REQUEST + uri);

			ConnectionsPool connectionsPool = new ConnectionsPool();
			CloseableHttpClient httpClient = HttpClients.createDefault();

			HttpGet httpGet = new HttpGet(uri);
			httpGet.addHeader("Content-Type", MediaType.APPLICATION_JSON);
			httpGet.addHeader("Authorization", BEARER + token);
			for (PropriedadesHTTP propriedadesHTTP : propriedadesHTTPs) {
				httpGet.addHeader(propriedadesHTTP.getChave(), propriedadesHTTP.getValor());
			}

			RequestConfig requestConfig = RequestConfig.custom()
					.setConnectTimeout(1000)
					.setSocketTimeout(timeout * 10)
					.build();
			httpGet.setConfig(requestConfig);
			return httpClient.execute(httpGet);
		} 
		catch (SocketTimeoutException e) {
			logger.error(ERRO_ABRIR_CONEXAO + uri, e);
			return null;
		} 
		catch (IOException e) {
			logger.error(FALHA_CONEXAO + uri, e);
			throw new ControleException(e.getMessage(), FALHA_CONEXAO);
		} 
		catch (Exception e) {
			logger.error(e);
			throw new ControleException(e.getMessage(), "ERRO REQUISICAO HTTP");
		}
	}
	
	public static TokenServicoSaida gerarToken(TipoGeracaoToken tipoGeracao, String clientId, String clientSecret) throws ControleException {
		try {
			String uri = "https://logindes.caixa.gov.br/auth/realms/internet/protocol/openid-connect/token";

			StringBuilder builder = new StringBuilder();

			builder.append("grant_type=").append(tipoGeracao.getParamBody());
			builder.append("&client_id=").append(clientId);
			builder.append("&client_secret=").append(clientSecret);

			ClientResponse resposta = gerarToken(uri, builder.toString());

			if (resposta == null) {
				logger.warn("Sem resposta da API na Geracao do Token de Servico");
				throw new ControleException("Sem resposta da API na Geracao do Token de Servico", ERRO_TOKEN);
			} 
			else if (resposta.getStatus() != 200) {
				logger.warn("Geracao do Token de Servico executado com erro[" + resposta.getStatus() + "]");
				throw new ControleException("Geracao do Token de Servico executado com erro[" + resposta.getStatus() + "]", ERRO_TOKEN);
			} 
			else {
				String dadosSaida = resposta.getEntity(String.class);
				return new ObjectMapper().readerFor(TokenServicoSaida.class).readValue(dadosSaida);
			}
		} 
		catch (Exception e) {
			logger.error(e);
			throw new ControleException(e.getMessage(), ERRO_TOKEN);
		}
	}
	
	private static ClientResponse gerarToken(String uri, String dadosEntrada) {
		try {
			ClientConfig clientConfig = new DefaultClientConfig();
			((DefaultClientConfig) clientConfig).getFeatures().put(JSONConfiguration.FEATURE_POJO_MAPPING,
					Boolean.TRUE);

			Client client = Client.create(clientConfig);
			client.setConnectTimeout(5000);
			client.setReadTimeout(5000);
			WebResource webResource = client.resource(uri);
			
			return webResource.header("Content-Type", "application/x-www-form-urlencoded").post(ClientResponse.class,
					dadosEntrada);
		} 
		catch (Exception e) {
			logger.error(e);
			return null;
		}
	}
	
	private static void certificadoInvalido() {
		try {
			// Create a trust manager that does not validate certificate chains
			TrustManager[] trustAllCerts = new TrustManager[] { new X509TrustManager() {
				public java.security.cert.X509Certificate[] getAcceptedIssuers() {
					return null;
				}

				public void checkClientTrusted(X509Certificate[] certs, String authType) {
				}

				public void checkServerTrusted(X509Certificate[] certs, String authType) {
				}
			}};

			// Install the all-trusting trust manager
			SSLContext sc = SSLContext.getInstance("SSL");
			sc.init(null, trustAllCerts, new java.security.SecureRandom());
			HttpsURLConnection.setDefaultSSLSocketFactory(sc.getSocketFactory());

			// Create all-trusting host name verifier
			HostnameVerifier allHostsValid = new HostnameVerifier() {
				public boolean verify(String hostname, SSLSession session) {
					return true;
				}
			};

			// Install the all-trusting host verifier
			HttpsURLConnection.setDefaultHostnameVerifier(allHostsValid);
		} 
		catch (NoSuchAlgorithmException | KeyManagementException e) {
			System.out.println(e);
		}
	}

}
