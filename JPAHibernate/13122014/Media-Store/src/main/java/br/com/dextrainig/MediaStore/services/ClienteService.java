package br.com.dextrainig.MediaStore.services;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import br.com.dextrainig.MediaStore.entidades.Cliente;
import br.com.dextrainig.MediaStore.entidades.Estado;
import br.com.dextrainig.MediaStore.entidades.Livro;
import br.com.dextrainig.MediaStore.entidades.Musica;
import br.com.dextrainig.MediaStore.util.EntityManagerUtil;

public class ClienteService extends BaseService<Long, Cliente> {

	
	public ClienteService(){
		super(Cliente.class);
	}

	public List<Cliente> listarPorNome(){
		
		EntityManager em = EntityManagerUtil.criarEntityManager();
		
		String jpql = "FROM Cliente c ORDER BY c.nome";
		TypedQuery<Cliente> query = em.createQuery(jpql, Cliente.class);
		List<Cliente> clientes = query.getResultList();
		em.close();
		
		return clientes;
		
	}
	
	public List<Cliente> listarporEstado(Enum<Estado> estado){
		
		EntityManager em = EntityManagerUtil.criarEntityManager();
		
		String jpql = "FROM Cliente c WHERE c.endereco.estado= :estado"
				+ " ORDER BY c.endereco.nome";
		TypedQuery<Cliente> query = em.createQuery(jpql, Cliente.class);
		query.setParameter("estado", estado);
		List<Cliente> clientes = query.getResultList();
		em.close();
		
		return clientes;
	}

	public List<Cliente> buscarPorNome(String nome){
		
		EntityManager em = EntityManagerUtil.criarEntityManager();
		
		String jpql = "FROM Cliente m WHERE m.nome LIKE :nome";
		
		TypedQuery<Cliente> query = em.createQuery(jpql, Cliente.class);
		query.setParameter("nome", "%"+nome+"%");
		
		List<Cliente> clientes = query.getResultList();
		em.close();
		
		return clientes;
		
	}
	
	
	
}
