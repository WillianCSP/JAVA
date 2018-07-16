package br.com.dextraining.MediaStore;

import javax.persistence.EntityManager;

import br.com.dextraining.MediaStore.entities.TesteIdTable;
import br.com.dextraining.MediaStore.util.EntityManagerUtil;

public class TesteGeradorIdTable {
	public static void main(String[] args) {
		EntityManager em = EntityManagerUtil.criarEntityManager();

		TesteIdTable t = new TesteIdTable();
		t.setNome("teste bla2");
		
		em.getTransaction().begin();
		em.persist(t);
		em.getTransaction().commit();
		em.close();

		EntityManagerUtil.closeConnection();
	}
}
