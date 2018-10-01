<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Cadastro de Cliente</title>
</head>
<body>

	<form action="cadastrar" method="post">
	
		<div>
			<label for="nome">Nome</label>
			<input type="text" id="nome" name="nome"/>
		</div>
	
		<div>
			<label for="idade">Idade</label>
			<input type="text" id="idade" name="idade"/>
		</div>
		
		<div>
			<label for="cnh">CNH</label>
			<input type="checkbox" id="cnh" name="cnh"/>
		</div>
		
		<div>
			<label for="genero">Genero</label>
			<select id="genero" name="genero">
				<option label="MASCULINO" value="masculino"/>
				<option label="FEMININO" value="feminino"/>
			</select>
		</div>
	
		<div>
			<input type="submit" value="ENVIAR"/>
		</div>
	
	</form>

</body>
</html>