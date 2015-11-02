<%@page import="java.util.Iterator"%>
<%@page import="br.unibratec.util.BibliotecaFuncoes"%>
<%@page import="br.unibratec.linhasaereas.entidades.Passageiro"%>
<%@page import="java.util.Collection"%>
<%@page import="br.unibratec.web.ProcessarFormularioServlet"%>
<%@ page 
	language="java" 
	contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Tela de Consulta de Passageiros</title>
		
	</head>
	<body>
		<table border="1" width="70%">
			<tr>
				<th colspan="3">
					Consulta ao cadastro de Passageiros
				</thead>
			</tr>
			<tr>
				<th width="30%">
					CPF
				</th>
				<th width="60%">
					Nome:
				</th>
				<th width="10%">
					É portador de Necessidades Especiais?
				</th>
			</tr>
			<%
				Collection<Passageiro> resultSet = 
					(Collection<Passageiro>) request.getAttribute(ProcessarFormularioServlet.REQ_RESULTSET_PASSAGEIROS);
				
				if ( BibliotecaFuncoes.isColecaoValida(resultSet) ) {
					Iterator<Passageiro> iterator = resultSet.iterator();
					
					while ( iterator.hasNext() ) {
						Passageiro passageiro = iterator.next();
			%>
			<tr>
				<td>
					<%=passageiro.getCPF()%>
				</td>
				<td>
					<%=passageiro.getNome()%>
				</td>
				<td>
					<%=BibliotecaFuncoes.getBooleanComoSimOuNao(passageiro.isPortadorNecessidadesEspeciais())%>
				</td>
			</tr>
			<%
					}
				} else {
			%>
			<tr>
				<td colspan="3">
					Nenhum registro a ser exibido
				</td>
			</tr>
			<%
				}
			%>
		</table>
	</body>
</html>