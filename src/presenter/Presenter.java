package presenter;

import dialogs.JDRegisterDoctor;
import dialogs.JDRegisterPet;
import dialogs.JDScheduleAppointment;
import model.Doctor;
import model.VetManager;
import persistence.HandlerLanguage;
import view.JFrameMainWindow;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class Presenter implements ActionListener {

    private static final String ENGLISH_PATH = "resources/languages/languageUS.properties";
    private static final String SPANISH_PATH = "resources/languages/languageES.properties";
    private static final String NAME_FILE_CONFIG = "resources/config/config.init";

    private VetManager vetManager;
    private JFrameMainWindow mainWindow;
    private JDRegisterPet jdRegisterPet;
    private JDRegisterDoctor jdRegisterDoc;
    private JDScheduleAppointment jdScheduleAppointment;

    private HandlerLanguage config;

    public Presenter(){
        vetManager = new VetManager();
        loadConfiguration();
        mainWindow = new JFrameMainWindow(this);

    }

    private void loadConfiguration() {
        if(config == null){
            config = new HandlerLanguage(NAME_FILE_CONFIG);
        }
        try{
            config.loadLanguage();
        }catch(IOException e){
            //JOptionPane.showMessageDialog(jfMainWindow, e.getMessage());
            System.out.println(e.getMessage());
        }
    }

    private void loadLanguage() {
        try {
            config.loadLanguage();
        }catch (IOException e){
            JOptionPane.showMessageDialog(mainWindow,e.getMessage());
        }
    }

    private void saveConfig() {
        try {
            new HandlerLanguage(NAME_FILE_CONFIG).saveLanguage();
        }catch (IOException e){
            JOptionPane.showMessageDialog(mainWindow, e.getMessage());
        }
    }

    private void manageChangeLenguageUS(){
        try {
            changeToEnglish();
        }catch (IOException e1){
            JOptionPane.showMessageDialog(mainWindow,e1.getMessage());
        }
        manageChangeLanguage();
    }

    private void manageChangeLanguageES(){
        try {
            changeToSpanish();
        } catch (IOException e1) {
            JOptionPane.showMessageDialog(mainWindow, e1.getMessage());
        }
        manageChangeLanguage();
    }

    public void changeToEnglish() throws IOException{
        HandlerLanguage.language = ENGLISH_PATH;
        saveConfig();
        loadLanguage();
    }

    public void changeToSpanish() throws IOException{
        HandlerLanguage.language = SPANISH_PATH;
        saveConfig();
        loadLanguage();
    }

    private void manageChangeLanguage(){
        mainWindow.changeLanguage();
    }

    /**
     * crea un Doctor conlos datos obtenidos por el Dialogo Register Doct
     * @return Doctor nuevo
     */
    public void createDoctor(){
        vetManager.getDoctorManager().addDoctor(jdRegisterDoc.createDoctor());
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        switch (EVENTS.valueOf(e.getActionCommand())){

            case C_SPANISH_LANGUAGE:
                manageChangeLanguageES();
                break;

            case C_ENGLISH_LANGUAGE:
                manageChangeLenguageUS();
                break;

            case C_DIALOG_REGISTER_PET:
                jdRegisterPet = new JDRegisterPet(this);
                break;

            case C_DIALOG_REGISTER_DOC:
                jdRegisterDoc = new JDRegisterDoctor(this);
                break;

            case C_ADD_DOCTOR:
                createDoctor();
                jdRegisterDoc.dispose();
                break;

            case C_SCHEDULE_APPOINTMENT:
                jdScheduleAppointment = new JDScheduleAppointment(this);
                break;
        }

    }
}
