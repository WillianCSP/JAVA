package ui;


import java.io.IOException;
import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

import br.com.dextrainig.MediaStore.entidades.Album;
import br.com.dextrainig.MediaStore.entidades.Musica;
import br.com.dextrainig.MediaStore.services.AlbumService;
import br.com.dextrainig.MediaStore.services.MusicaService;


public class MenuAlbum extends MenuBase {

	// TODO instanciar servico
	MusicaService musicaService = new MusicaService();
	AlbumService albumService = new AlbumService();
	
	@Override
	public void executar() throws IOException {
		int op;
		do {
			limparTela();
			System.out.println("-----------------------------");
			System.out.println("Albuns:");
			System.out.println("1\t-\tIncluir");
			System.out.println("2\t-\tBuscar por nome");
			System.out.println("3\t-\tAlterar");
			System.out.println("4\t-\tRemover");
			System.out.println();
			System.out.println("0\t-\tVoltar");
			System.out.print("Escolha sua opcao: ");
			op = reader.read();
		} while (op < 48 || op > 52);
		reader.readLine();
		char opcao = (char) op;
		switch (opcao) {
		case '1':
			incluir();
			break;
		case '2':
			break;
		case '3':
			break;
		case '4':
			break;	
		case '5':
			break;
		default:
			break;
		}
	}
	
	private void incluir(){ 
		
		System.out.println("---------------------------------");
		System.out.println("Inclusao de Album");
		String nomeAlbum = pedirString("Digite o titulo do Album: ");
		BigDecimal preco = pedirValor("Digite o preco do Album: ");
		
		Set<Musica> musicas = new HashSet<Musica>();
		
		do{
			
			Musica m = pedirMusica();
			
			musicas.add(m);

		}while(confirmacao("Incluir mais musicas(s/n): "));
		
		
		Album a = new Album();
		a.setNome(nomeAlbum);
		a.setPreco(preco);
		a.setListaMusicas(musicas);
		
		
		albumService.persist(a);
		
	}

	private Musica pedirMusica() {
		System.out.println("Musica: ------");
		String nomeMuscia = pedirString("Digite o nome: ");
		BigDecimal precoMusica = pedirValor("Digite o preco: ");
		Integer duracao = pedirInteiro("Digite a duracao: ");
		Musica m = new Musica();
		m.setNome(nomeMuscia);
		m.setPreco(precoMusica);
		m.setDuracao(duracao);
		return m;
	}
	
	

}