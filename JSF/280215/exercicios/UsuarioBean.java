package br.dextra.managedbeans;

import javax.faces.bean.ManagedBean;

@ManagedBean
public class UsuarioBean {

	private String nome;
	private int idade;
	
	// Getters e Setters
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
