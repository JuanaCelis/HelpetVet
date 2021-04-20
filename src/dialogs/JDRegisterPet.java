package dialogs;

import model.Gender;
import model.Pet;
import model.Size;
import persistence.HandlerLanguage;
import presenter.EVENTS;
import presenter.Presenter;
import view.ConstantGUI;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class JDRegisterPet extends JDialog {

    private JPanel jPanelDialogContainer;
    private JTextField jtfName;
    private JComboBox<Gender> jcGender;
    private JComboBox<Size> jcSize;
    private JSpinner jsAge;
    private JButton buttonRegisterPet, cancelAction;

    private Presenter myPresenter;


    public JDRegisterPet(Presenter presenter){
        myPresenter = presenter;
        setSize(350, 600);
        getContentPane().setBackground(Color.WHITE);
        setLayout(new BorderLayout());
        setLocationRelativeTo(null);
        setTitle(HandlerLanguage.languageProperties.getProperty( ConstantGUI.T_JD_TITTLE_REGISTER_PET ));
        setVisible(true);
        initComponents();
    }

    private void initComponents() {
        jPanelDialogContainer = new JPanel();
        GridLayout gridLayout = new GridLayout(7,1);
        gridLayout.setVgap(15);
        jPanelDialogContainer.setBorder(new EmptyBorder(20,20,20,20));
        jPanelDialogContainer.setLayout(gridLayout);

        jtfName = new JTextField();
        jtfName.setBorder(BorderFactory.createTitledBorder(HandlerLanguage.languageProperties.getProperty( ConstantGUI.T_JD_NAME_PET )));
        jPanelDialogContainer.add(jtfName);

        jcGender = new JComboBox<>(Gender.values());
        jcGender.setBorder(BorderFactory.createTitledBorder(HandlerLanguage.languageProperties.getProperty( ConstantGUI.T_JD_GENDER_PET )));
        jcGender.setBackground(Color.WHITE);
        jPanelDialogContainer.add(jcGender);

        jcSize = new JComboBox<>(Size.values());
        jcSize.setBorder(BorderFactory.createTitledBorder(HandlerLanguage.languageProperties.getProperty( ConstantGUI.T_JD_SIZE_PET )));
        jcSize.setBackground(Color.WHITE);
        jPanelDialogContainer.add(jcSize);

        jsAge = new JSpinner();
        jsAge.setBorder(BorderFactory.createTitledBorder(HandlerLanguage.languageProperties.getProperty( ConstantGUI.T_JD_GET_AGE_PET )));
        jsAge.setBackground(Color.WHITE);
        jPanelDialogContainer.add(jsAge);

        buttonRegisterPet = new JButton();
        buttonRegisterPet = new view.RoundedJButton(15, 15, HandlerLanguage.languageProperties.getProperty( ConstantGUI.T_JD_REGISTER_PET ), Color.decode("#337AB7"), Color.WHITE, EVENTS.C_ADD_NEW_PET.toString(), myPresenter);
        buttonRegisterPet.addActionListener(myPresenter);
        jPanelDialogContainer.add(buttonRegisterPet);

        cancelAction = new JButton();
        cancelAction = new view.RoundedJButton(15, 15, HandlerLanguage.languageProperties.getProperty( ConstantGUI.T_JD_CANCEL ), Color.decode("#337AB7"), Color.WHITE, EVENTS.C_CANCEL.toString(), myPresenter);
        cancelAction.addActionListener(myPresenter);
        jPanelDialogContainer.add(cancelAction);

        add(jPanelDialogContainer, BorderLayout.CENTER);

    }

    public Pet createNewPet(){
        setVisible(false);
        return new Pet(jtfName.getText(),
                (Size)jcSize.getSelectedItem(),
                (Gender)jcGender.getSelectedItem(),
                Integer.parseInt(jsAge.getValue().toString()));
    }

}
