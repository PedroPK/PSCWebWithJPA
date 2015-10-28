package br.unibratec.linhasaereas.web.passageiro;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.unibratec.linhasaereas.fachada.FachadaLinhasAereas;
import br.unibratec.linhasaereas.fachada.IFachadaLinhasAereas;
import br.unibratec.linhasaereas.util.passageiro.ConstantesPassageiro;
import br.unibratec.util.BibliotecaFuncoes;

/**
 * Servlet implementation class AdicionarPassageiro
 */
@WebServlet("/AdicionarPassageiro")
public class PRAdicionarPassageiro extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public PRAdicionarPassageiro() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	protected void service(HttpServletRequest pRequest, HttpServletResponse pResponse) throws ServletException, IOException {
		PrintWriter pw = pResponse.getWriter();
		
		String nome								= pRequest.getParameter(ConstantesPassageiro.ID_REQ_Nome);
		String email							= pRequest.getParameter(ConstantesPassageiro.ID_REQ_eMail);
		String cpf 								= pRequest.getParameter(ConstantesPassageiro.ID_REQ_CPF);
		String dataNascimento					= pRequest.getParameter(ConstantesPassageiro.ID_REQ_DataNascimento);
		String isPortadorNecessidadesEspeciais	= pRequest.getParameter(ConstantesPassageiro.ID_REQ_IsPortadorNecessidadesEspeciais);
		
		StringBuffer sb;
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
			
			sb = getMensagemHTML("Passageiro criado com sucesso!");
		} else {
			sb = getMensagemHTML("Dados para criação de Passageiro inconsistentes");
		}
		
		//RequestDispatcher rd = pRequest.getRequestDispatcher("/visualizar.jsp");
		//rd.forward(pRequest, pResponse);
		
		
		pw.println(sb.toString());
		pw.close();
	}

	private StringBuffer getMensagemHTML(String pMensagem) {
		StringBuffer sb = new StringBuffer();
		sb.append(ConstantesPassageiro.HTML_TAG_INICIO);
		sb.append(ConstantesPassageiro.BODY_TAG_INICIO);
		sb.append(pMensagem);
		sb.append(ConstantesPassageiro.BODY_TAG_FIM);
		sb.append(ConstantesPassageiro.HTML_TAG_FIM);
		return sb;
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
