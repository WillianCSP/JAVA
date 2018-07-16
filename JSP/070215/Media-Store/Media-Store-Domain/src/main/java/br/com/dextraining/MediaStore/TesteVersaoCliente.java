package br.com.dextraining.MediaStore;

import javax.persistence.EntityManager;

import br.com.dextraining.MediaStore.entities.Cliente;
import br.com.dextraining.MediaStore.util.EntityManagerUtil;

public class TesteVersaoCliente {
	public static void main(String[] args) {
		EntityManager em = EntityManagerUtil.criarEntityManager();
		
		Cliente c = new Cliente();
		c.setNome("teste");
		
		em.getTransaction().begin();
		em.persist(c); // VERSAO estara 0
		em.getTransaction().commit();
		
		c.setNome("hagsdjhasg");
		em.getTransaction().begin();
		em.persist(c); // VERSAO passara a ser 1
		em.getTransaction().commit();
		
		em.close();
		EntityManagerUtil.closeConnection();
	}
}
