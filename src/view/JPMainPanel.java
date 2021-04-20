package view;

import presenter.Presenter;
import view.body.JPContainerBody;
import view.footer.JPContainerFooter;
import view.header.JPContainerHeader;

import javax.swing.*;
import java.awt.*;

public class JPMainPanel extends JPanel {

    private JPContainerHeader jpcontainerHeader;
    private JPContainerBody jpcontainerBody;
    private JPContainerFooter jpcontainerFooter;
    private Presenter myPresenter;

    public JPMainPanel(Presenter presenter){
        myPresenter = presenter;
        setLayout(new BorderLayout());
        setBackground(Color.white);
        initComponents();
    }

    private void initComponents() {

        jpcontainerHeader = new JPContainerHeader(myPresenter);
        add(jpcontainerHeader, BorderLayout.PAGE_START);

        jpcontainerBody = new JPContainerBody(myPresenter);
        add(jpcontainerBody,BorderLayout.CENTER);

        jpcontainerFooter = new JPContainerFooter(myPresenter);
        add(jpcontainerFooter, BorderLayout.PAGE_END);

    }

    public void changeLanguage() {
        jpcontainerHeader.changeLanguage();
        jpcontainerBody.changeLanguage();
    }
}
