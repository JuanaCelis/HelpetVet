package model;

import java.time.LocalDate;

public class Doctor {

    private String id;
    private String name;
    private String lastName;
    private LocalDate birthday;
    private CategoryEspeciality categoryEspeciality;

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

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    public CategoryEspeciality getCategoryEspeciality() {
        return categoryEspeciality;
    }

    public void setCategoryEspeciality(CategoryEspeciality categoryEspeciality) {
        this.categoryEspeciality = categoryEspeciality;
    }
}
