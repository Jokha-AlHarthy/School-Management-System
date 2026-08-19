package main;

import entities.*;
import services.CourseService;
import services.EnrollmentService;
import services.StudentService;
import services.TeacherService;
import utils.InputHandler;

public class SchoolApp {
    private final StudentService studentService = new StudentService();
    private final TeacherService teacherService = new TeacherService();
    private final CourseService courseService = new CourseService();
    private final EnrollmentService enrollmentService = new EnrollmentService();

    public static void main(String[] args) {
        SchoolApp app = new SchoolApp();
        app.start();
    }

    public void start() {
        boolean running = true;
        while (running) {
            displayMainMenu();
            int choice = InputHandler.readInt("Enter your choice (1-6): ", 1, 6);

            switch (choice) {
                case 1:

                    break;
                case 2:
                    break;
                case 3:

                    break;
                case 4:
                    break;
                case 5:
                    break;
                case 6:
                    System.out.println("Exiting system. Goodbye!");
                    running = false;
                    break;
            }
        }
    }

    private void displayMainMenu() {
        System.out.println("School Management System");
        System.out.println("1. Students");
        System.out.println("2. Teachers");
        System.out.println("3. Courses");
        System.out.println("4. Enrollments");
        System.out.println("5. Reports");
        System.out.println("6. Exit");
    }

    //printAll(...) — loop once, call displayInfo() on each Person
    public static void printAll(Person[] people, int count){
        for(int i= 0; i < count; i++){
            people[i].displayInfo();
        }
    }

    //countByType(...) — count how many are Student, Teacher (use instanceof, most specific first
    public static void countByType(Person []people, int count){
        int studentCount = 0;
        int teacherCount = 0;
        int seniorStudentCount = 0;
        int headTeacherCount = 0;

        for(int i=0; i < count; i++){
            Person p = people[i];
            if(p instanceof HeadTeacher){
                headTeacherCount++;
            }else if(p instanceof Teacher){
                teacherCount++;
            }else if(p instanceof SeniorStudent){
                seniorStudentCount++;
            }else if(p instanceof Student){
                studentCount++;
            }
        }
        System.out.println("Head Teacher: "+headTeacherCount);
        System.out.println("Teachers: "+teacherCount);
        System.out.println("Senior Student: "+seniorStudentCount);
        System.out.println("Students: "+studentCount);
    }

    //findOldest(...)
    public static Person findOldest(Person[]people, int count){
        if(people==null || count ==0){
            return null;
        }
        Person oldest = people[0];
        for(int i=1; i < count; i++){
            if(people[i].getAge()>oldest.getAge()){
                oldest = people[i];
            }

        }
        return oldest;
    }


}
