package model;

import java.util.ArrayList;

public class DoctorManager {

    private AppointmentManager appointmentManager;
    private ArrayList<Doctor> doctors;

    public DoctorManager(){
        doctors = new ArrayList<>();
    }

    /**
     * Crear Clase con los listas de doctores y citas
     * @param Arraylist lista doctores
     * @param Arraylist lsitas citas
     */
    public DoctorManager(ArrayList<Doctor> doctors){
        this.doctors = doctors;
    }

    /**
     * Agrega una lista de doctores
     */
    public void setDoctors(ArrayList<Doctor> doctors){
        this.doctors = doctors;
    }

    /**
     * Agrega un doctor a la lista
     */
    public void addDoctor(Doctor doctor){
        if (!doctors.contains(doctor)){
            doctors.add(doctor);
        }
    }

    /**
     * Eleimina un doctor de la lista
     * @param idDoctor id del doctor a eliminar
     */
    public void deleteDoctor(String idDoctor){
        for (int i = 0; i < doctors.size(); i++) {
            if(doctors.get(i).getId() == idDoctor){
                doctors.remove(i);
            }
        }
    }

    /**
     * Se obtienen los doctores registrados
     * @return ArrayList de doctores
     */
    public ArrayList<Doctor> getDoctors() {
        return doctors;
    }    

    public ArrayList<Appointment> getAppointmentsList() {
        return appointmentManager.getAppointmentList();
    }

    public AppointmentManager getAppointmentManager() {
        return appointmentManager;
    }

    public ArrayList<Double> percentageDoctorForCategory(){
        ArrayList<Double> list = new ArrayList<>();

        list.add((double)numberDoctorsCategorys(CategoryEspeciality.SURGERY));
        list.add((double)numberDoctorsCategorys(CategoryEspeciality.PHISIOTHERAPY));
        list.add((double)numberDoctorsCategorys(CategoryEspeciality.ONCOLOGY));
        list.add((double)numberDoctorsCategorys(CategoryEspeciality.REHABILITATION));
        list.add((double)numberDoctorsCategorys(CategoryEspeciality.IMAGING));
        list.add((double)numberDoctorsCategorys(CategoryEspeciality.WILDLIFE));

        return list;
    }

    public int numberDoctorsCategorys(CategoryEspeciality especiality){
        int result = 0;
        for (int i = 0; i < doctors.size(); i++) {
            if (doctors.get(i).getCategoryEspeciality() == especiality){
                result++;
            }
        }
        return result;
    }

}
