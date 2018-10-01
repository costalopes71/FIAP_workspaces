<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="tags" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<tags:template titulo="Cadastrar Produto">

	<c:if test="${msgSucesso != null}">
		<div class="alert alert-success">${msgSucesso}</div>
	</c:if>
	
	<c:if test="${msgErro != null}">
		<div class="alert alert-danger">${msgErro}</div>
	</c:if>
	
	<c:url value="/convidado/cadastrar" var="action"/>
	<form:form action="${action }" method="post" modelAttribute="convidado">
		<div class="form-group">
			<form:label  path="nome">Nome do Convidado</form:label>
   			<form:input type="text" cssClass="form-control" placeholder="Nome do convidado" path="nome" id="iNome"/>
		</div>
		
		<div class="form-group">
			<form:label path="email">Email</form:label>
   			<form:input type="text" cssClass="form-control" placeholder="Email do convidado" path="email" id="iEmail"/>
		</div>
		
		<div>
			<button class="btn btn-primary" type="submit">CADASTRAR</button>
		</div>
		
	</form:form>

</tags:template>