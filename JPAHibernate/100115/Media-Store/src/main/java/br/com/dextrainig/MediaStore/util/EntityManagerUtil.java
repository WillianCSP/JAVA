package br.com.dextrainig.MediaStore.util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class EntityManagerUtil {
	
	private static EntityManagerFactory emf;// = Persistence.createEntityManagerFactory("MediaStorePu");
	
	public static EntityManager criarEntityManager(){
		return emf.createEntityManager();
	}
	
	public static void connect(){
		emf = Persistence.createEntityManagerFactory("MediaStorePu");
		emf.isOpen();
	}
	
	public static void closeConnection(){
		emf.close();
	}

}
