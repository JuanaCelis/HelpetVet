package dialogs.filters;

import model.CategoryEspeciality;
import model.Size;
import persistence.HandlerLanguage;
import presenter.EVENTS;
import presenter.Presenter;
import view.ConstantGUI;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class JDialogPetsBySize extends JDialog {

    private JPanel jPanelDialogContainer;
    private JComboBox<Size> category;
    private JButton buttonSelectCategory;
    private Presenter myPresenter;

    public JDialogPetsBySize(Presenter presenter) {
        myPresenter = presenter;
        setSize(350, 200);
        getContentPane().setBackground(Color.WHITE);
        setLayout(new BorderLayout());
        setLocationRelativeTo(null);
        setTitle(HandlerLanguage.languageProperties.getProperty( ConstantGUI.T_TITTLE_JD_SELECT_CATEGORY ));
        setVisible(true);
        initComponents();
    }

    private void initComponents() {
        jPanelDialogContainer = new JPanel();
        GridLayout gridLayout = new GridLayout(2,1);
        gridLayout.setVgap(15);
        jPanelDialogContainer.setBorder(new EmptyBorder(20,20,20,20));
        jPanelDialogContainer.setLayout(gridLayout);

        category = new JComboBox<>(Size.values());
        category.setBorder(BorderFactory.createTitledBorder(HandlerLanguage.languageProperties.getProperty( ConstantGUI.T_TITTLE_JD_SELECT_CATEGORY )));
        category.setBackground(Color.white);
        jPanelDialogContainer.add(category);

        buttonSelectCategory = new JButton();
        buttonSelectCategory = new view.RoundedJButton(15, 15, HandlerLanguage.languageProperties.getProperty( ConstantGUI.T_JD_SELECT_CATEGORY), Color.decode("#337AB7"), Color.WHITE, EVENTS.C_SHOW_TABLE_PETS_BY_CATEGORY.toString(), myPresenter);
        jPanelDialogContainer.add(buttonSelectCategory);

        add(jPanelDialogContainer, BorderLayout.CENTER);
    }

    public Size getSelectCategory(){
        setVisible(false);
        return (Size)category.getSelectedItem();
    }
}
