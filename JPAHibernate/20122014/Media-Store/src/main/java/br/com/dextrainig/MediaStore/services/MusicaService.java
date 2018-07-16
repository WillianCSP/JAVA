package br.com.dextrainig.MediaStore.services;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.TypedQuery;





import br.com.dextrainig.MediaStore.entidades.Musica;
import br.com.dextrainig.MediaStore.util.EntityManagerUtil;

public class MusicaService extends BaseService<Long, Musica> {

	
	public MusicaService(){
		super(Musica.class);
	}
	
	public List<Musica> listarPorPreco(){
		
		EntityManager em = EntityManagerUtil.criarEntityManager();
		
		String jpql = "FROM Musica m ORDER BY m.preco";
		TypedQuery<Musica> query = em.createQuery(jpql, Musica.class);
		List<Musica> musicas = query.getResultList();
		em.close();
		
		return musicas;
		
	}
	
	public List<Musica> buscarPorNome(String nome){
		
		EntityManager em = EntityManagerUtil.criarEntityManager();
		
		String jpql = "FROM Musica m WHERE m.nome LIKE :nome ORDER BY m.preco";
		
		TypedQuery<Musica> query = em.createQuery(jpql, Musica.class);
		query.setParameter("nome", "%"+nome+"%");
		
		List<Musica> musicas = query.getResultList();
		em.close();
		
		return musicas;
		
	}
	
	public void reajustarPreco(BigDecimal factor){
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
	
	public int removerMusicasBaratas(BigDecimal limite){
		
		EntityManager em = EntityManagerUtil.criarEntityManager();
		
		EntityTransaction transaction = em.getTransaction();
		transaction.begin();
		StringBuilder builder = new StringBuilder("DELETE FROM Musica m");
		builder.append(" WHERE m.preco < :limite");
		
		Query query = em.createQuery(builder.toString());
		query.setParameter("limite",limite);
		int n  = query.executeUpdate();
		transaction.commit();
		
		em.close();
		
		return n;
	}
}
