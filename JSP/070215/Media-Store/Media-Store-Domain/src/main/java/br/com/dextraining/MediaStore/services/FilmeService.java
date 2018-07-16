package br.com.dextraining.MediaStore.services;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import br.com.dextraining.MediaStore.entities.Filme;
import br.com.dextraining.MediaStore.util.EntityManagerUtil;

public class FilmeService extends BaseService<Long, Filme> {
	public FilmeService() {
		super(Filme.class);
	}
	
	public List<Filme> listarTodoComAtores() {
		StringBuilder builder = new StringBuilder("FROM Filme f");
		builder.append(" LEFT JOIN FETCH f.atores");
		
		EntityManager em = EntityManagerUtil.criarEntityManager();
		TypedQuery<Filme> query = em.createQuery(builder.toString(), Filme.class);
		
		List<Filme> filmes = query.getResultList();
		em.close();
		return filmes;
	}
	
	public List<Filme> buscarPorAtor(String nomeAtor) {
		StringBuilder builder = new StringBuilder("FROM Filme f");
		builder.append(" LEFT JOIN FETCH f.atores a");
		builder.append(" WHERE LOWER(a.ator.nome) LIKE :nome");
		
		EntityManager em = EntityManagerUtil.criarEntityManager();
		TypedQuery<Filme> query = em.createQuery(builder.toString(), Filme.class);
		
		query.setParameter("nome", "%" + nomeAtor.toLowerCase() + "%");
		
		List<Filme> filmes = query.getResultList();
		em.close();
		return filmes;
	}
}
