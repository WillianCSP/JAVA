package ui;
import java.io.IOException;
import java.util.List;

import br.com.dextrainig.MediaStore.entidades.Cliente;
import br.com.dextrainig.MediaStore.entidades.Endereco;
import br.com.dextrainig.MediaStore.entidades.Estado;
import br.com.dextrainig.MediaStore.services.ClienteService;


public class MenuClientes extends MenuBase {

	// TODO instanciar servico
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
			System.out.println("4\t-\tBuscar por estado");
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
			listarPorEstado();
			break;	
		case '5':
			break;
		default:
			break;
		}
	}
	
	private void incluir() {
		System.out.println("---LISTAR POR ESTADO---");
		System.out.println("Inclusao de Cliente:");
		String nome = pedirString("Digite o nome: ");
		String rua = pedirString("Digite a rua: ");
		Estado estado = pedirEstado("Digite o estado: ");
		
		Endereco endereco = new Endereco();
		endereco.setRua(rua);
		endereco.setEstado(estado);
		
		Cliente c = new Cliente();
		c.setNome("Cliente 1");
		c.setEmail("aaaa@aaaa");
		c.setCpf("1111");
		c.setEndereco(endereco);

		clienteService.persist(c);
		//chamar servico de inclusao
	}
	
	public void listarPorEstado(){
		
		Estado estado = pedirEstado("Digite o estado: ");
		List<Cliente> clientes = clienteService.listarporEstado(estado);
		System.out.println("---------------------------------------");
		System.out.println("Clientes encontrados: "+clientes.size());
		for (Cliente cliente : clientes) {
			
			System.out.println(cliente);
			
		}
	}
	
	




}
