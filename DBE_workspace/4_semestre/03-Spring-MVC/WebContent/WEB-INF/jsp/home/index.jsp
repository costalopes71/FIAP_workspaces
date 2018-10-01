<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="tags" tagdir="/WEB-INF/tags" %>

<tags:template titulo="Pagina Inicial">

	<jsp:attribute name="scripts">
		<p>Algum js apenas da página index aqui</p>
	</jsp:attribute>
	
	<jsp:body>
		<%-- Tudo que estiver aqui vai para o <jsp:doBody> do template --%>	
		<h1>Pagina Inicial</h1>
	</jsp:body>
	
</tags:template>