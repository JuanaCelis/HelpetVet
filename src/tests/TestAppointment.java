package tests;

import model.Appointment;
import model.CategoryEspeciality;
import model.Doctor;

import java.time.LocalDate;
import java.util.ArrayList;

public class TestAppointment {

    private ArrayList<Appointment> appointmentList;
    private ArrayList<Doctor> doctorList;

    public TestAppointment() {
        appointmentList = new ArrayList<>();
        this.doctorList = new ArrayList<>();
        appointments();
        doctors();
    }

    public void appointments(){
        appointmentList.add(new Appointment(001, "03", "Juana", 0123, "Mango", CategoryEspeciality.ONCOLOGY, LocalDate.of(2021, 5, 6)));
        appointmentList.add(new Appointment(001, "02", "Cristobal", 0133, "Aguacate", CategoryEspeciality.PHISIOTHERAPY, LocalDate.of(2021, 6, 12)));

    }

    public ArrayList<Appointment> appointmentsList() {
        return appointmentList;
    }

    public void doctors(){
        doctorList.add(new Doctor("404", "Julian", "Ardila", LocalDate.of(2001, 8, 7), CategoryEspeciality.ONCOLOGY));
    }

    public ArrayList<Doctor> getDoctorList() {
        return doctorList;
    }
}
