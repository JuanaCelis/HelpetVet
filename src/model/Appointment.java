package model;

import java.time.LocalDate;
import java.util.ArrayList;

public class Appointment {

    private int idAppointment;
    private String idDoctor;
    private String nameDoctor;
    private String idOwner;
    private String nameOwner;
    private int idPet;
    private String namePet;
    private CategoryEspeciality category;
    private LocalDate dateAppointment;
    private ArrayList<AppointmentResult> resultAppointmentList;

    public Appointment(int idAppointment, String idDoctor, String nameDoctor, String idOwner, String nameOwner, int idPet, String namePet, CategoryEspeciality category, LocalDate dateAppointment, ArrayList<AppointmentResult> resultAppointmentList) {
        this.idAppointment = idAppointment;
        this.idDoctor = idDoctor;
        this.nameDoctor = nameDoctor;
        this.idOwner = idOwner;
        this.nameOwner = nameOwner;
        this.idPet = idPet;
        this.namePet = namePet;
        this.category = category;
        this.dateAppointment = dateAppointment;
        this.resultAppointmentList = resultAppointmentList;
    }

    public int getIdAppointment() {
        return idAppointment;
    }

    public void setIdAppointment(int idAppointment) {
        this.idAppointment = idAppointment;
    }

    public String getIdDoctor() {
        return idDoctor;
    }

    public void setIdDoctor(String idDoctor) {
        this.idDoctor = idDoctor;
    }

    public String getNameDoctor() {
        return nameDoctor;
    }

    public void setNameDoctor(String nameDoctor) {
        this.nameDoctor = nameDoctor;
    }

    public String getIdOwner() {
        return idOwner;
    }

    public void setIdOwner(String idOwner) {
        this.idOwner = idOwner;
    }

    public String getNameOwner() {
        return nameOwner;
    }

    public void setNameOwner(String nameOwner) {
        this.nameOwner = nameOwner;
    }

    public int getIdPet() {
        return idPet;
    }

    public void setIdPet(int idPet) {
        this.idPet = idPet;
    }

    public String getNamePet() {
        return namePet;
    }

    public void setNamePet(String namePet) {
        this.namePet = namePet;
    }

    public CategoryEspeciality getCategory() {
        return category;
    }

    public void setCategory(CategoryEspeciality category) {
        this.category = category;
    }

    public LocalDate getDateAppointment() {
        return dateAppointment;
    }

    public void setDateAppointment(LocalDate dateAppointment) {
        this.dateAppointment = dateAppointment;
    }

    public ArrayList<AppointmentResult> getResultAppointmentList() {
        return resultAppointmentList;
    }

    public void setResultAppointmentList(ArrayList<AppointmentResult> resultAppointmentList) {
        this.resultAppointmentList = resultAppointmentList;
    }
}
