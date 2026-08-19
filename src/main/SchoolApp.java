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
                    handleStudents();
                    break;
                case 2:
                    handleTeachers();
                    break;
                case 3:
                    handleCourses();
                    break;
                case 4:
                    handleEnrollments();
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

    private void handleStudents() {
        System.out.println("\n--- Student Management ---");
        System.out.println("1. View All Students");
        System.out.println("2. Add Student");
        System.out.println("3. Search Student");
        System.out.println("4. Remove Student");
        System.out.println("5. Back to Main Menu");

        int choice = InputHandler.readInt("Select an option (1-5): ", 1, 5);
        switch (choice) {
            case 1:
                Object[] students = studentService.getAll();
                for (Object obj : students) {
                    ((Student) obj).displayInfo();
                }
                break;
            case 2:
                String id = InputHandler.readText("Enter Student ID: ");
                String fname = InputHandler.readText("Enter First Name: ");
                String lname = InputHandler.readText("Enter Last Name: ");
                studentService.addStudent(id, fname, lname);
                System.out.println("Student added successfully.");
                break;
            case 3:
                String key = InputHandler.readText("Enter name search keyword: ");
                Object[] matches = studentService.search(key);
                for (Object obj : matches) {
                    ((Student) obj).displayInfo();
                }
                break;
            case 4:
                String remId = InputHandler.readText("Enter Student ID to remove: ");
                if (studentService.removeById(remId)) {
                    System.out.println("Student removed.");
                } else {
                    System.out.println("Student ID not found.");
                }
                break;
            case 5:
                return;
        }
    }

    private void handleTeachers() {
        System.out.println("\n--- Teacher Management ---");
        System.out.println("1. View All Teachers");
        System.out.println("2. Search Teacher");
        System.out.println("3. Back to Main Menu");

        int choice = InputHandler.readInt("Select an option (1-3): ", 1, 3);
        switch (choice) {
            case 1:
                Object[] teachers = teacherService.getAll();
                for (Object obj : teachers) {
                    ((Teacher) obj).displayInfo();
                }
                break;
            case 2:
                String key = InputHandler.readText("Enter teacher search keyword: ");
                Object[] matches = teacherService.search(key);
                for (Object obj : matches) {
                    ((Teacher) obj).displayInfo();
                }
                break;
            case 3:
                return;
        }
    }

    private void handleCourses() {
        System.out.println("\n--- Course Management ---");
        System.out.println("1. View All Courses");
        System.out.println("2. Back to Main Menu");

        int choice = InputHandler.readInt("Select an option (1-2): ", 1, 2);
        if (choice == 1) {
            Object[] courses = courseService.getAll();
            for (Object obj : courses) {
                ((CourseRecord) obj).displayInfo();
            }
        }
    }

    private void handleEnrollments() {
        System.out.println("\n--- Enrollment Management ---");
        System.out.println("1. View All Enrollments");
        System.out.println("2. Back to Main Menu");

        int choice = InputHandler.readInt("Select an option (1-2): ", 1, 2);
        if (choice == 1) {
            Object[] enrollments = enrollmentService.getAll();
            for (Object obj : enrollments) {
                ((Enrollment) obj).displayInfo();
            }
        }
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
