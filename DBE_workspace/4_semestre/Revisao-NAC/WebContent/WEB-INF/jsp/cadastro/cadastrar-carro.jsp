<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="tags" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<tags:template titulo="Cadastrar (NAC)">

	<form:form action="<c:url value="/carro/cadastrar"/>" method="post" modelAttribute="carro">
	
		<div class="form-group">
			<form:label path="modelo">Modelo</form:label>
			<form:input path="modelo" cssClass="form-control" placeholder="Modelo do carro"/>
		</div>
	
		<div class="form-group">
			<form:checkbox path="completo"/>
			<form:label path="completo">Completo</form:label>
		</div>
	
		<div class="form-group">
			<form:label path="dataFabricacao">Data de Fabricação</form:label>
			<form:input path="dataFabricacao" cssClass="form-control" placeholder="dd/mm/aaaa"/>
		</div>
		
		<button class="btn btn-primary" type="submit">Cadastrar</button>
	
	</form:form>	

</tags:template>
