package presenter;

import dialogs.JDRegisterDoctor;
import dialogs.JDRegisterPet;
import dialogs.JDScheduleAppointment;
import dialogs.filters.JDialogAppointmentByCategory;
import dialogs.filters.JDialogDoctorsByCategory;
import dialogs.filters.JDialogMedicineBySpecie;
import dialogs.filters.JDialogPetsBySize;
import model.*;
import org.json.simple.DeserializationException;
import persistence.FileManager;
import persistence.HandlerLanguage;
import persistence.JsonManager;
import view.ConstantGUI;
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
    private JDialogPetsBySize jDialogPetsBySize;
    private JDialogDoctorsByCategory jDialogDoctorsByCategory;
    private JDialogAppointmentByCategory jDialogAppointmentByCategory;
    private JDialogMedicineBySpecie jDialogMedicineBySpecie;

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
            if (jDialogDoctorsByCategory.getSelectCategory() == doctorTemp.get(i).getCategoryEspeciality()){
                addTable(doctorTemp.get(i).toObjectVector());
            }else if (jDialogDoctorsByCategory.getSelectCategory() == CategoryEspeciality.NONE){
                addTable(doctorTemp.get(i).toObjectVector());
            }
        }
    }

    private void showMedicines() {
        clearTable();
        ArrayList<Medicine> medicinesTemp = medicineManager.getMedicinesList();
        for (int i = 0; i < medicinesTemp.size(); i++) {
            if (jDialogMedicineBySpecie.getSelectCategory().toString().toLowerCase().contains(medicinesTemp.get(i).getSpecies().toLowerCase())){
                addTable(medicinesTemp.get(i).toObjectVector());
            }else if(jDialogMedicineBySpecie.getSelectCategory() == Specie.NONE){
                addTable(medicinesTemp.get(i).toObjectVector());
            }
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
        ArrayList<Pet> petsList = vetManager.getPetsList();
        for (int i = 0; i < petsList.size(); i++) {
            if (petsList.get(i).getSize() == jDialogPetsBySize.getSelectCategory()){
                addTable(petsList.get(i).toObjectVector());
            }else if (jDialogPetsBySize.getSelectCategory()== Size.NONE){
                addTable(petsList.get(i).toObjectVector());
            }
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
            if (appointmentTemp.get(i).getCategory() == jDialogAppointmentByCategory.getSelectCategory()){
                addTable(appointmentTemp.get(i).toObjectVector());
            }else if (jDialogAppointmentByCategory.getSelectCategory() == CategoryEspeciality.NONE){
                addTable(appointmentTemp.get(i).toObjectVector());
            }
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

    public void showGraphicAppointmentCategory(){
        mainWindow.showGraphicAppointmentCategory(vetManager.percentageCategoriesAppointment());
    }

    public void frequentPets(){
        mainWindow.frequenPetsBySize(vetManager.frequentPets());
    }

    public void doctorsByCategoryGraphic(){
        mainWindow.doctorsByCategoryGraphic(vetManager.percentageDoctorForCategory());
    }

    public void petsForMonthGraphic(){
        mainWindow.petsForMounth(vetManager.getMonths());
    }

    public void typesOfMedicines(){
        mainWindow.typesOfMedicines(medicineManager.typesOfMedicines());
    }

    public void reportGender(){
        mainWindow.reportGender(vetManager.getPercentageGender());
    }

    public void buttonsCrud(){
        mainWindow.buttonsCrud();
    }

    public void setCommandButton(String command){
        mainWindow.setCommandButton(command);
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
                jDialogAppointmentByCategory = new JDialogAppointmentByCategory(this);
                break;

            case C_SHOW_TABLE_APPOINTMENT_BY_CATEGORY:
                showTableAppointment();
                showAppointments();
                buttonsCrud();
                setCommandButton(EVENTS.C_DELETE_PPOINTMENT.toString());
                break;

            case C_DELETE_PPOINTMENT:
                vetManager.deleteAppointment(Integer.parseInt(JOptionPane.showInputDialog(HandlerLanguage.languageProperties.getProperty(ConstantGUI.ID_PET_DELETE))));
                clearTable();
                showAppointments();
                break;

            case C_SHOW_PANEL_GRAPHICS:
                mainWindow.showPanelGraphics();
                break;

            case C_SHOW_PANEL_TABLES:
                mainWindow.showPanelButtonsReportsTable();
                break;

            case C_SHOW_TABLE_MEDICINE_RARE:
                jDialogMedicineBySpecie = new JDialogMedicineBySpecie(this);
                break;

            case C_SHOW_TABLE_MEDICINE_BY_SPECIE:
                clearTable();
                showPanelTableMedicine();
                showMedicines();
                buttonsCrud();
                setCommandButton(EVENTS.C_DELETE_MEDICINE.toString());
                break;

            case C_DELETE_MEDICINE:
                medicineManager.deleteMedicine(JOptionPane.showInputDialog(HandlerLanguage.languageProperties.getProperty(ConstantGUI.NAME_MEDICINE_DELETE)));
                clearTable();
                showMedicines();
                break;

            case C_SHOW_LIST_OF_DOCTORS:
                jDialogDoctorsByCategory = new JDialogDoctorsByCategory(this);
                break;

            case C_SHOW_TABLE_DOCTORS_BY_CATEGORY:
                clearTable();
                showPanelTable();
                showDoctors();
                buttonsCrud();
                setCommandButton(EVENTS.C_DELETE_DOCTOR.toString());
                break;

            case C_DELETE_DOCTOR:
                vetManager.deleteDoctor(JOptionPane.showInputDialog(HandlerLanguage.languageProperties.getProperty(ConstantGUI.ID_DOCTOR_DELETE)));
                clearTable();
                showDoctors();
                break;

            case C_SHOW_LIST_OF_PETS_AND_OWNER:
                jDialogPetsBySize = new JDialogPetsBySize(this);
                break;

            case C_SHOW_TABLE_PETS_BY_CATEGORY:
                clearTable();
                showPanelTablePets();
                showPetsAndOwners();
                buttonsCrud();
                setCommandButton(EVENTS.C_DELETE_PET.toString());
                break;

            case C_DELETE_PET:
                vetManager.deletePet(Integer.parseInt(JOptionPane.showInputDialog(HandlerLanguage.languageProperties.getProperty(ConstantGUI.ID_OWNER_DELETE))));
                clearTable();
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

            case C_SHOW_GRAPHICS_ONE:
                showGraphicAppointmentCategory();
                break;

            case C_SHOW_GRAPHICS_TWO:
                frequentPets();
                break;

            case C_SHOW_GRAPHICS_THREE:
                doctorsByCategoryGraphic();
                break;

            case C_SHOW_GRAPHICS_FOUR:
                petsForMonthGraphic();
                break;

            case C_SHOW_GRAPHICS_FIVE:
                typesOfMedicines();
                break;
            case C_SHOW_GRAPHICS_SIX:
                reportGender();
                break;
        }
    }


}
