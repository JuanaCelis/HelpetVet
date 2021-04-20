package view.body;

import persistence.HandlerLanguage;
import presenter.Presenter;
import view.ConstantGUI;

import javax.swing.*;
import java.awt.*;

public class JPContainerBody extends JPanel {

    private Presenter myPresenter;
    private JPButtonsReportsGraphics jpButtonsReportsGraphics;

    public JPContainerBody(Presenter presenter) {
        this.setLayout(new BorderLayout());
        myPresenter = presenter;
        initViews();

    }

    private void initViews() {

        jpButtonsReportsGraphics = new JPButtonsReportsGraphics(myPresenter);
        this.add(jpButtonsReportsGraphics,BorderLayout.PAGE_START);
    }

    public void changeLanguage(){
        jpButtonsReportsGraphics.changeLanguage();
    }
}
