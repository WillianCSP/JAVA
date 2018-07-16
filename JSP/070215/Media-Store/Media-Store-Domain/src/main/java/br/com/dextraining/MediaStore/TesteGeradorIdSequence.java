package br.com.dextraining.MediaStore;

import javax.persistence.EntityManager;

import br.com.dextraining.MediaStore.entities.TesteIdSequence;
import br.com.dextraining.MediaStore.util.EntityManagerUtil;

public class TesteGeradorIdSequence {
	public static void main(String[] args) {
		EntityManager em = EntityManagerUtil.criarEntityManager();
		
		TesteIdSequence t = new TesteIdSequence();
		t.setNome("bla bla32");
		
		TesteIdSequence t2 = new TesteIdSequence();
		t2.setNome("teteettetetetete");
		
		TesteIdSequence t3 = new TesteIdSequence();
		t3.setNome("nova aeee");
		
		TesteIdSequence t4 = new TesteIdSequence();
		t4.setNome("nova aeee4");
		
		TesteIdSequence t5 = new TesteIdSequence();
		t5.setNome("nova aeee5");
		
		em.getTransaction().begin();
		em.persist(t);
		em.persist(t2);
		em.persist(t3);
		em.persist(t4);
		em.persist(t5);
		em.getTransaction().commit();
		em.close();
		
		EntityManagerUtil.closeConnection();
	}
}
