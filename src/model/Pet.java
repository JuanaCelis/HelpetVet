package model;

public class Pet {

    public static final int NUMBER_INITIAL_PETS_ID = 1;

    private int id;
    private String name;
    private Size size;
    private Gender gender;
    private int age;

    public Pet(String name, Size size, Gender gender, int age) {
        this.name = name;
        this.size = size;
        this.gender = gender;
        this.age = age;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Size getSize() {
        return size;
    }

    public void setSize(Size size) {
        this.size = size;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
