package br.com.tec.utils;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class EntityManagerUtils {
	
	
	public EntityManager getEntityManager() {
		EntityManagerFactory factory = null;
		EntityManager entityManager = null;
		
		if (factory == null || !factory.isOpen()) {
			factory = Persistence.createEntityManagerFactory("CarteiraVirtual");
		}
		
		if (entityManager == null) {
			entityManager = factory.createEntityManager();
		}
		return entityManager;
	}

}
