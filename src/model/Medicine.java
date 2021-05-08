package model;

public class Medicine {

    private String descriptionProduct;
    private MedicineClass medicineClass;
    private String presentation;
    private Species species;

    public Medicine(String descriptionProduct, MedicineClass medicineClass, String presentation, Species species) {
        this.descriptionProduct = descriptionProduct;
        this.medicineClass = medicineClass;
        this.presentation = presentation;
        this.species = species;
    }

    public Medicine() {
    }

    public String getDescriptionProduct() {
        return descriptionProduct;
    }

    public void setDescriptionProduct(String descriptionProduct) {
        this.descriptionProduct = descriptionProduct;
    }

    public MedicineClass getMedicineClass() {
        return medicineClass;
    }

    public void setMedicineClass(MedicineClass medicineClass) {
        this.medicineClass = medicineClass;
    }

    public String getPresentation() {
        return presentation;
    }

    public void setPresentation(String presentation) {
        this.presentation = presentation;
    }

    public Species getSpecies() {
        return species;
    }

    public void setSpecies(Species species) {
        this.species = species;
    }
}
