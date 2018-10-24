<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="tags" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<tags:template titulo="Cadastrar (NAC)">

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

	<c:url value="/carro/cadastrar" var="action"/>
	<form:form action="${action}" method="post" modelAttribute="carro">
	
		<div class="form-group">
			<form:label path="modelo">Modelo</form:label>
			<form:input path="modelo" cssClass="form-control" placeholder="Modelo do carro"/>
			<form:errors path="modelo" class="text-danger"/>
		</div>
	
		<div class="form-group">
			<form:checkbox path="completo"/>
			<form:label path="completo">Completo</form:label>
		</div>
	
		<div class="form-group">
			<form:label path="dataFabricacao">Data de Fabricação</form:label>
			<form:input path="dataFabricacao" cssClass="form-control" placeholder="dd/mm/aaaa"/>
			<form:errors path="dataFabricacao" cssClass="text-danger"/>
		</div>
		
		<div class="form-group">
			<form:label path="marca">Marca</form:label>
			<form:select path="marca.codigo" cssClass="form-control">
				<form:options items="${marcas}" itemLabel="nome" itemValue="codigo"/>			
			</form:select>
		</div>
		
		<div class="form-group">
			<form:label path="combustivel">Combustível</form:label>
			<form:select path="combustivel" cssClass="form-control">
				<form:option value="0">Selecione</form:option>
				<form:options items="${combustiveis}" itemLabel="label"/>
			</form:select>
		</div>
		
		<input class="btn btn-primary" type="submit" value="Cadastrar"/>
	
	</form:form>	

</tags:template>
