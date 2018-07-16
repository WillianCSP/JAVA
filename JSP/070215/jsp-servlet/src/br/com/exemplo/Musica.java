package br.com.exemplo;

public class Musica {

	public Musica() {
		// TODO Auto-generated constructor stub
	}
	
	private String nome;
	private String artista;
	
	
	public String getNome() {
		return nome;
	}
	
	public Musica(String nome, String artista) {
		super();
		this.nome = nome;
		this.artista = artista;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getArtista() {
		return artista;
	}
	public void setArtista(String artista) {
		this.artista = artista;
	}
}
