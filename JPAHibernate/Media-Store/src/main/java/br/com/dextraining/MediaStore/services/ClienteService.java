package br.com.dextraining.MediaStore.services;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import br.com.dextraining.MediaStore.entities.Cliente;
import br.com.dextraining.MediaStore.entities.Estado;
import br.com.dextraining.MediaStore.util.EntityManagerUtil;

public class ClienteService extends BaseService<Long, Cliente> {
	public ClienteService() {
		super(Cliente.class);
	}
	
	public List<Cliente> listarPorEstado(Estado estado) {
		StringBuilder builder = new StringBuilder("FROM Cliente c");
		builder.append(" WHERE c.endereco.estado = :estado");
		
		EntityManager em = EntityManagerUtil.criarEntityManager();
		TypedQuery<Cliente> query = em.createQuery(builder.toString(), Cliente.class);
		
		query.setParameter("estado", estado);
		
		List<Cliente> clientes = query.getResultList();
		em.close();
		return clientes;
	}
}
