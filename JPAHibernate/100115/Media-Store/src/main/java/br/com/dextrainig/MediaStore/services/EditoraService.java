package br.com.dextrainig.MediaStore.services;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

import br.com.dextrainig.MediaStore.entidades.Editora;
import br.com.dextrainig.MediaStore.util.EntityManagerUtil;

public class EditoraService extends BaseService<Long, Editora>{
	
	public EditoraService(){
		super(Editora.class);
	}
	
	public Editora buscarPorNome(String nome){
		
		StringBuilder builder = new StringBuilder("FROM Editora e");
		builder.append(" WHERE e.nome = :nome");
		
		EntityManager em = EntityManagerUtil.criarEntityManager();
		TypedQuery<Editora> query = em.createQuery(builder.toString(), Editora.class);
		query.setParameter("nome", nome);
		Editora editora =null;
		
		try{
			
			editora = query.getSingleResult();
		}catch(NoResultException e ){}
		
		
			em.close();
			return editora;
		
	}

}
