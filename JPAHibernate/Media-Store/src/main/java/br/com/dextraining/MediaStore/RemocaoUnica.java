package br.com.dextraining.MediaStore;

import br.com.dextraining.MediaStore.entities.Musica;
import br.com.dextraining.MediaStore.services.MusicaService;
import br.com.dextraining.MediaStore.util.EntityManagerUtil;

public class RemocaoUnica {
	public static void main(String[] args) {
		EntityManagerUtil.connect();
		MusicaService musicaService = new MusicaService();
		try {
			//Buscar uma musica
			Musica musica = musicaService.findById(1L);
			
			//Remover
			musicaService.remove(musica);
		} catch (RuntimeException e) {
			e.printStackTrace();
		} finally {
			EntityManagerUtil.closeConnection();
			System.exit(0);
		}
	}
}
