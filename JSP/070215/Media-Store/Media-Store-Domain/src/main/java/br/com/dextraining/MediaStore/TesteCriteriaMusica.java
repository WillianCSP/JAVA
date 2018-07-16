package br.com.dextraining.MediaStore;

import java.math.BigDecimal;
import java.util.List;

import br.com.dextraining.MediaStore.entities.Musica;
import br.com.dextraining.MediaStore.services.MusicaService;
import br.com.dextraining.MediaStore.util.EntityManagerUtil;

public class TesteCriteriaMusica {
	public static void main(String[] args) {
		EntityManagerUtil.connect();
		
		MusicaService service = new MusicaService();
		
		List<Musica> musicas = service.musicasComPrecoAcimaDe(new BigDecimal("1.90"));
		
		for (Musica musica : musicas) {
			System.out.println(musica);
		}
		
		EntityManagerUtil.closeConnection();
	}
}
