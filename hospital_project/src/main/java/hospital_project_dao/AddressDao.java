package hospital_project_dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import hospital_project_dto.Address;
import hospital_project_dto.Branch;

public class AddressDao {

	public EntityManager getEntityManager() {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("vinod");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		return entityManager;
	}

	public void saveAddress(Address address, int branch_id) {
		EntityManager entityManager = getEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		Branch branch = entityManager.find(Branch.class, branch_id);
		if (branch != null) {
			entityTransaction.begin();
			branch.setId(branch_id);
			branch.setAddress(address);
			entityManager.persist(address);
			entityManager.merge(branch);
			entityTransaction.commit();
		}
	}

	public void updateAddress(Address address) {
		EntityManager entityManager = getEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		Address address1 = entityManager.find(Address.class, address.getId());
		address1.setId(address.getId());
		address1.setName(address.getName());
		entityTransaction.begin();
		entityManager.merge(address1);
		entityTransaction.commit();
	}

	public void deleteAddress(int id) {
		EntityManager entityManager = getEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		Address address2 = entityManager.find(Address.class, id);
		address2.setId(id);
		entityTransaction.begin();
		entityManager.remove(address2);
		entityTransaction.commit();
	}

	public void getAddressById(int id) {
		EntityManager entityManager = getEntityManager();
		Address address2 = entityManager.find(Address.class, id);
		System.out.println(address2);
	}

	public void getAll() {
		EntityManager entityManager = getEntityManager();
		Query query = entityManager.createQuery("SELECT b from Address b");
		List resultList = query.getResultList();
		System.out.println(resultList);
	}
}