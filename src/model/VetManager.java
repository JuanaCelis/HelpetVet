package model;

import java.util.ArrayList;

public class VetManager {

    private String nameVet;
    private String country;
    private ArrayList<Owner> ownerList;
    private ArrayList<Appointment> appointmentList;
    private ArrayList<Doctor> doctorList;
    private ArrayList<Medicine> medicinesList;

    public VetManager() {

    }

    /**
     * Metodo que nos retorna la cantidad total de mascotas registradas
     * @return Total pets
     */
    public int getTotalPets(){
        int totalPets = 0;
        for (int i = 0; i < ownerList.size(); i++) {
            totalPets += ownerList.get(i).getPetList().size();
        }
        return totalPets;
    }

    /**
     * Establece el ID no repetidos para las mascotas
     */
    public void setIdPets(){
        int idPet = 1;
        for (int i = 0; i < ownerList.size(); i++) {
            ArrayList<Pet> pets = ownerList.get(i).getPetList();
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

    public ArrayList<Owner> getOwnerList() {
        return ownerList;
    }

    public void setOwnerList(ArrayList<Owner> ownerList) {
        this.ownerList = ownerList;
    }

    public ArrayList<Appointment> getAppointmentList() {
        return appointmentList;
    }

    public void setAppointmentList(ArrayList<Appointment> appointmentList) {
        this.appointmentList = appointmentList;
    }

    public ArrayList<Doctor> getDoctorList() {
        return doctorList;
    }

    public void setDoctorList(ArrayList<Doctor> doctorList) {
        this.doctorList = doctorList;
    }

    public ArrayList<Medicine> getMedicinesList() {
        return medicinesList;
    }

    public void setMedicinesList(ArrayList<Medicine> medicinesList) {
        this.medicinesList = medicinesList;
    }
}
