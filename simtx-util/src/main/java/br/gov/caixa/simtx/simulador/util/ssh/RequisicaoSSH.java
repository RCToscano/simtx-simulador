package br.gov.caixa.simtx.simulador.util.ssh;

import java.io.ByteArrayOutputStream;
import java.util.Properties;

import org.apache.log4j.Logger;

import com.jcraft.jsch.ChannelExec;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.Session;

public class RequisicaoSSH {

	private static final Logger logger = Logger.getLogger(RequisicaoSSH.class);

	private RequisicaoSSH() {
	}
	
	public static String requisicao(String comando) {
		Session session = null;
		ChannelExec channel = null;
		try {
			session = new JSch().getSession("f747250", "10.116.95.194", 22);
			session.setPassword("16831Rafael");

			Properties config = new java.util.Properties();
			config.put("StrictHostKeyChecking", "no");
			config.put("Compression", "yes");
			config.put("ConnectionAttempts", "2");
			session.setConfig(config);

			session.connect();

			channel = (ChannelExec) session.openChannel("exec");
			channel.setCommand(comando);
			ByteArrayOutputStream responseStream = new ByteArrayOutputStream();
			channel.setOutputStream(responseStream);
			channel.connect();

			while (channel.isConnected()) {
				Thread.sleep(100);
			}

			return new String(responseStream.toByteArray());
		} 
		catch (Exception e) {
			logger.error(e);
			return null;
		} 
		finally {
			if (session != null) {
				session.disconnect();
			}
			if (channel != null) {
				channel.disconnect();
			}
		}
	}

}
