package services;

import entities.CourseRecord;
import entities.Enrollment;
import entities.Student;
import interfaces.Manageable;
import interfaces.Searchable;

public class EnrollmentService implements Manageable, Searchable {
    private Enrollment[] enorllments =  new Enrollment[50];
    private int count = 0;


    //ids + date
    public void enroll(String studentId, String courseId, String enrollDate){
        if(count < enorllments.length){
            String id = "ENR"+(count + 1);
            enorllments[count] =  new Enrollment(id, studentId, courseId, enrollDate, "Active", "Standard", false);
            count++;
        }
    }

    // ids + date + term
    public void enroll(String studentId, String courseId, String enrollDate, String term){
        if(count < enorllments.length){
            String id = "ENR"+(count + 1);
            enorllments[count] =  new Enrollment(id, studentId, courseId, enrollDate, "Active", "Term: "+term, false);
            count++;
        }
    }

    //full objects + reason
    public void enroll(Student student, CourseRecord course, String reason){
        if(student != null && course != null && count < enorllments.length){
            String id = "ENR"+(count + 1);
            enorllments[count] =  new Enrollment(id, student.getStudentId(), course.getRecordId(), "08-Aug-26", "Active", reason, false);
            count++;
        }
    }
}
