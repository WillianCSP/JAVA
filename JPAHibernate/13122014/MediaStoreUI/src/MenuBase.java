import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public abstract class MenuBase {

	protected BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

	protected void limparTela() {
		final String os = System.getProperty("os.name");

		try {
			if (os.contains("Windows")) {
				// Runtime.getRuntime().exec("cls");
			} else {
				Runtime.getRuntime().exec("clear");
			}
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

	protected String pedirString(String titulo) {
		String entrada = null;
		do {
			System.out.print(titulo);
			try {
				entrada = reader.readLine();
			} catch (IOException e) {
				throw new RuntimeException(e);
			}
		} while (entrada == null || "".equals(entrada.trim()));

		return entrada;
	}

	public abstract void executar() throws IOException;

}
