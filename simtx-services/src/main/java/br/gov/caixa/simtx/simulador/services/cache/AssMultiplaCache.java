package br.gov.caixa.simtx.simulador.services.cache;

import javax.annotation.PostConstruct;
import javax.inject.Singleton;

@Singleton
public class AssMultiplaCache {
	
	private MemoryCache<String, String> cache;
	
	@PostConstruct
	public void iniciaCache() {
		
		cache = new MemoryCache<String, String>(86400, 500, 99999999);
		 
		
	}

}
