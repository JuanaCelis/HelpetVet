package view.body;

import persistence.HandlerLanguage;
import presenter.EVENTS;
import presenter.Presenter;
import utilities.*;
import view.ConstantGUI;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class JPButtonsReportsGraphics extends JPanel {

    private JPanel panelButtonsRepGraphics, panelTittle;
    private JButton jbAverageCategory, jbDocsCategory,jbPetsPerMonth, jbFrequentPets, jbGenderPets, jbReportMedicine;
    private JLabel jlTittleGraphicsReports, jlTittleTablesReports;

    private Presenter myPresenter;

    public JPButtonsReportsGraphics(Presenter presenter){
        myPresenter = presenter;
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setAlignmentX(LEFT_ALIGNMENT);
        setBackground(Color.decode(ConstantGUI.COLOR_DARK_BLUE));
        initComponents();

    }

    private void initComponents() {
        addTittleGraphicsReports();
        addButtonsGraphicsReports();

    }

    private void addTittleGraphicsReports() {
        panelTittle = new JPanel();
        panelTittle.setLayout(new BorderLayout());
        panelTittle.setBackground(Color.decode(ConstantGUI.COLOR_SKY_BLUE));

        jlTittleGraphicsReports = new JLabel(HandlerLanguage.languageProperties.getProperty(ConstantGUI.T_JLABEL_TITTLE_GRAPHIC_REPORTS));
        jlTittleGraphicsReports.setForeground(Color.WHITE);
        jlTittleGraphicsReports.setBorder(BorderFactory.createEmptyBorder(30,0,30,100));
        //jlTittleGraphicsReports.setAlignmentX(Component.LEFT_ALIGNMENT);
        jlTittleGraphicsReports.setFont(new Font("Arial", Font.BOLD,30));
        panelTittle.add(jlTittleGraphicsReports);

        this.add(jlTittleGraphicsReports);

    }

    private void addButtonsGraphicsReports() {
        panelButtonsRepGraphics = new JPanel();
        GridLayout gridLayout = new GridLayout(2,3);
        gridLayout.setVgap(15);
        gridLayout.setHgap(15);
        panelButtonsRepGraphics.setBorder(new EmptyBorder(20,20,20,20));
        panelButtonsRepGraphics.setLayout(gridLayout);
        panelButtonsRepGraphics.setBackground(Color.decode(ConstantGUI.COLOR_DARK_BLUE));

        jbAverageCategory = new JButton();
        ImageIcon tempAverageCategory = new ImageIcon(new ImageIcon(getClass().getResource(ConstantGUI.BUTTON_GENERAL_REPORTS)).getImage());
        MyUtilities.setTextAndIconButtons(jbAverageCategory, HandlerLanguage.languageProperties.getProperty(ConstantGUI.T_BUTTON_AVERAGE_CATEGORY), tempAverageCategory, 0,0,0,0);
        jbAverageCategory.addActionListener(myPresenter);
        jbAverageCategory.setActionCommand(EVENTS.C_SHOW_GRAPHICS_ONE.toString());
        panelButtonsRepGraphics.add(jbAverageCategory);

        jbDocsCategory = new JButton();
        ImageIcon tempDocsCategory = new ImageIcon(new ImageIcon(getClass().getResource(ConstantGUI.BUTTON_GENERAL_REPORTS)).getImage());
        MyUtilities.setTextAndIconButtons(jbDocsCategory, HandlerLanguage.languageProperties.getProperty(ConstantGUI.T_BUTTON_DOCS_BY_CATEGORY), tempDocsCategory, 0,0,0,0);
        jbDocsCategory.addActionListener(myPresenter);
        jbDocsCategory.setActionCommand(EVENTS.C_SHOW_GRAPHICS_THREE.toString());
        panelButtonsRepGraphics.add(jbDocsCategory);

        jbPetsPerMonth = new JButton();
        ImageIcon tempPetsPerMonth = new ImageIcon(new ImageIcon(getClass().getResource(ConstantGUI.BUTTON_GENERAL_REPORTS)).getImage());
        MyUtilities.setTextAndIconButtons(jbPetsPerMonth, HandlerLanguage.languageProperties.getProperty(ConstantGUI.T_BUTTON_PETS_PER_MONTH), tempPetsPerMonth, 0,0,0,0);
        jbPetsPerMonth.addActionListener(myPresenter);
        jbPetsPerMonth.setActionCommand(EVENTS.C_SHOW_GRAPHICS_FOUR.toString());
        panelButtonsRepGraphics.add(jbPetsPerMonth);

        jbFrequentPets = new JButton();
        ImageIcon tempFrequentPets = new ImageIcon(new ImageIcon(getClass().getResource(ConstantGUI.BUTTON_GENERAL_REPORTS)).getImage());
        MyUtilities.setTextAndIconButtons(jbFrequentPets, HandlerLanguage.languageProperties.getProperty(ConstantGUI.T_BUTTON_FREQUENT_PETS), tempFrequentPets, 0,0,0,0);
        jbFrequentPets.addActionListener(myPresenter);
        jbFrequentPets.setActionCommand(EVENTS.C_SHOW_GRAPHICS_TWO.toString());
        panelButtonsRepGraphics.add(jbFrequentPets);

        jbGenderPets = new JButton();
        ImageIcon tempRatingVet = new ImageIcon(new ImageIcon(getClass().getResource(ConstantGUI.BUTTON_GENERAL_REPORTS)).getImage());
        MyUtilities.setTextAndIconButtons(jbGenderPets, HandlerLanguage.languageProperties.getProperty(ConstantGUI.T_BUTTON_RATING_VET), tempRatingVet, 0,0,0,0);
        jbGenderPets.addActionListener(myPresenter);
        jbGenderPets.setActionCommand(EVENTS.C_SHOW_GRAPHICS_SIX.toString());
        panelButtonsRepGraphics.add(jbGenderPets);

        jbReportMedicine = new JButton();
        ImageIcon tempReportMedicine = new ImageIcon(new ImageIcon(getClass().getResource(ConstantGUI.BUTTON_GENERAL_REPORTS)).getImage());
        MyUtilities.setTextAndIconButtons(jbReportMedicine, HandlerLanguage.languageProperties.getProperty(ConstantGUI.T_BUTTON_REPORT_MEDICINE), tempReportMedicine, 0,0,0,0);
        jbReportMedicine.addActionListener(myPresenter);
        jbReportMedicine.setActionCommand(EVENTS.C_SHOW_GRAPHICS_FIVE.toString());
        panelButtonsRepGraphics.add(jbReportMedicine);

        this.add(panelButtonsRepGraphics);
    }

    public void changeLanguage(){
        jlTittleGraphicsReports.setText((HandlerLanguage.languageProperties.getProperty(ConstantGUI.T_JLABEL_TITTLE_GRAPHIC_REPORTS)));
        jbAverageCategory.setText(HandlerLanguage.languageProperties.getProperty(ConstantGUI.T_BUTTON_AVERAGE_CATEGORY));
        jbDocsCategory.setText(HandlerLanguage.languageProperties.getProperty(ConstantGUI.T_BUTTON_DOCS_BY_CATEGORY));
        jbPetsPerMonth.setText(HandlerLanguage.languageProperties.getProperty(ConstantGUI.T_BUTTON_PETS_PER_MONTH));
        jbFrequentPets.setText(HandlerLanguage.languageProperties.getProperty(ConstantGUI.T_BUTTON_FREQUENT_PETS));
        jbGenderPets.setText(HandlerLanguage.languageProperties.getProperty(ConstantGUI.T_BUTTON_RATING_VET));
        jbReportMedicine.setText(HandlerLanguage.languageProperties.getProperty(ConstantGUI.T_BUTTON_REPORT_MEDICINE));
    }

}
