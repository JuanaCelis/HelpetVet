package view.body;

import persistence.HandlerLanguage;
import view.ConstantGUI;

import javax.swing.*;
import java.awt.*;

public class JPShowService extends JPanel {

    private JPGeneratePanelService jpGeneratePanelService;
    private String text1,text2,text3;

    public JPShowService(){

        jpGeneratePanelService = new JPGeneratePanelService();
        setBackground(Color.white);
        this.setLayout(new GridLayout(1,3,35,35));
        initComponents();
    }

    private void initComponents() {
        text1 = HandlerLanguage.languageProperties.getProperty(ConstantGUI.T_SERVICE_EXCELLENT_PROFESSIONALS);
        text2 = HandlerLanguage.languageProperties.getProperty(ConstantGUI.T_SERVICE_MEDICINE);
        text3 = HandlerLanguage.languageProperties.getProperty(ConstantGUI.T_SERVICE_FACILITIES);

        addServices();
    }

    private void addServices() {

        this.add(jpGeneratePanelService.generatePanel(ConstantGUI.DOCTOR_IMAGE_SERVICE, text1));
        this.add(jpGeneratePanelService.generatePanel(ConstantGUI.MEDICINE_IMAGE_SERVICE, text2 ));
        this.add(jpGeneratePanelService.generatePanel(ConstantGUI.INSTALACIONES_IMAGE_SERVICE, text3));
    }

    public void changeLanguage(){
        text1 = HandlerLanguage.languageProperties.getProperty(ConstantGUI.T_SERVICE_EXCELLENT_PROFESSIONALS);
        text2 = HandlerLanguage.languageProperties.getProperty(ConstantGUI.T_SERVICE_MEDICINE);
        text3 = HandlerLanguage.languageProperties.getProperty(ConstantGUI.T_SERVICE_FACILITIES);
    }
}
