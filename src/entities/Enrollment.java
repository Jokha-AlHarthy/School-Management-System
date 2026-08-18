package entities;

public class Enrollment {
    //Attributes
    private String enrollmentId;
    private String studentId;
    private String courseId;
    private String enrollDate;
    private String status;
    private String reason;
    private boolean isRepeat;

    //full constructor
    public Enrollment(String enrollmentId, String studentId, String courseId, String enrollDate, String status, String reason, boolean isRepeat) {
        this.enrollmentId = enrollmentId;
        this.studentId = studentId;
        this.courseId = courseId;
        this.enrollDate = enrollDate;
        this.status = status;
        this.reason = reason;
        this.isRepeat = isRepeat;
    }

    //getters and setters
    public String getEnrollmentId() {
        return enrollmentId;
    }

    public void setEnrollmentId(String enrollmentId) {
        this.enrollmentId = enrollmentId;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public String getCourseId() {
        return courseId;
    }

    public void setCourseId(String courseId) {
        this.courseId = courseId;
    }

    public String getEnrollDate() {
        return enrollDate;
    }

    public void setEnrollDate(String enrollDate) {
        this.enrollDate = enrollDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public boolean isRepeat() {
        return isRepeat;
    }

    public void setRepeat(boolean repeat) {
        isRepeat = repeat;
    }

    //displayInfo()
    public void displayInfo(){
        System.out.println("Enrollment{" +
                "enrollmentId='" + enrollmentId + '\'' +
                ", studentId='" + studentId + '\'' +
                ", courseId='" + courseId + '\'' +
                ", enrollDate='" + enrollDate + '\'' +
                ", status='" + status + '\'' +
                ", reason='" + reason + '\'' +
                ", isRepeat=" + isRepeat +
                '}');
    }
}
