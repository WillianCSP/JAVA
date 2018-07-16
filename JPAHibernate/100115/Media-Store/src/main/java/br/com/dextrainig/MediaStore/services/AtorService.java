package br.com.dextrainig.MediaStore.services;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

import br.com.dextrainig.MediaStore.entidades.Ator;
import br.com.dextrainig.MediaStore.util.EntityManagerUtil;

public class AtorService extends BaseService<Long, Ator> {
	
	public AtorService(){
		super(Ator.class);
	}
	
	public Ator buscarPorNome(String nome){
		
		StringBuilder builder = new StringBuilder("FROM Ator a");
		builder.append(" WHERE a.nome= :nome");
		
		EntityManager em = EntityManagerUtil.criarEntityManager();
		TypedQuery<Ator> query = em.createQuery(builder.toString(), Ator.class);
		
		query.setParameter("nome", nome);
		
		try{
			Ator ator = query.getSingleResult();
			em.close();
			
			return ator;
		}catch(NoResultException e){
			em.close();
			return null;
			
		}
				
	}

}
