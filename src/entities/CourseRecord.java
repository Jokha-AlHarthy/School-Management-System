package entities;

import interfaces.Displayable;

public class CourseRecord implements Displayable {
    //Attributes
    private String recordId;
    private String studentId;
    private String teacherId;
    private String term;
    private String grade;
    private String remarks;
    private String [] notes;
    private boolean isFinalized;
    private int notesCount;

    //Full constructor
    public CourseRecord(String recordId, String studentId, String teacherId, String term, String grade, String remarks, String[] notes, boolean isFinalized, int notesCount) {
        this.recordId = recordId;
        this.studentId = studentId;
        this.teacherId = teacherId;
        this.term = term;
        this.grade = grade;
        this.remarks = remarks;
        this.notes = new String[10];
        this.isFinalized = isFinalized;
        this.notesCount = 0;
    }

    //getters and setters
    public String getRecordId() {
        return recordId;
    }

    public void setRecordId(String recordId) {
        if(recordId==null || recordId.trim().isEmpty()){
            System.out.println("The record id can't be empty..");
        }else{
            this.recordId = recordId;
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

    public String getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(String teacherId) {
        if(teacherId==null || teacherId.trim().isEmpty()){
            System.out.println("The teacher Id can't be empty..");
        }else{
            this.teacherId = teacherId;
        }
    }

    public String getTerm() {
        return term;
    }

    public void setTerm(String term) {
        this.term = term;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public String[] getNotes() {
        return notes;
    }

    public void setNotes(String[] notes) {
        this.notes = notes;
    }

    public void setFinalized(boolean finalized) {
        isFinalized = finalized;
    }

    //displayInfo()
    public void displayInfo() {
        System.out.println("CourseRecord{" +
                "recordId='" + recordId + '\'' +
                ", studentId='" + studentId + '\'' +
                ", teacherId='" + teacherId + '\'' +
                ", term='" + term + '\'' +
                ", grade='" + grade + '\'' +
                ", remarks='" + remarks + '\'' +
                ", notes='" + notes + '\'' +
                ", isFinalized=" + isFinalized +
                '}');
    }

    //appendNote(...)
    public void appendNote(String note){
        if(note != null && notesCount < notes.length){
            notes[notesCount] = note;
            notesCount++;
        }
    }

    //finalizeRecord() and isFinalized()
    public void finalizeRecord(){
        this.isFinalized = true;
    }

    public boolean isFinalized(){
       return isFinalized;
    }
}
