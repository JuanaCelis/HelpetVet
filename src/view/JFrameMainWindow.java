package view;
import model.Appointment;
import model.Doctor;
import model.Medicine;
import persistence.HandlerLanguage;
import presenter.Presenter;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class JFrameMainWindow extends JFrame {

    private JPMainPanel mainPanel;
    private Presenter myPresenter;

    public JFrameMainWindow(Presenter presenter){
        myPresenter = presenter;
        setExtendedState(MAXIMIZED_BOTH);
        setSize(600, 400);
        //setIconImage(new ImageIcon(getClass().getResource(ConstantsGUI.LOGO_PAGE)).getImage());
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

    public void showListOfDoctors(ArrayList<Doctor> doctorList){
        mainPanel.showListOfDoctors(doctorList);
    }

    public void showMedicineRaresTable(ArrayList<Medicine> medicineList){
        mainPanel.showMedicineRaresTable(medicineList);
    }

    public void showTableOfAppoinmentAssingnedByDate(ArrayList<Appointment>appointentList){
        mainPanel.showTableOfAppoinmentAssingnedByDate(appointentList);
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

    public void addToTable(Object [] cyclist){
        mainPanel.addToTable(cyclist);
    }

    public void clearTable() {
        mainPanel.clearTable();
    }
}
