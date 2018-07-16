package br.com.dextra.livraria.bean;

import javax.faces.bean.ManagedBean;

@ManagedBean(name="autorBean")
public class AutorBean {

	private Autor autor = new Autor("AAA");

	public String gravar(){
		
		System.out.println("Gravando .........");
		System.out.println("Autor: "+this.autor.getNome());
		return null;
	}

	public Autor getAutor() {
		return autor;
	}

	public void setAutor(Autor autor) {
		this.autor = autor;
	}

	
	
}