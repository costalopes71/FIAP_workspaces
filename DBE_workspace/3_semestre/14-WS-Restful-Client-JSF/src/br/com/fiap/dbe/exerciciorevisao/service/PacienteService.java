package br.com.fiap.dbe.exerciciorevisao.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.ws.rs.core.MediaType;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

import br.com.fiap.dbe.exerciciorevisao.to.Paciente;

public class PacienteService {

	private Client client = Client.create();
	private static final String URL = "http://localhost:8080/13-WS-Restful-Server-Health/rest/paciente";
	
	public void cadastrar(Paciente paciente) throws Exception {
		
		// criando a conexao com o WS
		WebResource resource = client.resource(URL);
		//chama o WS e passa o json do objeto a ser inserido
		ClientResponse response = resource.type(MediaType.APPLICATION_JSON).post(ClientResponse.class, paciente);
		
		if (response.getStatus() != 201) {
			throw new Exception("Erro! Código do erro: " + response.getStatus());
		}
		
	}
	
	public Paciente pesquisar(int codigo) throws Exception {
		
		WebResource resource = client.resource(URL).path(String.valueOf(codigo));
		ClientResponse response = resource.accept(MediaType.APPLICATION_JSON).get(ClientResponse.class);
		
		if (response.getStatus() != 200) {
			throw new Exception("Erro! Código do erro: " + response.getStatus());
		}
		
		return response.getEntity(Paciente.class);
	}
	
	public List<Paciente> listar() throws Exception {
		
		WebResource resource = client.resource(URL);
		ClientResponse response = resource.accept(MediaType.APPLICATION_JSON).get(ClientResponse.class);
		
		if (response.getStatus() != 200) {
			throw new Exception("ERRO! Código do erro: " + response.getStatus());
		}
		
		return new ArrayList<Paciente>(Arrays.asList(response.getEntity(Paciente[].class)));
	}
	
	public void atualizar(Paciente paciente) throws Exception {
		
		WebResource resource = client.resource(URL).path(String.valueOf(paciente.getCodigo()));
		ClientResponse response = resource.type(MediaType.APPLICATION_JSON).put(ClientResponse.class, paciente);
		
		if (response.getStatus() != 200) {
			throw new Exception("ERRO! Código do erro: " + response.getStatus());
		}
		
	}
	
	public void deletar(int codigo) throws Exception {
		
		WebResource resource = client.resource(URL).path(String.valueOf(codigo));
		ClientResponse response = resource.delete(ClientResponse.class);
		
		if (response.getStatus() != 204) {
			throw new Exception("ERRO! Código do erro: " + response.getStatus());
		}
		
	}
	
}
