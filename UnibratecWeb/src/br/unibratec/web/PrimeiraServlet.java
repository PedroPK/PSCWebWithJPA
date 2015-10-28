package br.unibratec.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class PrimeiraServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5233986402572961975L;
	
	private void getMetodo(HttpServletRequest pRequest) {
		System.out.println( pRequest.getMethod() );
	}

	private void gerarHTML(HttpServletResponse pResponse) throws IOException {
		PrintWriter pw = pResponse.getWriter();
		pw.println("<html>");
			pw.println("<head>");
				pw.println("<title>");
					pw.println("Título da Página");
				pw.println("</title>");
			pw.println("</head>");
			pw.println("<body>");
				pw.println("Conteúdo da Página");
				pw.println("<form method='get'>");
					pw.println("<input type='text' name='campo' id='campo' size='16' maxlength='6' placeholder='Preencha aqui' />");
					pw.println("<br>");
					pw.println("<input type='submit' value='Submeter' />");
				pw.println("</form>");
			pw.println("</body>");
		pw.println("</html>");
	}

	private void getCampo(HttpServletRequest pRequest) {
		String campo = pRequest.getParameter("campo");
		if ( campo != null ) {
			System.out.println("service() " + campo);
		}
	}
	
	protected void service(HttpServletRequest pRequest, HttpServletResponse pResponse) throws ServletException, IOException {
		getCampo(pRequest);
		gerarHTML(pResponse);
		getMetodo(pRequest);
		System.out.println("service() executado");
	}
	
	protected void doPost(HttpServletRequest pRequest, HttpServletResponse pResponse) throws ServletException, IOException {
		getCampo(pRequest);
		gerarHTML(pResponse);
		getMetodo(pRequest);
		System.out.println("doPost executado");
	}
	
	protected void doGet(HttpServletRequest pRequest, HttpServletResponse pResponse) throws ServletException, IOException {
		getCampo(pRequest);
		gerarHTML(pResponse);
		getMetodo(pRequest);
		System.out.println("doGet executado");
	}

}