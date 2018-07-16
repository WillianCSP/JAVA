package ui;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.util.List;

import br.com.dextrainig.MediaStore.entidades.Estado;
import br.com.dextrainig.MediaStore.entidades.Livro;

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
	
	List<Livro> livros;
	
	protected BigDecimal pedirValor(String titulo){
		BigDecimal valor=null;
	
		do{
		
			String dado = pedirString(titulo);
			try{
				valor = new BigDecimal(dado);
				
			}catch(NumberFormatException e){
				e.printStackTrace();
			}
			
			return valor;
		}while(valor == null);
		
	
	}
	protected Integer pedirInteiro(String titulo){
		Integer valor = null;
	
		do{
		
			String dado = pedirString(titulo);
			try{
				valor =Integer.parseInt(dado);
				
			}catch(NumberFormatException e){
				e.printStackTrace();
			}
			
			return valor;
		}while(valor == null);
		
	
	}
	
	protected Long pedirLong(String titulo){
		Long valor=null;
	
		do{
		
			String dado = pedirString(titulo);
			try{
				valor = new Long(dado);
				
			}catch(NumberFormatException e){
				e.printStackTrace();
			}
			
			return valor;
		}while(valor == null);
		
	
	}
	
	protected boolean confirmacao(String titulo) {
		String dado = null;
		do {
			dado = pedirString(titulo);
		} while ( !("S".equals(dado) || "s".equals(dado) || "N".equals(dado) || "n".equals(dado)) );
		if("S".equals(dado) || "s".equals(dado)) {
			return true;
		}
		if("N".equals(dado) || "n".equals(dado)) {
			return false;
		}
		return false;
	}
	

    protected Estado pedirEstado(String titulo) {
            Estado estado = null;
            do {
                    String dado = pedirString(titulo);
                    try {
                            estado = Estado.valueOf(dado);
                    } catch (IllegalArgumentException e) {}
            } while (estado == null);
            return estado;
    }
	public abstract void executar() throws IOException;

}
