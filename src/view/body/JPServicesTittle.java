package view.body;

import persistence.HandlerLanguage;
import presenter.Presenter;
import utilities.*;
import utilities.UploaderFontsResource;
import view.ConstantGUI;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class JPServicesTittle extends JPanel {

    private JLabel jlTittleServices, jlTittleAnswer;
    private Presenter myPresenter;

    public JPServicesTittle(Presenter presenter){
        myPresenter = presenter;
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setBackground(Color.WHITE);
        initComponents();
    }

    private void initComponents() {
        addTittle();
        addAnswerTittle();
    }


    private void addTittle() {

        jlTittleServices = new JLabel(HandlerLanguage.languageProperties.getProperty(ConstantGUI.T_SERVICE_TITTLE));
        jlTittleServices.setForeground(Color.decode(ConstantGUI.COLOR_TITTLE_SERVICE));
        jlTittleServices.setBorder(BorderFactory.createEmptyBorder(40,550,10,0));
        try {
            jlTittleServices.setFont(UploaderFontsResource.uploadFont(ConstantGUI.FONT_UBUNTU_LIGHT, Font.BOLD,40));
        } catch (FontFormatException | IOException e) {
            e.printStackTrace();
        }

        this.add(jlTittleServices);
    }

    private void addAnswerTittle() {

        jlTittleAnswer = new JLabel(HandlerLanguage.languageProperties.getProperty(ConstantGUI.T_SERVICE_ANSWER));
        jlTittleAnswer.setForeground(Color.decode(ConstantGUI.COLOR_GRAY_SERVICE));
        jlTittleAnswer.setBorder(BorderFactory.createEmptyBorder(10,350,30,0));
        try {
            jlTittleAnswer.setFont(UploaderFontsResource.uploadFont(ConstantGUI.FONT_UBUNTU_LIGHT, Font.BOLD,20));
        } catch (FontFormatException | IOException e) {
            e.printStackTrace();
        }

        this.add(jlTittleAnswer);
    }

    public void changeLanguage(){
        jlTittleServices.setText(HandlerLanguage.languageProperties.getProperty(ConstantGUI.T_SERVICE_TITTLE));
        jlTittleAnswer.setText(HandlerLanguage.languageProperties.getProperty(ConstantGUI.T_SERVICE_ANSWER));
    }


}
