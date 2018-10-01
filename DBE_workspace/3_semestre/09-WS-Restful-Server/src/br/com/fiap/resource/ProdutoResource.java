package br.com.fiap.resource;

import java.util.List;
import javax.persistence.EntityManager;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.core.UriBuilder;
import javax.ws.rs.core.UriInfo;
import br.com.fiap.jpa.dao.ProdutoDAO;
import br.com.fiap.jpa.dao.impl.ProdutoDAOImpl;
import br.com.fiap.jpa.exception.CommitException;
import br.com.fiap.jpa.exception.KeyNotFoundException;
import br.com.fiap.jpa.singleton.EntityManagerFactorySingleton;
import br.com.fiap.to.ProdutoTO;

@Path("/produto")
public class ProdutoResource {

	private ProdutoDAO dao;
	
	public ProdutoResource() {
		EntityManager em = EntityManagerFactorySingleton.getInstance().createEntityManager();
		dao = new ProdutoDAOImpl(em);
	}
	
//	@GET
//	@Produces(MediaType.APPLICATION_JSON)
//	public ProdutoTO pesquisar(int idProduto) {
//		return dao.pesquisar(idProduto);
//	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<ProdutoTO> listar() {
		return dao.listar();
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response cadastrar(ProdutoTO produto, @Context UriInfo uri) {
		try {
			dao.inserir(produto);
			dao.commit();
			//construir a URL de resposta
			UriBuilder builder = uri.getAbsolutePathBuilder();
			builder.path(String.valueOf(produto.getCodigo()));
			return Response.created(builder.build()).build();
		} catch (CommitException e) {
			e.printStackTrace();
			throw new WebApplicationException(Status.INTERNAL_SERVER_ERROR);
		}
	}
	
	public void remover(int idProduto) throws KeyNotFoundException {
		dao.remover(idProduto);
	}
	
}


