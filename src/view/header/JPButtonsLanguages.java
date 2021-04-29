package view.header;

import presenter.EVENTS;
import presenter.Presenter;
import utilities.*;
import view.ConstantGUI;

import javax.swing.*;
import java.awt.*;

public class JPButtonsLanguages extends JPanel {

    private JPanel panelButtonsBackground;

    private JButton jmbLanguageEnglish;
    private JButton jmbLanguageSpanish;

    private Presenter myPresenter;

    public JPButtonsLanguages(Presenter presenter){
        myPresenter = presenter;
        setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
        setAlignmentX(LEFT_ALIGNMENT);
        setBackground(Color.decode("#00C4CC"));
        initComponents();
    }

    private void initComponents() {
        addIcons();
    }

    private void addIcons() {

        panelButtonsBackground = new JPanel();
        panelButtonsBackground.setBackground(Color.decode("#00C4CC"));

        jmbLanguageEnglish = new JButton();
        ImageIcon tempEnglish = new ImageIcon(new ImageIcon(getClass().getResource(ConstantGUI.BUTTON_ENGLISH)).getImage());
        MyUtilities.setMainElementsButton(jmbLanguageEnglish,tempEnglish,5,30,5,0);
        jmbLanguageEnglish.addActionListener(myPresenter);
        jmbLanguageEnglish.setActionCommand(EVENTS.C_ENGLISH_LANGUAGE.toString());
        panelButtonsBackground.add(jmbLanguageEnglish);

        jmbLanguageSpanish = new JButton();
        ImageIcon tempSpanish = new ImageIcon(new ImageIcon(getClass().getResource(ConstantGUI.BUTTON_SPANISH)).getImage());
        MyUtilities.setMainElementsButton(jmbLanguageSpanish,tempSpanish,5,20,5,0);
        jmbLanguageSpanish.addActionListener(myPresenter);
        jmbLanguageSpanish.setActionCommand(EVENTS.C_SPANISH_LANGUAGE.toString());
        panelButtonsBackground.add(jmbLanguageSpanish);

        this.add(panelButtonsBackground);


    }

}
