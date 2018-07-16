package br.com.dextraining.MediaStore;

import java.math.BigDecimal;

import br.com.dextraining.MediaStore.entities.Musica;
import br.com.dextraining.MediaStore.services.MusicaService;
import br.com.dextraining.MediaStore.util.EntityManagerUtil;

public class InclusaoMusica {
	public static void main(String[] args) {
		EntityManagerUtil.connect();
		MusicaService musicaService = new MusicaService();
		try {
			Musica m = new Musica();
			m.setId(1L);
			m.setNome("Faixa 1");
			m.setPreco(new BigDecimal(0.29));
			m.setDuracao(320);
			
			musicaService.persist(m);
			
			System.out.println(m);
			
		} finally {
			EntityManagerUtil.closeConnection();
			System.exit(0);
		}
		
		
	}
}
