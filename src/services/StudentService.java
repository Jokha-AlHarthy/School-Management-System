package services;

import entities.Student;

public class StudentService {

    // three versions basic details
    public void addStudent(String id, String firstName, String lastName){
        //create student and store it
    }

    //three versions  details + grade level
    public void addStudent(String id, String firstName, String lastName, String gradeLevel){
        //create student with grade level
    }

    //three versions  details +  an existing Student
    public void addStudent(Student student){
        //storing an existing Student
    }
}
