package br.unibratec.web;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class ProcessarFormularioServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6677691519208193772L;

	protected void service(HttpServletRequest pRequest, HttpServletResponse pResponse) throws ServletException, IOException {
		processarParametros(pRequest);
		processarCookie(pRequest, pResponse);
		processarAtributosNaSessao(pRequest);
		
		pRequest.getRequestDispatcher("htm/primeiroCadastro.html").forward(pRequest, pResponse);
	}
	
	/**
	 * Métodos de Sessão
	 * 
	 * Sessão permite armazenar dados de forma menos transiente.
	 * Atributos continuam existindo entre diferentes Requisições.
	 * 
	 * 
	 * setAttribute				- Insere um atributo na Sessão, com um nome e seu valor. O nome será utilizado para obter seu valor no futuro
	 * getAttribute				- Obtém o valor do Atributo da Sessão. Se nenhum atributo com o nome passado no argumento existir na Sessão, será retornado Null
	 * getAttributeNames		- Obtém um Enumeration<String> contendo os nomes de todos os Atributos contidos na Sessão
	 * getId					- Obtém o Identificador da Sessão. Este valor é definido pelo Container da Servlet, no nosso caso, o TomEE.
	 * 
	 * removeAttribute			- Remove o atributo pelo nome passado como argumento
	 * 
	 * setMaxInactiveInterval	- Define tempo (em Segundos) de inatividade, entre uma Requisição e outra, para Invalidar a Sessão
	 * 
	 * invalidate				- Invalida a sessão explicitamente
	 * 
	 * getCreationTime			- Obtem um Long para determinar a Data-Hora de criação da Sessão.
	 * 							= É uma boa ideia criar um método que invoque o método acima, para determinar se a Sessão está válida ou não
	 * 
	 * getLastAccessedTime		- Obtém um Long para determinar o momento em que o último acesso à Sessão foi feito 
	 * 
	 * 
	 * 
	 * @param pRequest
	 * 
	 * @throws	IllegalStateException	- Será lançada ao invocar qualquer um dos métodos acima, caso a Sessão esteja Inválida.
	 */
	private void processarAtributosNaSessao(HttpServletRequest pRequest) {
		/*
		 * O boolean passado como parâmetro indica se uma nova Sessão poderá ser criada
		 * Os cenários possíveis são os seguintes
		 *  - Se uma Sessão existir, esta será devolvida, independentemente do Booleano passado
		 *  - Se uma Sessão não existir ou tiver expirado:
		 *  -=- Se o Boolean for True, irá criar uma nova Sessão
		 *  -=- Se o Boolean for False, irá retornar Null, que deverá ser tratado pelo Desenvolvedor
		 */
		HttpSession sessao = pRequest.getSession(true);
		
		sessao.getLastAccessedTime();
		
		Enumeration<String> nmAtributosSessao = 
			sessao.getAttributeNames();
		while ( nmAtributosSessao != null && nmAtributosSessao.hasMoreElements() ) {
			String nmAtributoAtualSessao = nmAtributosSessao.nextElement();
			
			/*
			 * Os valores de Atributos na Sessão são Object's
			 * Permitem objetos mais complexos que somente Strings
			 */
			Object objetoSessao = sessao.getAttribute(nmAtributoAtualSessao);
			System.out.println("O valor do atributo " + nmAtributoAtualSessao + " na Sessão é: " + objetoSessao.toString());
		}
		
		
		// Adicionar Parametros do Request na Sessao
		
		/*
		 * Obtém os nomes de Todos os Parâmetros no Request
		 */
		Enumeration<String> nmParametrosRequest = pRequest.getParameterNames();
		while ( nmParametrosRequest != null && nmParametrosRequest.hasMoreElements() ) {
			String nmParametroAtualRequest = nmParametrosRequest.nextElement();
			String vlParametroAtual = pRequest.getParameter(nmParametroAtualRequest);
			
			sessao.setAttribute(nmParametroAtualRequest  + " na Sessão", vlParametroAtual + " na Sessão");
		}
		
		sessao.setAttribute("NomeDoAtributo", "Valor do Atributo colocado na Sessão");
	}
	
	/**
	 * Request/Requisições
	 * 
	 * Objetos transitam entre tela e Servlet são praticamente Transientes
	 * Se não forem armazenados em um campo no Formulário da tela, serão perdidos
	 * 
	 * @param pRequest
	 */
	private void processarParametros(HttpServletRequest pRequest) {
		Enumeration<String> nmParametros = pRequest.getParameterNames();
		
		if ( nmParametros != null && nmParametros.hasMoreElements() ) {
			System.out.println("O nomes dos campos foram recebidos com Sucesso");
			while ( nmParametros.hasMoreElements() ) {
				String nmParametroAtual = nmParametros.nextElement();
				
				/*
				 * Valores de Parâmetros no Request são sempre Strings!
				 */
				String vlParametroAtual = pRequest.getParameter(nmParametroAtual);
				System.out.println("O valor do parâmetro " + nmParametroAtual + " é igual a: " + vlParametroAtual);
			}
		} else {
			System.out.println("ProcessarFormularioServlet executado");
		}
	}

	private void processarCookie(HttpServletRequest pRequest, HttpServletResponse pResponse) {
		Cookie[] cookies = pRequest.getCookies();
		if ( cookies == null || cookies.length == 0 ) {
			gerarCookie(pResponse);
		} else {
			for (Cookie cookie : cookies) {
				System.out.println("Cookie: " + cookie.toString());
			}
		}
	}
	
	/**
	 * Objetivo
	 *  - Armazenar na máquina do Cliente informações úteis à aplicação
	 *  - Muito utilizados para guardar preferências dos usuários (Tracking)
	 *  - Quase um histórico de longo prazo
	 *  - É necessária preocupação por parte do Desenvovedor quanto à violações de Privacidade dos usuários
	 *  - É recomendável configurações de Segurança e Criptografia
	 *  
	 * @param pResponse
	 */
	private void gerarCookie( HttpServletResponse pResponse ) {
		Cookie cookieEhBom = new Cookie("PrimeiroCookie", "Valor do primeiro Cookie");
		
		/*
		 * Define tempo, em segundos, para que o Cookie expire
		 * Se um valor Negativo for usado, indicará que o Cookie será deletado quando o Navegador for fechado
		 * O Valor Zero irá deletar o Cookie
		 */
		cookieEhBom.setMaxAge(300);
		cookieEhBom.setComment("Comentário para o 1º Cookie");
		
		/*
		 * Define se o Cookie deverá ser enviado somente via protocolos seguros, 
		 * tais como HTTPS ou SSL
		 */
		cookieEhBom.setSecure(false);
		
		/*
		 * Evita que o Cookie seja exposto para Scripts do lado do cliente.
		 * O objetivo é evitar alguns ataques do tipo XSS (Cross-site Script)
		 */
		cookieEhBom.setHttpOnly(false);
		
		pResponse.addCookie(cookieEhBom);
	}
}