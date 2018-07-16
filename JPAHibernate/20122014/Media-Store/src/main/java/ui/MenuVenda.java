package ui;


import java.io.IOException;
import java.util.List;

import br.com.dextrainig.MediaStore.entidades.Cliente;
import br.com.dextrainig.MediaStore.entidades.Livro;
import br.com.dextrainig.MediaStore.services.ClienteService;
import br.com.dextrainig.MediaStore.services.LivroService;

public class MenuVenda extends MenuBase {
	
	
	Cliente cliente = new Cliente();
	ClienteService clienteService = new ClienteService();
	
	
	public void executar() throws IOException {
		int op;
		
		
		do{
			limparTela();
			System.out.println("Selecionar Cliente");
			selecionarCliente();
			
		}while(cliente == null);
		
		do {
			limparTela();
			System.out.println("-----------------------------");
			System.out.println("Cadastros:");
			System.out.println("2\t-\tLivros");
			System.out.println("3\t-\tFilmes");
			System.out.println("4\t-\tAlbuns");
			System.out.println();
			System.out.println("0\t-\tVoltar");
			System.out.print("Escolha sua opcao: ");
			op = reader.read();
		} while (op < 48 || op > 52);
		reader.readLine();
		char opcao = (char) op;
		switch (opcao) {
		case '1':
			selecionarCliente();
			break;
		case '2':
			selecionarLivro();
			break;
		case '3':
			new MenuFilme().filmeService.findAll();
			break;
		case '4':
			new MenuAlbum().albumService.findAll();
			break;
		default:
			break;
		}
	}
	
	private void selecionarCliente(){
		List<Cliente> clientes = new MenuClientes().clienteService.findAll();
		for (Cliente cliente : clientes) {
			System.out.println(cliente);
			System.out.println("");
			
		}
		
		Long id = pedirLong("Digite o ID:");
		
		cliente = clienteService.findById(id); 
	}
	
	private void selecionarLivro(){
		
		List<Livro> livros = new LivroService().findAll();
		for (Livro livro : livros) {
			System.out.println(livro);
			System.out.println("");
			
		}
		
		Long id = pedirLong("Digite o ID:");
		
	} 

}
