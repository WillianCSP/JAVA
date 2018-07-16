package br.com.dextrainig.MediaStore;

import java.math.BigDecimal;
import java.util.List;

import br.com.dextrainig.MediaStore.entidades.Musica;
import br.com.dextrainig.MediaStore.services.MusicaService;
import br.com.dextrainig.MediaStore.util.EntityManagerUtil;

public class Remove {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		EntityManagerUtil.connect();
	       MusicaService musicaService = new MusicaService();
	    	try{
	    	   
//	    		Musica m = new Musica();
//	    		m = musicaService.findById(5L);
	    		int n = musicaService.removerMusicasBaratas(new BigDecimal(1));
	    		System.out.println("Qtde deletadas:"+n);
	    		List<Musica> musicas = musicaService.listarPorPreco();
	    		System.out.println("-- Musicas ordenadas por preço --");
	    		for(Musica m : musicas){
	    		
	    			System.out.println(m);
	    		
	    		}
	    		
	    	}catch(Exception e){
	    		e.printStackTrace();
	    	}
	    	
	    	finally{
	    	   EntityManagerUtil.closeConnection();
	    	   System.exit(0);
	       }
		
	}

}
