package model;

import java.time.LocalDate;

public class AppointmentResult {

    private String medicalObservation;
    private LocalDate dateOfResult;
    private int qualification;

    public AppointmentResult(String medicalObservation, LocalDate dateOfResult, int qualification) {
        this.medicalObservation = medicalObservation;
        this.dateOfResult = dateOfResult;
        this.qualification = qualification;
    }

    public String getMedicalObservation() {
        return medicalObservation;
    }

    public void setMedicalObservation(String medicalObservation) {
        this.medicalObservation = medicalObservation;
    }

    public LocalDate getDateOfResult() {
        return dateOfResult;
    }

    public void setDateOfResult(LocalDate dateOfResult) {
        this.dateOfResult = dateOfResult;
    }

    public int getQualification() {
        return qualification;
    }

    public void setQualification(int qualification) {
        this.qualification = qualification;
    }
}
