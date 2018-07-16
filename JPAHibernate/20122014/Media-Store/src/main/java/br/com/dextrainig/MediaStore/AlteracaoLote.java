package br.com.dextrainig.MediaStore;

import java.math.BigDecimal;
import java.util.List;

import br.com.dextrainig.MediaStore.entidades.Musica;
import br.com.dextrainig.MediaStore.services.MusicaService;
import br.com.dextrainig.MediaStore.util.EntityManagerUtil;

public class AlteracaoLote {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		EntityManagerUtil.connect();
	       MusicaService musicaService = new MusicaService();
	    	try{
	    	   
	    			musicaService.reajustarPreco(new BigDecimal(1.10));
	    			List<Musica> musicas = musicaService.listarPorPreco();
		    		System.out.println("-- Musicas ordenadas por preço --");
		    		for(Musica m : musicas){
		    		
		    			System.out.println(m);
		    		
		    		}
	   
	    	
	    	}catch(RuntimeException e){
	    		
	    		e.printStackTrace();
	    		}
	    	finally{
	    	   EntityManagerUtil.closeConnection();
	    	   System.exit(0);
	       }
		
	}

	}


