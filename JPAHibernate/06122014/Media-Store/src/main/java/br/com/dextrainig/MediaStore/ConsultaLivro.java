package br.com.dextrainig.MediaStore;

import java.util.List;

import br.com.dextrainig.MediaStore.entidades.Musica;
import br.com.dextrainig.MediaStore.services.MusicaService;
import br.com.dextrainig.MediaStore.util.EntityManagerUtil;

public class ConsultaLivro {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		EntityManagerUtil.connect();
	       MusicaService musicaService = new MusicaService();
	    	try{
	    	   
	    		List<Musica> musicas = musicaService.listarPorPreco();
	    		System.out.println("-- Musicas ordenadas por preço --");
	    		for(Musica m : musicas){
	    		
	    			System.out.println(m);
	    		
	    		}
	    		
	    		
	    		List<Musica> musicasPorNome = musicaService.buscarPorNome("1");
	    		System.out.println("-- Musicas que contem 1--");
	    		for(Musica m : musicasPorNome){
	    		
	    			System.out.println(m);
	    		
	    		}
	    		
	    		
	    		
	       }finally{
	    	   EntityManagerUtil.closeConnection();
	    	   System.exit(0);
	       }
	    }
	}


