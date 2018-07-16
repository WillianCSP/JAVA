package br.com.dextraining.mediaStore.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.dextraining.MediaStore.services.MusicaService;

public class HelloWorldServlet extends HttpServlet{

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.getWriter().write("Hello Servlet! HHEEYY");
		resp.setStatus(HttpServletResponse.SC_OK);
		
		new MusicaService().findAll();
	}

}
