package br.com.fiap.ads.singleton;

import java.io.IOException;
import java.util.Properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PropertiesSingleton {
	
	//1 - atributo estatico que mantem a unica instancia
	private static Properties properties;
	private static final Logger log = LoggerFactory.getLogger(PropertiesSingleton.class);
	
	//3 - construtor privado
	private PropertiesSingleton() {
		
	}
	
	//2 - metodo estatico getInstance que retorna a unica instancia
	public static Properties getInstance() throws IOException {
		if (properties == null) {
			log.trace("Criando o objeto properties.");
			properties = new Properties();
			//carregar o arquivo com as propriedades
			try {
				log.info("Carregando o arquivo de propriedade do sistema.");
				properties.load(PropertiesSingleton.class.getResourceAsStream("/config.properties"));
			} catch (IOException e) {
				log.error("Arquivo de configuração não carregado.");
				e.printStackTrace();
				throw new IOException("Arquivo não encontrado.", e);
			}
		}
		log.debug("Retornando as configurações do sistema.");
		return properties;
	}

}
