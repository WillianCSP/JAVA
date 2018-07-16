package br.com.dextraining.MediaStore;

import java.math.BigDecimal;
import java.util.List;

import br.com.dextraining.MediaStore.entities.Musica;
import br.com.dextraining.MediaStore.services.MusicaService;
import br.com.dextraining.MediaStore.util.EntityManagerUtil;

public class AlteracaoLote {
	public static void main(String[] args) {
		EntityManagerUtil.connect();
		MusicaService musicaService = new MusicaService();
		try {
			musicaService.reajustarPreco(new BigDecimal(1.10));
			List<Musica> musicas = musicaService.listarPorPreco(10, 1);
			for (Musica musica : musicas) {
				System.out.println(musica.getNome() + 
						" - R$" + musica.getPreco());
			}
		} catch (RuntimeException e) {
			e.printStackTrace();
		} finally {
			EntityManagerUtil.closeConnection();
			System.exit(0);
		}
	}
}
