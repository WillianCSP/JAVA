package br.com.dextraining.MediaStore;

import java.math.BigDecimal;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import br.com.dextraining.MediaStore.entities.Livro;
import br.com.dextraining.MediaStore.util.EntityManagerUtil;

public class ErrosComuns {
	public static void main(String[] args) {
		persistDetachedEntity();
	}

	private static void persistDetachedEntity() {
		EntityManagerUtil.connect();
		EntityManager em = EntityManagerUtil.criarEntityManager();
		try {
			EntityTransaction transaction = em.getTransaction();
			transaction.begin();
			Livro l = new Livro(); // Transient
			l.setId(1L);           // Detached
			l.setIsbn("0000000000001");
			l.setPreco(new BigDecimal("9.90"));
			l.setNome("Primeiro livro");
			
			em.persist(l);    // Erro =(
			transaction.commit();
			em.close();
			
		} catch(RuntimeException e) {
			e.printStackTrace();
		} finally {
			EntityManagerUtil.closeConnection();
		}
	}
}
