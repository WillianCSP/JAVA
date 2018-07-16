package ui;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;

import br.com.dextrainig.MediaStore.entidades.Editora;
import br.com.dextrainig.MediaStore.entidades.Livro;
import br.com.dextrainig.MediaStore.services.EditoraService;
import br.com.dextrainig.MediaStore.services.LivroService;


public class MenuLivro extends MenuBase {

	// instanciar servico
	LivroService LivroService = new LivroService();
	EditoraService editoraService = new EditoraService();
	
	@Override
	public void executar() throws IOException {
		int op;
		do {
			limparTela();
			System.out.println("-----------------------------");
			System.out.println("Livros:");
			System.out.println("1\t-\tIncluir");
			System.out.println("2\t-\tBuscar por nome");
			System.out.println("3\t-\tListar por Editora");
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
			buscarPorNome();
			break;
		case '3':
			buscarPorEditora();
			break;
		case '4':
			listar();
			break;	
		case '5':
			remover();
			break;
		default:
			break;
		}
	}
	
	private void incluir() {
		System.out.println("-----------------------------");
		System.out.println("Inclusao de Livros:");
		String nome = pedirString("Titulo do livro: ");
		String isbn = pedirString("Titulo do ISBN: ");
		BigDecimal valor = pedirValor("Valor do Livro: ");
		String nomeEditora = pedirString("Digite a editora: ");
		
		Editora editora = editoraService.buscarPorNome(nomeEditora);
		if(editora == null){
			editora = new Editora();
			editora.setNome(nomeEditora);
		}
		
		Livro novoLivro = new Livro();
		novoLivro.setNome(nome);
		novoLivro.setIsbn(isbn);
		novoLivro.setPreco(valor);
		novoLivro.setEditora(editora);
		LivroService.update(novoLivro);
		//chamar servico de inclusao
	}
	
	private void listar(){
		
		List<Livro> livros = LivroService.listarPorPreco();
		System.out.println("-----TODOS LIVROS--------");
		for(Livro livro : livros){
			
			System.out.println("Nome="+livro.getNome());
			System.out.println("ISBN="+livro.getIsbn());
			System.out.println("Preco="+livro.getPreco());
			System.out.println("---------------------");
		}

		
	}
	
	private void buscarPorNome(){
		
		String nome = pedirString("Nome: ");
		
		List<Livro> livros = this.LivroService.buscarPorTitulo(nome);
		
		System.out.println("Numero de Livros encontrados: "+livros.size());
		for(Livro livro : livros){
			
			System.out.println(livro);

		}
	}
	
	private void buscarPorEditora(){
		
		String nome = pedirString("Nome Editora: ");
		
		List<Livro> livros = this.LivroService.buscarPorEditora(nome);
		
		System.out.println("Numero de Livros encontrados: "+livros.size());
		for(Livro livro : livros){
			
			System.out.println(livro);

		}
	}
	
	private void remover(){
		
		//Pedir ID
		Long id = pedirLong("Digite o Id: ");
		Livro livro = LivroService.findById(id);
		System.out.println("Encontrado"+livro);
		//mostrar livro
		
		//Pedir confirmacao
		if(confirmacao("Deseja remover?(s/n): ") && livro.getId() > 0){
			LivroService.remove(livro);
			System.out.println("Livro removido");
		}
	}

}
