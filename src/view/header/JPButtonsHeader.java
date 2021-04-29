package view.header;

import persistence.HandlerLanguage;
import presenter.EVENTS;
import presenter.Presenter;
import utilities.*;
import view.ConstantGUI;

import javax.swing.*;
import java.awt.*;

public class JPButtonsHeader extends JPanel {

    public JButton jlIconHelpet,jbNewUser, jbNewDoctor, jbNewAppointment, jbReports, jbTables;

    private Presenter myPresenter;

    public JPButtonsHeader(Presenter presenter){
        myPresenter = presenter;
        setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
        setAlignmentX(LEFT_ALIGNMENT);
        setBackground(Color.decode("#ffffff"));
        initComponents();
    }

    private void initComponents() {
        addIconHelpVet();
        addButtonsText();
    }

    private void addIconHelpVet() {
        jlIconHelpet = new JButton();
        ImageIcon temp = new ImageIcon(new ImageIcon(getClass().getResource(ConstantGUI.LOGO_HELPET)).getImage());
        MyUtilities.setMainElementsButton(jlIconHelpet,temp,0,50,20,10);
        jlIconHelpet.addActionListener(myPresenter);
        jlIconHelpet.setActionCommand(EVENTS.C_SHOW_HOMEPAGE.toString());
        this.add(jlIconHelpet);
    }

    private void addButtonsText() {
        jbNewUser = new JButton();
        ImageIcon tempWorld = new ImageIcon(new ImageIcon(getClass().getResource(ConstantGUI.NEW_USER)).getImage());
        MyUtilities.setTextAndIconButtons(jbNewUser, HandlerLanguage.languageProperties.getProperty(ConstantGUI.T_BUTTON_NEW_USER), tempWorld, 0,0,0,0);
        jbNewUser.addActionListener(myPresenter);
        jbNewUser.setActionCommand(EVENTS.C_DIALOG_REGISTER_PET.toString());
        this.add(jbNewUser);

        jbNewDoctor = new JButton();
        ImageIcon tempDoc = new ImageIcon(new ImageIcon(getClass().getResource(ConstantGUI.NEW_DOCTOR)).getImage());
        MyUtilities.setTextAndIconButtons(jbNewDoctor, HandlerLanguage.languageProperties.getProperty(ConstantGUI.T_BUTTON_NEW_DOCTOR), tempDoc, 0,0,0,0);
        jbNewDoctor.addActionListener(myPresenter);
        jbNewDoctor.setActionCommand(EVENTS.C_DIALOG_REGISTER_DOC.toString());
        this.add(jbNewDoctor);

        jbNewAppointment = new JButton();
        ImageIcon tempAppointment = new ImageIcon(new ImageIcon(getClass().getResource(ConstantGUI.NEW_APPOINTMENT)).getImage());
        MyUtilities.setTextAndIconButtons(jbNewAppointment, HandlerLanguage.languageProperties.getProperty(ConstantGUI.T_BUTTON_NEW_APPOINTMENT), tempAppointment, 0,0,0,0);
        jbNewAppointment.addActionListener(myPresenter);
        jbNewAppointment.setActionCommand(EVENTS.C_SCHEDULE_APPOINTMENT.toString());
        this.add(jbNewAppointment);

        jbReports = new JButton();
        ImageIcon tempReports = new ImageIcon(new ImageIcon(getClass().getResource(ConstantGUI.BUTTON_GENERAL_REPORTS)).getImage());
        MyUtilities.setTextAndIconButtons(jbReports, HandlerLanguage.languageProperties.getProperty(ConstantGUI.T_BUTTON_SHOW_REPORTS), tempReports, 0,0,0,0);
        jbReports.addActionListener(myPresenter);
        jbReports.setActionCommand(EVENTS.C_SHOW_PANEL_GRAPHICS.toString());
        this.add(jbReports);

        jbTables = new JButton();
        ImageIcon tempTables = new ImageIcon(new ImageIcon(getClass().getResource(ConstantGUI.BUTTON_SHOW_TABLES)).getImage());
        MyUtilities.setTextAndIconButtons(jbTables, HandlerLanguage.languageProperties.getProperty(ConstantGUI.T_BUTTON_SHOW_TABLES), tempTables, 0,0,0,0);
        jbTables.addActionListener(myPresenter);
        jbTables.setActionCommand(EVENTS.C_SHOW_PANEL_TABLES.toString());
        this.add(jbTables);

    }

    public void changeLanguage(){
        jbNewUser.setText(HandlerLanguage.languageProperties.getProperty(ConstantGUI.T_BUTTON_NEW_USER));
        jbNewDoctor.setText(HandlerLanguage.languageProperties.getProperty(ConstantGUI.T_BUTTON_NEW_DOCTOR));
        jbNewAppointment.setText(HandlerLanguage.languageProperties.getProperty(ConstantGUI.T_BUTTON_NEW_APPOINTMENT));
        jbReports.setText(HandlerLanguage.languageProperties.getProperty(ConstantGUI.T_BUTTON_SHOW_REPORTS));
        jbTables.setText(HandlerLanguage.languageProperties.getProperty(ConstantGUI.T_BUTTON_SHOW_TABLES));
    }
}
