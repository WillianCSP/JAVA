package br.com.exemplo;

import java.io.IOException;
import java.util.Date;
import java.util.concurrent.atomic.AtomicInteger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class MeuServlet
 */
@WebServlet({ "/MeuServlet", "/meu-servlet" })
public class MeuServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private AtomicInteger contador;

	@Override
	public void init() throws ServletException {
		// TODO Auto-generated method stub
		super.init();
		this.contador = new AtomicInteger(0);

	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		super.destroy();
		this.contador = null;
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		int contagemAtual = this.contador.getAndIncrement();
		System.out.println("cont = " + contagemAtual);

		String nome = request.getParameter("nome");
		int idade = 0;
		try {

			idade = Integer.parseInt(request.getParameter("idade"));

		} catch (Exception e) {

		}

		if (nome != null && idade > 0) {
			
			adicionarContadorNaSessao(request);
			RequestDispatcher dispatcher = request
					.getRequestDispatcher("/pagina.jsp");
			
			dispatcher.forward(request, response);
			
		} else {
			response.sendError(HttpServletResponse.SC_BAD_REQUEST);
		}

	}

	private void adicionarContadorNaSessao(HttpServletRequest request) {
		// TODO Auto-generated method stub
		HttpSession sessao = request.getSession();
		Object nullCheck = sessao.getAttribute("atribute");
		Integer contagemAtual = 0;
		if(nullCheck != null){
			contagemAtual = (Integer) nullCheck;
			
		}
		contagemAtual++;
		sessao.setAttribute("contador", contagemAtual);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

			response.sendRedirect("./bem-vindo.jsp?nome-usuario="+request.getParameter("nome-usuario"));
			
	}
	
	

}
