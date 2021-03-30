package view.body;

import model.Appointment;
import model.Owner;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.ArrayList;

public class JPTableElements extends JPanel {

    private DefaultTableModel defaultTable;
    private JTable tableElements;
    private JScrollPane scrollTable;

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
        tableElements.getTableHeader().setBackground(new Color(120, 120, 120));

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
        String [] headers = {};
        defaultTable.setColumnIdentifiers(headers);
        loadAppointmentToList(listAppointment);
    }

    private void loadAppointmentToList(ArrayList<Appointment> appointmentsList){
        for (Appointment appointment: appointmentsList) {

        }
    }

    private void clearTable() {
        defaultTable.setRowCount(0);
    }

}
