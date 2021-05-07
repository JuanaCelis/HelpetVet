package model;

public class Pet {

    public static final int NUMBER_INITIAL_PETS_ID = 1;

    private int id;
    private String name;
    private Size size;
    private Gender gender;
    private int age;
    private int ownerId;
    private String ownerName;
    private String numberContact;

    public Pet(String name, Size size, Gender gender, int age, int ownerId, String ownerName, String numberContact) {
        this.name = name;
        this.size = size;
        this.gender = gender;
        this.age = age;
        this.ownerId = ownerId;
        this.ownerName = ownerName;
        this.numberContact = numberContact;
    }


    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Size getSize() {
        return size;
    }

    public int getOwnerId() {
        return ownerId;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public Gender getGender() {
        return gender;
    }

    public int getAge() {
        return age;
    }

    public String getNumberContact() {
        return numberContact;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setOwnerId(int ownerId) {
        this.ownerId = ownerId;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    public void setSize(Size size) {
        this.size = size;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setNumberContact(String numberContact) {
        this.numberContact = numberContact;
    }

    public Object[] toObjectVector() {
        return new Object[]{getOwnerId(),getOwnerName(),getName(),getAge(),getSize()};
    }
}
