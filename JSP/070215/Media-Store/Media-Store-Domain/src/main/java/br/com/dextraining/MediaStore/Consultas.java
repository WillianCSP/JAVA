package br.com.dextraining.MediaStore;

import java.util.List;

import br.com.dextraining.MediaStore.entities.Musica;
import br.com.dextraining.MediaStore.services.MusicaService;
import br.com.dextraining.MediaStore.util.EntityManagerUtil;

public class Consultas {
	public static void main(String[] args) {
		EntityManagerUtil.connect();
		MusicaService musicaService = new MusicaService();
		try {
			List<Musica> musicasPorPreco = musicaService.listarPorPreco(10, 1);
			System.out.println("---- Musicas ordenadas por preco");
			for (Musica musica : musicasPorPreco) {
				System.out.println(musica.getNome() + " - R$"
						+ musica.getPreco());
			}
			
			System.out.println("---- Musicas que contem 'Faixa' no nome");
			List<Musica> musicasPorNome = musicaService.buscarPorNome("Faixa");
			for (Musica musica : musicasPorNome) {
				System.out.println(musica.getNome() + " - R$"
						+ musica.getPreco());
			}

		} finally {
			EntityManagerUtil.closeConnection();
			System.exit(0);
		}
	}
}
