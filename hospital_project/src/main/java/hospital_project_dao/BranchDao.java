package hospital_project_dao;

import java.util.ArrayList;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import hospital_project_dto.Branch;
import hospital_project_dto.Hospital;

public class BranchDao {
	public EntityManager getEntityManager() {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("vinod");
		return entityManagerFactory.createEntityManager();
	}

	public void saveBranch(Branch branch, int hospital_id) {
		EntityManager entityManager = getEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();

		Hospital hospital = entityManager.find(Hospital.class, hospital_id);
		if (hospital != null) {
			List<Branch> existingBranch = hospital.getBranches();
			if (existingBranch != null) {
				existingBranch.add(branch);
				entityTransaction.begin();
				hospital.setId(hospital_id);
				hospital.setBranches(existingBranch);
				entityManager.persist(branch);
				entityManager.merge(hospital);
				entityTransaction.commit();
			} else {
				List<Branch> newbranch = new ArrayList<Branch>();
				newbranch.add(branch);
				entityTransaction.begin();
				hospital.setId(hospital_id);
				hospital.setBranches(newbranch);
				entityManager.persist(newbranch);
				entityManager.merge(hospital);
				entityTransaction.commit();
			}
		} else {
			System.out.println("Hospital is not available...cannot create branch without hospital");
		}

	}

	public void updateBranch(Branch branch) {
		EntityManager entityManager = getEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		Branch branch2 = entityManager.find(Branch.class, branch.getId());
		branch2.setId(branch.getId());
		branch2.setBname(branch.getBname());
		entityTransaction.begin();
		entityManager.merge(branch2);
		entityTransaction.commit();
	}

	public void deleteBranch(int id) {
		EntityManager entityManager = getEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		Branch branch2 = entityManager.find(Branch.class, id);
		branch2.setId(id);
		entityTransaction.begin();
		entityManager.remove(branch2);
		entityTransaction.commit();
	}

	public void getBranchById(int id) {
		EntityManager entityManager = getEntityManager();
		Branch branch2 = entityManager.find(Branch.class, id);
		branch2.setId(id);
		System.out.println(branch2);
	}

	public void getAll() {
		EntityManager entityManager = getEntityManager();
		Query query = entityManager.createQuery("SELECT b from Branch b");
		List<Branch> list = query.getResultList();
		System.out.println(list);
	}
}
