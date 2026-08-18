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
    private int recordCount = 0;

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


    //Getters & setters
    public String getGradeLevel() {
        return gradeLevel;
    }

    public void setGradeLevel(String gradeLevel) {
        if(gradeLevel == null || gradeLevel.trim().isEmpty()){
            System.out.println("Grade level can't be empty..");
        }
        this.gradeLevel = gradeLevel;
    }

    public String getEnrollmentDate() {
        return enrollmentDate;
    }

    public void setEnrollmentDate(String enrollmentDate) {
        if(enrollmentDate==null || enrollmentDate.trim().isEmpty()){
            System.out.println("The enrollment can't be empty");
        }
        this.enrollmentDate = enrollmentDate;
    }

    public String[] getEnrolledSubjects() {
        return enrolledSubjects;
    }

    public void setEnrolledSubjects(String[] enrolledSubjects) {
        this.enrolledSubjects = enrolledSubjects;
    }

    public String[] getPastCourseRecord() {
        return pastCourseRecord;
    }

    public void setPastCourseRecord(String[] pastCourseRecord) {
        this.pastCourseRecord = pastCourseRecord;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        if(studentId==null || studentId.trim().isEmpty()){
            System.out.println("The student Id can't be empty..");
        }
        this.studentId = studentId;
    }

    public double getFeeBalance() {
        return feeBalance;
    }

    public void setFeeBalance(double feeBalance) {
        if(feeBalance<0){
            System.out.println("The fee can't be 0");
        }
        this.feeBalance = feeBalance;
    }

    public boolean isScholarship() {
        return isScholarship;
    }

    public void setScholarship(boolean scholarship) {
        isScholarship = scholarship;
    }

    public int getSubjectCount() {
        return subjectCount;
    }

    public void setSubjectCount(int subjectCount) {
        this.subjectCount = subjectCount;
    }

    public void setRecordCount(int recordCount) {
        this.recordCount = recordCount;
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

    //addRecordId(...) and getRecordCount()
    public void addRecordId(String recordId){
        if(recordId != null && recordCount < pastCourseRecord.length){
            pastCourseRecord[recordCount] = recordId;
            recordCount++;
        }
    }

    public int getRecordCount(){
        return recordCount;
    }


    //addToBalance(...) and clearBalance()
    public void addToBalance(double amount){
        if(amount > 0){
            this.feeBalance +=amount;
        }
    }

    public void clearBalance(){
        this.feeBalance = 0.0;
    }
}
