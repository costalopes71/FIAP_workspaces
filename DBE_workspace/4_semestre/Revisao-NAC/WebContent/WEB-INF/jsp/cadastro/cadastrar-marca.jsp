<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="tags" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<tags:template titulo="Cadastrar Marca">

	<c:if test="${not empty msgErro}">
		<div class="alert alert-danger">
			${msgErro}
		</div>
	</c:if>
	
	<c:if test="${not empty msgSucesso}">
		<div class="alert alert-success">
			${msgSucesso}
		</div>
	</c:if>
	
	<c:url value="/marca/cadastrar" var="action"/>
	<form:form action="${action}" method="post" modelAttribute="marca">
	
		<div class="form-group">
			<form:label path="nome">Nome</form:label>
			<form:input path="nome" cssClass="form-control" placeholder="Nome da marca"></form:input>
			<form:errors path="nome" cssClass="text-danger"/>
		</div>
	
		<input class="btn btn-primary" type="submit" value="Cadastrar"/>
	
	</form:form>	

</tags:template>
