package dialogs;
import com.toedter.calendar.JDateChooser;
import model.CategoryEspeciality;
import model.Doctor;
import persistence.HandlerLanguage;
import presenter.EVENTS;
import presenter.Presenter;
import utilities.*;
import view.ConstantGUI;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class JDRegisterDoctor extends JDialog {

    private JPanel jPanelDialogContainer;
    private JTextField jtfName, jtId, jtLastName;
    private JComboBox<CategoryEspeciality> jcCategory;
    private JDateChooser jDBirthDate;
    private  JButton buttonAddDoctor, cancelAction;

    private Presenter myPresenter;

    public JDRegisterDoctor(Presenter presenter){
        myPresenter = presenter;
        setSize(350, 600);
        getContentPane().setBackground(Color.WHITE);
        setLayout(new BorderLayout());
        setLocationRelativeTo(null);
        setTitle(HandlerLanguage.languageProperties.getProperty( ConstantGUI.T_JD_TITTLE_REGISTER_DOCTOR ));
        setVisible(true);
        initComponents();
    }

    private void initComponents() {
        jPanelDialogContainer = new JPanel();
        GridLayout gridLayout = new GridLayout(7,1);
        gridLayout.setVgap(15);
        jPanelDialogContainer.setBorder(new EmptyBorder(20,20,20,20));
        jPanelDialogContainer.setLayout(gridLayout);

        jtId = new JTextField();
        jtId.setBorder(BorderFactory.createTitledBorder(HandlerLanguage.languageProperties.getProperty( ConstantGUI.T_JD_GET_ID )));
        jPanelDialogContainer.add(jtId);

        jtfName = new JTextField();
        jtfName.setBorder(BorderFactory.createTitledBorder(HandlerLanguage.languageProperties.getProperty( ConstantGUI.T_JD_GET_NAME )));
        jPanelDialogContainer.add(jtfName);

        jtLastName = new JTextField();
        jtLastName.setBorder(BorderFactory.createTitledBorder(HandlerLanguage.languageProperties.getProperty( ConstantGUI.T_JD_GET_LASTNAME )));
        jPanelDialogContainer.add(jtLastName);

        jDBirthDate = new JDateChooser();
        jDBirthDate.setBorder(BorderFactory.createTitledBorder(HandlerLanguage.languageProperties.getProperty( ConstantGUI.T_JD_GET_BIRTHDATE )));
        jPanelDialogContainer.add(jDBirthDate);

        jcCategory = new JComboBox<>(CategoryEspeciality.values());
        jcCategory.setBorder(BorderFactory.createTitledBorder(HandlerLanguage.languageProperties.getProperty( ConstantGUI.T_JD_GET_CATEGORY )));
        jcCategory.setBackground(Color.white);
        jPanelDialogContainer.add(jcCategory);

        buttonAddDoctor = new JButton();
        buttonAddDoctor = new view.RoundedJButton(15, 15, HandlerLanguage.languageProperties.getProperty( ConstantGUI.T_JD_ADD_DOCTOR), Color.decode("#337AB7"), Color.WHITE, EVENTS.C_ADD_NEW_DOCTOR.toString(), myPresenter);
        jPanelDialogContainer.add(buttonAddDoctor);

        cancelAction = new JButton();
        cancelAction = new view.RoundedJButton(15, 15, HandlerLanguage.languageProperties.getProperty( ConstantGUI.T_JD_CANCEL ), Color.decode("#337AB7"), Color.WHITE, EVENTS.C_CANCEL.toString(), myPresenter);
        jPanelDialogContainer.add(cancelAction);

        add(jPanelDialogContainer, BorderLayout.CENTER);

    }

    public Doctor createDoctor(){
        setVisible(false);
        return new Doctor(jtId.getText(),
                jtfName.getText(),
                jtLastName.getText(),
                MyUtilities.parseDateToLocalDate(jDBirthDate.getDate()),
                (CategoryEspeciality)jcCategory.getSelectedItem());
    }
}
