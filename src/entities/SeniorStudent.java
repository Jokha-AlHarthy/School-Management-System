package entities;

public class SeniorStudent extends Student{
    //Attributes
    private String major;
    private double gpa;
    private String graduationDate;
    private int creditsEarned;

    //constructor calling super(...)
    public SeniorStudent(String personId, String firstName, String lastName, String dateOfBirth, String gender, int phoneNumber, String email, String address, int nationalId, int age, String activeStatus) {
        super(personId, firstName, lastName, dateOfBirth, gender, phoneNumber, email, address, nationalId, age, activeStatus);
        this.major = major;
        this.gpa = gpa;
        this.graduationDate = graduationDate;
        this.creditsEarned = creditsEarned;
    }

    

}
