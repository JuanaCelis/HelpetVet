package tests;


import model.*;

import java.util.ArrayList;
import java.util.HashSet;

public class TestApp {

    private VetManager vetManager;
    private ArrayList<Owner> ownerList;

    public TestApp() {
        vetManager = new VetManager();
        ownerList = new ArrayList<>();
        owners();
    }

    /**
     * Dueños quemados
     */
    public void owners(){
       ownerList.add(new Owner("1023","Julian","Ardila",petsList()));
       ownerList.add(new Owner("32012","Juana","Celis",petsList()));
       ownerList.add(new Owner("3123","Laura","Mantilla",petsList()));
       ownerList.add(new Owner("73829","Roberto","Castro",petsList()));
       ownerList.add(new Owner("10221","Gerardo","Vacuna",petsList()));
       ownerList.add(new Owner("82901","Camilo","Perez",petsList()));
    }

    /**
     * Metodo encargado de generar array con maximo 3 mascostas aleatorias
     * @return Array de maximo 3 mascotsas No repetidas
     */
    public ArrayList<Pet> petsList(){
        HashSet<Pet> temp = new HashSet<>();
        int maxPets = random(3);

        Pet [] temps = new Pet[] {
            new Pet( "Tobi", Size.MEDIUM, Gender.MALE, 3),
            new Pet("Mango", Size.BIG, Gender.MALE, 2),
            new Pet( "Winny", Size.LITTLE, Gender.FEMALE, 7),
            new Pet( "Chester", Size.MEDIUM, Gender.MALE, 4),
            new Pet( "Cloe", Size.LITTLE, Gender.FEMALE, 1),
            new Pet( "Tribilin", Size.MEDIUM, Gender.MALE, 5),
            new Pet( "Ponsi", Size.BIG, Gender.MALE, 8),
            new Pet( "Ponsi", Size.MEDIUM, Gender.FEMALE, 3),
        };

        for (int i = 0; i < temps.length; i++) {
            temp.add(temps[random(temps.length)-1]);
            maxPets--;
            if (maxPets == 0){
                return new ArrayList<>(temp);
            }
        }
        return new ArrayList<>();
    }

    /**
     * Metodo encargado de generar numeros aleatorios
     * @param size numeor maximo que puede generar
     * @return numero aleatorio
     */
    public int random(int size){
        return (int)(Math.random() * size + 1);
    }

    public void addOwners(){
        vetManager.setOwnerList(ownerList);
    }

    public void print(){
        addOwners();
        vetManager.setIdPets();
        ArrayList<Owner> temp = vetManager.getOwnerList();
        for (int i = 0; i < temp.size(); i++) {
            System.out.println(temp.get(i).getName());
            ArrayList<Pet> pets = temp.get(i).getPetList();
            for (int j = 0; j < pets.size(); j++) {
                System.out.print("Mascotas: " + pets.get(j).getName() + " " + pets.get(j).getId() + "\n");
            }
        }
        System.out.println(vetManager.getTotalPets());
    }

    public static void main(String[] args) {
        new TestApp().print();
    }
}
