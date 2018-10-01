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
import javax.ws.rs.core.UriBuilder;
import javax.ws.rs.core.UriInfo;

import br.com.fiap.dao.VendaDAO;
import br.com.fiap.dao.impl.VendaDAOImpl;
import br.com.fiap.entity.Venda;
import br.com.fiap.singleton.EntityManagerFactorySingleton;

@Path("/venda")
public class VendaResource {

	private VendaDAO dao;
	private EntityManager em;
	
	public VendaResource() {
		em = EntityManagerFactorySingleton.getInstance().createEntityManager();
		dao = new VendaDAOImpl(em);
	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response cadastrar(Venda venda, @Context UriInfo uri) {
		try {
			dao.cadastrar(venda);
			dao.commit();
		} catch (Exception e) {
			return Response.serverError().build();
		}
		
		UriBuilder builder = uri.getAbsolutePathBuilder().path(String.valueOf(venda.getId()));
		return Response.created(builder.build()).build();
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Venda> listar() {
		return dao.listar();
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("{id}")
	public Venda pesquisar(@PathParam("id") int id) {
		return dao.buscar(id);
	}
	
	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("{id}")
	public Response atualizar(Venda venda, @PathParam("id") int id) {
		try {
			venda.setId(id);
			dao.atualizar(venda);
			dao.commit();
		} catch (Exception e) {
			return Response.serverError().build();
		}
		return Response.ok().build();
	}
	
	@DELETE
	@Path("{id}")
	public void deletar(@PathParam("id") int id) {
		try {
			dao.remover(id);
		} catch (Exception e) {
			throw new WebApplicationException(Response.Status.BAD_REQUEST);
		}
		try {
			dao.commit();
		} catch (Exception e) {
			throw new WebApplicationException(Response.Status.INTERNAL_SERVER_ERROR);
		}
	}
	
}
