package br.com.dextra.livraria.bean;

import javax.faces.bean.ManagedBean;

@ManagedBean
public class UsuarioBean {

	
	private String nome;
	
	private int idade;

	
	public String gravar(){
		
		return "usuario";
	}
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getIdade() {
		return idade;
	}

	public void setIdade(int idade) {
		this.idade = idade;
	}
}
