package model;

import java.time.LocalDate;

public class Appointment {

    private int idAppointment;
    private String idOwner;
    private String nameOwner;
    private String lastNameOwner;
    private int idPet;
    private String namePet;
    private CategoryEspeciality category;
    private LocalDate dateAppointment;
    private Doctor doctor;
    
    public Appointment(int idAppointment, String idOwner,  String nameOwner, String lastNameOwner, int idPet, String namePet, CategoryEspeciality category, LocalDate dateAppointment) {
        this.idAppointment = idAppointment;
        this.idOwner = idOwner;
        this.nameOwner = nameOwner;
        this.lastNameOwner = lastNameOwner;
        this.idPet = idPet;
        this.namePet = namePet;
        this.category = category;
        this.dateAppointment = dateAppointment;
    }

    public Appointment(String idOwner, String lastNameOwner, String nameOwner,String namePet, CategoryEspeciality category, LocalDate dateAppointment) {
        this.idOwner = idOwner;
        this.nameOwner = nameOwner;
        this.lastNameOwner = lastNameOwner;
        this.namePet = namePet;
        this.category = category;
        this.dateAppointment = dateAppointment;
    }

    public Appointment(int idAppointment, String idOwner, String nameOwner, int idPet, String namePet, CategoryEspeciality category, LocalDate dateAppointment) {
        this.idAppointment = idAppointment;
        this.idOwner = idOwner;
        this.nameOwner = nameOwner;
        this.lastNameOwner = lastNameOwner;
        this.idPet = idPet;
        this.namePet = namePet;
        this.category = category;
        this.dateAppointment = dateAppointment;
    }

    public int getIdAppointment() {
        return idAppointment;
    }

    public void setIdAppointment(int idAppointment) {
        this.idAppointment = idAppointment;
    }

    public void setDoctor(Doctor doctor){
        this.doctor = doctor;
    }

    public Doctor getDoctor() {
        return doctor;
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

    public Object[] toObjectVector() {
        return new Object[]{getCategory()+"",getNamePet(),getDateAppointment(),getIdPet(),getIdOwner(),getNameOwner()};
    }
}
