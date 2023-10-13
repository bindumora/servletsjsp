package Dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import Dto.Employee;

public class EmployeeDao {

	
	EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("sharath");
	EntityManager entityManager=entityManagerFactory.createEntityManager();
	EntityTransaction entityTransaction=entityManager.getTransaction();
	
	
	public void saveBoth(Employee e)
	{
		entityTransaction.begin();
		entityManager.persist(e);
		entityTransaction.commit();
	}
}
