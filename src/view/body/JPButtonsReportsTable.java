package view.body;

import persistence.HandlerLanguage;
import presenter.EVENTS;
import presenter.Presenter;
import utilities.*;
import view.ConstantGUI;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class JPButtonsReportsTable extends JPanel {

    private JPanel panelButtonsRepTables, panelTittle;
    private JButton jbReportMedicine, jbReportPetsAndOwner, jbAppointmentByCategory, jbShowListOfDoctors;
    private JLabel jlTittleTableReports;

    private Presenter myPresenter;

    public JPButtonsReportsTable(Presenter presenter){
        myPresenter = presenter;
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setAlignmentX(LEFT_ALIGNMENT);
        setBackground(Color.decode(ConstantGUI.COLOR_DARK_BLUE));
        initComponents();
    }

    private void initComponents() {
        addTittleTableReports();
        addButtonsTableReports();
    }

    private void addTittleTableReports() {
        panelTittle = new JPanel();
        panelTittle.setLayout(new BorderLayout());
        panelTittle.setBackground(Color.decode(ConstantGUI.COLOR_SKY_BLUE));

        jlTittleTableReports = new JLabel(HandlerLanguage.languageProperties.getProperty(ConstantGUI.T_JLABEL_TITTLE_TABLE_REPORT));
        jlTittleTableReports.setForeground(Color.WHITE);
        jlTittleTableReports.setBorder(BorderFactory.createEmptyBorder(30,0,30,100));
        //jlTittleTableReports.setAlignmentX(Component.LEFT_ALIGNMENT);
        jlTittleTableReports.setFont(new Font("Arial", Font.BOLD,30));
        panelTittle.add(jlTittleTableReports);

        this.add(jlTittleTableReports);
    }

    private void addButtonsTableReports() {

        panelButtonsRepTables = new JPanel();
        GridLayout gridLayout = new GridLayout(2,2);
        gridLayout.setVgap(15);
        gridLayout.setHgap(15);

        panelButtonsRepTables.setBorder(new EmptyBorder(20,20,20,20));
        panelButtonsRepTables.setLayout(gridLayout);
        panelButtonsRepTables.setBackground(Color.decode(ConstantGUI.COLOR_DARK_BLUE));

        jbReportMedicine = new JButton();
        ImageIcon tempIconReportMedicine = new ImageIcon(new ImageIcon(getClass().getResource(ConstantGUI.BUTTON_MEDICINE_TABLE)).getImage());
        MyUtilities.setTextAndIconButtons(jbReportMedicine, HandlerLanguage.languageProperties.getProperty(ConstantGUI.T_BUTTON_REPORT_MEDICINE_TABLE), tempIconReportMedicine, 0,0,0,0);
        jbReportMedicine.addActionListener(myPresenter);
        jbReportMedicine.setActionCommand(EVENTS.C_SHOW_TABLE_MEDICINE_RARE.toString());
        panelButtonsRepTables.add(jbReportMedicine);

        jbReportPetsAndOwner = new JButton();
        ImageIcon tempPetsAndOwner = new ImageIcon(new ImageIcon(getClass().getResource(ConstantGUI.BUTTON_PETS_OWNER_TABLE)).getImage());
        MyUtilities.setTextAndIconButtons(jbReportPetsAndOwner, HandlerLanguage.languageProperties.getProperty(ConstantGUI.T_BUTTON_PETS_OWNER_TABLE), tempPetsAndOwner, 0,0,0,0);
        jbReportPetsAndOwner.addActionListener(myPresenter);
        jbReportPetsAndOwner.setActionCommand(EVENTS.C_SHOW_LIST_OF_PETS_AND_OWNER.toString());
        panelButtonsRepTables.add(jbReportPetsAndOwner);

        jbAppointmentByCategory = new JButton();
        ImageIcon tempAppointmentByCategory = new ImageIcon(new ImageIcon(getClass().getResource(ConstantGUI.BUTTON_APPOINTMENT_BY_CATEGORY_TABLE)).getImage());
        MyUtilities.setTextAndIconButtons(jbAppointmentByCategory, HandlerLanguage.languageProperties.getProperty(ConstantGUI.T_BUTTON_APPOINTMENT_BY_CATEGORY_TABLE), tempAppointmentByCategory, 0,0,0,0);
        jbAppointmentByCategory.addActionListener(myPresenter);
        jbAppointmentByCategory.setActionCommand(EVENTS.C_SHOW_LIST_APPOINTMENT.toString());
        panelButtonsRepTables.add(jbAppointmentByCategory);


        jbShowListOfDoctors = new JButton();
        ImageIcon tempAppointmentByDay = new ImageIcon(new ImageIcon(getClass().getResource(ConstantGUI.NEW_DOCTOR)).getImage());
        MyUtilities.setTextAndIconButtons(jbShowListOfDoctors, HandlerLanguage.languageProperties.getProperty(ConstantGUI.T_BUTTON_SHOW_LIST_OF_DOCTOR_TABLE), tempAppointmentByDay, 0,0,0,0);
        jbShowListOfDoctors.addActionListener(myPresenter);
        jbShowListOfDoctors.setActionCommand(EVENTS.C_SHOW_LIST_OF_DOCTORS.toString());
        panelButtonsRepTables.add(jbShowListOfDoctors);

        this.add(panelButtonsRepTables);
    }

    public void changeLanguage(){
        jlTittleTableReports.setText(HandlerLanguage.languageProperties.getProperty(ConstantGUI.T_JLABEL_TITTLE_TABLE_REPORT));
        jbReportMedicine.setText(HandlerLanguage.languageProperties.getProperty(ConstantGUI.T_BUTTON_REPORT_MEDICINE_TABLE));
        jbReportPetsAndOwner.setText(HandlerLanguage.languageProperties.getProperty(ConstantGUI.T_BUTTON_PETS_OWNER_TABLE));
        jbAppointmentByCategory.setText(HandlerLanguage.languageProperties.getProperty(ConstantGUI.T_BUTTON_APPOINTMENT_BY_CATEGORY_TABLE));
        jbShowListOfDoctors.setText(HandlerLanguage.languageProperties.getProperty(ConstantGUI.T_BUTTON_SHOW_LIST_OF_DOCTOR_TABLE));
    }
}
