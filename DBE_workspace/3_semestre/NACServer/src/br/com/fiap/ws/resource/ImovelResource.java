package br.com.fiap.ws.resource;

import java.util.List;
import javax.persistence.EntityManager;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;
import javax.ws.rs.core.UriInfo;
import br.com.fiap.ws.dao.ImovelDAO;
import br.com.fiap.ws.dao.impl.ImovelDAOImpl;
import br.com.fiap.ws.entity.Imovel;
import br.com.fiap.ws.exception.CommitException;
import br.com.fiap.ws.singleton.EntityManagerFactorySingleton;

@Path("/imovel")
public class ImovelResource {

	private ImovelDAO dao;
	
	public ImovelResource() {
		EntityManager em = EntityManagerFactorySingleton.getInstance().createEntityManager();
		dao = new ImovelDAOImpl(em);
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response cadastrar(Imovel imovel, @Context UriInfo uri) {
		
		dao.cadastrar(imovel);
		try {
			dao.commit();
		} catch (CommitException e) {
			e.printStackTrace();
			return Response.serverError().build();
		}
		
		UriBuilder builder = uri.getAbsolutePathBuilder();
		builder.path(String.valueOf(imovel.getCodigo()));
		return Response.created(builder.build()).build();
		
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Imovel> listar() {
		return dao.listar();
	}

	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("{id}")
	public Response atualizar(Imovel imovel, @PathParam("id") int codigoImovel) {
		
		imovel.setCodigo(codigoImovel);
		dao.atualizar(imovel);
		try {
			dao.commit();
			return Response.ok().build();
		} catch (CommitException e) {
			e.printStackTrace();
			return Response.serverError().build();
		}
		
	}
	
}
