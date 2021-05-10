package view.body;

import model.Appointment;
import model.Doctor;
import model.Medicine;
import model.Pet;
import persistence.HandlerLanguage;
import presenter.Presenter;
import view.body.reportsGraphics.AppointmentForCategory;
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

        //this.add(jpButtonsReportsGraphics,BorderLayout.PAGE_START);
        //jpTableElements = new JPTableElements();
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

    public void showGraphicAppointmentCategory(List<Double> doubles){
        this.removeAll();
        this.repaint();
        appointmentForCategory = new AppointmentForCategory(doubles);
        this.add(appointmentForCategory,BorderLayout.PAGE_START);
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
