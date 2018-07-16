package br.com.dextrainig.MediaStore;

import java.math.BigDecimal;

import br.com.dextrainig.MediaStore.entidades.Musica;
import br.com.dextrainig.MediaStore.services.MusicaService;
import br.com.dextrainig.MediaStore.util.EntityManagerUtil;

public class Alteracao {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		EntityManagerUtil.connect();
	       MusicaService musicaService = new MusicaService();
	    	try{
	    	   
	    		Musica m = new Musica();
	    		m = musicaService.findById(2L);
	    		m.setPreco(m.getPreco().multiply(new BigDecimal(1.10)));
	    		musicaService.update(m);
	    		
	    		System.out.println(m);
	   
	    	
	    	}finally{
	    	   EntityManagerUtil.closeConnection();
	    	   System.exit(0);
	       }
		
	}

}
