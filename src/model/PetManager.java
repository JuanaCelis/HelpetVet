package model;

import java.util.ArrayList;

public class PetManager {

    private ArrayList<Pet> petsList;

    public PetManager() {
        this.petsList = new ArrayList<>();
    }

    /**
     * Metodo que nos retorna la cantidad total de mascotas registradas
     * @return Total pets
     */
    public int getTotalPets(){
        return petsList.size();
    }

    public void addPet(Pet pet){
        if (!petsList.contains(pet)){
            petsList.add(pet);
        }
    }

    public ArrayList<Pet> getPetsList() {
        return petsList;
    }
}
