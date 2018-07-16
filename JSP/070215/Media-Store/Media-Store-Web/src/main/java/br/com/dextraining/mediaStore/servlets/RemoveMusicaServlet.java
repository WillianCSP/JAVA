package br.com.dextraining.mediaStore.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.dextraining.MediaStore.entities.Musica;
import br.com.dextraining.MediaStore.services.MusicaService;

/**
 * Servlet implementation class RemoveMusicaServlet
 */
@WebServlet("/RemoveMusicaServlet")
public class RemoveMusicaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RemoveMusicaServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String idString = request.getParameter("id");
		
		try{
			
		Long id= Long.valueOf(idString);
		MusicaService musicaService = new MusicaService();
		Musica musica = musicaService.findById(id);
		if(musica != null){
			musicaService.remove(musica);
		}
		
		}catch(Exception e){
			
		}
		
		response.sendRedirect("./musicas.jsp");
		
	}

}
