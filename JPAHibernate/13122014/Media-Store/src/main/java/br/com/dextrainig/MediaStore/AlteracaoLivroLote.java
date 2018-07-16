package br.com.dextrainig.MediaStore;

import java.math.BigDecimal;
import java.util.List;

import br.com.dextrainig.MediaStore.entidades.Livro;
import br.com.dextrainig.MediaStore.entidades.Musica;
import br.com.dextrainig.MediaStore.services.LivroService;
import br.com.dextrainig.MediaStore.util.EntityManagerUtil;

public class AlteracaoLivroLote {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		EntityManagerUtil.connect();
	       LivroService livroService = new LivroService();
	    	try{
	    	   
	    			livroService.reajustarPreco(new BigDecimal(1.10));
	    			List<Livro> livros = livroService.listarPorPreco();
		    		System.out.println("-- Livros ordenados por preço --");
		    		for(Livro l : livros){
		    		
		    			System.out.println(l);
		    		
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


