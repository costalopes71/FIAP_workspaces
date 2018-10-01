<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Cadastrar Pessoa</title>
</head>
<body>

	<h1>Cadastrar Pessoa</h1>

	<form action="cadastrar-pessoa" method="post">
		<div>
			<label for="nome">Nome</label>
			<input type="text" name="nome" id="nome"/>
		</div>
		<div>
			<label for="idade">Idade</label>
			<input type="text" name="idade" id="idade"/>
		</div>
		<div>
			<label for="aposentado">Aposentado</label>
			<input type="radio" name="aposentado" id="aposentado"/>		
		</div>
		<div>
			<input type="submit" value="OK"/>
		</div>
	</form>

</body>
</html>