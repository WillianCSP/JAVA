package br.com.dextra.livraria.bean;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import br.com.dextra.livraria.dao.AutorDao;
import br.com.dextra.livraria.modelo.Autor;

@Stateless
public class AutorService {

	@Inject 
	AutorDao dao;
	
	public void adiciona(Autor autor) throws LivrariaException {
//	public void adiciona(Autor autor) {
		
		// pode conter mais regras
		dao.salva(autor);
		
		// Alguma regra de negocio vai lancar deu pau!
//		throw new LivrariaException();
		
	}

	public List<Autor> todosAutores() {
		return dao.todosAutores();
	}
	
	
}
