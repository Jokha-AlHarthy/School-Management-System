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
    private String notes;

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
        if(enrollmentId==null || enrollmentId.trim().isEmpty()){
            System.out.println("The enrollment Id can't be empty..");
        }else{
            this.enrollmentId = enrollmentId;
        }
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        if(studentId==null || studentId.trim().isEmpty()){
            System.out.println("The student Id can't be empty");
        }else{
            this.studentId = studentId;
        }
    }

    public String getCourseId() {
        return courseId;
    }

    public void setCourseId(String courseId) {
        if(courseId == null || courseId.trim().isEmpty()){
            System.out.println("The course Id can't be empty");
        }else{
            this.courseId = courseId;
        }
    }

    public String getEnrollDate() {
        return enrollDate;
    }

    public void setEnrollDate(String enrollDate) {
        if(enrollDate==null || enrollDate.trim().isEmpty()){
            System.out.println("The enrolled date can't be empty");
        }else{
            this.enrollDate = enrollDate;
        }
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        if(status==null || status.trim().isEmpty()){
            System.out.println("The status can't be empty..");
        }

        if(!status.equalsIgnoreCase("Cancelled") && !status.equalsIgnoreCase("Completed") && !status.equalsIgnoreCase("Transfered") && !status.equalsIgnoreCase("Active")){
            System.out.println("Please only enter one word.. Active | Cancelled | Completed | Transfered");
        }
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

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
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

    //cancel(), complete() — each changes status
    public void cancel(){
        System.out.println("Cancelled");
    }

    public void complete(){
        System.out.println("Completed");
    }

    //transfer(...)
    public void transfer(String newCourseId, String newEnrolledDate){
        this.courseId = newCourseId;
        this.enrollDate = newEnrolledDate;
        this.status = "Transfered";
    }

    //isPast(...)
    public boolean isPast(String givenDate){
        if(enrollDate == null || givenDate == null){
            return false;
        }
        return enrollDate.compareTo(givenDate) < 0;
    }

    //addNotes - notes only
    public void addNotes(String note){
        if(note != null && note.trim().isEmpty()){
            if(!this.notes.isEmpty()){
                this.notes+= " | ";
            }
            this.notes += note;
        }
    }

    //addNotes - notes +  notes with author
    public void addNotes(String note, String notesAuthor){
        if(note != null && note.trim().isEmpty()){
            if(!this.notes.isEmpty()){
                this.notes+= " | ";
            }
            this.notes += note + "By author"+notesAuthor;
        }
    }


}
