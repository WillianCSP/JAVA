package br.com.dextrainig.MediaStore.services;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.TypedQuery;






import br.com.dextrainig.MediaStore.entidades.Livro;
import br.com.dextrainig.MediaStore.entidades.Musica;
import br.com.dextrainig.MediaStore.util.EntityManagerUtil;

public class LivroService extends BaseService<Long, Livro> {

	
	public LivroService(){
		super(Livro.class);
	}
	
	public List<Livro> listarPorPreco(){
		
		EntityManager em = EntityManagerUtil.criarEntityManager();
		
		String jpql = "FROM Livro m ORDER BY m.preco";
		TypedQuery<Livro> query = em.createQuery(jpql, Livro.class);
		List<Livro> livros = query.getResultList();
		em.close();
		
		return livros;
		
	}
	
	public List<Livro> buscarPorTitulo(String titulo){
		
		EntityManager em = EntityManagerUtil.criarEntityManager();
		
		String jpql = "FROM Livro m WHERE m.nome LIKE :titulo ORDER BY m.preco";
		
		TypedQuery<Livro> query = em.createQuery(jpql, Livro.class);
		query.setParameter("titulo", "%"+titulo+"%");
		
		List<Livro> livros = query.getResultList();
		em.close();
		
		return livros;
		
	}
	
	public void reajustarPreco(BigDecimal factor){
		EntityManager em = EntityManagerUtil.criarEntityManager();
		
		EntityTransaction transaction = em.getTransaction();
		transaction.begin();
		StringBuilder builder = new StringBuilder("UPDATE Livro m");
		builder.append(" SET m.preco = m.preco * :factor");
		
		Query query = em.createQuery(builder.toString());
		query.setParameter("factor", factor);
		query.executeUpdate();
		transaction.commit();
		em.close();
	}
	
	public List<Livro> buscarPorEditora(String nome){
		
		EntityManager em = EntityManagerUtil.criarEntityManager();
		
		String jpql = "FROM Livro m WHERE m.editora.nome LIKE :nome";
		
		TypedQuery<Livro> query = em.createQuery(jpql, Livro.class);
		query.setParameter("nome", "%"+nome+"%");
		
		List<Livro> livros = query.getResultList();
		em.close();
		
		return livros;
		
	}
	
}
