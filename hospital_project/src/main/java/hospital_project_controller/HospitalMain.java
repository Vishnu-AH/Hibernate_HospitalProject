package hospital_project_controller;

import java.util.Scanner;

import org.hibernate.internal.build.AllowSysOut;

import hospital_project_dao.AddressDao;
import hospital_project_dao.BranchDao;
import hospital_project_dao.EncounterDao;
import hospital_project_dao.HospitalDao;
import hospital_project_dao.MedItemsDao;
import hospital_project_dao.MedOrderDao;
import hospital_project_dao.PersonDao;
import hospital_project_dto.Address;
import hospital_project_dto.Branch;
import hospital_project_dto.Encounter;
import hospital_project_dto.Hospital;
import hospital_project_dto.MedicineItems;
import hospital_project_dto.MedicineOrder;
import hospital_project_dto.Person;

public class HospitalMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner scanner = new Scanner(System.in);
		Hospital hospital = new Hospital();
		HospitalDao hospitalDao = new HospitalDao();
		BranchDao branchDao = new BranchDao();
		AddressDao addressDao = new AddressDao();
		PersonDao personDao = new PersonDao();
		EncounterDao encounterDao = new EncounterDao();
		MedOrderDao medOrderDao = new MedOrderDao();
		MedItemsDao medicineItemsDAO = new MedItemsDao();
		
		boolean exit = true;
		do {
			System.out.println("=======To which one u want to perform actions======");
			System.out.println(" 1.Hospital \n 2.Branch \n 3.Address \n 4.Person \n 5.Encounter \n 6.MedicineOrder \n 7.MedicineItems \n 8.exit");
			System.out.print("Enter your choice : ");
			int choice = scanner.nextInt();

			switch (choice) {

			case 1: {
				boolean exit1 = true;
				do {
					System.out.println(" 1.Add hospital \n 2.Get hospital details by id \n 3.Delete Hospital\n 4.Get all hospital details \n 5.exit");
					System.out.print("Enter your choice : ");
					int choice1 = scanner.nextInt();
					switch (choice1) {
					case 1: {
						System.out.print("Enter the hospital id : ");
						int id = scanner.nextInt();
						System.out.print("Enter the hospital name : ");
						String name = scanner.next();
						System.out.print("Enter the gst : ");
						String gst = scanner.next();
						hospital.setId(id);
						hospital.setH_name(name);
						hospital.setGst(gst);
						hospitalDao.saveHospital(hospital);
					}
						break;
					case 2: {
						System.out.print("Enter the hospital id to get the details : ");
						int id = scanner.nextInt();
						hospitalDao.getHospitalById(id);
					}
						break;
					case 3 : {
						System.out.print("Enter the hospital id to be deleted : ");
						int id = scanner.nextInt();
						hospitalDao.deleteHospital(id);
					}
					break;
					case 4: {
						hospitalDao.getAllHospital();
					}
						break;
					case 5: {
						exit1 = false;
						System.out.println("======Thank you====");
					}
						break;
					default:
						System.out.println("Invalid choice");
					}
				} while (exit1);
			}
				break;
			case 2: {
				boolean exit2 = true;
				do {
					System.out.println(" 1.Add branch \n 2.Delete branch \n 3.Get branch details by id \n 4.Get all branch details \n 5.exit");
					System.out.print("Enter your choice : ");
					int choice1 = scanner.nextInt();
					switch (choice1) {
					case 1: {
						hospitalDao.getAllHospital();
						System.out.println(" ===========hospitals details==========");
						System.out.println("====Enter the hospital id to add the branch to the hospital====");
						System.out.print("Hospital id : ");
						int hospital_id = scanner.nextInt();
						System.out.println("======Add branch details======");
						System.out.print("enter the branch id : ");
						int bid = scanner.nextInt();
						System.out.print("Enter the branch name : ");
						String bname = scanner.next();
						System.out.print("Enter the phone : ");
						long phone = scanner.nextLong();
		
						Branch branch = new Branch();
						branch.setId(bid);
						branch.setBname(bname);
						branch.setPhone(phone);
		
						branchDao.saveBranch(branch, hospital_id);
					}
					break;
					case 2 : {
						System.out.print("Enter the branch id to be deleted : ");
						int id = scanner.nextInt();
						branchDao.deleteBranch(id);
					}
					break;
					case 3:{
						System.out.print("Enter the branch id to get the details : ");
						int id = scanner.nextInt();
						System.out.println(" ===========branch details==========");
						branchDao.getBranchById(id);;
					}
					break;
					case 4:{
						System.out.println(" ===========branch details==========");
						branchDao.getAll();
					}
					break;
					case 5:{
						exit2 = false;
						System.out.println("======Thank you====");						
					}
					break;
					default: System.out.println("Invalid choice");
					}
				}while(exit2);
			}
				break;
			case 3: {
				boolean exit3 = true;
				do {
					System.out.println(" 1.Add address \n 2.Delete address \n 3.Get address details by id \n 4.Get all address details \n 5.exit");
					System.out.print("Enter your choice : ");
					int choice1 = scanner.nextInt();
					switch (choice1) {
					case 1: {		
						branchDao.getAll();
						System.out.println(" ===========branch details==========");	
						System.out.println("===Enter the branch id to add address== ");
						System.out.print("Branch id : ");
						int branch_id = scanner.nextInt();						
						System.out.println("======Add Address=====");		
						System.out.print("enter the Address id : ");
						int aid = scanner.nextInt();
						System.out.print("Enter the address : ");
						String loc_name = scanner.next();
						System.out.print("Enter the pincode : ");
						long pincode = scanner.nextLong();		
						Address address = new Address();
						address.setId(aid);
						address.setName(loc_name);
						address.setPincode(pincode);		
						Branch branch = new Branch();
						branch.setId(branch_id);		
						addressDao.saveAddress(address, branch_id);
					}
					break;
					case 2 : {
						System.out.print("Enter the address id to be deleted : ");
						int id = scanner.nextInt();
						addressDao.deleteAddress(id);
					}
					break;
					case 3:{
						System.out.print("Enter the address id to get the details : ");
						int id = scanner.nextInt();
						System.out.println(" ===========address details==========");
						addressDao.getAddressById(id);
					}
					break;
					case 4:{
						System.out.println(" ===========address details==========");
						addressDao.getAll();
					}
					break;
					case 5:{
						exit3=false;
						System.out.println("======Thank you=====");
					}
					break;
					default:System.out.println("Invalid choice");				
					}
				}while(exit3);
			}
				break;
			case 4: {
				boolean exit4 = true;
				do {
					System.out.println(" 1.Add person \n 2.Delete Person \n 3.Get person details by id \n 4.Get all person details \n 5.exit");
					System.out.print("Enter your choice : ");
					int choice1 = scanner.nextInt();
					switch (choice1) {
					case 1: {
						System.out.println(" ===add person====");		
						System.out.print("Enter person id : ");
						int personId = scanner.nextInt();		
						System.out.print("Enter person name : ");
						String name = scanner.next();		
						System.out.print("Enter person phone : ");
						long phone = scanner.nextLong();		
						System.out.print("Enter the person Address : ");
						String address = scanner.next();		
						Person person = new Person();
						person.setPersonId(personId);
						person.setPersonName(name);
						person.setPersonPhone(phone);
						person.setPersonAddress(address);		
						personDao.savePerson(person);
					}
					break;
					case 2 : {
						System.out.print("Enter the person id to be deleted : ");
						int id = scanner.nextInt();
						personDao.deletePerson(id);
					}
					break;
					case 3:{
						System.out.print("Enter the person id to get the details : ");
						int id = scanner.nextInt();
						System.out.println(" ===========person details==========");
						personDao.fetchPerson(id);
					}
					break;
					case 4:{
						System.out.println(" ===========person details==========");
						personDao.fetchAllPersons();
					}
					break;
					case 5:{
						exit4=false;
						System.out.println("======Thank you=====");
					}
					break;
					default:System.out.println("Invalid choice");
					}
				}while(exit4);
			}
				break;
			case 5: {
				boolean exit5 = true;
				do {
					System.out.println(" 1.Add Encounter \n 2.Get Encounter details by id \n 3.Get all Encounter details \n 4.exit");
					System.out.print("Enter your choice : ");
					int choice1 = scanner.nextInt();
					switch (choice1) {
					case 1: {	
						personDao.fetchAllPersons();
						System.out.println("=====Person details=====");						
						System.out.println("======Enter person id to Encounter====");
						int personId = scanner.nextInt();					
						hospitalDao.getAllHospital();
						System.out.println(" ====the hospital details==== ");
						System.out.println("=============================");
						branchDao.getAll();
						System.out.println("====Hopsital branchs====");
						System.out.println("==To which branch u want to encounter==");		
						System.out.print("Enter the branch id u want to encounter : ");
						int bid = scanner.nextInt();		
						System.out.println(" =======Add Encounter=======");		
						System.out.print("enter the encounter id : ");
						int id = scanner.nextInt();		
						System.out.print("Enter the cause to encounter : ");
						String cause = scanner.next();						
						System.out.print("Enter the date of encounter : ");
						String date = scanner.next();		
						Encounter encounter = new Encounter();		
						encounter.setId(id);
						encounter.setCause(cause);
						encounter.setDate(date);
						Person person = new Person();
						person.setPersonId(personId);		
						Branch branch = new Branch();
						branch.setId(bid);						
						encounterDao.saveEncounter(encounter, personId, bid);
					}
					break;
					case 2:{
						System.out.print("Enter the encounter id to get the details : ");
						int id = scanner.nextInt();		
						System.out.println(" ===========encounter details==========");
						encounterDao.fetchById(id);
					}
					break;
					case 3:{
						System.out.println(" ===========encounter details==========");
						encounterDao.getAll();
					}
					break;
					case 4:{
						exit5=false;
						System.out.println("======Thank you=====");
					}
					break;
					default:System.out.println("Invalid choice");
					}
				}while(exit5);
			}
				break;
			case 6: {
				boolean exit6 = true;
				do {
					System.out.println(" 1.Add medicineOrder \n 2.Get medicineOrder details by id \n 3.Get all medicineOrder details \n 4.exit");
					System.out.print("Enter your choice : ");
					int choice1 = scanner.nextInt();
					switch (choice1) {
					case 1: {
						encounterDao.getAll();
						System.out.println("====encounter details=====");
						System.out.print("enter the encounter id : ");
						int eid = scanner.nextInt();
						System.out.println("======enter the medicineOrder==========");
						System.out.print("Enter the medicineOrder id : ");
						int id = scanner.nextInt();
						System.out.print("Enter the consulted doctor name : ");
						String name = scanner.next();
						System.out.print("Enter the disease : ");
						String disease = scanner.next();
						MedicineOrder medicineOrder = new MedicineOrder();
						medicineOrder.setMedId(id);
						medicineOrder.setDname(name);
						medicineOrder.setDisease(disease);
						Encounter encounter = new Encounter();
						encounter.setId(eid);
						medOrderDao.saveMedicineOrder(medicineOrder, eid);
					}
					break;
					case 2:{
						System.out.println("Enter the medicineOrder id to get the details : ");
						int id = scanner.nextInt();
						System.out.println(" ===========medicineOrder details==========");
						medOrderDao.getMedicineOrderById(id);
					}
					break;
					case 3:{
						System.out.println(" ===========medicineOrder details==========");	
						medOrderDao.getAllMedicineOrder();
					}
					break;
					case 4:{
						exit6=false;
						System.out.println("======Thank you=====");
					}
					break;
					default:System.out.println("Invalid choice");
					}
				}while(exit6);
			}
			break;
			case 7: {
				boolean exit7 = true;
				do {
					System.out.println(" 1.Add medicineItems \n 2.Get medicineItems details by id \n 3.Get all medicineItems details \n 4.exit");
					System.out.print("Enter your choice : ");
					int choice1 = scanner.nextInt();
					switch (choice1) {
					case 1: {
						medOrderDao.getAllMedicineOrder();
						System.out.println("=======medicienOrder details============");
						System.out.print("Enter the medicineOrder id : ");
						int mid = scanner.nextInt();
						System.out.println("======enter the medicineItems==========");
						System.out.print("Enter the medicineItems id : ");
						int id = scanner.nextInt();
						System.out.print("Enter the medicineItem name : ");
						String name = scanner.next();
						System.out.print("Enter the medicineItem price : ");
						double price = scanner.nextDouble();
						System.out.print("Enter the medicine quantity : ");
						int quantity = scanner.nextInt();
						MedicineItems medicineItems = new MedicineItems();
						medicineItems.setId(id);
						medicineItems.setName(name);
						medicineItems.setPrice(price);
						medicineItems.setQuantity(quantity);
						MedicineOrder medicineOrder = new MedicineOrder();
						medicineOrder.setMedId(mid);
						medicineItemsDAO.saveMedicineItems(medicineItems, mid);
					}
					break;
					case 2:{
						System.out.print("Enter the medicineItems id to get the details : ");
						int id = scanner.nextInt();
						System.out.println(" ===========medicineItems details==========");
						medicineItemsDAO.getMedicineItemsById(id);
					}
					break;
					case 3:{
						System.out.println(" ===========medicineItems details==========");
						medicineItemsDAO.getAllMedicineItems();
					}
					break;
					case 4:{
						exit7=false;
						System.out.println("======Thank you=====");
					}
					break;
					default:System.out.println("Invalid choice");
					}
				}while(exit7);
					}
				break;
			case 8: {
				exit = false;
				System.out.println("Thank you");
			}
				break;
			default:
				System.out.println("Invalid choice");
			}
		} while (exit);
	}
}