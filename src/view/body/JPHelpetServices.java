package view.body;

import presenter.Presenter;
import utilities.UploaderFontsResource;
import view.ConstantGUI;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class JPHelpetServices extends JPanel {

    private JPServicesTittle jpServicesTittle;
    private JPShowService jpShowService;
    private Presenter myPresenter;

    public JPHelpetServices(Presenter presenter){

        myPresenter = presenter;
        setLayout(new BorderLayout());
        setBackground(Color.WHITE);
        setAlignmentX(LEFT_ALIGNMENT);
        initComponents();
    }

    private void initComponents() {

        jpServicesTittle = new JPServicesTittle(myPresenter);
        add(jpServicesTittle,BorderLayout.PAGE_START);

        jpShowService = new JPShowService();
        add(jpShowService,BorderLayout.CENTER);

    }

    public void changeLanguage(){
        jpServicesTittle.changeLanguage();
        jpShowService.changeLanguage();
    }

}
