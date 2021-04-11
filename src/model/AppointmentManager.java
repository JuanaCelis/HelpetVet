package model;

import java.util.ArrayList;
import java.util.List;

public class AppointmentManager {

    // private ArrayList<AppointmentResult> resultAppointmentList;
    private ArrayList<Appointment> appointmentList;


    public AppointmentManager(ArrayList<Appointment> appointmentList) {
        // this.resultAppointmentList = new ArrayList<>();
        this.appointmentList = appointmentList;
    }

    /**
     * Pendiente por refactorizar
     * @return
     */
    public List<Double> percentageCategoriesAppointment(){
        int total = appointmentList.size();
        List<Double> results = new ArrayList<>();

        results.add((double)getTotalNumberOfCategories(CategoryEspeciality.SURGERY)*100/total);
        results.add((double)getTotalNumberOfCategories(CategoryEspeciality.ONCOLOGY)*100/total);
        results.add((double)getTotalNumberOfCategories(CategoryEspeciality.PHISIOTHERAPY)*100/total);
        results.add((double)getTotalNumberOfCategories(CategoryEspeciality.REHABILITATION)*100/total);
        results.add((double)getTotalNumberOfCategories(CategoryEspeciality.IMAGING)*100/total);
        results.add((double)getTotalNumberOfCategories(CategoryEspeciality.WILDLIFE)*100/total);

        return results;
    }

    public int getTotalNumberOfCategories(CategoryEspeciality categoryEspeciality){
        int result = 0;
        for (int i = 0; i < appointmentList.size(); i++) {
            if (appointmentList.get(i).getCategory() == categoryEspeciality){
                result++;
            }
        }
        return result;
    }

    /**
     * Asigna la Doctor a la cita 
     * 
     */
    public Appointment assingDoctorForAppointment(Doctor doctor){
        Appointment appointmentResult = null;
        for (Appointment appointment : appointmentList) {
            if (appointment.getCategory() == doctor.getCategoryEspeciality()) {
                appointment.setDoctor(doctor);;
                appointmentResult = appointment;
                break;
            }
        }
        return appointmentResult;
    }
    

    public ArrayList<Appointment> getAppointmentList() {
        return appointmentList;
    }


    public void setAppointmentList(ArrayList<Appointment> appointmentList) {
        this.appointmentList = appointmentList;
    }


}
