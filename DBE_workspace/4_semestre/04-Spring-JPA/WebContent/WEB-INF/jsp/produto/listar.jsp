<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="tags" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<tags:template titulo="Cadastrar Produto">

	<c:if test="${mensagemSucesso != null}">
		<div class="alert alert-success">${mensagemSucesso}</div>
	</c:if>
	
	<c:if test="${mensagemErro != null}">
		<div class="alert alert-danger">${mensagemErro}</div>
	</c:if>

	<table class="table table-striped">
	
		<thead>
			<tr>
				<th>ID</th>
				<th>NOME</th>
				<th>PREÇO</th>
				<th>PERECÍVEL</th>
				<th>AÇÕES</th>
			</tr>
		</thead>
		
		<c:forEach items="${produtos}" var="produto">
			<tr>
				<td>${produto.codigo}</td>
				<td>${produto.nome}</td>
				<td>${produto.preco}</td>
				<td>${produto.perecivel?"Sim" : "Não"}</td>
				<td>
					<a class="fas fa-edit" href="<c:url value="/produto/editar/${produto.codigo}"/>"></a>
					<a onclick="idExcluir.value = ${produto.codigo}" data-toggle="modal" 
						data-target="#modalExcluir" href="">
						<span class="fas fa-trash-alt" ></span>
					</a>
				</td>
			</tr>
		</c:forEach>

	</table>
	
	
	
	<!-- Modal -->
	<div class="modal fade" id="modalExcluir" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
	  <div class="modal-dialog" role="document">
	    <div class="modal-content">
	      <div class="modal-header">
	        <h5 class="modal-title" id="exampleModalLabel">Excluir</h5>
	        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
	          <span aria-hidden="true">&times;</span>
	        </button>
	      </div>
	      <div class="modal-body">
	        Tem certeza que deseja excluir o produto?
	      </div>
	      <div class="modal-footer">
	      	<c:url value="/produto/excluir" var="action"/>
	      	<form action="${action}" method="post">
	      		<input type="hidden" name="codigo" id="idExcluir">
		        <button type="submit" class="btn btn-primary">Sim</button>
	        </form>
		    <button type="button" class="btn btn-warning" data-dismiss="modal">Não</button>
	      </div>
	    </div>
	  </div>
	</div>

</tags:template>