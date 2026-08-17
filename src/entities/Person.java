package entities;

public class Person {
    //Attributes
    private String personId;
    private String firstName;
    private String lastName;
    private String dateOfBirth;
    private String gender;
    private int phoneNumber;
    private String email;
    private String address;
    private int nationalId;
    private int age;
    private String  activeStatus;

    //Full constructor covering all attributes
    public Person(String personId, String firstName, String lastName, String dateOfBirth, String gender, int phoneNumber, String email, String address, int nationalId, int age, String activeStatus) {
        this.personId = personId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
        this.gender = gender;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.address = address;
        this.nationalId = nationalId;
        this.age = age;
        this.activeStatus = activeStatus;
    }

    //Second constructor covering only id + first + last name
    public Person(String personId, String firstName, String lastName) {
        this.personId = personId;
        this.firstName = firstName;
        this.lastName = lastName;
    }
}
