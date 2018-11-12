<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="tag" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<tag:_template titulo="Cadastrar Jogo">

	<h1>Cadastrar Jogo</h1>

	<c:url value="/jogo/cadastrar-jogo" var="action"/>
	<form:form action="${action}" method="post" modelAttribute="jogo">
	
		<div class="form-group">
			<form:label path="nome">Nome</form:label>
			<form:input path="nome" cssClass="form-control" placeholder="Nome do jogo"/>
			<form:errors path="nome" cssClass="text-danger"/>
		</div>
		
		<div class="form-group">
			<form:label path="dataLancamento">Data de Lançamento</form:label>
			<form:input path="dataLancamento" cssClass="form-control" placeholder="dd/MM/aaaa"/>
			<form:errors path="dataLancamento" cssClass="text-danger"/>
		</div>
	
		<div class="form-group">
			<form:label path="plataforma">Plataforma</form:label>
			<form:select path="plataforma" cssClass="form-control">
				<form:option value="" >Selecione</form:option>
				<form:options items="${plataformas}" itemLabel="label"/>
			</form:select>
			<form:errors path="plataforma" cssClass="text-danger"/>
		</div>
	
		<div class="form-group">
			<form:label path="genero">Gênero</form:label>
			<form:select path="genero.codigo" cssClass="form-control">
				<form:option value="">Selecione</form:option>
				<form:options items="${generos}" itemLabel="nome" itemValue="codigo"/>
			</form:select>
			<form:errors path="genero" cssClass="text-danger"/>
		</div>
		
		<div class="form-group">
			<input type="submit" class="btn btn-primary" value="Cadastrar"/>
		</div>
		
	</form:form>

</tag:_template>