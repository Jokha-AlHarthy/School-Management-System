package entities;

public class Student extends Person{
    //Attributes
    private String gradeLevel;
    private String enrollmentDate;
    private String [] enrolledSubjects;
    private String [] pastCourseRecord;
    private String studentId;
    private double feeBalance;
    private boolean isScholarship;
    private int subjectCount= 0;

    public Student(String personId, String firstName, String lastName, String dateOfBirth, String gender, int phoneNumber, String email, String address, int nationalId, int age, String activeStatus) {
        super(personId, firstName, lastName, dateOfBirth, gender, phoneNumber, email, address, nationalId, age, activeStatus);
        this.gradeLevel = gradeLevel;
        this.enrollmentDate = enrollmentDate;
        this.enrolledSubjects = new String [10];
        this.pastCourseRecord = new String [10];
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

    //addSubject(...) and hasSubject(...) — add one, check if present
    public void addSubject(String subject) {
        if(subjectCount < enrolledSubjects.length){
            enrolledSubjects[subjectCount] = subject;
            subjectCount++;
        }
    }

    public boolean hasSubject(String subject) {
        for (int i = 0; i < subjectCount; i++) {
            if (enrolledSubjects[i].equalsIgnoreCase(subject)) {
                return true;
            }
        }
        return false;
    }

    //listSubjects() — prints all subjects
    public void listSubjects() {
        for (int i = 0; i < subjectCount; i++) {
            System.out.println("- " + enrolledSubjects[i]);
        }
    }

}
