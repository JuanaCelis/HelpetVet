package model;

import java.util.ArrayList;

public class PetManager {

    private ArrayList<Pet> petsList;

    public PetManager() {
        this.petsList = new ArrayList<>();
        testDatas();
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

    public ArrayList<Double> frequentPets(){
        ArrayList<Double> list = new ArrayList<>();
        int totalPets = petsList.size();

        list.add((double)numberFrequentPet(Size.BIG)*100/totalPets);
        list.add((double)numberFrequentPet(Size.MEDIUM)*100/totalPets);
        list.add((double)numberFrequentPet(Size.LITTLE)*100/totalPets);

        return list;
    }

    public int numberFrequentPet(Size size){
        int result = 0;
        for (int i = 0; i < petsList.size(); i++) {
            Pet tempPet = petsList.get(i);
            if (size == tempPet.getSize()){
                result++;
            }
        }
        return result;
    }

    //Datos quemados
    public void testDatas(){
        petsList.add(new Pet("Winny",Size.LITTLE,Gender.FEMALE,8,102910,"Julian","3902"));
        petsList.add(new Pet("Mango", Size.MEDIUM,Gender.MALE,2,119382,"Juana","39912"));
        petsList.add(new Pet("Dogy", Size.MEDIUM,Gender.MALE,1,106352,"Andres","32132"));
        petsList.add(new Pet("Shiba", Size.BIG,Gender.MALE,4,109822,"Satochi","57402"));
    }
}
