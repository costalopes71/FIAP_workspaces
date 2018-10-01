package br.com.fiap.resource;

import java.util.List;
import javax.persistence.EntityManager;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.core.UriBuilder;
import javax.ws.rs.core.UriInfo;
import br.com.fiap.entities.Selecao;
import br.com.fiap.jpa.dao.SelecaoDAO;
import br.com.fiap.jpa.dao.impl.SelecaoDAOImpl;
import br.com.fiap.jpa.exception.CommitException;
import br.com.fiap.jpa.exception.KeyNotFoundException;
import br.com.fiap.jpa.singleton.EntityManagerFactorySingleton;

@Path("/selecao")
public class SelecaoResource {

	private SelecaoDAO dao;
	
	public SelecaoResource() {
		EntityManager em = EntityManagerFactorySingleton.getInstance().createEntityManager();
		dao = new SelecaoDAOImpl(em);
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("{id}")
	public Selecao pesquisar(@PathParam("id") int codigo) {
		return dao.pesquisar(codigo);
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Selecao> listar() {
		return dao.listar();
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON) //recebe um JSON
	public Response cadastrar(Selecao selecao, @Context UriInfo uri) {
		
		try {
			dao.inserir(selecao);
			dao.commit();
			//construir a URL de resposta
		} catch (CommitException e) {
			e.printStackTrace();
			//Posso retornar o status code 500 do HTTP desse jeito abaixo: 
			// throw new WebApplicationException(Status.INTERNAL_SERVER_ERROR);
			//ou desta maneira
			return Response.serverError().build();
		}
		
		//recupera a URL atual
		UriBuilder builder = uri.getAbsolutePathBuilder();
		// adiciona o codigo da selecao na URL
		builder.path(String.valueOf(selecao.getCodigo()));
		//Retorna status 501
		return Response.created(builder.build()).build();
	}

	@PUT
	@Path("{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response atualizar(Selecao selecao, @PathParam("id") int codigo) {
		try {
			selecao.setCodigo(codigo);
			dao.atualizar(selecao);
			dao.commit();
		} catch (CommitException e) {
			e.printStackTrace();
			return Response.serverError().build();
		}
		return Response.ok().build();
	}
	
	@DELETE
	@Path("{id}")
	public void deletar(@PathParam("id") int codigo) {
		try {
			dao.remover(codigo);
			dao.commit();
		} catch (CommitException | KeyNotFoundException e) {
			e.printStackTrace();
			throw new WebApplicationException(Status.INTERNAL_SERVER_ERROR);
		}
	}
	
}