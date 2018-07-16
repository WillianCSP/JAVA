package br.com.dextrainig.MediaStore.services;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

import br.com.dextrainig.MediaStore.entidades.Categoria;
import br.com.dextrainig.MediaStore.entidades.Venda;
import br.com.dextrainig.MediaStore.util.EntityManagerUtil;

public class VendaService extends BaseService<Long, Venda>{
	
	public VendaService(){
		super(Venda.class);
	}
	
	
//	public Categoria buscarPorNome(String nome){
//		
//		StringBuilder builder = new StringBuilder("FROM Categoria c ");
//		builder.append("WHERE c.nome = :nome");
//		
//		EntityManager em = EntityManagerUtil.criarEntityManager();
//		TypedQuery<Categoria> query = em.createQuery(builder.toString(), Categoria.class);
//		query.setParameter("nome", nome);
//		
//		try{
//		Categoria categoria = query.getSingleResult();
//		em.close();
//		
//		return categoria;
//		
//		}catch(NoResultException e){
//			em.close();
//			return null;
//		}
//	}

}
