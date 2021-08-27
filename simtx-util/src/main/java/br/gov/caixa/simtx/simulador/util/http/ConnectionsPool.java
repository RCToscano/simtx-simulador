package br.gov.caixa.simtx.simulador.util.http;

import javax.net.ssl.SSLSocketFactory;

import org.apache.http.HeaderElement;
import org.apache.http.HeaderElementIterator;
import org.apache.http.HttpHost;
import org.apache.http.HttpResponse;
import org.apache.http.config.Registry;
import org.apache.http.config.RegistryBuilder;
import org.apache.http.conn.ConnectionKeepAliveStrategy;
import org.apache.http.conn.SchemePortResolver;
import org.apache.http.conn.UnsupportedSchemeException;
import org.apache.http.conn.socket.ConnectionSocketFactory;
import org.apache.http.conn.socket.PlainConnectionSocketFactory;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.apache.http.message.BasicHeaderElementIterator;
import org.apache.http.protocol.HTTP;
import org.apache.http.protocol.HttpContext;
import org.apache.log4j.Logger;


public class ConnectionsPool {

	private static final Logger logger = Logger.getLogger(ConnectionsPool.class);

	public static final int TOTAL_RETRIES = 1;

	private CloseableHttpClient clientPool;

	private PoolingHttpClientConnectionManager cm;


	public CloseableHttpClient getClientPool() {
		if (clientPool == null) {
			clientPool = getClientApache();
		}
		cm.closeExpiredConnections();
		return clientPool;
	}

	private CloseableHttpClient getClientApache() {
		logger.info("Criando Pool de conexoes");
		int porta = 8443;

		Registry<ConnectionSocketFactory> socketFactoryRegistry = RegistryBuilder.<ConnectionSocketFactory>create()
				.register("https", getSSLConnectionSocketFactory())
				.register("http", PlainConnectionSocketFactory.getSocketFactory()).build();
		cm = new PoolingHttpClientConnectionManager(socketFactoryRegistry);
		CloseableHttpClient httpClient = getCloseableHttpClient(cm, porta);

		cm.setMaxTotal(10);
		cm.setDefaultMaxPerRoute(5);
		return httpClient;
	}

	private CloseableHttpClient getCloseableHttpClient(PoolingHttpClientConnectionManager cm, final int porta) {
		return HttpClients.custom().setConnectionManager(cm).setKeepAliveStrategy(getStrategy())
				.setSchemePortResolver(new SchemePortResolver() {
					public int resolve(HttpHost host) throws UnsupportedSchemeException {
						return porta;
					}
				}).build();
	}

	private SSLConnectionSocketFactory getSSLConnectionSocketFactory() {
		SSLSocketFactory sslsocketfactory = (SSLSocketFactory) SSLSocketFactory.getDefault();
		return new SSLConnectionSocketFactory(sslsocketfactory,
				SSLConnectionSocketFactory.getDefaultHostnameVerifier());
	}

	private ConnectionKeepAliveStrategy getStrategy() {
		return new ConnectionKeepAliveStrategy() {
			public long getKeepAliveDuration(HttpResponse response, HttpContext context) {
				HeaderElementIterator it = new BasicHeaderElementIterator(
						response.headerIterator(HTTP.CONN_KEEP_ALIVE));
				while (it.hasNext()) {
					HeaderElement he = it.nextElement();
					String param = he.getName();
					String value = he.getValue();
					if (value != null && param.equalsIgnoreCase("timeout")) {
						return Long.parseLong(value) * 1000;
					}
				}
				return 300 * 1000; // 5 min
			}
		};
	}

}
