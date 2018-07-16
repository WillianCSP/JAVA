package br.com.dextra.livraria.bean;

import java.util.List;

import javax.enterprise.inject.Model;
import javax.inject.Inject;

import br.com.dextra.livraria.dao.AutorDao;
import br.com.dextra.livraria.modelo.Autor;

@Model
public class AutorBean {
	
	@Inject
	private Autor autor;
	
	@Inject
	//private AutorDao dao;
	private AutorService service;
	
	public Autor getAutor() {
		return autor;
	}
	
	public void cadastra() throws LivrariaException {
//	public void cadastra() {
		this.service.adiciona(autor);
		this.autor = new Autor();
	}
	
	public List<Autor> getAutores() {
		return this.service.todosAutores();
	}
}
