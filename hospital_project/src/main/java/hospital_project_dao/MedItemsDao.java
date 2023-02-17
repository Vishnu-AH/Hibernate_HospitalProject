package hospital_project_dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import hospital_project_dto.MedicineItems;
import hospital_project_dto.MedicineOrder;

public class MedItemsDao {

	public EntityManager getEntityManager() {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("vinod");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		return entityManager;
	}
	public void saveMedicineItems(MedicineItems medicineItems, int medicineOrder_id) {
		EntityManager entityManager = getEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		MedicineOrder medicineOrder = entityManager.find(MedicineOrder.class, medicineOrder_id);
		List<MedicineItems> medicineItemsList = medicineOrder.getMedicineItems();
		if (medicineItemsList != null) {
			medicineItemsList.add(medicineItems);
			medicineOrder.setMedId(medicineOrder_id);
			medicineOrder.setMedicineItems(medicineItemsList);
			entityTransaction.begin();
			entityManager.persist(medicineItems);
			entityManager.merge(medicineOrder);
			entityTransaction.commit();
		} else {
			medicineItemsList.add(medicineItems);
			medicineOrder.setMedId(medicineOrder_id);
			medicineOrder.setMedicineItems(medicineItemsList);
			entityTransaction.begin();
			entityManager.persist(medicineItems);
			entityManager.merge(medicineOrder);
			entityTransaction.commit();
		}
	}
	public void getMedicineItemsById(int id) {
		EntityManager entityManager = getEntityManager();
		MedicineItems medicineItems = entityManager.find(MedicineItems.class, id);
		System.out.println(medicineItems);
	}
	public void getAllMedicineItems() {
		EntityManager entityManager = getEntityManager();
		Query query = entityManager.createQuery("select m from MedicineItems m");
		List<MedicineItems> list = query.getResultList();
		System.out.println(list);
	}
}