package manytoone_uni.dao;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

public class CollegeDao {

	public EntityManager getEntityManager() {
		return Persistence.createEntityManagerFactory("sujit").createEntityManager();
	}
	
	
}
