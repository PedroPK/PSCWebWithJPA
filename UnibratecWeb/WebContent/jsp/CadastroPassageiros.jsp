<?xml version="1.0" encoding="UTF-8" ?>

<jsp:root xmlns:jsp="http://java.sun.com/JSP/Page" version="2.0">

<jsp:directive.page import="br.unibratec.linhasaereas.util.passageiro.ConstantesPassageiro"/>

	<jsp:directive.page 
		contentType="text/html; charset=UTF-8" 
		pageEncoding="UTF-8" 
		session="false"/>
	<jsp:output 
		doctype-root-element="html"
		doctype-public="-//W3C//DTD XHTML 1.0 Transitional//EN"
		doctype-system="http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd"
		omit-xml-declaration="true" />
		
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<title>Unibratec - PSC - Cadastro de Passageiros</title>
	</head>
	<body>
		<form 
			action="AdicionarPassageiro" 
			method="post">
			
			<table>
				<th colspan="2">
					Cadastro de Passageiros
				</th>
				<tr>
					<td>Nome:</td>
					<td>
						<input type="text" name="nome"/>
					</td>
				</tr>
				<tr>
					<td>e-Mail:</td>
					<td>
						<input type="text" name="email"/>
					</td>
				</tr>
				<tr>
					<td>CPF:</td>
					<td><input type="text" name="CPF"/></td>
				</tr>
				<tr>
					<td>Data de Nascimento:</td>
					<td><input type="text" name="dataNascimento"/></td>
				</tr>
				<tr>
					<td>É Portador de Necessidades Especiais?</td>
					<td>
						Sim: <input type="radio" name="isPortadorNecessidadesEspeciais" value="true" />
						<br/>
						Não: <input type="radio" name="isPortadorNecessidadesEspeciais" value="false" />
					</td>
				</tr>
				<tr >
					<td colspan="2">
						<input type="submit" value="Salvar" />
					</td>
				</tr>
			</table>
		</form>
	</body>
</html>
</jsp:root>