package br.com.dextraining.MediaStore.ui;

import java.io.IOException;
import java.util.List;

import br.com.dextraining.MediaStore.entities.Cliente;
import br.com.dextraining.MediaStore.entities.Endereco;
import br.com.dextraining.MediaStore.entities.Estado;
import br.com.dextraining.MediaStore.services.ClienteService;


public class MenuClientes extends MenuBase {

	ClienteService clienteService = new ClienteService();
	
	@Override
	public void executar() throws IOException {
		int op;
		do {
			limparTela();
			System.out.println("-----------------------------");
			System.out.println("Clientes:");
			System.out.println("1\t-\tIncluir");
			System.out.println("2\t-\tBuscar por nome");
			System.out.println("3\t-\tAlterar");
			System.out.println("4\t-\tListar por Estado");
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
			break;
		case '3':
			break;
		case '4':
			porEstado();
			break;	
		case '5':
			break;
		default:
			break;
		}
	}
	
	private void incluir() {
		System.out.println("-----------------------------");
		System.out.println("Inclusao de Cliente:");
		String nome = pedirString("Digite o nome: ");
		String rua = pedirString("Digite a rua: ");
		Estado estado = pedirEstado("Digite o estado: ");
		
		Endereco e = new Endereco();
		e.setRua(rua);
		e.setEstado(estado);
		
		Cliente c = new Cliente();
		c.setEndereco(e);
		c.setNome(nome);
		
		//chamar servico de inclusao
		clienteService.persist(c);
	}
	
	private void porEstado() {
		System.out.println("-----------------------------");
		Estado estado = pedirEstado("Digite o estado: ");
		
		List<Cliente> clientes = clienteService.listarPorEstado(estado);
		for (Cliente cliente : clientes) {
			System.out.println(cliente);
		}
	}

}
