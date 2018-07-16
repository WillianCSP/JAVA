package br.com.dextraining.mediaStore.servlets;

import java.io.IOException;
import java.math.BigDecimal;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.dextraining.MediaStore.entities.Musica;
import br.com.dextraining.MediaStore.services.MusicaService;

/**
 * Servlet implementation class CadastroMusicaServlet
 */
@WebServlet("/CadastroMusicaServlet")
public class CadastroMusicaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private MusicaService musicaService = new MusicaService();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CadastroMusicaServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try{
		
			String nome = request.getParameter("nome");
		BigDecimal preco = new BigDecimal(request.getParameter("preco"));
		Integer duracao = Integer.valueOf(request.getParameter("duracao"));
		
		Musica musica = new Musica();
		
		musica.setNome(nome);
		musica.setPreco(preco);
		musica.setDuracao(duracao);
		
		musicaService.persist(musica);
		response.sendRedirect("./musicas.jsp");
		}catch(Exception e){
			e.printStackTrace();
			RequestDispatcher dispatcher = request.getRequestDispatcher("./cadastroMusica.jsp");
			dispatcher.forward(request, response);
			
		}
	}

}
