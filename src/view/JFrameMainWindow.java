package view;
import persistence.HandlerLanguage;
import presenter.Presenter;

import javax.swing.*;

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

    public void changeLanguage() {
        this.setTitle( HandlerLanguage.languageProperties.getProperty(ConstantGUI.T_MAIN_WINDOW ));
        mainPanel.changeLanguage();
    }
}
