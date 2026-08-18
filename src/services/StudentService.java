package services;

import entities.Student;
import interfaces.Manageable;
import interfaces.Searchable;

public class StudentService implements Manageable, Searchable {

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
