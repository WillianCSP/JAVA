package br.com.dextrainig.MediaStore;

import java.math.BigDecimal;

import br.com.dextrainig.MediaStore.entidades.Livro;
import br.com.dextrainig.MediaStore.services.LivroService;
import br.com.dextrainig.MediaStore.util.EntityManagerUtil;


public class InserirLivro 
{
    public static void main( String[] args )
    {
    	EntityManagerUtil.connect();
       LivroService livroService = new LivroService();
    	try{
    	    
    		Livro l = new Livro();
    		l.setAutor("Autor 3");
    		l.setIsbn("33333333333");
    		l.setPaginas(450);
    		l.setTitulo("Livro 3");
    		l.setPreco(new BigDecimal(250));
    		livroService.persist(l);
    		
    		System.out.println(l);
       }finally{
    	   EntityManagerUtil.closeConnection();
    	   System.exit(0);
       }
    }
}
