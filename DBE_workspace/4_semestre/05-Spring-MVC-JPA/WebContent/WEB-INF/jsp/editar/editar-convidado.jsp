<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="tags" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<tags:template titulo="Editar Produto">

	<c:url value="/convidado/editar-convidado" var="action"/>
	<form:form action="${action}" method="post" modelAttribute="convidado">
		<form:hidden path="codigo"/>
		<div class="form-group">
			<form:label  path="nome">Nome do Convidado</form:label>
   			<form:input type="text" cssClass="form-control" placeholder="Nome do convidado" path="nome" id="iNome"/>
		</div>
		
		<div class="form-group">
			<form:label path="email">Email</form:label>
   			<form:input type="text" cssClass="form-control" placeholder="Email do convidado" path="email" id="iEmail"/>
		</div>
		
		<div class="form-group">
			<form:label path="confirmado">Confirmado</form:label>
			<form:checkbox path="confirmado"/>
		</div>
		
		<div>
			<button class="btn btn-primary" type="submit">Editar</button>
		</div>
		
	</form:form>

</tags:template>