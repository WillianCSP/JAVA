package br.com.dextrainig.MediaStore;

import java.math.BigDecimal;

import br.com.dextrainig.MediaStore.entidades.Musica;
import br.com.dextrainig.MediaStore.services.MusicaService;
import br.com.dextrainig.MediaStore.util.EntityManagerUtil;


public class App 
{
    public static void main( String[] args )
    {
    	EntityManagerUtil.connect();
       MusicaService musicaService = new MusicaService();
    	try{
    	   
    		Musica m = new Musica();
    		m.setNome("Faixa 7");
    		m.setPreco(new BigDecimal(0.59));
    		m.setDuracao(20);
    		
    		musicaService.persist(m);
    		
    		System.out.println(m);
       }finally{
    	   EntityManagerUtil.closeConnection();
    	   System.exit(0);
       }
    }
}
