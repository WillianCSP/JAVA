package br.com.dextrainig.MediaStore.services;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

import br.com.dextrainig.MediaStore.util.EntityManagerUtil;

public abstract class BaseService<T, C> {
	
	protected Class<C> entityClass;
	
	public BaseService(Class<C> entityClass){
		this.entityClass = entityClass;
	}
	
	public C findById(T id){
		
		C entity;
		EntityManager em = EntityManagerUtil.criarEntityManager();
		entity = em.find(entityClass, id);
		em.close();
		return entity;
	}
	
	public List<C> findAll(){
		
		EntityManager em = EntityManagerUtil.criarEntityManager();
		String jpql = "FROM " + entityClass.getSimpleName();
		TypedQuery<C> query = em.createQuery(jpql, entityClass);
		List<C> resultList = query.getResultList();
		em.close();
		return resultList;
	}
	
	public C persist(C entity){
		
		EntityManager em = EntityManagerUtil.criarEntityManager();
		EntityTransaction transaction = null;
		
		try{
		
			transaction = em.getTransaction();
			transaction.begin();
			em.persist(entity);
			transaction.commit();
	
		}catch(RuntimeException e){
		
			if(transaction != null && transaction.isActive())
			transaction.rollback();
	
		}finally{
			em.close();
		}
		
		return entity;
	}
	
	public void remove(C entity){
		
		EntityManager em = EntityManagerUtil.criarEntityManager();
		EntityTransaction transaction = null;
		
		try{
		
			transaction = em.getTransaction();
			transaction.begin();
			entity = em.merge(entity);
			em.remove(entity);
			transaction.commit();
	
		}catch(RuntimeException e){
		
			if(transaction != null && transaction.isActive())
			transaction.rollback();
	
		}finally{
			em.close();
		}
		
	}
	
	public C update(C entity){
		
		EntityManager em = EntityManagerUtil.criarEntityManager();
		EntityTransaction transaction = null;
		
		try{
		
			transaction = em.getTransaction();
			transaction.begin();
			entity = em.merge(entity);
			transaction.commit();
	
		}catch(RuntimeException e){
		
			if(transaction != null && transaction.isActive())
			transaction.rollback();
	
		}finally{
			em.close();
		}
		
		return entity;
	}

}
