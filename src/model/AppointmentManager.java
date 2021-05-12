package model;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;

public class AppointmentManager {

    private ArrayList<Appointment> appointmentList;


    public AppointmentManager() {
         this.appointmentList = new ArrayList<>();
         testDatas();
    }

    public void addAppointment(Appointment appointment){
        int count = appointmentList.size()+1;
        if (!appointmentList.contains(appointment)){
            appointment.setIdPet(count++);
            appointmentList.add(appointment);
        }
    }

    public void deleteAppointment(int idPet){
        for (int i = 0; i < appointmentList.size(); i++) {
            if (appointmentList.get(i).getIdPet() == idPet){
                appointmentList.remove(i);
            }
        }
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

    public void registerNewAppointment(Appointment appointment){
        
    }

    public ArrayList<Appointment> getAppointmentList() {
        return appointmentList;
    }


    public void setAppointmentList(ArrayList<Appointment> appointmentList) {
        this.appointmentList = appointmentList;
    }

    public void petsForMonth(){


    }

    public ArrayList<Integer> getMonths(){
        ArrayList<Integer> list = new ArrayList<>();
        list.add(getAppointmentsForMonth(Month.JANUARY));
        list.add(getAppointmentsForMonth(Month.FEBRUARY));
        list.add(getAppointmentsForMonth(Month.MARCH));
        list.add(getAppointmentsForMonth(Month.APRIL));
        list.add(getAppointmentsForMonth(Month.MAY));
        list.add(getAppointmentsForMonth(Month.JUNE));
        list.add(getAppointmentsForMonth(Month.JULY));
        list.add(getAppointmentsForMonth(Month.AUGUST));
        list.add(getAppointmentsForMonth(Month.SEPTEMBER));
        list.add(getAppointmentsForMonth(Month.OCTOBER));
        list.add(getAppointmentsForMonth(Month.NOVEMBER));
        list.add(getAppointmentsForMonth(Month.DECEMBER));

        return list;
    }

    public int getAppointmentsForMonth(Month month){
        int result = 0;
        for (int i = 0; i < appointmentList.size(); i++) {
            if (month == appointmentList.get(i).getDateAppointment().getMonth()){
                result++;
            }
        }
        return result;
    }

    /**
     * Datos quemados
     */
    public void testDatas(){
        addAppointment(new Appointment("17321","Gomez","Cristina","Ema",CategoryEspeciality.SURGERY, LocalDate.of(2021,01,13)));
        addAppointment(new Appointment("10932","Ardila","Julian","Winny",CategoryEspeciality.SURGERY, LocalDate.of(2021,01,23)));
        addAppointment(new Appointment("13862","Sanchez","Yulieth","Manchita",CategoryEspeciality.PHISIOTHERAPY, LocalDate.of(2021,06,13)));
        addAppointment(new Appointment("14582","Perez","Isabella","Max",CategoryEspeciality.WILDLIFE, LocalDate.of(2021,06,18)));
        addAppointment(new Appointment("12476","Ortiz","Selena","Tobi",CategoryEspeciality.SURGERY, LocalDate.of(2021,05,27)));
        addAppointment(new Appointment("154216","Calderon","Catalina","Bash",CategoryEspeciality.REHABILITATION, LocalDate.of(2021,07,20)));
        addAppointment(new Appointment("124234","Calderon","Ramiro","Mota",CategoryEspeciality.SURGERY, LocalDate.of(2021,07,20)));
        addAppointment(new Appointment("143218","Gualdron","Silvia","linux",CategoryEspeciality.REHABILITATION, LocalDate.of(2021,8,20)));
        addAppointment(new Appointment("132116","Mondragon","Guillermo","Chispas",CategoryEspeciality.IMAGING, LocalDate.of(2021,8,7)));
        addAppointment(new Appointment("133426","Mondragon","Jorge","Candy",CategoryEspeciality.IMAGING, LocalDate.of(2021,8,15)));
    }

}
