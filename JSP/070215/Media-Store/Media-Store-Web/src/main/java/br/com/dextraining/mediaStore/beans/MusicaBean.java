package br.com.dextraining.mediaStore.beans;

import java.util.ArrayList;
import java.util.List;

import br.com.dextraining.MediaStore.entities.Musica;
import br.com.dextraining.MediaStore.services.MusicaService;

public class MusicaBean {

	public MusicaBean() {
		// TODO Auto-generated constructor stub
	}
	
	private MusicaService musicaService = new MusicaService();
	
	private List<Musica> musicas;
	
	
	public void setMusicas(List<Musica> musicas) {
		this.musicas = musicas;
	}

	public List<Musica> getMusicas(){
		
		if(musicas == null){
			
			musicas = this.musicaService.findAll();
			
		}
		
		return musicas;
		
		
	}
	
	public String saudacao(String nome){
		return "Ola "+nome;
	}
}
