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

    /**
     * Establece el ID no repetidos para las mascotas
     */
    public void setIdPets(){
        int idPet = 1;
        for (int i = 0; i < petsList.size(); i++) {
            petsList.get(i).setId((idPet++));
        }
    }

    public void addPet(Pet pet){
        pet.setId(petsList.size()+1);
        petsList.add(pet);
    }

    public ArrayList<Pet> getPetsList() {
        return petsList;
    }
}
