package br.com.dextraining.AulaJpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

import util.EntityManagerUtil;


public class PessoaService {

	public Pessoa inserirPessoa(Pessoa p){
		
		EntityManager em = EntityManagerUtil.criarEntityManager();
		
		EntityTransaction transaction = em.getTransaction();
		
		transaction.begin();
		
		em.persist(p);
		
		transaction.commit();
		
		return p;
		
	}
	
	public Pessoa buscarPorId(Long id){
		
		EntityManager em = EntityManagerUtil.criarEntityManager();
		
		return em.find(Pessoa.class, id);
	
	}
	
	public List<Pessoa> listarTodos(){
		
		EntityManager em = EntityManagerUtil.criarEntityManager();
		String jpql = "FROM Pessoa p";
		TypedQuery<Pessoa> query = em.createQuery(jpql, Pessoa.class);
		
		return query.getResultList();
		 
	}
	
	public List<Pessoa> buscarPorNome(String nome){
		
		EntityManager em = EntityManagerUtil.criarEntityManager();
		StringBuilder builder = new StringBuilder("FROM Pessoa p");
		builder.append(" WHERE p.nome LIKE :nome");
		builder.append(" ORDER BY p.nome");
		
		TypedQuery<Pessoa> query = em.createQuery(builder.toString(), Pessoa.class);
		
		query.setParameter("nome", "%"+nome+"%");
		return query.getResultList();
		
	}
}
