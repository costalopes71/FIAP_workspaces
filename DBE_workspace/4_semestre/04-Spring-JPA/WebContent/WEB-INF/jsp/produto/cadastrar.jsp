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
	

	<form action="cadastrar" method="post">
		<div class="form-group">
			<label  for="iNome">Nome do Produto</label>
   			<input type="text" class="form-control" placeholder="Nome do produto" name="nome" id="iNome">
		</div>
		
		<div class="form-group">
			<label  for="iPreco">Preço</label>
   			<input type="text" class="form-control" placeholder="Preço do produto" name="preco" id="iPreco">
		</div>
		
		<div class="form-group">
   			<input type="checkbox" name="perecivel" id="iPerecivel">Perecível
		</div>
		
		<div>
			<button class="btn btn-primary" type="submit">CADASTRAR</button>
		</div>
		
	</form>

</tags:template>