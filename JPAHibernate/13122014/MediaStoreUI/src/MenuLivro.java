import java.io.IOException;


public class MenuLivro extends MenuBase {

	// TODO instanciar servico
	
	@Override
	public void executar() throws IOException {
		int op;
		do {
			limparTela();
			System.out.println("-----------------------------");
			System.out.println("Livros:");
			System.out.println("1\t-\tIncluir");
			System.out.println("4\t-\tListar todos");
			System.out.println("2\t-\tBuscar por nome");
			System.out.println("3\t-\tAlterar");
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
			break;	
		case '5':
			break;
		default:
			break;
		}
	}
	
	private void incluir() {
		System.out.println("-----------------------------");
		System.out.println("Inclusao de Livros:");
		String nome = pedirString("Titulo do livro: ");

		//chamar servico de inclusao
	}

}
