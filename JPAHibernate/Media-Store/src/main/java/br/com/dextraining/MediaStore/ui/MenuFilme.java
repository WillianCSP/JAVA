package br.com.dextraining.MediaStore.ui;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;

import br.com.dextraining.MediaStore.entities.Ator;
import br.com.dextraining.MediaStore.entities.Categoria;
import br.com.dextraining.MediaStore.entities.Filme;
import br.com.dextraining.MediaStore.entities.FilmeAtor;
import br.com.dextraining.MediaStore.services.AtorService;
import br.com.dextraining.MediaStore.services.CategoriaService;
import br.com.dextraining.MediaStore.services.FilmeService;


public class MenuFilme extends MenuBase {

	// instanciar servico
	
	CategoriaService categoriaService = new CategoriaService();
	FilmeService filmeService = new FilmeService();
	AtorService atorService = new AtorService();
	
	@Override
	public void executar() throws IOException {
		int op;
		do {
			limparTela();
			System.out.println("-----------------------------");
			System.out.println("Livros:");
			System.out.println("1\t-\tIncluir");
			System.out.println("2\t-\tBuscar por nome");
			System.out.println("3\t-\tAlterar");
			System.out.println("4\t-\tListar todos");
			System.out.println("5\t-\tRemover");
			System.out.println("6\t-\tListar por Ator");
			System.out.println();
			System.out.println("0\t-\tVoltar");
			System.out.print("Escolha sua opcao: ");
			op = reader.read();
		} while (op < 48 || op > 54);
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
			listarTodos();
			break;	
		case '5':
			break;
		case '6':
			listarPorAtor();
			break;
		default:
			break;
		}
	}
	
	private void incluir() {
		System.out.println("-----------------------------");
		System.out.println("Inclusao de Filme:");
		String titulo = pedirString("Digite o titulo: ");
		BigDecimal valor = pedirValor("Digite o preco: ");
		Integer duracao = pedirInteiro("Digite a duracao: ");
		
		Filme filme = new Filme();
		filme.setNome(titulo);
		filme.setPreco(valor);
		filme.setDuracao(duracao);
		
		do {
			String nomeCategoria = pedirString("Digite a categoria: ");
			Categoria categoria = categoriaService.buscarPorNome(nomeCategoria);
			if(categoria == null) {
				Integer limiteIdade = pedirInteiro("Digite o limite de idade dessa categoria: ");
				categoria = new Categoria();
				categoria.setNome(nomeCategoria);
				categoria.setRestricaoIdade(limiteIdade);
			}
			filme.getCategorias().add(categoria);
		} while (confirmacao("Incluir outra categoria? (s/n)"));
		
		do {
			String nomeAtor = pedirString("Digite o nome do ator: ");
			Ator ator = atorService.buscarPorNome(nomeAtor);
			if(ator == null) {
				ator = new Ator();
				ator.setNome(nomeAtor);
			}
			
			String papel = pedirString("Digite o papel: ");
			FilmeAtor filmeAtor = new FilmeAtor();
			filmeAtor.setAtor(ator);
			filmeAtor.setFilme(filme);
			filmeAtor.setPapel(papel);
			filme.getAtores().add(filmeAtor);
		} while (confirmacao("Incluir outro ator? (s/n)"));
		
		filmeService.update(filme);
	}
	
	private void listarTodos() {
		List<Filme> filmes = filmeService.listarTodoComAtores();
		exibirFilmes(filmes);
	}
	
	private void listarPorAtor() {
		String nome = pedirString("Digite o nome do ator: ");
		List<Filme> filmes = filmeService.buscarPorAtor(nome);
		exibirFilmes(filmes);
	}

	private void exibirFilmes(List<Filme> filmes) {
		for (Filme filme : filmes) {
			System.out.println();
			System.out.println(filme);
			System.out.println("--Categorias:");
			for (Categoria categoria : filme.getCategorias()) {
				System.out.println("\t" + categoria.getNome() + 
						"\t Censura: " + categoria.getRestricaoIdade()
						+ " anos");
			}
			System.out.println("--Atores:");
			for (FilmeAtor filmeAtor : filme.getAtores()) {
				System.out.println("\t" + filmeAtor.getAtor().getNome() + 
						" - " + filmeAtor.getPapel());
			}
		}
	}
}
