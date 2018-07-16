package ui;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;

import br.com.dextrainig.MediaStore.entidades.Ator;
import br.com.dextrainig.MediaStore.entidades.Categoria;
import br.com.dextrainig.MediaStore.entidades.Filme;
import br.com.dextrainig.MediaStore.entidades.FilmeAtor;
import br.com.dextrainig.MediaStore.services.AtorService;
import br.com.dextrainig.MediaStore.services.CategoriaService;
import br.com.dextrainig.MediaStore.services.FilmeService;


public class MenuFilme extends MenuBase {

	// instanciar servico
	FilmeService filmeService = new FilmeService();
	CategoriaService categoriaService = new CategoriaService();
	AtorService atorService = new AtorService();
	
	@Override
	public void executar() throws IOException {
		int op;
		do {
			limparTela();
			System.out.println("-----------------------------");
			System.out.println("Filme:");
			System.out.println("1\t-\tIncluir");
			System.out.println("2\t-\tBuscar por nome");
			System.out.println("3\t-\tListar por Nome Ator");
			System.out.println("4\t-\tListar todos");
			System.out.println("5\t-\tRemover");
			System.out.println();
			System.out.println("0\t-\tVoltar");
			System.out.print("Escolha sua opcao: ");
			op = reader.read();
		} while (op < 48 || op > 53);
		reader.readLine();
		char opcao = (char) op;
		switch (opcao) {
		case '1':
			incluir();
			break;
		case '2':
//			buscarPorNome();
			break;
		case '3':
			listarPorNome();
			break;
		case '4':
			listarTodos();
			break;	
		case '5':
//			remover();
			break;
		default:
			break;
		}
	}
	
	private void incluir() {
		System.out.println("-----------------------------");
		System.out.println("Inclusao de Filme:");
		String titulo = pedirString("Digite o Titulo:");
		BigDecimal valor = pedirValor("Digite o preco:");
		Integer duracao = pedirInteiro("Digite a Duracao");
		
		Filme filme = new Filme();
		filme.setNome(titulo);
		filme.setDuracao(duracao);
		filme.setPreco(valor);
		
		do{
			String nomeCategoria = pedirString("Digite a categoria");
			Categoria categoria = categoriaService.buscarPorNome(nomeCategoria);
			if(categoria == null){
				
				Integer limiteIdade = pedirInteiro("Digite o limite de Idade:");
				categoria = new Categoria();
				categoria.setNome(nomeCategoria);
				categoria.setRestricaoIdade(limiteIdade);
			}
			filme.getCategorias().add(categoria);
			
		}while(confirmacao("Incluir outra categoria(s/n)"));
		
		do{
			String nomeAtor = pedirString("Digite o nome do ator");
			Ator ator = atorService.buscarPorNome(nomeAtor);
			
			if(ator ==null){
				ator = new Ator();
				ator.setNome(nomeAtor);
			}
			
			String papel = pedirString("Digite o papel: ");
			FilmeAtor filmeAtor = new FilmeAtor();
			filmeAtor.setAtor(ator);
			filmeAtor.setFilme(filme);
			filmeAtor.setPapel(papel);
			filme.getAtores().add(filmeAtor);
			
		}while(confirmacao("incluir outro ator(s/n"));
	
		
		filmeService.update(filme);
		
	}
	
	private void listarTodos(){
		//TODO listar todos os filmes
		
		List<Filme> filmes = filmeService.listarTodosComAtores();
		System.out.println("----TODOS FILMES-----");
		for (Filme filme : filmes) {
			System.out.println(filme);
			
			System.out.println("----CATEGORIAS:");
			
			for (Categoria categoria : filme.getCategorias()) {
				System.out.println("\t"+categoria.getNome() + "\t Censura: "+categoria.getRestricaoIdade()+ " anos");
		
			}
			
			System.out.println("----ATORES:");
			for (FilmeAtor filmeAtor : filme.getAtores()) {
				System.out.println("\tAtor: "+filmeAtor.getAtor().getNome()+"\t Papel:"+filmeAtor.getPapel());
			}
		}
	}
	
	private void listarPorNome(){
		
		String nome = pedirString("Digite o nome do Ator: ");
		List<Filme> filmes = filmeService.buscarPorAtor(nome);
		System.out.println("----FILMES COM ATOR: "+nome);
		for (Filme filme : filmes) {
			System.out.println(filme);
			
		}
	}
//	
//	private void listar(){
//		
//		List<Livro> livros = LivroService.listarPorPreco();
//		System.out.println("-----TODOS LIVROS--------");
//		for(Livro livro : livros){
//			
//			System.out.println("Nome="+livro.getNome());
//			System.out.println("ISBN="+livro.getIsbn());
//			System.out.println("Preco="+livro.getPreco());
//			System.out.println("---------------------");
//		}
//
//		
//	}
//	
//	private void buscarPorNome(){
//		
//		String nome = pedirString("Nome: ");
//		
//		List<Livro> livros = this.LivroService.buscarPorTitulo(nome);
//		
//		System.out.println("Numero de Livros encontrados: "+livros.size());
//		for(Livro livro : livros){
//			
//			System.out.println(livro);
//
//		}
//	}
//	
//	private void buscarPorEditora(){
//		
//		String nome = pedirString("Nome Editora: ");
//		
//		List<Livro> livros = this.LivroService.buscarPorEditora(nome);
//		
//		System.out.println("Numero de Livros encontrados: "+livros.size());
//		for(Livro livro : livros){
//			
//			System.out.println(livro);
//
//		}
//	}
//	
//	private void remover(){
//		
//		//Pedir ID
//		Long id = pedirLong("Digite o Id: ");
//		Livro livro = LivroService.findById(id);
//		System.out.println("Encontrado"+livro);
//		//mostrar livro
//		
//		//Pedir confirmacao
//		if(confirmacao("Deseja remover?(s/n): ") && livro.getId() > 0){
//			LivroService.remove(livro);
//			System.out.println("Livro removido");
//		}
//	}

}
