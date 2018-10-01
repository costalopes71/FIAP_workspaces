<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="tags" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<tags:template titulo="Cadastrar Apresentação">

	<c:if test="${msg != null}">
		<div class="alert alert-success">${msg}</div>
	</c:if>
	

	<form action="cadastrar-apresentacao" method="post">
		<div class="form-group">
			<label  for="iNomeGrupo">Nome do Grupo</label>
   			<input type="text" class="form-control" placeholder="Nome do grupo do projeto" name="nomeGrupo" id="iNomeGrupo">
		</div>
		
		<div class="form-group">
			<label  for="iDuracao">Duração</label>
   			<input type="text" class="form-control" placeholder="Duraçao (em min)" name="duracao" id="iDuracao">
		</div>
		
		<div class="form-group">
			<label for="iDescricao">Descricao</label>
			<textarea rows="5" cols="50" name="descricao" id="iDescricao" class="form-control"></textarea>
		</div>
		
		<div class="form-group">
   			<input type="checkbox" name="apresentado" id="iApresentado">Apresentado
		</div>
		
		<div>
			<button class="btn btn-primary" type="submit">CADASTRAR</button>
		</div>
		
	</form>

</tags:template>