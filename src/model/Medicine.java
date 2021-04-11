package model;

public class Medicine {

    private String name;
    private double price;
    private double amount;
    private CategoryMedicine categoryMedicine;

    public Medicine(String name, double price, double amout, CategoryMedicine categoryMedicine) {
        this.name = name;
        this.price = price;
        this.amount = amout;
        this.categoryMedicine = categoryMedicine;
    }

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

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public CategoryMedicine getCategoryMedicine() {
        return categoryMedicine;
    }

    public void setCategoryMedicine(CategoryMedicine categoryMedicine) {
        this.categoryMedicine = categoryMedicine;
    }
}
