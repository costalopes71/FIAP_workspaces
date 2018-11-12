<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="tag" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<tag:_template titulo="Listar Jogos">

	<h1>Lista de Jogos</h1>
	
	<br>

	<div class="row">

		<div class="col-md-5">
			<c:url value="/jogo/pesquisarPorNome" var="action"/>
			<form action="${action}" method="get" class="form-inline">
				<input type="text" name="pesquisa" placeholder="Pesquisar por nome" class="form-control"/>
				<button type="submit" class="btn btn-default">Pesquisar</button>
			</form>
		</div>
		
		<div class="col-md-5">
			<c:url value="/jogo/pesquisarPorGenero" var="action"/>
			<form action="${action}" method="get" class="form-inline">
				<select class="form-control" name="codigo">
					<option value="" label="Selecione">
					<c:forEach items="${generos}" var="genero">
						<option value="${genero.codigo}" label="${genero.nome}">
					</c:forEach>
				</select>
				<button type="submit" class="btn btn-default">Pesquisar</button>
			</form>
		</div>
	</div>

	<br>

	<table class="table table-hover">
		
		<thead>
			<tr>
				<th class="text-center">Nome</th>
				<th class="text-center">Data Lançamento</th>
				<th class="text-center">Disponível</th>
				<th class="text-center">Plataforma</th>
				<th class="text-center">Gênero</th>
				<th class="text-center">Ações</th>
			</tr>
		</thead>
		
		<tbody>
			<c:forEach items="${jogos}" var="jogo">
				<tr>
					<td class="text-center">${jogo.nome}</td>
					<td class="text-center">
						<fmt:formatDate value="${jogo.dataLancamento.time}" pattern="dd/MM/yyyy" timeZone="America/Sao_Paulo"/>
					</td>
					<td class="text-center">${jogo.disponivel ? "Sim" : "Não"}</td>
					<td class="text-center">${jogo.plataforma.label}</td>
					<td class="text-center">${jogo.genero.nome}</td>
					<td class="text-center">
						<c:choose>
							<c:when test="${jogo.disponivel == false }">
								<a href="<c:url value="/jogo/editar-jogo/${jogo.codigo}"/>" class="btn btn-outline-primary">Editar</a>
								<button onclick="codigoRemover.value = ${jogo.codigo}" type="button" class="btn btn-outline-danger" data-toggle="modal" data-target="#modalRemover">
									Remover
								</button>
								<button onclick="codigoDisponibilizar.value = ${jogo.codigo}" type="button" class="btn btn-outline-success" data-toggle="modal" data-target="#modalDisponibilizar">
									Disponibilizar
								</button>					
							</c:when>
							<c:otherwise>
								<button class="btn btn-outline-primary" disabled="disabled">Editar</button>
								<button type="button" class="btn btn-outline-danger" disabled="disabled">
									Remover
								</button>
								<button type="button" class="btn btn-outline-success" disabled="disabled">
									Disponibilizar
								</button>
							</c:otherwise>
						</c:choose>
					</td>
				</tr>
			</c:forEach>
		</tbody>
	
	</table>

	<!-- Modal Exluir -->
	<div class="modal fade" id="modalRemover" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
	  <div class="modal-dialog" role="document">
	    <div class="modal-content">
	      <div class="modal-header">
	        <h5 class="modal-title" id="exampleModalLabel">Confirmação</h5>
	        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
	          <span aria-hidden="true">&times;</span>
	        </button>
	      </div>
	      <div class="modal-body">
	        Deseja realmente apagar o jogo?
	      </div>
	      <div class="modal-footer">
	      		<c:url var="action" value="/jogo/remover-jogo"/>
	      		<form:form action="${action}" method="post">
	      			<input type="hidden" name="codigo" id="codigoRemover"/>
					<button type="button" class="btn btn-secondary" data-dismiss="modal">Não</button>
		        	<button type="submit" class="btn btn-danger">Sim</button>	      		
	      		</form:form>
	      </div>
	    </div>
	  </div>
	</div>
	
	<!-- Modal Disponibilizar -->
	<div class="modal fade" id="modalDisponibilizar" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
	  <div class="modal-dialog" role="document">
	    <div class="modal-content">
	      <div class="modal-header">
	        <h5 class="modal-title" id="exampleModalLabel">Confirmação</h5>
	        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
	          <span aria-hidden="true">&times;</span>
	        </button>
	      </div>
	      <div class="modal-body">
	        Deseja realmente disponibilizar o jogo?
	      </div>
	      <div class="modal-footer">
	      		<c:url value="/jogo/disponibilizar-jogo" var="action"/>
	      		<form:form action="${action}" method="post">
	      			<input type="hidden" name="codigo" id="codigoDisponibilizar"/>
	      			<button type="button" class="btn btn-secondary" data-dismiss="modal">Não</button>
		        	<button type="submit" class="btn btn-success">Sim</button>
	      		</form:form>
	      </div>
	    </div>
	  </div>
	</div>

</tag:_template>