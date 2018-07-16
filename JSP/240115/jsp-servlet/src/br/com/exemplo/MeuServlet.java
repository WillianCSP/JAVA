package br.com.exemplo;

import java.io.IOException;
import java.util.Date;
import java.util.concurrent.atomic.AtomicInteger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
		this.contador= new AtomicInteger(0);
		
		
	}
	
	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		super.destroy();
		this.contador = null;
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int contagemAtual = this.contador.getAndIncrement();
		System.out.println("cont = "+contagemAtual);
		
		String nome = request.getParameter("nome");
		int idade = 0;
		try{
		
			idade = Integer.parseInt(request.getParameter("idade"));
		
		}catch(Exception e ){
			
			
		}
		
		if(nome != null && idade >0){
			response.getWriter().print("<html><body><h1>Meu Servlet</h1><p>"+nome+"-"+idade+"-</p></body></html>" +new Date());
		}else{
			response.sendError(HttpServletResponse.SC_BAD_REQUEST);
		}
		
		}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String nomeUsuario = request.getParameter("nome-usuario");
		response.getWriter().print("<html><body><h1>Meu Servlet</h1><p>Bem vindo: " +nomeUsuario
				+ "</p></body></html>" );
	}

}
