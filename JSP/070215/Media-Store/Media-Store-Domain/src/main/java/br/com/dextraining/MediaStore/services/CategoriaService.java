package br.com.dextraining.MediaStore.services;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

import br.com.dextraining.MediaStore.entities.Categoria;
import br.com.dextraining.MediaStore.util.EntityManagerUtil;

public class CategoriaService extends BaseService<Long, Categoria> {
	public CategoriaService() {
		super(Categoria.class);
	}
	
	public Categoria buscarPorNome(String nome) {
		StringBuilder builder = new StringBuilder("FROM Categoria c");
		builder.append(" WHERE c.nome = :nome");
		
		EntityManager em = EntityManagerUtil.criarEntityManager();
		TypedQuery<Categoria> query = em.createQuery(builder.toString(), Categoria.class);
		query.setParameter("nome", nome);
		
		try {
			Categoria categoria = query.getSingleResult();
			em.close();
			return categoria;
		} catch (NoResultException e) {
			em.close();
			return null;
		}
	}
}
