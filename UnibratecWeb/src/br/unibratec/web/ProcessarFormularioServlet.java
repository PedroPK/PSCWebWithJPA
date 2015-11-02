package br.unibratec.web;

import java.io.IOException;
import java.util.Collection;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.unibratec.linhasaereas.entidades.Passageiro;
import br.unibratec.linhasaereas.fachada.FachadaLinhasAereas;
import br.unibratec.linhasaereas.fachada.IFachadaLinhasAereas;
import br.unibratec.linhasaereas.util.passageiro.ConstantesPassageiro;
import br.unibratec.util.BibliotecaFuncoes;
import br.unibratec.util.UtilJPA;

@WebServlet("/ProcessarFormulario")
public class ProcessarFormularioServlet extends HttpServlet {
	
	public static final String EVENTO_SALVAR = "EVENTO_SALVAR";
	public static final String EVENTO_CONSULTAR = "EVENTO_CONSULTAR";
	
	public static final String REQ_EVENTO_SUBMISSAO_FORMULARIO = "REQ_EVENTO_SUBMISSAO_FORMULARIO";
	public static final String REQ_PARAMETRO_TITULO_TELA = "REQ_PARAMETRO_TITULO_TELA";
	public static final String REQ_RESULTSET_PASSAGEIROS = "REQ_RESULTSET_PASSAGEIROS";
	
	public static final String NM_REQ_NOME									= ConstantesPassageiro.ID_REQ_Nome;
	public static final String NM_REQ_EMAIL									= ConstantesPassageiro.ID_REQ_eMail;
	public static final String NM_REQ_CPF									= ConstantesPassageiro.ID_REQ_CPF;
	public static final String NM_REQ_DT_NASCIMENTO							= ConstantesPassageiro.ID_REQ_DataNascimento;
	public static final String NM_REQ_IS_PORTADOR_NECESSIDADES_ESPECIAIS	= ConstantesPassageiro.ID_REQ_IsPortadorNecessidadesEspeciais;
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -6677691519208193772L;
	
	public void init(
		HttpServletRequest		pRequest,
		HttpServletResponse		pResponse
	) {
		UtilJPA.createEntityManagerFactory();
	}

	protected void service(
		HttpServletRequest pRequest, 
		HttpServletResponse pResponse) 
	throws ServletException, IOException {
		if ( isMetodoDoPost(pRequest) ) {
			doPost(pRequest, pResponse);
		} else {
			//pRequest.setAttribute(NM_REQ_PARAMETRO_TITULO_TELA, "Tela de Início");
			redirecionar_CadastroPassageirosJSP(pRequest, pResponse);
		}
	}
	
	private boolean isMetodoDoPost(HttpServletRequest pRequest) {
		return pRequest.getMethod().equalsIgnoreCase("POST");
	}
	
	private void redirecionar_CadastroPassageirosJSP(HttpServletRequest pRequest, HttpServletResponse pResponse)
	throws ServletException, IOException {
		redirecionarJSP(pRequest, pResponse, "jsp/CadastroPassageirosV2.jsp");
	}
	
	private void redirecionar_ConsultarPassageirosJSP(HttpServletRequest pRequest, HttpServletResponse pResponse)
	throws ServletException, IOException {
		redirecionarJSP(pRequest, pResponse, "jsp/ConsultarPassageirosV2.jsp");
	}

	private void redirecionarJSP(HttpServletRequest pRequest, HttpServletResponse pResponse, String pArquivoJSP)
			throws ServletException, IOException {
		pRequest
			.getRequestDispatcher(pArquivoJSP)
			.forward(pRequest, pResponse);
	}
	
	protected void doPost(HttpServletRequest pRequest, HttpServletResponse pResponse) throws ServletException, IOException {
		/*processarParametros(pRequest);
		processarCookie(pRequest, pResponse);
		processarAtributosNaSessao(pRequest);*/
		
		String evento = pRequest.getParameter(REQ_EVENTO_SUBMISSAO_FORMULARIO);
		if ( evento.equals(EVENTO_CONSULTAR) ) {
			consultarPassageiros(pRequest);
			
			redirecionar_ConsultarPassageirosJSP(pRequest, pResponse);
		} else {
			if ( evento.equals(EVENTO_SALVAR) ) {
				String nome								= pRequest.getParameter(ConstantesPassageiro.ID_REQ_Nome);
				String email							= pRequest.getParameter(ConstantesPassageiro.ID_REQ_eMail);
				String cpf 								= pRequest.getParameter(ConstantesPassageiro.ID_REQ_CPF);
				String dataNascimento					= pRequest.getParameter(ConstantesPassageiro.ID_REQ_DataNascimento);
				String isPortadorNecessidadesEspeciais	= pRequest.getParameter(ConstantesPassageiro.ID_REQ_IsPortadorNecessidadesEspeciais);
				
				if ( 
						BibliotecaFuncoes.isStringValida(nome)				&&
						BibliotecaFuncoes.isStringValida(email)				&&
						BibliotecaFuncoes.isStringValida(cpf)				&&
						BibliotecaFuncoes.isStringValida(dataNascimento)		
				) {
					IFachadaLinhasAereas fachada = new FachadaLinhasAereas();
					fachada.inserirPassageiro(
						nome,
						cpf,
						email,
						dataNascimento,
						isPortadorNecessidadesEspeciais
					);
				}
				
				consultarPassageiros(pRequest);
				
				redirecionar_ConsultarPassageirosJSP(pRequest, pResponse);
			} else {
				redirecionar_CadastroPassageirosJSP(pRequest, pResponse);
			}
		}
		
		// 1º Cadastrar um novo Passageiro na Base de Dados
		
		// 2º Consultar a Base de Dados, redirecionar para uma outra JSP, que irá exibir o ResultSet
	}

	private void consultarPassageiros(HttpServletRequest pRequest) {
		IFachadaLinhasAereas fachada = new FachadaLinhasAereas();
		Collection<Passageiro> passageiros = fachada.consultar();
		
		pRequest.setAttribute(REQ_RESULTSET_PASSAGEIROS, passageiros);
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
		
		
		boolean isSessaoValida = isSessaoValida(sessao);
		
		String idSessao = sessao.getId();
		sessao.setMaxInactiveInterval(300);
		
		Enumeration<String> nmAtributosSessao = sessao.getAttributeNames();
		
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

	private boolean isSessaoValida(HttpSession pSessao) {
		boolean isSessaoValida = true;
		try {
			pSessao.getLastAccessedTime();
		}
		catch ( IllegalStateException iee ) {
			isSessaoValida = false;
		}
		return isSessaoValida;
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
		if ( cookies == null || cookies.length < 2 ) {
			gerarCookie(pResponse);
			System.out.println("Cookie foi gerado.");
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
		cookieEhBom.setMaxAge(30);
		cookieEhBom.setComment("Comentario para o primeiro Cookie");
		
		/*
		 * Define se o Cookie deverá ser enviado somente via protocolos seguros, 
		 * tais como HTTPS ou SSL
		 */
		cookieEhBom.setSecure(false);
		
		/*
		 * Evita que o Cookie seja exposto para Scripts do lado do cliente.
		 * O objetivo é evitar alguns ataques do tipo XSS (Cross-site Script)
		 */
		cookieEhBom.setHttpOnly(true);
		
		pResponse.addCookie(cookieEhBom);
	}
}