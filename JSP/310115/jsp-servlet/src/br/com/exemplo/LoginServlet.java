package br.com.exemplo;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String usuario = request.getParameter("nome-usuario");
		String senha = request.getParameter("senha");
		
		LoginService loginService = new LoginService();
		if(loginService.autenticar(usuario,senha)){
			request.getSession().setAttribute(loginService.ATRIBUTO_USUARIO, usuario);
			response.sendRedirect("./meu-servlet");
		}else{
			response.sendRedirect("./index.html");
		}
	}

}
