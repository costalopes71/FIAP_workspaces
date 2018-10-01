package br.com.nac.service;

import java.util.Arrays;
import java.util.List;

import javax.ws.rs.core.MediaType;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

import br.com.nac.entity.Imovel;

public class ImovelService {

	private static final String URL = "http://localhost:8080/NACServer/rest/imovel";
	private Client client = Client.create();
	
	public void cadastrar(Imovel imovel) throws Exception {
		
		WebResource resource = client.resource(URL);
		ClientResponse response = resource.type(MediaType.APPLICATION_JSON).post(ClientResponse.class, imovel);
		
		if (response.getStatus() != 201) {
			throw new Exception("Erro " + response.getStatus());
		}
		
	}
	
	public List<Imovel> listar() throws Exception {
		WebResource resource = client.resource(URL);
		ClientResponse response = resource.accept(MediaType.APPLICATION_JSON).get(ClientResponse.class);
		
		if (response.getStatus() != 200) {
			throw new Exception("Erro ao tentar listar. Código do erro: " + response.getStatus());
		}
		
		return Arrays.asList(response.getEntity(Imovel[].class));
	}

	public void atualizar(Imovel imovel) throws Exception {
		WebResource resource = client.resource(URL).path(String.valueOf(imovel.getCodigo()));
		ClientResponse response = resource.type(MediaType.APPLICATION_JSON).put(ClientResponse.class, imovel);
		
		if (response.getStatus() != 200) {
			throw new Exception("Erro ao atualizar. Código do erro: " + response.getStatus());
		}
		
	}
	
}
