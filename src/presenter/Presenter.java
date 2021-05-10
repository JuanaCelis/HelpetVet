package presenter;

import dialogs.JDRegisterDoctor;
import dialogs.JDRegisterPet;
import dialogs.JDScheduleAppointment;
import model.*;
import org.json.simple.DeserializationException;
import persistence.FileManager;
import persistence.HandlerLanguage;
import persistence.JsonManager;
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
    private MedicineManager medicineManager;
    private JFrameMainWindow mainWindow;
    private JDRegisterPet jdRegisterPet;
    private JDRegisterDoctor jdRegisterDoc;
    private JDScheduleAppointment jdScheduleAppointment;
    private FileManager fileManager;

    private HandlerLanguage config;

    public Presenter() throws IOException {
        fileManager = new FileManager();
        vetManager = new VetManager();
        medicineManager = new MedicineManager();
        readMedicineOfApi();
        readFile();
        loadConfiguration();
        mainWindow = new JFrameMainWindow(this);
    }

    public void readMedicineOfApi(){
        try {
            medicineManager.setMedicinesList(new JsonManager().getMedicineList());
        } catch (IOException e) {
            e.printStackTrace();
        } catch (DeserializationException e) {
            e.printStackTrace();
        }
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

    //Tablas
    public void clearTable() {
        mainWindow.clearTable();
    }

    public void showPanelTable(){
        mainWindow.showPanelTable();
        showListOfDoctors(vetManager.getDoctors());
    }

    public void showListOfDoctors(ArrayList<Doctor> doctorList){
        mainWindow.showListOfDoctors(doctorList);
    }

    public void showDoctors(){
        clearTable();
        ArrayList<Doctor> doctorTemp = vetManager.getDoctors();
        for (int i = 0; i < doctorTemp.size(); i++) {
            addTable(doctorTemp.get(i).toObjectVector());
        }
    }

    private void showMedicines() {
        clearTable();
        ArrayList<Medicine> medicinesTemp = medicineManager.getMedicinesList();
        for (int i = 0; i < medicinesTemp.size(); i++) {
            addTable(medicinesTemp.get(i).toObjectVector());
        }
    }

    public void showPanelTablePets(){
        mainWindow.showPanelTable();
        showTablePetsOwners(vetManager.getPetsList());
    }


    private void showPanelTableMedicine() {
        mainWindow.showPanelTable();
        showTableMedicine(medicineManager.getMedicinesList());
    }

    public void showTablePetsOwners(ArrayList<Pet> petList){
        mainWindow.showTablePetsOwners(petList);
    }

    public void showTableMedicine(ArrayList<Medicine>medicinesList){
        mainWindow.showTableMedicines(medicinesList);
    }

    public void showPetsAndOwners(){
        clearTable();
        ArrayList<Pet> doctorTemp = vetManager.getPetsList();
        for (int i = 0; i < doctorTemp.size(); i++) {
            addTable(doctorTemp.get(i).toObjectVector());
        }
    }

    public void showTableAppointment(){
        mainWindow.showPanelTable();
        showTableOfAppoinmentAssingnedByDate(vetManager.appointmenList());
    }

    public void showTableOfAppoinmentAssingnedByDate(ArrayList<Appointment> appointmentList){
        mainWindow.showTableOfAppoinmentAssingnedByDate(appointmentList);
    }

    public void showAppointments(){
        clearTable();

        ArrayList<Appointment> appointmentTemp = vetManager.appointmenList();
        for (int i = 0; i < appointmentTemp.size(); i++) {
            addTable(appointmentTemp.get(i).toObjectVector());
        }
        System.out.println(appointmentTemp.get(0).getNamePet());
    }

    public void addTable(Object [] element){
        mainWindow.addTable(element);
    }

    public void createPet(){
        Pet temp = jdRegisterPet.createNewPet();
        if (temp != null){
            vetManager.addPet(temp);
        }
        System.out.println(temp.getName() +" " + temp.getId());
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
            vetManager.addDoctor(new Doctor(temp[0],temp[1],temp[2], splitDate(temp[3]), CategoryEspeciality.valueOf(temp[4])));
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
                break;

            case C_DIALOG_REGISTER_DOC:
                jdRegisterDoc = new JDRegisterDoctor(this);
                break;

            case C_ADD_NEW_DOCTOR:
                vetManager.addDoctor(jdRegisterDoc.createDoctor());
                jdRegisterDoc.dispose();
                break;

            case C_SCHEDULE_APPOINTMENT:
                jdScheduleAppointment = new JDScheduleAppointment(this);
                break;

            case C_ADD_NEW_APPOINTMENT:
                vetManager.addAppointment(jdScheduleAppointment.createAppointment());
                break;

            case C_SHOW_LIST_APPOINTMENT:
                showTableAppointment();
                showAppointments();
                break;

            case C_SHOW_PANEL_GRAPHICS:
                mainWindow.showPanelGraphics();
                break;

            case C_SHOW_PANEL_TABLES:
                mainWindow.showPanelButtonsReportsTable();
                break;

            case C_SHOW_TABLE_MEDICINE_RARE:
                clearTable();
                showPanelTableMedicine();
                showMedicines();
                break;

            case C_SHOW_LIST_OF_DOCTORS:
                clearTable();
                showPanelTable();
                showDoctors();
                break;

            case C_SHOW_LIST_OF_PETS_AND_OWNER:
                clearTable();
                showPanelTablePets();
                showPetsAndOwners();
                break;

            case C_SHOW_HOMEPAGE:
                mainWindow.showHomePage();

            case C_NEXT_IMAGE_BANNER:
                mainWindow.changeImageBannerNext();
                break;

            case C_BACK_IMAGE_BANNER:
                mainWindow.changeImageBannerBack();
                break;

        }
    }


}
