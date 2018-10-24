<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="tags" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

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

	<table class="table table-hover">
		
		<thead>
			<tr>
				<th>Modelo</th>
				<th>Completo</th>
				<th>Data Fabricação</th>
				<th>Marca</th>
				<th>Combustível</th>
			</tr>
		</thead>
		
		<tbody>
			<c:forEach items="${carros}" var="carro">
				<tr>			
					<td>${carro.modelo}</td>
					<td>${carro.completo ? "Sim" : "Não"}</td>
					<td>
						<fmt:formatDate value="${carro.dataFabricacao.time}" pattern="dd/MM/yyyy"/>
					</td>
					<td>${carro.marca.nome}</td>
					<td>${carro.combustivel.label}</td>
				</tr>
			</c:forEach>		
		</tbody>
	
	</table>

</tags:template>
