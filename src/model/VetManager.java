package model;

import java.util.ArrayList;

public class VetManager {

    private String nameVet;
    private String country;
    private PetManager petManager;
    private DoctorManager doctorManager;
    //private AppointmentManager appointmentManager;
    private ArrayList<Medicine> medicinesList;

    public VetManager() {
        this.doctorManager = new DoctorManager();
        this.petManager = new PetManager();
    }





    public PetManager getPetManager() {
        return petManager;
    }

    public ArrayList<Pet> getPetsList(){
        return petManager.getPetsList();
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

    public ArrayList<Doctor> getDoctors(){
        return doctorManager.getDoctors();
    }

    public DoctorManager getDoctorManager() {
        return doctorManager;
    }

    public ArrayList<Medicine> getMedicinesList() {
        return medicinesList;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public void setDoctorsList(ArrayList<Doctor> doctors){
        doctorManager.setDoctors(doctors);
    }

    public void setMedicinesList(ArrayList<Medicine> medicinesList) {
        this.medicinesList = medicinesList;
    }
}
