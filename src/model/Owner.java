package model;

import java.util.ArrayList;

public class Owner {

    private String id;
    private String name;
    private String lastName;
    private ArrayList<Pet> petList;

    public Owner(String id, String name, String lastName, ArrayList<Pet> petList) {
        this.id = id;
        this.name = name;
        this.lastName = lastName;
        this.petList = petList;
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

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public ArrayList<Pet> getPetList() {
        return petList;
    }

    public void setPetList(ArrayList<Pet> petList) {
        this.petList = petList;
    }
}
