package model;

import java.util.ArrayList;

public class OwnerManager {

    private ArrayList<Owner> ownerList;

    public OwnerManager(ArrayList<Owner> ownerList) {
        this.ownerList = ownerList;
    }

    /**
     * Metodo que nos retorna la cantidad total de mascotas registradas
     * @return Total pets
     */
    public int getTotalPets(){
        int totalPets = 0;
        for (int i = 0; i < ownerList.size(); i++) {
            totalPets += ownerList.get(i).getPetList().size();
        }
        return totalPets;
    }

    /**
     * Metodo encargado de agregar una nueva mascota a la lista del dueño
     * y agregando su respectivo ID pet
     * @param idOwner Id del cliente al cual se le quiere agregar una mascota
     * @param pet mascota a agregar
     */
    public void addNewPet(String idOwner, Pet pet){
        String id = idOwner.trim();
        for (int i = 0; i < ownerList.size(); i++) {
            Owner owner = ownerList.get(i);
            if (owner.getId() == id){
                pet.setId(getTotalPets()+1);
                owner.getPetList().add(pet);
            }
        }
    }

    /**
     * Devuelve la lista de todos los Dueños
     * @return Dueños
     */
    public ArrayList<Owner> getOwnerList() {
        return ownerList;
    }
}
