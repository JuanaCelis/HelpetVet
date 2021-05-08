package model;

import java.util.ArrayList;

public class MedicineManager {

    private ArrayList<Medicine> medicinesList;

    public MedicineManager(){
        medicinesList = new ArrayList<>();
    }

    public void addMedicine(Medicine medicine){
        medicinesList.add(medicine);
    }

    public ArrayList<Medicine> getMedicinesList() {
        return medicinesList;
    }

    public void setMedicinesList(ArrayList<Medicine> medicinesList) {
        this.medicinesList = medicinesList;
    }
}
