package view;
import model.Appointment;
import model.Doctor;
import model.Medicine;
import model.Pet;
import persistence.HandlerLanguage;
import presenter.Presenter;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class JFrameMainWindow extends JFrame {

    private JPMainPanel mainPanel;
    private Presenter myPresenter;

    public JFrameMainWindow(Presenter presenter){
        myPresenter = presenter;
        setExtendedState(MAXIMIZED_BOTH);
        setSize(600, 400);
        setIconImage(new ImageIcon(getClass().getResource(ConstantGUI.VET_PET_ICON)).getImage());
        setTitle(HandlerLanguage.languageProperties.getProperty(ConstantGUI.T_MAIN_WINDOW ));
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        initComponents();
        setVisible(true);
    }

    private void initComponents() {
        mainPanel = new JPMainPanel(myPresenter);
        JScrollPane jsPMainPanel = new JScrollPane();
        jsPMainPanel.setViewportView(mainPanel);
        jsPMainPanel.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        add(jsPMainPanel);
    }

    public void showPanelGraphics(){
        mainPanel.showPanelGraphics();
    }

    public void showPanelButtonsReportsTable(){
        mainPanel.showPanelButtonsReportsTable();
    }

    public void showPanelTable(){
        mainPanel.showPanelTable();
    }

    public void showGraphicAppointmentCategory(List<Double> doubles){
        mainPanel.showGraphicAppointmentCategory(doubles);
    }

    public void frequenPetsBySize(ArrayList<Double> doubles){
        mainPanel.frequenPetsBySize(doubles);
    }

    public void doctorsByCategoryGraphic(ArrayList<Double> doubles){
        mainPanel.doctorsByCategoryGraphic(doubles);
    }

    public void petsForMounth(ArrayList<Integer> doubles){
        mainPanel.petsForMounth(doubles);
    }

    public void typesOfMedicines(ArrayList<Double> values){
        mainPanel.typesOfMedicines(values);
    }

    public void reportGender(ArrayList<Integer> values){
        mainPanel.reportGender(values);
    }

    public void buttonsCrud(){
        mainPanel.buttonsCrud();
    }

    public void setCommandButton(String command){
        mainPanel.setCommandButton(command);
    }

    public void showListOfDoctors(ArrayList<Doctor> doctorList){
        mainPanel.showListOfDoctors(doctorList);
    }

    public void showTablePetsOwners(ArrayList<Pet> petList){
        mainPanel.showTablePetsOwners(petList);
    }

    public void showMedicineRaresTable(ArrayList<Medicine> medicineList){
        mainPanel.showMedicineRaresTable(medicineList);
    }

    public void showTableOfAppoinmentAssingnedByDate(ArrayList<Appointment>appointentList){
        mainPanel.showTableOfAppoinmentAssingnedByDate(appointentList);
    }

    public void showTableMedicines(ArrayList<Medicine> medicineArrayList){
        mainPanel.showTableMedicines(medicineArrayList);

    }
    public void changeImageBannerNext(){
        mainPanel.changeImageBannerNext();
    }

    public void changeImageBannerBack(){
        mainPanel.changeImageBannerBack();
    }

    public void showHomePage(){
        mainPanel.showHomePage();
    }

    public void changeLanguage() {
        this.setTitle( HandlerLanguage.languageProperties.getProperty(ConstantGUI.T_MAIN_WINDOW ));
        mainPanel.changeLanguage();
    }

    public void addTable(Object [] element){
        mainPanel.addTable(element);
    }

    public void clearTable() {
        mainPanel.clearTable();
    }
}
