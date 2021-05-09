package dialogs;

import com.toedter.calendar.JDateChooser;
import model.Appointment;
import model.CategoryEspeciality;
import persistence.HandlerLanguage;
import presenter.EVENTS;
import presenter.Presenter;
import utilities.*;
import view.ConstantGUI;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class JDScheduleAppointment extends JDialog {

    private JPanel jPanelDialogContainer;
    private JTextField jtfIdOwner, jtfNameOwner, jtfLastNameOwner, jtfNamePet;
    private JComboBox<CategoryEspeciality> category;
    private JDateChooser jDateAppointment;
    private JButton buttonRegisterAppointment, cancelAction;

    private Presenter myPresenter;

    public JDScheduleAppointment(Presenter presenter){
        myPresenter = presenter;
        setSize(350, 600);
        getContentPane().setBackground(Color.WHITE);
        setLayout(new BorderLayout());
        setLocationRelativeTo(null);
        setTitle(HandlerLanguage.languageProperties.getProperty( ConstantGUI.T_TITTLE_SCHEDULE_APPOINTMENT ));
        setVisible(true);
        initComponents();
    }

    private void initComponents() {
        jPanelDialogContainer = new JPanel();
        GridLayout gridLayout = new GridLayout(8,1);
        gridLayout.setVgap(15);
        jPanelDialogContainer.setBorder(new EmptyBorder(20,20,20,20));
        jPanelDialogContainer.setLayout(gridLayout);

        jtfIdOwner = new JTextField();
        jtfIdOwner.setBorder(BorderFactory.createTitledBorder(HandlerLanguage.languageProperties.getProperty( ConstantGUI.T_GET_ID_OWNER )));
        jPanelDialogContainer.add(jtfIdOwner);

        jtfNameOwner = new JTextField();
        jtfNameOwner.setBorder(BorderFactory.createTitledBorder(HandlerLanguage.languageProperties.getProperty( ConstantGUI.T_GET_NAME_OWNER )));
        jPanelDialogContainer.add(jtfNameOwner);

        jtfLastNameOwner = new JTextField();
        jtfLastNameOwner.setBorder(BorderFactory.createTitledBorder(HandlerLanguage.languageProperties.getProperty( ConstantGUI.T_GET_LASTNAME_OWNER )));
        jPanelDialogContainer.add(jtfLastNameOwner);

        jtfNamePet = new JTextField();
        jtfNamePet.setBorder(BorderFactory.createTitledBorder(HandlerLanguage.languageProperties.getProperty( ConstantGUI.T_GET_NAMEPET )));
        jPanelDialogContainer.add(jtfNamePet);

        category = new JComboBox<>(CategoryEspeciality.values());
        category.setBorder(BorderFactory.createTitledBorder(HandlerLanguage.languageProperties.getProperty( ConstantGUI.T_GET_CATEGORY )));
        category.setBackground(Color.white);
        jPanelDialogContainer.add(category);

        jDateAppointment = new JDateChooser();
        jDateAppointment.setBorder(BorderFactory.createTitledBorder(HandlerLanguage.languageProperties.getProperty( ConstantGUI.T_DATE_APPOINTMENT )));
        jPanelDialogContainer.add(jDateAppointment);

        buttonRegisterAppointment = new JButton();
        buttonRegisterAppointment = new view.RoundedJButton(15, 15, HandlerLanguage.languageProperties.getProperty( ConstantGUI.T_JD_REGISTER_APPOINTMENT), Color.decode("#337AB7"), Color.WHITE, EVENTS.C_ADD_NEW_APPOINTMENT.toString(), myPresenter);
        jPanelDialogContainer.add(buttonRegisterAppointment);

        cancelAction = new JButton();
        cancelAction = new view.RoundedJButton(15, 15, HandlerLanguage.languageProperties.getProperty( ConstantGUI.T_JD_CANCEL ), Color.decode("#337AB7"), Color.WHITE, EVENTS.C_CANCEL.toString(), myPresenter);
        cancelAction.addActionListener(myPresenter);
        jPanelDialogContainer.add(cancelAction);

        add(jPanelDialogContainer, BorderLayout.CENTER);
    }

    public Appointment createAppointment(){
        setVisible(false);
        return new Appointment(jtfIdOwner.getText(),jtfLastNameOwner.getText(),
                jtfNameOwner.getText(),jtfNamePet.getText(),
                (CategoryEspeciality)category.getSelectedItem(),
                MyUtilities.parseDateToLocalDate(jDateAppointment.getDate()));
    }

}
