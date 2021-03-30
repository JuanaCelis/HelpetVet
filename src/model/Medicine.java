package model;

public class Medicine {

    private String name;
    private double price;
    private double amout;
    private CategoryMedicine categoryMedicine;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getAmout() {
        return amout;
    }

    public void setAmout(double amout) {
        this.amout = amout;
    }

    public CategoryMedicine getCategoryMedicine() {
        return categoryMedicine;
    }

    public void setCategoryMedicine(CategoryMedicine categoryMedicine) {
        this.categoryMedicine = categoryMedicine;
    }
}
