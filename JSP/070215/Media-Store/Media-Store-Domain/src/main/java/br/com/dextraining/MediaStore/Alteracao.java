package br.com.dextraining.MediaStore;

import java.math.BigDecimal;

import br.com.dextraining.MediaStore.entities.Musica;
import br.com.dextraining.MediaStore.services.MusicaService;
import br.com.dextraining.MediaStore.util.EntityManagerUtil;

public class Alteracao {
	public static void main(String[] args) {
		EntityManagerUtil.connect();
		MusicaService musicaService = new MusicaService();
		try {
			// Achar uma entidade ja existente
			Musica musica = musicaService.findById(2L);
			
			// Alterar um ou mais campos
			musica.setPreco(musica.getPreco().multiply(
					new BigDecimal(1.15)));

			// Salvar no banco
			musicaService.update(musica);
			
		} finally {
			EntityManagerUtil.closeConnection();
			System.exit(0);
		}
	}
}
