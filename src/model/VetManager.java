package model;

import java.util.ArrayList;

public class VetManager {

    private String nameVet;
    private String country;
    private ArrayList<Owner> ownerList;
    private ArrayList<Appointment> appointmentList;
    private ArrayList<Doctor> doctorList;
    private ArrayList<Medicine> medicinesList;

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
