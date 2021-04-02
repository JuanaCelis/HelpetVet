package model;

import java.util.ArrayList;
import java.util.List;

public class AppointmentManager {

    private ArrayList<Appointment> appointmentList;
    private ArrayList<Doctor> doctorList;

    public AppointmentManager(ArrayList<Appointment> appointmentList) {
        this.appointmentList = appointmentList;
    }

    /**
     * Pendiente por refactorizar
     * @return
     */
    public List<Double> percentageCategoriesAppointment(){
        int total = appointmentList.size();
        List<Double> results = new ArrayList<>();

        results.add((double)getTotalCategories(CategoryEspeciality.SURGERY)*100/total);
        results.add((double)getTotalCategories(CategoryEspeciality.ONCOLOGY)*100/total);
        results.add((double)getTotalCategories(CategoryEspeciality.PHISIOTHERAPY)*100/total);
        results.add((double)getTotalCategories(CategoryEspeciality.REHABILITATION)*100/total);
        results.add((double) getTotalCategories(CategoryEspeciality.IMAGING)*100/total);
        results.add((double)getTotalCategories(CategoryEspeciality.WILDLIFE)*100/total);

        return results;
    }

    public int getTotalCategories(CategoryEspeciality categoryEspeciality){
        int result = 0;
        for (int i = 0; i < appointmentList.size(); i++) {
            if (appointmentList.get(i).getCategory() == categoryEspeciality){
                result++;
            }
        }
        return result;
    }

    public ArrayList<Appointment> getAppointmentList() {
        return appointmentList;
    }

    public ArrayList<Doctor> getDoctorList() {
        return doctorList;
    }

    public void setAppointmentList(ArrayList<Appointment> appointmentList) {
        this.appointmentList = appointmentList;
    }

    public void setDoctorList(ArrayList<Doctor> doctorList) {
        this.doctorList = doctorList;
    }
}
