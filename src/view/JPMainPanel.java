package view;

import model.Appointment;
import model.Doctor;
import model.Medicine;
import model.Pet;
import presenter.Presenter;
import view.body.JPContainerBody;
import view.footer.JPContainerFooter;
import view.header.JPContainerHeader;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class JPMainPanel extends JPanel {

    private JPContainerHeader jpcontainerHeader;
    private JPContainerBody jpcontainerBody;
    private JPContainerFooter jpcontainerFooter;
    private Presenter myPresenter;

    public JPMainPanel(Presenter presenter){
        myPresenter = presenter;
        setLayout(new BorderLayout());
        setBackground(Color.white);
        initComponents();
    }

    private void initComponents() {

        jpcontainerHeader = new JPContainerHeader(myPresenter);
        add(jpcontainerHeader, BorderLayout.PAGE_START);

        jpcontainerBody = new JPContainerBody(myPresenter);
        add(jpcontainerBody,BorderLayout.CENTER);

        jpcontainerFooter = new JPContainerFooter(myPresenter);
        add(jpcontainerFooter, BorderLayout.PAGE_END);

    }

    public void showPanelGraphics(){
        jpcontainerBody.showPanelGraphics();
    }

    public void showPanelButtonsReportsTable(){
        jpcontainerBody.showPanelButtonsReportsTable();
    }

    public void showPanelTable(){
        jpcontainerBody.showPanelTable();
    }

    public void showGraphicAppointmentCategory(List<Double> doubles){
        jpcontainerBody.showGraphicAppointmentCategory(doubles);
    }

    public void frequenPetsBySize(ArrayList<Double> doubles){
        jpcontainerBody.frequenPetsBySize(doubles);
    }

    public void doctorsByCategoryGraphic(ArrayList<Double> doubles){
        jpcontainerBody.doctorsByCategoryGraphic(doubles);
    }

    public void petsForMounth(ArrayList<Integer> doubles){
        jpcontainerBody.petsForMounth(doubles);
    }

    public void typesOfMedicines(ArrayList<Double> values){
        jpcontainerBody.typesOfMedicines(values);
    }

    public void reportGender(ArrayList<Integer> values){
        jpcontainerBody.reportGender(values);
    }

    public void buttonsCrud(){
        jpcontainerBody.buttonsCrud();
    }

    public void setCommandButton(String command){
        jpcontainerBody.setCommandButton(command);
    }

    public void showListOfDoctors(ArrayList<Doctor> doctorList){
        jpcontainerBody.showListOfDoctors(doctorList);
    }

    public void showTablePetsOwners(ArrayList<Pet> petList){
        jpcontainerBody.showTablePetsOwners(petList);
    }


    public void showMedicineRaresTable(ArrayList<Medicine> medicineList){
        jpcontainerBody.showMedicineRaresTable(medicineList);
    }

    public void showTableOfAppoinmentAssingnedByDate(ArrayList<Appointment>appointentList){
        jpcontainerBody.showTableOfAppoinmentAssingnedByDate(appointentList);
    }

    public void showTableMedicines(ArrayList<Medicine> medicineArrayList){
        jpcontainerBody.showTableMedicines(medicineArrayList);

    }

    public void changeImageBannerNext(){
        jpcontainerHeader.changeImageBannerNext();
    }

    public void changeImageBannerBack(){
        jpcontainerHeader.changeImageBannerBack();
    }

    public void showHomePage(){
        jpcontainerBody.showHomePage();
    }


    public void changeLanguage() {
        jpcontainerHeader.changeLanguage();
        jpcontainerBody.changeLanguage();
    }

    public void addTable(Object [] element){
        jpcontainerBody.addTable(element);
    }

    public void clearTable() {
        jpcontainerBody.clearTable();
    }

}
