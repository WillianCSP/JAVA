package br.com.dextraining.MediaStore;

import java.math.BigDecimal;

import br.com.dextraining.MediaStore.entities.Livro;
import br.com.dextraining.MediaStore.services.LivroService;
import br.com.dextraining.MediaStore.util.EntityManagerUtil;

public class InclusaoLivros {
	public static void main(String[] args) {
		EntityManagerUtil.connect();
		LivroService livroService = new LivroService();
		try {
			Livro l = new Livro();
			l.setIsbn("0000000000001");
			l.setPreco(new BigDecimal("9.90"));
			l.setNome("Primeiro livro");
			
			livroService.persist(l);
			
			System.out.println(l);
			
		} catch(RuntimeException e) {
			e.printStackTrace();
		} finally {
			EntityManagerUtil.closeConnection();
			System.exit(0);
		}
	}
}
