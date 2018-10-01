package br.com.fiap.ads.dbe.singleton;

import java.io.IOException;
import java.util.Properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PropertySingleton {

	private static Properties properties;
	private static final Logger log = LoggerFactory.getLogger(PropertySingleton.class);
	
	private PropertySingleton() {
	
	}
	
	public static Properties getInstance() throws IOException {
		if (properties == null) {
			log.trace("Criando o objeto Properties.");
			properties = new Properties();
			try {
				log.trace("Tentando carregar o arquivo de configurações.");
				properties.load(PropertySingleton.class.getResourceAsStream("/configurations.properties"));
			} catch (IOException e) {
				log.error(e.getMessage());
				e.printStackTrace();
				throw new IOException("Arquivo não encontrado.");
			}
		}
		log.debug("retornando as configurações do sistema.");
		return properties;
	}
	
}
