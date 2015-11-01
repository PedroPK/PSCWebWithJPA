package br.unibratec.linhasaereas.web.passageiro;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.unibratec.linhasaereas.util.passageiro.ConstantesPassageiro;

/**
 * Servlet implementation class PRCadastroPassageiro
 */
@WebServlet("/ServletPassageiro")
public class PRCadastroPassageiro extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public PRCadastroPassageiro() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	protected void service(HttpServletRequest pRequest, HttpServletResponse pResponse) throws ServletException, IOException {
		/*PrintWriter pw = pResponse.getWriter();
		StringBuffer sb = getFormularioPassageiroHTML();
		pw.println(sb.toString());
		pw.close();*/
		pRequest.getRequestDispatcher("htm/cadastroPassageiros.html").forward(pRequest, pResponse);
	}
	
	private StringBuffer gerarHTMLFormularioPassageiro() {
		StringBuffer sb = new StringBuffer();
		sb.append("<html>");
			sb.append("<body>");
				sb.append("<form action=\""+ ConstantesPassageiro.ID_Servlet_AdicionarPassageiro + "\">");
					sb.append("Nome <input type=\"text\" name=\"" + ConstantesPassageiro.ID_REQ_Nome +"\" /> <br/>");
					sb.append("CPF <input type=\"text\" name=\""+ ConstantesPassageiro.ID_REQ_CPF + "\" /> <br/>");
					sb.append("e-Mail <input type=\"text\" name=\"" + ConstantesPassageiro.ID_REQ_eMail + "\" /> <br/>");
					sb.append("Data de Nascimento <input type=\"text\" name=\"" + ConstantesPassageiro.ID_REQ_DataNascimento + "\" /> <br/>");
					sb.append("É portador de necessidades Especiais?");
					getRadiobuttonHTML(sb, "isPortadorNecessidadesEspeciais", ConstantesPassageiro.SIM, ConstantesPassageiro.NAO);
					sb.append("<input type=\"submit\" value=\"Adicionar\" />");
				sb.append("</form>");
				//sb.append("ServletPassageiro is working!");
			sb.append("</body>");
		sb.append("</html>");
		return sb;
	}
	
	private void getRadiobuttonHTML(StringBuffer sb, String pNome, String pValor01, String pValor02) {
		sb.append(ConstantesPassageiro.TAG_BR_QUEBRA_LINHA);
		sb.append(pValor01).append(": ").append("<input type=\"radio\" name=\"" + pNome + "\" value=\""+ pValor01 + "\">");
		sb.append(pValor02).append(": ").append("<input type=\"radio\" name=\"" + pNome + "\" value=\""+ pValor02 + "\">");
		sb.append(ConstantesPassageiro.TAG_BR_QUEBRA_LINHA);
	}
	
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	
}