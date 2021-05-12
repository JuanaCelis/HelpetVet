package view.body;

import model.Appointment;
import model.Doctor;
import model.Medicine;
import model.Pet;
import persistence.HandlerLanguage;
import presenter.Presenter;
import view.body.reportsGraphics.*;
import utilities.MyUtilities;
import view.ConstantGUI;


import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class JPContainerBody extends JPanel {

    private Presenter myPresenter;
    private JPButtonsReportsGraphics jpButtonsReportsGraphics;
    private JPButtonsReportsTable jpButtonsReportsTable;
    private JPTableElements jpTableElements;
    private JPHelpetServices jpHelpetServices;

    private AppointmentForCategory appointmentForCategory;
    private FrequenPetsBySize frequenPetsBySize;
    private DoctorsByCategoryGraphic doctorsByCategoryGraphic;
    private PetsForMounth petsForMounth;
    private TypesOfMedicines typesOfMedicines;
    private ReportGender reportGender;

    private JButton delete;


    public JPContainerBody(Presenter presenter) {
        this.setLayout(new BorderLayout());
        myPresenter = presenter;
        initViews();
    }

    private void initViews() {

        jpTableElements = new JPTableElements();
        jpButtonsReportsGraphics = new JPButtonsReportsGraphics(myPresenter);
        jpButtonsReportsTable = new JPButtonsReportsTable(myPresenter);
        jpHelpetServices = new JPHelpetServices(myPresenter);


        this.add(jpHelpetServices,BorderLayout.PAGE_START);

    }

    public void showHomePage(){
        this.removeAll();
        this.repaint();
        this.add(jpHelpetServices,BorderLayout.PAGE_START);
        revalidate();
    }
    public void showPanelGraphics(){
        this.removeAll();
        this.repaint();
        this.add(jpButtonsReportsGraphics,BorderLayout.PAGE_START);
        revalidate();
    }

    public void showPanelButtonsReportsTable(){
        this.removeAll();
        this.repaint();
        this.add(jpButtonsReportsTable,BorderLayout.PAGE_START);
        revalidate();
    }

    public void showPanelTable(){
        this.removeAll();
        this.repaint();
        this.add(jpTableElements,BorderLayout.PAGE_START);
        revalidate();
    }

    public void setCommandButton(String command){
        delete.setActionCommand(command);
    }

    public void buttonsCrud(){
        delete = new JButton();
        ImageIcon temp = new ImageIcon(new ImageIcon(getClass().getResource(ConstantGUI.REMOVE_CRUD)).getImage());
        MyUtilities.setMainElementsButton(delete,temp,0,0,0,0);
        delete.addActionListener(myPresenter);
        this.add(delete);
    }

    public void showGraphicAppointmentCategory(List<Double> doubles){
        this.removeAll();
        this.repaint();
        appointmentForCategory = new AppointmentForCategory(doubles);
        this.add(appointmentForCategory,BorderLayout.PAGE_START);
        revalidate();
    }

    public void frequenPetsBySize(ArrayList<Double> doubles){
        this.removeAll();
        this.repaint();
        frequenPetsBySize = new FrequenPetsBySize(doubles);
        this.add(frequenPetsBySize,BorderLayout.PAGE_START);
        revalidate();
    }

    public void doctorsByCategoryGraphic(ArrayList<Double> doubles){
        this.removeAll();
        this.repaint();
        doctorsByCategoryGraphic = new DoctorsByCategoryGraphic(doubles);
        this.add(doctorsByCategoryGraphic,BorderLayout.PAGE_START);
        revalidate();
    }

    public void petsForMounth(ArrayList<Integer> doubles){
        this.removeAll();
        this.repaint();
        petsForMounth = new PetsForMounth(doubles);
        this.add(petsForMounth,BorderLayout.PAGE_START);
        revalidate();
    }

    public void typesOfMedicines(ArrayList<Double> values){
        this.removeAll();
        this.repaint();
        typesOfMedicines = new TypesOfMedicines(values);
        this.add(typesOfMedicines,BorderLayout.PAGE_START);
        revalidate();
    }

    public void reportGender(ArrayList<Integer> values){
        this.removeAll();
        this.repaint();
        reportGender = new ReportGender(values);
        this.add(reportGender,BorderLayout.PAGE_START);
        revalidate();
    }


    public void showMedicineRaresTable(ArrayList<Medicine> medicineList){
        jpTableElements.showTableMedicines(medicineList);
    }

    public void showTableMedicines(ArrayList<Medicine> medicineArrayList){
        jpTableElements.showTableMedicines(medicineArrayList);

    }

    public void showListOfDoctors(ArrayList<Doctor> doctorList){
        jpTableElements.showTableDoctors(doctorList);
    }

    public void showTableOfAppoinmentAssingnedByDate(ArrayList<Appointment>appointentList){
        jpTableElements.showTableOfAppoinmentAssingnedByDate(appointentList);
    }

    public void showTablePetsOwners(ArrayList<Pet> petList){
        jpTableElements.showTablePetsOwners(petList);
    }

    public void changeLanguage(){
        jpButtonsReportsGraphics.changeLanguage();
        jpTableElements.changeLanguage();
        jpButtonsReportsTable.changeLanguage();
        jpHelpetServices.changeLanguage();
    }

    public void addTable(Object [] element){
        jpTableElements.addTable(element);
    }

    public void clearTable() {
        jpTableElements.clearTable();
    }

}
