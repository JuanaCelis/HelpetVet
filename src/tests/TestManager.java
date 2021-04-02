package tests;

import model.*;

import java.util.ArrayList;

public class TestManager {

    private VetManager vetManager;
    private TestOwner testOwner;
    private TestAppointment testAppointment;

    public TestManager(){
        testOwner = new TestOwner();
        testAppointment = new TestAppointment();
        vetManager = new VetManager(testOwner.getOwnerList(), testAppointment.appointmentsList());
        init();
    }

    public void init(){
        vetManager.setIdPets();
        testAddNewPet();
        printOwnersAndPets();
    }

    /**
     * Imprime el nombre de cada dueño y sus repectivas mascotas y su ID
     */
    public void printOwnersAndPets(){
        ArrayList<Owner> temp = vetManager.ownersList();
        for (int i = 0; i < temp.size(); i++) {
            System.out.println(temp.get(i).getName());
            ArrayList<Pet> pets = temp.get(i).getPetList();
            for (int j = 0; j < pets.size(); j++) {
                System.out.print("Mascotas: " + pets.get(j).getName() + " " + pets.get(j).getId() + "\n");
            }
        }
        System.out.println(vetManager.getOwnerManager().getTotalPets());
    }

    /**
     * Agrega una nueva mascota al dueño especificado por ID
     */
    public void testAddNewPet(){
        vetManager.getOwnerManager().addNewPet("32012",new Pet("Miel", Size.MEDIUM, Gender.MALE,2));
    }

    public static void main(String[] args) {
        new TestManager();
    }
}
