package br.com.fiap.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.ws.rs.core.MediaType;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

import br.com.fiap.to.Paciente;

public class PacienteService {

	private static final String URL = "http://localhost:8080/RevisaoPS-Server2/rest/paciente";
	private Client client = Client.create();
	
	public void cadastrar(Paciente paciente) throws Exception {
		WebResource resource = client.resource(URL);
		ClientResponse response = resource.type(MediaType.APPLICATION_JSON).post(ClientResponse.class, paciente);
		if (response.getStatus() != 201) {
			throw new Exception("Erro ao tentar cadastrar. Código do erro: " + response.getStatus());
		}
	}
	
	public List<Paciente> listar() throws Exception {
		WebResource resource = client.resource(URL);
		ClientResponse response = resource.accept(MediaType.APPLICATION_JSON).get(ClientResponse.class);
		
		if (response.getStatus() != 200) {
			throw new Exception("Erro ao tentar listar os pacientes. Código do erro: " + response.getStatus());
		}
		
		return new ArrayList<Paciente>(Arrays.asList(response.getEntity(Paciente[].class)));
	}

	public Paciente pesquisar(int id) throws Exception {
		WebResource resource = client.resource(URL).path(String.valueOf(id));
		ClientResponse response = resource.accept(MediaType.APPLICATION_JSON).get(ClientResponse.class);
		
		if (response.getStatus() != 200) {
			throw new Exception("Erro ao tentar pesquisar pacientes. Código do erro: " + response.getStatus());
		}
		
		return response.getEntity(Paciente.class);
	}
	
	public void atualizar(Paciente paciente) throws Exception {
		WebResource resource = client.resource(URL).path(String.valueOf(paciente.getId()));
		ClientResponse response = resource.type(MediaType.APPLICATION_JSON).put(ClientResponse.class, paciente);
		if (response.getStatus() != 200) {
			throw new Exception("Erro ao tentar atualizar o paciente. Código do erro: " + response.getStatus());
		}
	}
	
	public void deletar(int id) throws Exception {
		WebResource resource = client.resource(URL).path(String.valueOf(id));
		ClientResponse response = resource.delete(ClientResponse.class);
		
		if (response.getStatus() != 204) {
			throw new Exception("Erro ao tentar deletar o paciente. Código do erro: " + response.getStatus());
		}
		
	}
	
}
