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

    //Getters & Setters
    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        if(major==null || major.trim().isEmpty()){
            System.out.println("Major can't be empty");
        }else{
            this.major = major;
        }
    }

    public double getGpa() {
        return gpa;
    }

    public void setGpa(double gpa) {
        if(gpa>=0.0 || gpa<=4.0){
            System.out.println("The gpa should be around the range");
        }
        this.gpa = gpa;
    }

    public String getGraduationDate() {
        return graduationDate;
    }

    public void setGraduationDate(String graduationDate) {
        if(graduationDate==null || graduationDate.trim().isEmpty()){
            System.out.println("The graduation date can't be empty");
        }
        this.graduationDate = graduationDate;
    }

    public int getCreditsEarned() {
        return creditsEarned;
    }

    public void setCreditsEarned(int creditsEarned) {
        if(creditsEarned<0){
            System.out.println("The credit can't be less than 0");
        }
        this.creditsEarned = creditsEarned;
    }

    //@Override displayInfo()
    @Override
    public void displayInfo() {
        System.out.println("SeniorStudent{" +
                "major='" + major + '\'' +
                ", gpa=" + gpa +
                ", graduationDate='" + graduationDate + '\'' +
                ", creditsEarned=" + creditsEarned +
                '}');
    }

    //promote(...)
    public void promote(String newGradeLevel, int addtionalCredites){
        if(addtionalCredites > 0){
            this.creditsEarned += addtionalCredites;
        }
        setGradeLevel(newGradeLevel);
        System.out.println("Student has promoted to new grade level: "+newGradeLevel);
    }


    //graduate()
    public void graduate(){
        setActiveStatus("Inactive");
        System.out.println("The student has officially graduate");
    }

    //totalCredits()
    public int totalCredits(){
        return creditsEarned;
    }
}
