package br.com.dextraining.MediaStore;

import javax.persistence.EntityManager;

import br.com.dextraining.MediaStore.entities.Endereco;
import br.com.dextraining.MediaStore.entities.Estado;
import br.com.dextraining.MediaStore.util.EntityManagerUtil;

public class TesteVersaoEndereco {
	public static void main(String[] args) {
		EntityManager em = EntityManagerUtil.criarEntityManager();
		
		Endereco e = new Endereco();
		e.setRua("Rua teste");
		e.setEstado(Estado.MG);
		
		em.getTransaction().begin();
		em.persist(e); // VERSAO sempre sera a data atual do sistema
		em.getTransaction().commit();
		
		em.close();
		EntityManagerUtil.closeConnection();
	}
}
