package view.body;

import model.Appointment;
import model.Doctor;
import model.Medicine;

import model.Pet;
import utilities.*;
import persistence.HandlerLanguage;
import view.ConstantGUI;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import java.awt.*;
import java.util.ArrayList;

public class JPTableElements extends JPanel {

    private DefaultTableModel defaultTable;
    private JTable tableElements;
    private JScrollPane scrollTable;
    private String [] headersMedicine,headersAppointment,headerDoctors, headerPets;

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

        TableRowSorter<DefaultTableModel> sorter = new TableRowSorter<>(defaultTable);
        tableElements.setRowSorter(sorter);

        scrollTable = new JScrollPane(tableElements);
        scrollTable.setForeground(Color.WHITE);
        scrollTable.setAlignmentX(LEFT_ALIGNMENT);
        this.add(scrollTable);
    }

    public void showTableOfAppoinmentAssingnedByDate(ArrayList<Appointment> listAppointment){
//        clearTable();
        headersAppointment = new String[]{HandlerLanguage.languageProperties.getProperty( ConstantGUI.T_GET_CATEGORY),
                HandlerLanguage.languageProperties.getProperty( ConstantGUI.T_GET_NAMEPET),
                HandlerLanguage.languageProperties.getProperty( ConstantGUI.T_DATE_APPOINTMENT),
                HandlerLanguage.languageProperties.getProperty( ConstantGUI.T_JD_ID_PET),
                HandlerLanguage.languageProperties.getProperty( ConstantGUI.T_GET_ID_OWNER),
                HandlerLanguage.languageProperties.getProperty( ConstantGUI.T_GET_NAME_OWNER)};
        defaultTable.setColumnIdentifiers(headersAppointment);
    }

    public void showTableMedicines(ArrayList<Medicine> medicineArrayList){
        //clearTable();
        headersMedicine = new String[]{HandlerLanguage.languageProperties.getProperty( ConstantGUI.T_HEADER_PRODUCT_DESCRIPTION),
                HandlerLanguage.languageProperties.getProperty( ConstantGUI.T_HEADER_MEDICINE_CLASS),
                HandlerLanguage.languageProperties.getProperty( ConstantGUI.T_HEADER_PRESENTATION_MEDICINE),
                HandlerLanguage.languageProperties.getProperty( ConstantGUI.T_HEADER_SPECIE_MEDICINE)};

        defaultTable.setColumnIdentifiers(headersMedicine);

    }

    private void loadMedicineToList(ArrayList<Medicine> medicineArrayList) {
        for (Medicine medicine : medicineArrayList) {
            defaultTable.addRow(medicine.toObjectVector());
        }
    }

    public void showTableDoctors(ArrayList<Doctor> doctorList){

//        clearTable();
        headerDoctors = new String[]{HandlerLanguage.languageProperties.getProperty( ConstantGUI.T_JD_GET_ID),
                HandlerLanguage.languageProperties.getProperty( ConstantGUI.T_JD_GET_NAME),
                HandlerLanguage.languageProperties.getProperty( ConstantGUI.T_JD_GET_LASTNAME),
                HandlerLanguage.languageProperties.getProperty( ConstantGUI.T_JD_GET_BIRTHDATE),
                HandlerLanguage.languageProperties.getProperty( ConstantGUI.T_JD_GET_CATEGORY)};

        defaultTable.setColumnIdentifiers(headerDoctors);

    }

    public void showTablePetsOwners(ArrayList<Pet> petList){
        headerPets = new String[]{
                HandlerLanguage.languageProperties.getProperty( ConstantGUI.T_GET_ID_OWNER),
                HandlerLanguage.languageProperties.getProperty( ConstantGUI.T_GET_NAME_OWNER),
                HandlerLanguage.languageProperties.getProperty( ConstantGUI.T_GET_NAMEPET),
                HandlerLanguage.languageProperties.getProperty( ConstantGUI.T_JD_GET_AGE_PET),
                HandlerLanguage.languageProperties.getProperty( ConstantGUI.T_JD_SIZE_PET)
        };
        defaultTable.setColumnIdentifiers(headerPets);
    }

    public void addTable(Object [] element){
        defaultTable.addRow(element);
    }

    private void loadAppointmentToList(ArrayList<Appointment> appointmentsList){
        for (Appointment appointment: appointmentsList) {

        }
    }

    public void clearTable(){
        defaultTable.setRowCount(0);
    }

    public void changeLanguage(){
        headersMedicine = new String[]{HandlerLanguage.languageProperties.getProperty( ConstantGUI.T_HEADER_PRODUCT_DESCRIPTION),
                HandlerLanguage.languageProperties.getProperty( ConstantGUI.T_HEADER_MEDICINE_CLASS),
                HandlerLanguage.languageProperties.getProperty( ConstantGUI.T_HEADER_PRESENTATION_MEDICINE),
                HandlerLanguage.languageProperties.getProperty( ConstantGUI.T_HEADER_SPECIE_MEDICINE)};

        headerDoctors = new String[]{MyUtilities.setRepairLetter(HandlerLanguage.languageProperties.getProperty( ConstantGUI.T_JD_GET_ID)),
                HandlerLanguage.languageProperties.getProperty( ConstantGUI.T_JD_GET_NAME),
                HandlerLanguage.languageProperties.getProperty( ConstantGUI.T_JD_GET_LASTNAME),
                HandlerLanguage.languageProperties.getProperty( ConstantGUI.T_JD_GET_BIRTHDATE),
                HandlerLanguage.languageProperties.getProperty( ConstantGUI.T_JD_GET_CATEGORY)};

        headerPets = new String[]{
                HandlerLanguage.languageProperties.getProperty( ConstantGUI.T_GET_ID_OWNER),
                HandlerLanguage.languageProperties.getProperty( ConstantGUI.T_GET_NAME_OWNER),
                HandlerLanguage.languageProperties.getProperty( ConstantGUI.T_GET_NAMEPET),
                HandlerLanguage.languageProperties.getProperty( ConstantGUI.T_JD_GET_AGE_PET),
                HandlerLanguage.languageProperties.getProperty( ConstantGUI.T_JD_SIZE_PET)
        };
    }

}
