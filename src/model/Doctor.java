package model;

import java.time.LocalDate;

public class Doctor {

    private String id;
    private String name;
    private String lastName;
    private LocalDate birthday;
    private CategoryEspeciality categoryEspeciality;
    private Appointment appointment;

    public Doctor(String id, String name, String lastName, LocalDate birthday, CategoryEspeciality categoryEspeciality) {
        this.id = id;
        this.name = name;
        this.lastName = lastName;
        this.birthday = birthday;
        this.categoryEspeciality = categoryEspeciality;
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public Object[] toObjectVector() {
        return new Object[] {getId(),getName(),getLastName(), getBirthday(),
                getCategoryEspeciality()};
    }

    /**
     * Recibe la cita asignada al doctor
     * @param Cita del doctor
     */
    public void setIdAppointment(Appointment appointment) {
        this.appointment = appointment;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    public Appointment getAppointment() {
        return appointment;
    }

    public CategoryEspeciality getCategoryEspeciality() {
        return categoryEspeciality;
    }

    public void setCategoryEspeciality(CategoryEspeciality categoryEspeciality) {
        this.categoryEspeciality = categoryEspeciality;
    }
}
