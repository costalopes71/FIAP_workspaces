<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="tags" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<tags:template titulo="Cadastrar Gênero">

	<h1>Cadastrar Gênero</h1>

	<c:if test="${not empty msgSucesso}">
		<div class="alert alert-success">
			${msgSucesso}
		</div>
	</c:if>

	<c:if test="${not empty msgErro}">
		<div class="alert alert-danger">
			${msgErro}
		</div>
	</c:if>

	<c:url value="/genero/cadastrar" var="action"/>
	<form:form action="${action}" method="post" modelAttribute="genero">
	
		<div class="form-group">
			<form:label path="nome">Nome</form:label>
			<form:input path="nome" cssClass="form-control"/>
		</div>
	
		<input type="submit" value="Cadastrar" class="btn btn-outline-success"/>	
	
	</form:form>
	
</tags:template>