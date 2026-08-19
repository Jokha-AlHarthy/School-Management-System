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
        seedData();
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
                    handleReports();
                    break;
                case 6:
                    System.out.println("Exiting system. Goodbye!");
                    running = false;
                    break;
            }
        }
    }

    private void seedData() {
        // 1. Seed 6 Students (Mix of Student & SeniorStudent)
        Student s1 = new Student("ST101", "Alice", "Smith", "2002-05-12", "Female", "91234567", "alice@school.com", "Main St", 1001, 20, "Active");
        Student s2 = new Student("ST102", "Bob", "Jones", "2001-08-22", "Male", "91234568", "bob@school.com", "High St", 1002, 21, "Active");
        Student s3 = new Student("ST103", "Charlie", "Brown", "2003-01-15", "Male", "91234569", "charlie@school.com", "Park Ave", 1003, 19, "Active");

        SeniorStudent s4 = new SeniorStudent("ST104", "Diana", "Prince", "1999-11-03", "Female", "91234570", "diana@school.com", "Oak St", 1004, 23, "Active");
        SeniorStudent s5 = new SeniorStudent("ST105", "Evan", "Wright", "2000-04-18", "Male", "91234571", "evan@school.com", "Pine St", 1005, 22, "Active");
        SeniorStudent s6 = new SeniorStudent("ST106", "Fiona", "Gallagher", "1998-09-30", "Female", "91234572", "fiona@school.com", "Elm St", 1006, 24, "Active");

        // Set SeniorStudent attributes
        s4.setMajor("Computer Science");
        s5.setMajor("Data Science");
        s6.setMajor("Software Eng");

        // Set fee balances to test totalOutstanding()
        s1.setFeeBalance(150.0);
        s2.setFeeBalance(300.0);
        s4.setFeeBalance(500.0);

        // Add students
        studentService.addStudent(s1);
        studentService.addStudent(s2);
        studentService.addStudent(s3);
        studentService.addStudent(s4);
        studentService.addStudent(s5);
        studentService.addStudent(s6);

        // 2. Seed Teachers & Head Teachers
        Teacher t1 = new Teacher("T201", "John", "Doe", "1980-03-14", "Male", "98765432", "john@school.com", "Broadway", 2001, 44, "Active");
        Teacher t2 = new Teacher("T202", "Sarah", "Connor", "1985-07-19", "Female", "98765433", "sarah@school.com", "Main Rd", 2002, 39, "Active");
        t1.setSubject("Mathematics");
        t1.setSalary(5000.0);
        t2.setSubject("Physics");
        t2.setSalary(5200.0);

        HeadTeacher ht1 = new HeadTeacher("HT203", "Michael", "Scott", "1975-01-15", "Male", "98765434", "michael@school.com", "Dunder St", 2003, 49, "Active");
        HeadTeacher ht2 = new HeadTeacher("HT204", "Elena", "Rostova", "1978-10-05", "Female", "98765435", "elena@school.com", "Center Ave", 2004, 46, "Active");
        ht1.setSubject("Administration");
        ht1.setSalary(7500.0);
        ht2.setSubject("Mathematics");
        ht2.setSalary(8000.0);

        teacherService.add(t1);
        teacherService.add(t2);
        teacherService.addHeadTeacher(ht1);
        teacherService.addHeadTeacher(ht2);

        // 3. Seed 5 Course Records (Matches CourseRecord constructor: 9 arguments)
        CourseRecord c1 = new CourseRecord("CR301", "ST101", "T201", "Fall 2026", "A", "Completed", new String[10], true, 0);
        CourseRecord c2 = new CourseRecord("CR302", "ST102", "T201", "Fall 2026", "B+", "Completed", new String[10], true, 0);
        CourseRecord c3 = new CourseRecord("CR303", "ST103", "T202", "Spring 2026", "Pending", "In Progress", new String[10], false, 0);
        CourseRecord c4 = new CourseRecord("CR304", "ST104", "T202", "Spring 2026", "Pending", "In Progress", new String[10], false, 0);
        CourseRecord c5 = new CourseRecord("CR305", "ST105", "T201", "Fall 2026", "A-", "Completed", new String[10], true, 0);

        courseService.add(c1);
        courseService.add(c2);
        courseService.add(c3);
        courseService.add(c4);
        courseService.add(c5);

        // 4. Seed 6 Enrollments (Exercising all 3 overloaded enroll methods)
        // Overload 1: IDs + date
        enrollmentService.enroll("ST101", "CR301", "2026-08-01");
        enrollmentService.enroll("ST102", "CR302", "2026-08-02");

        // Overload 2: IDs + date + term
        enrollmentService.enroll("ST103", "CR303", "2026-08-03", "Fall 2026");
        enrollmentService.enroll("ST104", "CR304", "2026-08-04", "Spring 2026");

        // Overload 3: Full objects + reason
        enrollmentService.enroll(s5, c5, "Prerequisite satisfied");
        enrollmentService.enroll(s6, c1, "Core elective requirement");

        System.out.println("Sample data successfully seeded into system.");
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

    private void handleReports() {
        System.out.println("\n--- Polymorphic Reports ---");
        Object[] studentObjs = studentService.getAll();
        Object[] teacherObjs = teacherService.getAll();

        Person[] allPeople = new Person[studentObjs.length + teacherObjs.length];
        int count = 0;

        for (Object s : studentObjs) allPeople[count++] = (Person) s;
        for (Object t : teacherObjs) allPeople[count++] = (Person) t;

        System.out.println("\n1. All People Overview:");
        printAll(allPeople, count);

        System.out.println("\n2. Breakdown by Type:");
        countByType(allPeople, count);

        Person oldest = findOldest(allPeople, count);
        if (oldest != null) {
            System.out.println("\n3. Oldest Person in System:");
            oldest.displayInfo();
        }

        System.out.println("\n4. Financial Summary:");
        System.out.println("Total Outstanding Fees: $" + studentService.totalOutstanding());
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
