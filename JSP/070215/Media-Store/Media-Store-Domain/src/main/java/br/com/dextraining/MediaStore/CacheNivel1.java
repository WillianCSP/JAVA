package br.com.dextraining.MediaStore;

import javax.persistence.EntityManager;

import br.com.dextraining.MediaStore.entities.Cliente;
import br.com.dextraining.MediaStore.util.EntityManagerUtil;

public class CacheNivel1 {
	public static void main(String[] args) {
		EntityManager em = EntityManagerUtil.criarEntityManager();
		
		Cliente cliente = em.find(Cliente.class, 1L);
		for (int i = 0; i < 100; i++) {
			Cliente cliente2 = em.find(Cliente.class, 1L);
			if(cliente != cliente2) {
				System.out.println("ESPACO DIFERENTE NA MEMORIA");
			}
		}
		
		EntityManager em2 = EntityManagerUtil.criarEntityManager();
		Cliente cliente2 = em2.find(Cliente.class, 1L);
		if(cliente != cliente2) {
			System.out.println("ESPACO DIFERENTE NA MEMORIA");
		}
		if(cliente.equals(cliente2)) {
			System.out.println("Objetos Iguais");
		}
		
		
		
		EntityManagerUtil.closeConnection();
	}
}
