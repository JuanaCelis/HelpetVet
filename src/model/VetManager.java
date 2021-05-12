package model;

import java.util.ArrayList;
import java.util.List;

public class VetManager {

    private String nameVet;
    private String country;
    private PetManager petManager;
    private DoctorManager doctorManager;
    private AppointmentManager appointmentManager;
    private MedicineManager medicineManager;
    private ArrayList<Medicine> medicinesList;

    public VetManager() {
        this.doctorManager = new DoctorManager();
        this.petManager = new PetManager();
        this.appointmentManager = new AppointmentManager();
        this.medicineManager = new MedicineManager();
    }

    public void addPet(Pet pet){
        petManager.addPet(pet);
    }

    public ArrayList<Pet> getPetsList() {
        return petManager.getPetsList();
    }

    /**
     * Doctors
     */
    public void addDoctor(Doctor doctor){
        doctorManager.addDoctor(doctor);
    }

    public ArrayList<Doctor> getDoctors() {
        return doctorManager.getDoctors();
    }

    /**
     * Medicine
     */
    public void addMedicine(Medicine medicine){
        medicineManager.addMedicine(medicine);
    }

    public ArrayList<Medicine> getMedicine() {
        return medicineManager.getMedicinesList();
    }


    /**
     * Apointment
     */
    public void addAppointment(Appointment appointment){
        appointmentManager.addAppointment(appointment);
    }

    public ArrayList<Appointment> appointmenList(){
        return appointmentManager.getAppointmentList();
    }

    public List<Double> percentageCategoriesAppointment(){
        return appointmentManager.percentageCategoriesAppointment();
    }

    public ArrayList<Integer> getMonths(){
        return appointmentManager.getMonths();
    }

    public void deleteAppointment(int idPet){
        appointmentManager.deleteAppointment(idPet);
    }

    /**
     * Mascotas
     */
    public ArrayList<Double> frequentPets(){
        return petManager.frequentPets();
    }

    public ArrayList<Integer> getPercentageGender(){
       return petManager.getPercentageGender();
    }

    public void deletePet(int idOwner){
        petManager.deletePet(idOwner);
    }

    /**
     * Doctores
     */
    public ArrayList<Double> percentageDoctorForCategory(){
        return doctorManager.percentageDoctorForCategory();
    }

    public void deleteDoctor(String idDoctor){
        doctorManager.deleteDoctor(idDoctor);
    }

    /**
     * Medicina
     */
    public ArrayList<Double> typesOfMedicines(){
        return medicineManager.typesOfMedicines();
    }


}
