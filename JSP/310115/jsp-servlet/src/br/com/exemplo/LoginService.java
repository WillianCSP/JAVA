package br.com.exemplo;

public class LoginService {

	public static final String ATRIBUTO_USUARIO ="usuario";
	
	public boolean autenticar(String usuario, String senha) {
		// TODO Auto-generated method stub
		return "willian".equals(usuario) && "123".equals(senha);
		
	
	}

}
