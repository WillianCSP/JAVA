package br.com.dextrainig.MediaStore.services;

import java.math.BigDecimal;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import br.com.dextrainig.MediaStore.entidades.Categoria;
import br.com.dextrainig.MediaStore.entidades.Venda;
import br.com.dextrainig.MediaStore.util.EntityManagerUtil;

public class VendaService extends BaseService<Long, Venda>{
	
	public VendaService(){
		super(Venda.class);
	}
	
	public BigDecimal consultaTotalPorCliente(Long id){
		
		String sql = "select sum(total) from Venda where cliente_id ="+id;
		EntityManager em = EntityManagerUtil.criarEntityManager();
		Query q = em.createNativeQuery(sql);
		
		try{
		BigDecimal total = (BigDecimal) q.getSingleResult();
		em.close();
		
		return total;
		
		}catch(NoResultException e){
			e.printStackTrace();
			em.close();
			return null;
		}
	}

}
