package entities;

import java.util.ArrayList;
import java.util.List;

public class Student extends Person{
    //Attributes
    private String gradeLevel;
    private String enrollmentDate;
    private List<String> enrolledSubjects;
    private List<String> pastCourseRecord;
    private String studentId;
    private double feeBalance;
    private boolean isScholarship;

    public Student(String personId, String firstName, String lastName, String dateOfBirth, String gender, int phoneNumber, String email, String address, int nationalId, int age, String activeStatus) {
        super(personId, firstName, lastName, dateOfBirth, gender, phoneNumber, email, address, nationalId, age, activeStatus);
        this.gradeLevel = gradeLevel;
        this.enrollmentDate = enrollmentDate;
        this.enrolledSubjects = new ArrayList<>();
        this.pastCourseRecord = new ArrayList<>();
        this.studentId = studentId;
        this.feeBalance = feeBalance;
        this.isScholarship = isScholarship;
    }

    //@Override displayInfo() adding the student details
    @Override
    public void displayInfo() {
        System.out.println("Student{" +
                "gradeLevel='" + gradeLevel + '\'' +
                ", enrollmentDate='" + enrollmentDate + '\'' +
                ", enrolledSubjects=" + enrolledSubjects +
                ", pastCourseRecord=" + pastCourseRecord +
                ", studentId='" + studentId + '\'' +
                ", feeBalance=" + feeBalance +
                ", isScholarship=" + isScholarship +
                '}');
    }

}
