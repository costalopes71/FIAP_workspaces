package br.com.fiap.ws.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.ws.rs.core.MediaType;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import br.com.fiap.to.Selecao;

//Realiza o acesso ao webservice
public class SelecaoService {

	private Client client = Client.create();
	private static final String URL = "http://localhost:8080/10-WS-Restful-Server/rest/selecao";
	
	public List<Selecao> listar() throws Exception {
		//Cria o acesso ao WS com a URL
		WebResource resource = client.resource(URL + "/listar");
		//Chamar o WS
		ClientResponse response = resource
				//configura o formato de resposta - JSON
				.accept(MediaType.APPLICATION_JSON)
				//faz a requisicao do tipo GET
				.get(ClientResponse.class);
		
		//valida a resposta do servidor - Status HTTP 200 OK 
		if (response.getStatus() != 200) {
			throw new Exception("ERRO: " + response.getStatus());
		} 
		
		//recupera as selecoes e retorna
		return new ArrayList<Selecao>(Arrays.asList(response.getEntity(Selecao[].class)));
	}
	
	public void cadastrar(Selecao selecao) throws Exception {
		WebResource resource = client.resource(URL);
		ClientResponse response = resource.type(MediaType.APPLICATION_JSON).post(ClientResponse.class, selecao);
		
		if (response.getStatus() != 201) {
			throw new Exception("ERRO: " + response.getStatus());
		}
		
	}
	
	public void atualizar(Selecao selecao) throws Exception {
		WebResource resource = client.resource(URL).path(String.valueOf(selecao.getCodigo()));
		ClientResponse response = resource.type(MediaType.APPLICATION_JSON).put(ClientResponse.class, selecao);
		
		if (response.getStatus() != 200) {
			throw new Exception("ERRO: " + response.getStatus());
		}
		
	}
	
	public void deletar(int id) throws Exception {
		WebResource resource = client.resource(URL).path(String.valueOf(id));
		ClientResponse response = resource.delete(ClientResponse.class);
		
		if (response.getStatus() != 204) {
			throw new Exception("ERRO: " + response.getStatus());
		}
		
	}

	public Selecao pesquisar(int id) throws Exception {
		WebResource resource = client.resource(URL).path(String.valueOf(id));
		ClientResponse response = resource.accept(MediaType.APPLICATION_JSON).get(ClientResponse.class);
		
		if (response.getStatus() != 200) {
			throw new Exception("ERRO: " + response.getStatus());
		}
		
		return response.getEntity(Selecao.class);
	}
	
}
