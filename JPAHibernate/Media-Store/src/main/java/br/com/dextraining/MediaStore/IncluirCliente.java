package br.com.dextraining.MediaStore;

import br.com.dextraining.MediaStore.entities.Cliente;
import br.com.dextraining.MediaStore.entities.Endereco;
import br.com.dextraining.MediaStore.entities.Estado;
import br.com.dextraining.MediaStore.services.ClienteService;
import br.com.dextraining.MediaStore.util.EntityManagerUtil;

public class IncluirCliente {
	public static void main(String[] args) {
		EntityManagerUtil.connect();
		ClienteService clienteService = new ClienteService();
		try {
			Endereco endereco = new Endereco();
			endereco.setRua("Rua teste 2");
			endereco.setEstado(Estado.SP);

			Cliente c = new Cliente();
			c.setNome("Segundo cliente");
			c.setEndereco(endereco);
			
			clienteService.persist(c);

		} catch (RuntimeException e) {
			e.printStackTrace();
		} finally {
			EntityManagerUtil.closeConnection();
			System.exit(0);
		}
	}
}
