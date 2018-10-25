<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="tags" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<tags:template titulo="Cadastrar Jogo">

	<h1>Cadastrar Jogo</h1>

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

	<c:url value="/jogo/cadastrar" var="action"/>
	<form:form action="${action}" method="post" modelAttribute="jogo">
	
		<div class="form-group">
			<form:label path="nome">Nome</form:label>
			<form:input path="nome" cssClass="form-control" placeholder="Nome do jogo"/>
		</div>
		
		<div class="form-group">
			<form:label path="dataLancamento">Data de Lançamento</form:label>
			<form:input path="dataLancamento" cssClass="form-control" placeholder="Data de lançamento"/>
		</div>
		
		<div class="form-group">
			<form:label path="plataforma">Plataforma</form:label>
			<form:select path="plataforma" cssClass="form-control">
				<form:option value="">Selecione</form:option>
				<form:options items="${plataformas}" itemLabel="label"/>
			</form:select>
			<form:errors path="plataforma" cssClass="text-danger"/>
		</div>
	
		<div class="form-group">
			<form:label path="genero">Gênero</form:label>
			<form:select path="genero.codigo" cssClass="form-control">
				<form:option value="">Selecione</form:option>
				<form:options items="${generos}" itemValue="codigo" itemLabel="nome"/>
			</form:select>
			<form:errors path="genero" cssClass="text-danger"/>
		</div>
	
		<input type="submit" value="Cadastrar" class="btn btn-outline-success"/>	
	
	</form:form>
	
</tags:template>