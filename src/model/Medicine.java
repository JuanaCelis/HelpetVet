package model;

import java.util.Locale;

public class Medicine {

    private String descriptionProduct;
    private String medicineClass;
    private String presentation;
    private String species;

    public Medicine(String descriptionProduct, String medicineClass, String presentation, String species) {
        this.descriptionProduct = descriptionProduct;
        this.medicineClass = medicineClass;
        this.presentation = presentation;
        this.species = species;
    }

    public String getDescriptionProduct() {
        return descriptionProduct;
    }

    public void setDescriptionProduct(String descriptionProduct) {
        this.descriptionProduct = descriptionProduct;
    }

    public String getMedicineClass() {
        return medicineClass;
    }

    public void setMedicineClass(String medicineClass) {
        this.medicineClass = medicineClass;
    }

    public String getPresentation() {
        return presentation;
    }

    public void setPresentation(String presentation) {
        this.presentation = presentation;
    }

    public String getSpecies() {
        return species;
    }

    public void setSpecies(String species) {
        this.species = species;
    }

    public Object[] toObjectVector() {
        return new Object[] {getDescriptionProduct(),getMedicineClass(),getPresentation(),getSpecies()};
    }

    @Override
    public String toString() {
        return "Medicine{" +
                "nombre='" + descriptionProduct + '\'' +
                ", clase='" + medicineClass + '\'' +
                ", presentacion='" + presentation + '\'' +
                ", especie='" + species + '\'' +
                '}';
    }
}
