package model;

public enum MedicineClass {

    VACUNA("VACUNA"),
    Antibioticos("Antibioticos"),
    Antiparasitarios("Antiparasitarios"),
    Antiinflamatorios("Antiinflamatorios"),
    Desinfectantes("Desinfectantes");

    private String medicineClassName;

    private MedicineClass(String name){
        this.medicineClassName = name;
    }

    public String getMedicineClassName() {
        return medicineClassName;
    }

    public void setMedicineClassName(String name) {
        this.medicineClassName = name;
    }

}
