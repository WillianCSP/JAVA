package br.com.dextraining.MediaStore;

import javax.persistence.EntityManager;

import br.com.dextraining.MediaStore.entities.TesteIdAuto;
import br.com.dextraining.MediaStore.util.EntityManagerUtil;

public class TesteGeradorIdAuto {
	public static void main(String[] args) {
		EntityManager em = EntityManagerUtil.criarEntityManager();
		
		TesteIdAuto t = new TesteIdAuto();
		t.setNome("bla");
		em.getTransaction().begin();
		em.persist(t);
		em.getTransaction().commit();
		em.close();
		
		EntityManagerUtil.closeConnection();
	}
}
