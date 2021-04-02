package tests;

import model.Appointment;
import model.Doctor;

import java.util.ArrayList;

public class TestAppointment {

    private ArrayList<Appointment> appointmentList;
    private ArrayList<Doctor> doctorList;

    public TestAppointment() {
        this.doctorList = new ArrayList<>();
    }

    public ArrayList<Doctor> getDoctorList() {
        return doctorList;
    }

    public ArrayList<Appointment> appointmentsList() {
        return appointmentList;
    }
}
