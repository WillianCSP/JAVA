package br.com.dextrainig.MediaStore;

import java.math.BigDecimal;

import br.com.dextrainig.MediaStore.entidades.Cliente;
import br.com.dextrainig.MediaStore.services.ClienteService;
import br.com.dextrainig.MediaStore.util.EntityManagerUtil;


public class InserirCliente 
{
    public static void main( String[] args )
    {
    	EntityManagerUtil.connect();
       ClienteService clienteService = new ClienteService();
    	try{
    	   
    		Cliente c = new Cliente();
    		c.setNome("Cliente 1");
    		c.setCpf("111111");
//    		c.setEndereco("aaaa");
    		c.setEmail("aaa@aaa");
    		clienteService.persist(c);
    		
    		System.out.println(c);
       }finally{
    	   EntityManagerUtil.closeConnection();
    	   System.exit(0);
       }
    }
}
