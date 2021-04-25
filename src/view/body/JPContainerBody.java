package view.body;

import model.Appointment;
import model.Doctor;
import model.Medicine;
import persistence.HandlerLanguage;
import presenter.Presenter;
import view.ConstantGUI;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class JPContainerBody extends JPanel {

    private Presenter myPresenter;
    private JPButtonsReportsGraphics jpButtonsReportsGraphics;
    private JPButtonsReportsTable jpButtonsReportsTable;
    private JPTableElements jpTableElements;

    public JPContainerBody(Presenter presenter) {
        this.setLayout(new BorderLayout());
        myPresenter = presenter;
        initViews();
    }

    private void initViews() {

        jpTableElements = new JPTableElements();
        jpButtonsReportsGraphics = new JPButtonsReportsGraphics(myPresenter);
        jpButtonsReportsTable = new JPButtonsReportsTable(myPresenter);
        //this.add(jpTableElements,BorderLayout.CENTER);

        //this.add(jpButtonsReportsGraphics,BorderLayout.PAGE_START);
        //jpTableElements = new JPTableElements();
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

    public void showMedicineRaresTable(ArrayList<Medicine> medicineList){
        jpTableElements.showTableMedicines(medicineList);
    }

    public void showListOfDoctors(ArrayList<Doctor> doctorList){
        jpTableElements.showTableDoctors(doctorList);
    }

    public void showTableOfAppoinmentAssingnedByDate(ArrayList<Appointment>appointentList){
        jpTableElements.showTableOfAppoinmentAssingnedByDate(appointentList);
    }

    public void changeLanguage(){
        jpButtonsReportsGraphics.changeLanguage();
        jpTableElements.changeLanguage();
    }
}
