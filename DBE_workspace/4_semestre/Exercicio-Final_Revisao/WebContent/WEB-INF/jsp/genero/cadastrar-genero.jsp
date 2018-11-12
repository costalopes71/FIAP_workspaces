<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="tag" tagdir="/WEB-INF/tags" %>

<tag:_template titulo="Cadastrar Gênero">

	<h1>Cadastrar Gênero</h1>

	<c:url value="/genero/cadastrar-genero" var="action"/>
	<form:form action="${action}" modelAttribute="genero" method="post">
	
		<div class="form-group">
			<form:label path="nome">Nome</form:label>
			<form:input path="nome" cssClass="form-control"/>
			<form:errors path="nome" cssClass="text-danger"/>
		</div>
		
		<div class="form-group">
			<input type="submit" value="Cadastrar" class="btn btn-primary"/>
		</div>
	
	</form:form>

</tag:_template>