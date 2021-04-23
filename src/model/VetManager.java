package model;

import java.util.ArrayList;

public class VetManager {

    private String nameVet;
    private String country;
    private OwnerManager ownerManager;
    private DoctorManager doctorManager;
    // private AppointmentManager appointmentManager;
    private ArrayList<Medicine> medicinesList;

    public VetManager(/*ArrayList<Owner> ownerManager*/) {
        //this.ownerManager = new OwnerManager(ownerManager);
        this.doctorManager = new DoctorManager();
    }

    /**
     * Establece el ID no repetidos para las mascotas
     */
    public void setIdPets(){
        int idPet = 1;
        for (int i = 0; i < ownerManager.getOwnerList().size(); i++) {
            ArrayList<Pet> pets = ownerManager.getOwnerList().get(i).getPetList();
            for (int j = 0; j < pets.size(); j++) {
                pets.get(j).setId((idPet++));
            }
        }
    }

    public String getNameVet() {
        return nameVet;
    }

    public void setNameVet(String nameVet) {
        this.nameVet = nameVet;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public ArrayList<Owner> ownersList() {
        return ownerManager.getOwnerList();
    }

    public OwnerManager getOwnerManager() {
        return ownerManager;
    }

    public void setDoctorsList(ArrayList<Doctor> doctors){
        doctorManager.setDoctors(doctors);
    }

    public ArrayList<Doctor> getDoctors(){
        return doctorManager.getDoctors();
    }

    public DoctorManager getDoctorManager() {
        return doctorManager;
    }

    public ArrayList<Medicine> getMedicinesList() {
        return medicinesList;
    }

    public void setMedicinesList(ArrayList<Medicine> medicinesList) {
        this.medicinesList = medicinesList;
    }
}
