package presenter;

import dialogs.JDRegisterDoctor;
import dialogs.JDRegisterPet;
import dialogs.JDScheduleAppointment;
import model.*;
import persistence.FileManager;
import persistence.HandlerLanguage;
import view.JFrameMainWindow;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;

public class Presenter implements ActionListener {

    private static final String ENGLISH_PATH = "resources/languages/languageUS.properties";
    private static final String SPANISH_PATH = "resources/languages/languageES.properties";
    private static final String NAME_FILE_CONFIG = "resources/config/config.init";
    private static final String PATH_FILE = "resources/archives/Doctors.vet";

    private VetManager vetManager;
    private JFrameMainWindow mainWindow;
    private JDRegisterPet jdRegisterPet;
    private JDRegisterDoctor jdRegisterDoc;
    private JDScheduleAppointment jdScheduleAppointment;
    private FileManager fileManager;

    private HandlerLanguage config;

    public Presenter() throws IOException {
        vetManager = new VetManager();
        fileManager = new FileManager();
        readFile();
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

    public void showTableDoctor(){
        mainWindow.showPanelTable();
        showListOfDoctors(vetManager.getDoctorManager().getDoctors());
    }

    public void showDoctors(){
        ArrayList<Doctor> doctorTemp = vetManager.getDoctorManager().getDoctors();
        for (int i = 0; i < doctorTemp.size(); i++) {
            mainWindow.addToTable(doctorTemp.get(i).toObjectVector());
        }
    }

    public void showTableMedicine(){
        mainWindow.showPanelTable();
        showMedicineRaresTable(vetManager.getMedicinesList());
    }

    public void showMedicineRaresTable(ArrayList<Medicine> medicineList){
        mainWindow.showMedicineRaresTable(medicineList);
    }

    public void showListOfDoctors(ArrayList<Doctor> doctorList){
        mainWindow.showListOfDoctors(doctorList);
    }

    /**
     * crea un Doctor con los datos obtenidos por el Dialog Register Doct
     * @return Doctor nuevo
     */
    public void createDoctor(){
        vetManager.getDoctorManager().addDoctor(jdRegisterDoc.createDoctor());
    }

    public void createPet(){
//        vetManager.getPetManager().getPetsList().add(jdRegisterPet.createNewPet());
        vetManager.getPetManager().addPet(jdRegisterPet.createNewPet());
    }

    public void testPets(){
        for (int i = 0; i < vetManager.getPetManager().getPetsList().size(); i++) {
            System.out.println( vetManager.getPetManager().getPetsList().get(i).getId() + vetManager.getPetManager().getPetsList().get(i).getName());
            System.out.println(vetManager.getPetManager().getPetsList().get(i));
        }
        System.out.println(vetManager.getPetManager().getTotalPets());
    }

    /**
     * Lee el archivo de Doctor.vet
     * @throws IOException
     */
    public void readFile() throws IOException {
       ArrayList tempDoctors = fileManager.readFile(PATH_FILE);
        splitLines(tempDoctors);
    }

    public void splitLines(ArrayList<String> lines){
        for (String line : lines) {
            String temp [] = line.split(";");
            vetManager.getDoctorManager().addDoctor(new Doctor(temp[0],temp[1],temp[2], splitDate(temp[3]), CategoryEspeciality.valueOf(temp[4])));
        }
    }

    public LocalDate splitDate(String date){
        String tempData [] = date.split(",");
        return LocalDate.of(Integer.parseInt(tempData[0]),Integer.parseInt(tempData[1]),Integer.parseInt(tempData[2]));
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

            case C_ADD_NEW_PET:
                createPet();
                testPets();
                vetManager.getPetManager().setIdPets();
                break;

            case C_DIALOG_REGISTER_DOC:
                jdRegisterDoc = new JDRegisterDoctor(this);
                break;

            case C_ADD_NEW_DOCTOR:
                createDoctor();
                jdRegisterDoc.dispose();

                break;

            case C_SCHEDULE_APPOINTMENT:
                jdScheduleAppointment = new JDScheduleAppointment(this);
                break;

            case C_SHOW_PANEL_GRAPHICS:
                mainWindow.showPanelGraphics();
                break;

            case C_SHOW_PANEL_TABLES:
                mainWindow.showPanelButtonsReportsTable();
                break;

            case C_SHOW_TABLE_MEDICINE_RARE:
                showTableMedicine();
                break;

            case C_SHOW_LIST_OF_DOCTORS:
                showTableDoctor();
                //showListOfDoctors(vetManager.getDoctors());
                showDoctors();
                break;

        }

    }
}
