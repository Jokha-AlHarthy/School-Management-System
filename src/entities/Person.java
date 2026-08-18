package entities;

import interfaces.Displayable;

public class Person implements Displayable {
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

    //Getters and setters for every attribute
    public String getPersonId() {
        return personId;
    }

    public void setPersonId(String personId) {
        if(personId==null || personId.trim().isEmpty()){
            System.out.println("Please enter the id..");
        }else{
            this.personId = personId;
        }
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        if(firstName==null || firstName.trim().isEmpty()){
            System.out.println("Please enter your first name..");
        }else{
            this.firstName = firstName;
        }
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        if(lastName==null || lastName.trim().isEmpty()){
            System.out.println("Please enter your last name..");
        }else{
            this.lastName = lastName;
        }
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getNationalId() {
        return nationalId;
    }

    public void setNationalId(int nationalId) {
        this.nationalId = nationalId;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        if(age >= 0 && age<=120){
            System.out.println("The should be around 0 up to 120");
        }else{
            this.age = age;
        }
    }

    public String getActiveStatus() {
        return activeStatus;
    }

    public void setActiveStatus(String activeStatus) {
        if(activeStatus == null || activeStatus.trim().isEmpty()){
            System.out.println("The status is not completed..");
        }else{
            this.activeStatus =activeStatus;
        }
    }

    //displayInfo()
    public void displayInfo(){
        System.out.println("Person{" +
                "personId='" + personId + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", dateOfBirth='" + dateOfBirth + '\'' +
                ", gender='" + gender + '\'' +
                ", phoneNumber=" + phoneNumber +
                ", email='" + email + '\'' +
                ", address='" + address + '\'' +
                ", nationalId=" + nationalId +
                ", age=" + age +
                ", activeStatus='" + activeStatus + '\'' +
                '}');
    }

    //displaySummary()
    public void displaySummary(){
        System.out.println("Person Id: "+personId);
        System.out.println("Person full name: "+firstName);
    }

    //getFullName()
    public void getFullName(){
        System.out.println(firstName+" "+lastName);
    }

    //toString()
    @Override
    public String toString() {
        return "Person{" +
                "personId='" + personId + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", dateOfBirth='" + dateOfBirth + '\'' +
                ", gender='" + gender + '\'' +
                ", phoneNumber=" + phoneNumber +
                ", email='" + email + '\'' +
                ", address='" + address + '\'' +
                ", nationalId=" + nationalId +
                ", age=" + age +
                ", activeStatus='" + activeStatus + '\'' +
                '}';
    }

    //equals()
    public void equals(String id){
        if(personId.equals(id)){
            System.out.println("Yes they're equal");
        }
    }

    //isAdult()
    public void isAdult(){
        if(age>= 18){
            System.out.println("The person is Adult");
        }
    }
}
