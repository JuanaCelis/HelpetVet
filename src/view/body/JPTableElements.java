package view.body;

import model.Appointment;
import model.Doctor;
import model.Medicine;

import utilities.*;
import persistence.HandlerLanguage;
import view.ConstantGUI;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.ArrayList;

public class JPTableElements extends JPanel {

    private DefaultTableModel defaultTable;
    private JTable tableElements;
    private JScrollPane scrollTable;
    private String [] headersMedicine,headersAppointment,headerDoctors;

    public JPTableElements(){
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.setBackground(Color.decode("#30373D"));
        initComponents();
    }

    private void initComponents() {

        defaultTable = new DefaultTableModel();

        tableElements = new JTable();
        tableElements.setModel(defaultTable);
        tableElements.getTableHeader().setReorderingAllowed(false);
        tableElements.getTableHeader().setBackground(Color.decode(ConstantGUI.COLOR_DARK_BLUE));

        //setSize

        tableElements.getTableHeader().setPreferredSize(new Dimension(150,50));
        tableElements.getTableHeader().setForeground(Color.WHITE);
        tableElements.setBackground(Color.WHITE);
        tableElements.setFillsViewportHeight(true);
        tableElements.setRowHeight(40);

        scrollTable = new JScrollPane(tableElements);
        scrollTable.setForeground(Color.WHITE);
        scrollTable.setAlignmentX(LEFT_ALIGNMENT);
        this.add(scrollTable);
    }

    public void showTableOfAppoinmentAssingnedByDate(ArrayList<Appointment> listAppointment){
        clearTable();
        headersAppointment = new String[]{};
        loadAppointmentToList(listAppointment);
    }

    public void showTableMedicines(ArrayList<Medicine> medicineArrayList){
        clearTable();
        headersMedicine = new String[]{MyUtilities.setRepairLetter(HandlerLanguage.languageProperties.getProperty( ConstantGUI.T_HEADER_PRODUCT_DESCRIPTION)),
                MyUtilities.setRepairLetter(HandlerLanguage.languageProperties.getProperty( ConstantGUI.T_HEADER_MEDICINE_CLASS)),
                MyUtilities.setRepairLetter(HandlerLanguage.languageProperties.getProperty( ConstantGUI.T_HEADER_PRESENTATION_MEDICINE)),
                MyUtilities.setRepairLetter(HandlerLanguage.languageProperties.getProperty( ConstantGUI.T_HEADER_SPECIE_MEDICINE))};

        defaultTable.setColumnIdentifiers(headersMedicine);

    }

    public void showTableDoctors(ArrayList<Doctor> doctorsList){
        clearTable();
        headerDoctors = new String[]{MyUtilities.setRepairLetter(HandlerLanguage.languageProperties.getProperty( ConstantGUI.T_JD_GET_ID)),
                MyUtilities.setRepairLetter(HandlerLanguage.languageProperties.getProperty( ConstantGUI.T_JD_GET_NAME)),
                MyUtilities.setRepairLetter(HandlerLanguage.languageProperties.getProperty( ConstantGUI.T_JD_GET_LASTNAME)),
                MyUtilities.setRepairLetter(HandlerLanguage.languageProperties.getProperty( ConstantGUI.T_JD_GET_BIRTHDATE)),
                MyUtilities.setRepairLetter(HandlerLanguage.languageProperties.getProperty( ConstantGUI.T_JD_GET_CATEGORY))};

        defaultTable.setColumnIdentifiers(headerDoctors);

    }



    private void loadAppointmentToList(ArrayList<Appointment> appointmentsList){
        for (Appointment appointment: appointmentsList) {

        }
    }

    private void clearTable() {
        defaultTable.setRowCount(0);
    }

    public void changeLanguage(){
        headersMedicine = new String[]{MyUtilities.setRepairLetter(HandlerLanguage.languageProperties.getProperty( ConstantGUI.T_HEADER_PRODUCT_DESCRIPTION)),
                MyUtilities.setRepairLetter(HandlerLanguage.languageProperties.getProperty( ConstantGUI.T_HEADER_MEDICINE_CLASS)),
                MyUtilities.setRepairLetter(HandlerLanguage.languageProperties.getProperty( ConstantGUI.T_HEADER_PRESENTATION_MEDICINE)),
                MyUtilities.setRepairLetter(HandlerLanguage.languageProperties.getProperty( ConstantGUI.T_HEADER_SPECIE_MEDICINE))};

        headerDoctors = new String[]{MyUtilities.setRepairLetter(HandlerLanguage.languageProperties.getProperty( ConstantGUI.T_JD_GET_ID)),
                MyUtilities.setRepairLetter(HandlerLanguage.languageProperties.getProperty( ConstantGUI.T_JD_GET_NAME)),
                MyUtilities.setRepairLetter(HandlerLanguage.languageProperties.getProperty( ConstantGUI.T_JD_GET_LASTNAME)),
                MyUtilities.setRepairLetter(HandlerLanguage.languageProperties.getProperty( ConstantGUI.T_JD_GET_BIRTHDATE)),
                MyUtilities.setRepairLetter(HandlerLanguage.languageProperties.getProperty( ConstantGUI.T_JD_GET_CATEGORY))};
    }

}
