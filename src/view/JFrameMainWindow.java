package view;

import model.Owner;
import presenter.Presenter;

import javax.swing.*;
import java.util.ArrayList;

public class JFrameMainWindow extends JFrame {

    private Presenter myPresenter;
    private JPMainPanel mainPanel;

    public JFrameMainWindow(Presenter presenter){
        myPresenter = presenter;
        setExtendedState(MAXIMIZED_BOTH);
        setSize(600, 400);
        //setIconImage(new ImageIcon(getClass().getResource(ConstantsGUI.LOGO_PAGE)).getImage());
        setTitle("HELPET");
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
}
