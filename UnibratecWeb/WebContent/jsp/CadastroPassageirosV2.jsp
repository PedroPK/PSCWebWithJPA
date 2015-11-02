<%@page import="br.unibratec.web.ProcessarFormularioServlet"%>
<%@page import="br.unibratec.util.BibliotecaFuncoes"%>

<%@page 
	language="java" 
	contentType="text/html; charset=UTF-8" 
	pageEncoding="UTF-8"
	isELIgnored="false"
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<%
			String tituloTela = (String) request.getAttribute(ProcessarFormularioServlet.REQ_PARAMETRO_TITULO_TELA);
			if ( !BibliotecaFuncoes.isStringValida(tituloTela) ) {
				tituloTela = "Título Padrão";
			}
		%>
		<title>Unibratec - PSC - ${NM_REQ_PARAMETRO_TITULO_TELA} </title>
		<!-- title>Unibratec - PSC - <%=tituloTela%> </title -->
		
		<script type="text/javascript">
			function salvar() {
				definirEventoSubmissaoFormulario("<%=ProcessarFormularioServlet.EVENTO_SALVAR%>");
			}
			function consultar() {
				definirEventoSubmissaoFormulario("<%=ProcessarFormularioServlet.EVENTO_CONSULTAR%>");
			}
			function definirEventoSubmissaoFormulario(pEvento) {
				document.forms[0].<%=ProcessarFormularioServlet.REQ_EVENTO_SUBMISSAO_FORMULARIO%>.value = pEvento;
			}
		</script>
	</head>
	<body>
		<form 
			method="post">
			
			<input 
				type="hidden" 
				name="<%=ProcessarFormularioServlet.REQ_EVENTO_SUBMISSAO_FORMULARIO%>" 
				id="<%=ProcessarFormularioServlet.REQ_EVENTO_SUBMISSAO_FORMULARIO%>" 
				value="EventoPadrao" >
			
			<table>
				<!-- Cabeçalho do Formulário -->
				<th colspan="2">
					Cadastro de Passageiros - <%=getLastModified(request)%>
				</th>
				<tr>
					<td>Nome:</td>
					<td>
						<input
							type="text" 
							id="<%=ProcessarFormularioServlet.NM_REQ_NOME%>" 
							name="<%=ProcessarFormularioServlet.NM_REQ_NOME%>"
						/>
					</td>
				</tr>
				<tr>
					<td>e-Mail:</td>
					<td>
						<input type="text"
							id="<%=ProcessarFormularioServlet.NM_REQ_EMAIL%>" 
							name="<%=ProcessarFormularioServlet.NM_REQ_EMAIL%>"
						/>
					</td>
				</tr>
				<tr>
					<td>CPF:</td>
					<td>
						<input 
							type="text" 
							id="<%=ProcessarFormularioServlet.NM_REQ_CPF%>"
							name="<%=ProcessarFormularioServlet.NM_REQ_CPF%>"
						/>
					</td>
				</tr>
				<tr>
					<td>Data de Nascimento:</td>
					<td>
						<input 
							type="text"
							id="<%=ProcessarFormularioServlet.NM_REQ_DT_NASCIMENTO%>" 
							name="<%=ProcessarFormularioServlet.NM_REQ_DT_NASCIMENTO%>"
						/>
					</td>
				</tr>
				<tr>
					<td>É Portador de Necessidades Especiais?</td>
					<td>
						Sim: <input 
								type="radio"
								id="<%=ProcessarFormularioServlet.NM_REQ_IS_PORTADOR_NECESSIDADES_ESPECIAIS%>" 
								name="<%=ProcessarFormularioServlet.NM_REQ_IS_PORTADOR_NECESSIDADES_ESPECIAIS%>" 
								value="true" />
						<br/>
						Não: <input 
								type="radio"
								id="<%=ProcessarFormularioServlet.NM_REQ_IS_PORTADOR_NECESSIDADES_ESPECIAIS%>" 
								name="<%=ProcessarFormularioServlet.NM_REQ_IS_PORTADOR_NECESSIDADES_ESPECIAIS%>" 
								value="false" />
					</td>
				</tr>
				<tr >
					<td colspan="2">
						<input type="submit" value="Salvar" onclick="salvar()" onkeydown="salvar()" />
						<input type="submit" value="Consultar" onclick="consultar()" onkeydown="consultar()" />
					</td>
				</tr>
			</table>
		</form>
	</body>
</html>