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

    public void deleteMedicine(String description){
        for (int i = 0; i < medicinesList.size(); i++) {
            if (medicinesList.get(i).getDescriptionProduct().equalsIgnoreCase(description)){
                medicinesList.remove(i);
            }
        }
    }

    public ArrayList<Medicine> getMedicinesList() {
        return medicinesList;
    }

    public void setMedicinesList(ArrayList<Medicine> medicinesList) {
        this.medicinesList = medicinesList;
    }

    public ArrayList<Double> typesOfMedicines(){
        ArrayList<Double> list = new ArrayList<>();

        list.add((double) countTypesMedicines("VACUNA"));
        list.add((double) countTypesMedicines("Antibióticos"));
        list.add((double) countTypesMedicines("Antiparasitarios"));
        list.add((double) countTypesMedicines("Antiinflamatorios"));
        list.add((double) countTypesMedicines("Desinfectantes"));

        return list;
    }

    public int countTypesMedicines(String criterion){
        int result = 0;
        for (int i = 0; i < medicinesList.size(); i++) {
            if (medicinesList.get(i).getMedicineClass().contains(criterion)){
                result++;
            }
        }
        return result;
    }
}
