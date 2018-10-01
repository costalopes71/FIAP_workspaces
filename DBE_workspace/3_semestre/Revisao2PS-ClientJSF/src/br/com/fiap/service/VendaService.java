package br.com.fiap.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.ws.rs.core.MediaType;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

import br.com.fiap.to.Venda;

public class VendaService {

	private static final String URL = "http://localhost:8080/Revisao2PS-Server/rest/venda";
	private Client client = Client.create();
	
	public void cadastrar(Venda venda) throws Exception {
		WebResource resource = client.resource(URL);
		ClientResponse response = resource.type(MediaType.APPLICATION_JSON).post(ClientResponse.class, venda);
		if (response.getStatus() != 201) {
			throw new Exception("Erro ao tentar cadastrar. Código do erro:	 " + response.getStatus());
		}
	}

	public Venda pesquisar(int id) throws Exception {
		WebResource resource = client.resource(URL).path(String.valueOf(id));
		ClientResponse response = resource.accept(MediaType.APPLICATION_JSON).get(ClientResponse.class);
		
		if (response.getStatus() != 200) {
			throw new Exception("Erro ao buscar a venda. Código do erro: " + response.getStatus());
		}
		return response.getEntity(Venda.class);
	}
	
	public List<Venda> listar() throws Exception {
		WebResource resource = client.resource(URL);
		ClientResponse response = resource.accept(MediaType.APPLICATION_JSON).get(ClientResponse.class);
		
		if (response.getStatus() != 200) {
			throw new Exception("Erro ao buscar a venda. Código do erro: " + response.getStatus());
		}
		return new ArrayList<Venda>(Arrays.asList(response.getEntity(Venda[].class)));
	}

	public void atualizar(Venda venda) throws Exception {
		WebResource resource = client.resource(URL).path(String.valueOf(venda.getId()));
		ClientResponse response = resource.type(MediaType.APPLICATION_JSON).put(ClientResponse.class, venda);
		if (response.getStatus() != 200) {
			throw new Exception("Erro ao tentar atualizar. Código do erro: " + response.getStatus());
		}		
	}
	
	public void deletar(int id) throws Exception {
		WebResource resource = client.resource(URL).path(String.valueOf(id));
		ClientResponse response = resource.delete(ClientResponse.class);
		if (response.getStatus() != 204) {
			throw new Exception("Erro ao tentar deletar a venda. Código do erro: " + response.getStatus());
		}
	}
	
}
