package model;

import java.util.ArrayList;
import java.util.LinkedList;

public class VetManager {

    private String nameVet;
    private String country;
    private PetManager petManager;
    private DoctorManager doctorManager;
    private AppointmentManager appointmentManager;
    private ArrayList<Medicine> medicinesList;

    public VetManager() {
        this.doctorManager = new DoctorManager();
        this.petManager = new PetManager();
        this.appointmentManager = new AppointmentManager();
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
     * Apointment
     */
    public void addAppointment(Appointment appointment){
        appointmentManager.addAppointment(appointment);
    }

    public ArrayList<Appointment> appointmenList(){
        return appointmentManager.getAppointmentList();
    }
}
