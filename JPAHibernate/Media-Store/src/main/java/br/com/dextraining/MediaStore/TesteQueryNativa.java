package br.com.dextraining.MediaStore;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.dextraining.MediaStore.util.EntityManagerUtil;

public class TesteQueryNativa {

	
	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		EntityManager em = EntityManagerUtil.criarEntityManager();
		
		String sql = "Select tipo_produto, SUM(preco) "
				+ "from produto GROUP BY tipo_produto";
		
		Query query = em.createNativeQuery(sql);
		
		List<Object[]> result = (List<Object[]>)query.getResultList();
		
		for (Object[] linha : result) {
//			for (Object obj : object) {
//				System.out.println(obj);
//			}
			System.out.println("Tipo:" +  linha[0] + " - Preco R$" + linha[1]);
		}
		
		em.close();
		EntityManagerUtil.closeConnection();
	}
}
