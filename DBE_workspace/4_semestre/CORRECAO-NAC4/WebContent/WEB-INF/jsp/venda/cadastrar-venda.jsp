<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="tags" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<tags:template titulo="Vendas">
	
	<h1>Cadastrar Vendas</h1>
	
	<c:if test="${not empty msgSucesso }">
		<div class="alert alert-success">
			${msgSucesso}
		</div>
	</c:if>
	
	<c:if test="${not empty msgErro}">
		<div class="alert alert-success">
			${msgErro}
		</div>
	</c:if>
	
	<c:url value="/venda/cadastrar" var="acao"/>
	<form:form action="${acao}" method="post" modelAttribute="venda">
	
		<div class="form-group">
			<form:label path="cliente">Cliente</form:label>
			<form:input path="cliente" cssClass="form-control"/>		
		</div>

		<div class="form-group">
			<form:label path="data">Data</form:label>
			<form:input path="data" cssClass="form-control"/>
		</div>

		<div class="form-group">
			<form:label path="valor">Valor</form:label>
			<form:input path="valor" cssClass="form-control"/>
		</div>

		<div class="form-group">
			<form:label path="descricao">Descrição</form:label>
			<form:textarea path="descricao" cssClass="form-control"/>
		</div>
	
		<input type="submit" value="Cadastrar" class="btn btn-primary"/>
	
	</form:form>

</tags:template>