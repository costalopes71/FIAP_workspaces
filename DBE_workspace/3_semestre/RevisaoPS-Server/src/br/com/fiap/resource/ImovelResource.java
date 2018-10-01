package br.com.fiap.resource;

import java.util.List;

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

import br.com.fiap.dao.ImovelDAO;
import br.com.fiap.dao.impl.ImovelDAOImpl;
import br.com.fiap.entities.Imovel;
import br.com.fiap.exceptions.CommitException;
import br.com.fiap.exceptions.IdNotFoundException;

@Path("/imovel")
public class ImovelResource {

	private ImovelDAO dao;
	
	public ImovelResource() {
		dao = new ImovelDAOImpl();
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Imovel> listar() {
		return dao.listar();
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response cadastrar(Imovel imovel, @Context UriInfo uri) {
		
		try {
			dao.cadastrar(imovel);
			dao.commit();
		} catch (CommitException e) {
			return Response.serverError().build();
		}
		
		UriBuilder builder = uri.getAbsolutePathBuilder().path(String.valueOf(imovel.getId()));
		return Response.created(builder.build()).build();
	}
	
	@GET
	@Path("{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Imovel pesquisar(@PathParam("id") int id) {
		return dao.pesquisar(id);
	}
	
	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("{id}")
	public Response atualizar(Imovel imovel, @PathParam("id") int codigo) {
		
		imovel.setId(codigo);
		try {
			dao.atualizar(imovel);
			dao.commit();
		} catch (CommitException e) {
			return Response.serverError().build();
		}
		return Response.ok().build();
	}
	
	@DELETE
	@Path("{id}")
	public void deletar(@PathParam("id") int id) {
		try {
			dao.deletar(id);
			dao.commit();
		} catch (IdNotFoundException e) {
			throw new WebApplicationException(Response.Status.BAD_REQUEST);
		} catch (CommitException e) {
			throw new WebApplicationException(Response.Status.INTERNAL_SERVER_ERROR);
		}
	}
	
}
