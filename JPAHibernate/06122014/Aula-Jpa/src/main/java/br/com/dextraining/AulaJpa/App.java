package br.com.dextraining.AulaJpa;

import java.util.List;

import util.EntityManagerUtil;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	
    	try{
    		
    		 EntityManagerUtil.connect();
    	        
//    	        Pessoa p = new Pessoa();
//    	        p.setId(2L);
//    	        p.setNome("Pessoa Teste");
//    	        
    	     PessoaService service = new PessoaService();
//    	     service.inserirPessoa(p);
//    		System.out.println("Pessoa Inserida");
//    		
//    	     Pessoa p = service.buscarPorId(1L);
//    		 System.out.println(p.getNome());
    	     
//    	     List<Pessoa> pessoas = service.listarTodos();
//
//    	     for(Pessoa pessoa: pessoas){
//    	    	 System.out.println(pessoa.getNome());
//    	     }
    	     
    	     List<Pessoa> pessoas = service.buscarPorNome("z");

    	     for(Pessoa pessoa: pessoas){
    	    	 System.out.println(pessoa.getNome());
    	     }
    		
    	}finally{
    		  EntityManagerUtil.closeConnection();
    		  System.exit(0);
    	}
    	
       
        
      
    }
}
