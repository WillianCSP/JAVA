package util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class EntityManagerUtil {
	
	private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("aula-jpa");
	
	public static EntityManager criarEntityManager(){
		return emf.createEntityManager();
	}
	
	public static void connect(){
		emf.isOpen();
	}
	
	public static void closeConnection(){
		emf.close();
	}

}
