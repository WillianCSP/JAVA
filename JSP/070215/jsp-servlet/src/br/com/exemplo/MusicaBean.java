package br.com.exemplo;

import java.util.ArrayList;
import java.util.List;

public class MusicaBean {

	public MusicaBean() {
		// TODO Auto-generated constructor stub
	}
	
	private List<Musica> musicas;
	
	
	public List<Musica> getMusicas(){
		
		if(musicas == null){
			
			musicas = new ArrayList<Musica>();
			
			musicas.add(new Musica("Mirror Mirror","Blind Guardian"));
			musicas.add(new Musica("Lepo Lepo","Psirico"));
			musicas.add(new Musica("Smoke on the water","Deep Purple"));
			
			
		}
		
		return musicas;
		
		
	}
	
	public String saudacao(String nome){
		return "Ola "+nome;
	}
}
