package hospital_project_dto;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class MedicineOrder {
	@Id
	private int medId;
	private String Dname;
	private String disease;
	
	@OneToMany(cascade = CascadeType.REMOVE)
	private List<MedicineItems> medicineItems;

	public int getMedId() {
		return medId;
	}

	public void setMedId(int medId) {
		this.medId = medId;
	}

	public String getDname() {
		return Dname;
	}

	public void setDname(String dname) {
		Dname = dname;
	}

	public String getDisease() {
		return disease;
	}

	public void setDisease(String disease) {
		this.disease = disease;
	}

	public List<MedicineItems> getMedicineItems() {
		return medicineItems;
	}

	public void setMedicineItems(List<MedicineItems> medicineItems) {
		this.medicineItems = medicineItems;
	}

	@Override
	public String toString() {
		return "MedicineOrder [medId=" + medId + ", Dname=" + Dname + ", disease=" + disease + ", medicineItems="
				+ medicineItems + "]";
	}
}
