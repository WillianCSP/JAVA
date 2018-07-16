package br.com.dextrainig.MediaStore;

import java.math.BigDecimal;

import br.com.dextrainig.MediaStore.entidades.Livro;
import br.com.dextrainig.MediaStore.services.LivroService;
import br.com.dextrainig.MediaStore.util.EntityManagerUtil;

public class AlteracaoLivro {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		EntityManagerUtil.connect();
	       LivroService livroService = new LivroService();
	    	try{
	    	   
	    		Livro l = new Livro();
	    		l = livroService.findById(2L);
	    		l.setPreco(l.getPreco().multiply(new BigDecimal(1.10)));
	    		livroService.update(l);
	    		
	    		System.out.println(l);
	   
	    	
	    	}finally{
	    	   EntityManagerUtil.closeConnection();
	    	   System.exit(0);
	       }
		
	}

}
