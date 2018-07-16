package br.com.dextrainig.MediaStore;

import java.util.List;

import br.com.dextrainig.MediaStore.entidades.Livro;
import br.com.dextrainig.MediaStore.entidades.Musica;
import br.com.dextrainig.MediaStore.services.LivroService;
import br.com.dextrainig.MediaStore.util.EntityManagerUtil;

public class Consultas {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		EntityManagerUtil.connect();
	       LivroService livroService = new LivroService();
	    	try{
	    	   
	    		List<Livro> livros = livroService.listarPorPreco();
	    		System.out.println("-- Livro ordenados por preço --");
	    		for(Livro l : livros){
	    		
	    			System.out.println(l);
	    		
	    		}
	    		
	    		
	    		List<Livro> livrosPorTitulo = livroService.buscarPorTitulo("1");
	    		System.out.println("-- Livro que contem 1--");
	    		for(Livro l : livrosPorTitulo){
	    		
	    			System.out.println(l);
	    		
	    		}
	    		
	    		
	    		
	       }finally{
	    	   EntityManagerUtil.closeConnection();
	    	   System.exit(0);
	       }
	    }
	}


