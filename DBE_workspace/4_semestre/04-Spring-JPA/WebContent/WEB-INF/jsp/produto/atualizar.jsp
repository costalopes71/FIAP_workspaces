<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="tags" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<tags:template titulo="Editar Produto">

	<c:if test="${mensagemSucesso != null}">
		<div class="alert alert-success">${mensagemSucesso}</div>
	</c:if>
	
	<c:if test="${mensagemErro != null}">
		<div class="alert alert-danger">${mensagemErro}</div>
	</c:if>
	
	<c:url value="/produto/editar" var="action"></c:url>
	<form:form action="${action}" method="post" modelAttribute="produto">
		<form:hidden path="codigo"/>
		
		<div class="form-group">
			<form:label  path="nome">Nome do Produto</form:label>
   			<form:input cssClass="form-control" placeholder="Nome do produto" path="nome"/>
		</div>
		
		<div class="form-group">
			<form:label  path="preco">Preço</form:label>
   			<form:input cssClass="form-control" placeholder="Preço do produto" path="preco"/>
		</div>
		
		<div class="form-group">
   			<form:checkbox path="perecivel"/>
   			<form:label path="perecivel"/>
		</div>
		
		<div>
			<input type="submit" class="btn btn-primary" value="CADASTRAR"/>
		</div>
		
	</form:form>

</tags:template>