package br.com.dextraining.MediaStore.services;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import br.com.dextraining.MediaStore.entities.Livro;
import br.com.dextraining.MediaStore.util.EntityManagerUtil;

public class LivroService extends BaseService<Long, Livro> {

	public LivroService() {
		super(Livro.class);
	}
	
	public List<Livro> buscarPorNome(String nome) {
		EntityManager em = EntityManagerUtil.criarEntityManager();
		StringBuilder builder = new StringBuilder("FROM Livro l");
		builder.append(" WHERE l.nome LIKE :nome");
		builder.append(" ORDER BY l.nome");
		TypedQuery<Livro> query = 
				em.createQuery(builder.toString(), Livro.class);
		query.setParameter("nome", "%"+nome+"%");
		List<Livro> livros = query.getResultList();
		em.close();
		return livros;
	}
	
	// TODO Listar livros de editora que contem nome ...
	public List<Livro> buscarPorEditora(String nomeEditora) {
		StringBuilder builder = new StringBuilder("FROM Livro l");
		builder.append(" WHERE l.editora.nome LIKE :nome");
		
		EntityManager em = EntityManagerUtil.criarEntityManager();
		TypedQuery<Livro> query = em.createQuery(builder.toString(), Livro.class);
		
		query.setParameter("nome", "%" + nomeEditora + "%");
		
		List<Livro> livros = query.getResultList();
		em.close();
		return livros;
	}
}
