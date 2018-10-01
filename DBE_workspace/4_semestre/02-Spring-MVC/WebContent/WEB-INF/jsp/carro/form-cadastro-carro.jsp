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
			<label for="modelo">Modelo</label>
			<input type="text" id="modelo" name="modelo"/>
		</div>
	
		<div>
			<label for="marca">Marca</label>
			<input type="text" id="marca" name="marca"/>
		</div>
		
		<div>
			<label for="novo">Novo</label>
			<input type="checkbox" id="novo" name="novo"/>
		</div>
		
		<div>
			<div>
				<input type="radio" name="cambio" value="automatico">Automático
			</div>
			<div>
				<input type="radio" name="cambio" value="manual">Manual
			</div>
		</div>
		
		<div>
			<label for="ano">Ano</label>
			<select id="ano" name="ano">
				<option label="2000" value="2000"/>
				<option label="2001" value="2001"/>
			</select>
		</div>
	
		<div>
			<input type="submit" value="ENVIAR"/>
		</div>
	
	</form>

</body>
</html>