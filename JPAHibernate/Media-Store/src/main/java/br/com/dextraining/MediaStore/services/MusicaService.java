package br.com.dextraining.MediaStore.services;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Path;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import br.com.dextraining.MediaStore.entities.Musica;
import br.com.dextraining.MediaStore.util.EntityManagerUtil;

public class MusicaService extends BaseService<Long, Musica> {

	public MusicaService() {
		super(Musica.class);
	}
	
	public List<Musica> listarPorPreco(int limit, int pagina) {
		EntityManager em = EntityManagerUtil.criarEntityManager();
		String jpql = "FROM Musica m ORDER BY m.preco";
		TypedQuery<Musica> query = em.createQuery(jpql, Musica.class);
		query.setMaxResults(limit);
		query.setFirstResult((limit * pagina) + 1);
		List<Musica> musicas = query.getResultList();
		em.close();
		return musicas;
	}
	
	
	// Buscar por trecho do nome
	// Ordenar pelo nome
	public List<Musica> buscarPorNome(String nome) {
		EntityManager em = EntityManagerUtil.criarEntityManager();
		StringBuilder builder = new StringBuilder("FROM Musica m");
		builder.append(" WHERE m.nome LIKE :nome");
		builder.append(" ORDER BY m.nome");
		TypedQuery<Musica> query = 
				em.createQuery(builder.toString(), Musica.class);
		query.setParameter("nome", "%"+nome+"%");
		List<Musica> musicas = query.getResultList();
		em.close();
		return musicas;
	}
	
	// Update no banco reajustando precos
	public void reajustarPreco(BigDecimal factor) {
		EntityManager em = EntityManagerUtil.criarEntityManager();
		EntityTransaction transaction = em.getTransaction();
		transaction.begin();
		StringBuilder builder = new StringBuilder("UPDATE Musica m");
		builder.append(" SET m.preco = m.preco * :factor");
		
		Query query = em.createQuery(builder.toString());
		query.setParameter("factor", factor);
		query.executeUpdate();
		transaction.commit();
		em.close();
	}
	
	// Apagar musicas abaixo do valor limite
	// Retornar quantidade de musicas apagadas
	public int removerMusicasBaratas(BigDecimal limite) {
		EntityManager em = EntityManagerUtil.criarEntityManager();
		EntityTransaction transaction = em.getTransaction();
		transaction.begin();
		StringBuilder builder = new StringBuilder("DELETE FROM Musica m");
		builder.append(" WHERE m.preco < :limite");
		Query query = em.createQuery(builder.toString());
		query.setParameter("limite", limite);
		int updated = query.executeUpdate();
		transaction.commit();
		em.close();
		return updated;
	}
	
	public List<Musica> musicasComPrecoAcimaDe(BigDecimal preco) {
		EntityManager em = EntityManagerUtil.criarEntityManager();
		
		CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();
		CriteriaQuery<Musica> cQuery = criteriaBuilder.createQuery(Musica.class);
		Root<Musica> root = cQuery.from(Musica.class);
		Path<BigDecimal> path = root.get("preco");
		Predicate condicao = criteriaBuilder.gt(path, preco);
		cQuery.where(condicao);
		
		TypedQuery<Musica> query = em.createQuery(cQuery);
		
		List<Musica> list;
		list = query.getResultList();
		em.close();
		return list;
	}
	
}
