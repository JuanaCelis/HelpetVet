package view;

import model.Appointment;
import model.Doctor;
import model.Medicine;
import presenter.Presenter;
import view.body.JPContainerBody;
import view.footer.JPContainerFooter;
import view.header.JPContainerHeader;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

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

    public void showListOfDoctors(ArrayList<Doctor> doctorList){
        jpcontainerBody.showListOfDoctors(doctorList);
    }


    public void showMedicineRaresTable(ArrayList<Medicine> medicineList){
        jpcontainerBody.showMedicineRaresTable(medicineList);
    }

    public void showTableOfAppoinmentAssingnedByDate(ArrayList<Appointment>appointentList){
        jpcontainerBody.showTableOfAppoinmentAssingnedByDate(appointentList);
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
}
