package hospital_project_dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import hospital_project_dto.Hospital;

public class HospitalDao {
	
	public EntityManager getEntityManager() {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("vinod");
		return entityManagerFactory.createEntityManager();
	}
	
	public void saveHospital(Hospital hospital) {
		EntityManager entityManager = getEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();
		entityManager.persist(hospital);
		entityTransaction.commit();
	}
	public void updateHospital(int id,Hospital hospital) {
		EntityManager entityManager = getEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		Hospital hospital2 = entityManager.find(Hospital.class,hospital.getId());
		hospital2.setId(hospital.getId());
		entityTransaction.begin();
		entityManager.merge(hospital2);
		entityTransaction.commit();
	}
	
	public void deleteHospital(int id) {
		EntityManager entityManager = getEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		Hospital hospital2 = entityManager.find(Hospital.class,id);
		hospital2.setId(id);
		entityTransaction.begin();
		entityManager.remove(hospital2);
		entityTransaction.commit();
	}
	
	public void getHospitalById(int id) {
		EntityManager entityManager = getEntityManager();
		Hospital hospital = entityManager.find(Hospital.class,id);
		System.out.println(" ===========hospitals details==========");
		System.out.println(hospital);
	}
	public void getAllHospital() {
		EntityManager entityManager = getEntityManager();
		Query query = entityManager.createQuery("select h from Hospital h");
		List<Hospital> list = query.getResultList();
		System.out.println(" ===========hospitals details==========");
		System.out.println(list);
	}
}