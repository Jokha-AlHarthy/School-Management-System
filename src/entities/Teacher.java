package entities;

import java.util.Arrays;

public class Teacher extends Person{
    //Attributes
    private String subject;
    private int experienceYears;
    private double salary;
    private String[] timeSlots;
    private String[]classId;
    private boolean isFormTeacher;

    //constructor calling super(...) first
    public Teacher(String personId, String firstName, String lastName, String dateOfBirth, String gender, int phoneNumber, String email, String address, int nationalId, int age, String activeStatus) {
        super(personId, firstName, lastName, dateOfBirth, gender, phoneNumber, email, address, nationalId, age, activeStatus);
    }

    //@Override displayInfo()
    @Override
    public void displayInfo() {
        System.out.println("Teacher{" +
                "subject='" + subject + '\'' +
                ", experienceYears=" + experienceYears +
                ", salary=" + salary +
                ", timeSlots=" + Arrays.toString(timeSlots) +
                ", classId=" + Arrays.toString(classId) +
                ", isFormTeacher=" + isFormTeacher +
                '}');
    }
}
