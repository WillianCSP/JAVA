package br.com.dextraining.MediaStore.ui;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;

import br.com.dextraining.MediaStore.entities.Editora;
import br.com.dextraining.MediaStore.entities.Livro;
import br.com.dextraining.MediaStore.services.EditoraService;
import br.com.dextraining.MediaStore.services.LivroService;


public class MenuLivro extends MenuBase {

	// instanciar servico
	LivroService livroService = new LivroService();
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
			System.out.println("3\t-\tAlterar");
			System.out.println("4\t-\tListar todos");
			System.out.println("5\t-\tRemover");
			System.out.println("6\t-\tListar por Editora");
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
			buscarPorNome();
			break;
		case '3':
			break;
		case '4':
			listarTodos();
			break;	
		case '5':
			remover();
			break;
		case '6':
			listarPorEditora();
			break;
		default:
			break;
		}
	}
	
	private void incluir() {
		System.out.println("-----------------------------");
		System.out.println("Inclusao de Livros:");
		String nome = pedirString("Titulo do livro: ");
		String isbn = pedirString("ISBN do livro: ");
		BigDecimal valor = pedirValor("Valor do livro: ");
		String nomeEditora = pedirString("Digite a editora: ");
		
		Editora editora = editoraService.buscarPorNome(nomeEditora);
		if(editora == null) {
			editora = new Editora();
			editora.setNome(nomeEditora);
		}
		
		Livro novoLivro = new Livro();
		novoLivro.setNome(nome);
		novoLivro.setIsbn(isbn);
		novoLivro.setPreco(valor);
		novoLivro.setEditora(editora);
		
		//chamar servico de inclusao
		livroService.update(novoLivro);
	}
	
	private void listarTodos() {
		System.out.println("-----------------------------");
		System.out.println("Todos os Livros:");
		List<Livro> livros = livroService.findAll();
		System.out.println(livros.size() + " livros encontrados");
		for (Livro livro : livros) {
			System.out.println(livro);
		}
		System.out.println("-----------------------------");
	}

	private void buscarPorNome() {
		System.out.println("-----------------------------");
		String nome = pedirString("Digite um trecho do nome: ");
		
		List<Livro> livros = livroService.buscarPorNome(nome);
		System.out.println(livros.size() + " livros encontrados");
		for (Livro livro : livros) {
			System.out.println(livro);
		}
		System.out.println("-----------------------------");
	}
	
	private void remover() {
		System.out.println("-----------------------------");
		// Pedir ID
		Long id = pedirLong("Digite o ID a remover: ");
		
		Livro livro = livroService.findById(id);
		
		if(livro != null) {
			// Mostrar livro
			System.out.println("Livro encontrado: " + livro);
			// Pedir confirmacao
			if(confirmacao("Deseja remover? (s/n)")) {
				// Remover se confirmado
				livroService.remove(livro);
				System.out.println("Livro removido");
			}
		}
	}
	
	private void listarPorEditora() {
		System.out.println("-----------------------------");
		String nomeEditora = pedirString("Digite o nome da editora:");
		
		List<Livro> livros = livroService.buscarPorEditora(nomeEditora);
		System.out.println(livros.size() + " livros encontrados");
		for (Livro livro : livros) {
			System.out.println(livro);
		}
		System.out.println("-----------------------------");
	}
}
