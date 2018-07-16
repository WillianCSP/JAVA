package br.com.dextrainig.MediaStore.services;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import br.com.dextrainig.MediaStore.entidades.Filme;
import br.com.dextrainig.MediaStore.entidades.Livro;
import br.com.dextrainig.MediaStore.util.EntityManagerUtil;

public class FilmeService extends BaseService<Long, Filme>{
	
	public FilmeService(){
		super(Filme.class);
	}
	
	public List<Filme> listarTodosComAtores(){
		
		EntityManager em = EntityManagerUtil.criarEntityManager();
		
		String jpql = "FROM Filme f JOIN FETCH f.atores ORDER BY f.nome";
		TypedQuery<Filme> query = em.createQuery(jpql, Filme.class);
		List<Filme> filmes = query.getResultList();
		em.close();
		
		return filmes;
		
	}
	
	public List<Filme> buscarPorAtor(String nomeAtor){
		//TODO Retornar todos os filmes que contenham nome de um ator
	
		EntityManager em = EntityManagerUtil.criarEntityManager();
		
		String jpql = "FROM Filme f JOIN FETCH f.atores a WHERE a.ator.nome LIKE :nomeAtor"
				+ " ORDER BY f.nome";
		TypedQuery<Filme> query = em.createQuery(jpql, Filme.class);
		query.setParameter("nomeAtor", "%"+nomeAtor+"%");
		List<Filme> filmes = query.getResultList();
		
		em.close();
		
		return filmes;
	}

}
