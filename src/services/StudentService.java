package services;

import entities.Student;
import entities.SeniorStudent;
import interfaces.Manageable;
import interfaces.Searchable;

public class StudentService implements Manageable, Searchable {

    private Student[] students = new Student[100];
    private int count = 0;

    // --- Manageable Implementation ---
    @Override
    public boolean add(Object item) {
        if (item instanceof Student && count < students.length) {
            students[count++] = (Student) item;
            return true;
        }
        return false;
    }

    @Override
    public boolean removeById(String id) {
        for (int i = 0; i < count; i++) {
            if (students[i].getStudentId() != null && students[i].getStudentId().equals(id)) {
                students[i] = students[--count];
                students[count] = null;
                return true;
            }
        }
        return false;
    }

    @Override
    public Object[] getAll() {
        Student[] result = new Student[count];
        for (int i = 0; i < count; i++) {
            result[i] = students[i];
        }
        return result;
    }

    // --- Searchable Implementation ---
    @Override
    public Object[] search(String keyword) {
        Student[] temp = new Student[count];
        int matches = 0;
        for (int i = 0; i < count; i++) {
            // Combine first name and last name directly using your getters
            String fullName = students[i].getFirstName() + " " + students[i].getLastName();

            if (fullName.toLowerCase().contains(keyword.toLowerCase())) {
                temp[matches++] = students[i];
            }
        }
        Student[] result = new Student[matches];
        for (int i = 0; i < matches; i++) {
            result[i] = temp[i];
        }
        return result;
    }

    @Override
    public Object searchById(String id) {
        for (int i = 0; i < count; i++) {
            if (students[i].getStudentId() != null && students[i].getStudentId().equals(id)) {
                return students[i];
            }
        }
        return null;
    }

    // --- 3 Overloaded addStudent Methods (Task 2.2 / 2.7) ---

    // 1. Basic details
    public boolean addStudent(String id, String firstName, String lastName) {
        Student s = new Student(id, firstName, lastName, "2000-01-01", "Other",
                0, "unknown@school.test", "unknown", 0, 18, "Active");
        return add(s);
    }

    // 2. Details + grade level
    public boolean addStudent(String id, String firstName, String lastName, String gradeLevel) {
        Student s = new Student(id, firstName, lastName, "2000-01-01", "Other",
                0, "unknown@school.test", "unknown", 0, 18, "Active");
        s.setGradeLevel(gradeLevel);
        return add(s);
    }

    // 3. Existing Student object
    public boolean addStudent(Student student) {
        return add(student);
    }

    // --- Service Specific Methods (Task 2.7) ---

    public boolean updateContact(String id, int phone, String email) {
        Student s = (Student) searchById(id);
        if (s == null) return false;
        s.updateContact(phone, email);
        return true;
    }

    public Student[] listSeniors() {
        Student[] temp = new Student[count];
        int matches = 0;
        for (int i = 0; i < count; i++) {
            if (students[i] instanceof SeniorStudent) {
                temp[matches++] = students[i];
            }
        }
        Student[] result = new Student[matches];
        for (int i = 0; i < matches; i++) {
            result[i] = temp[i];
        }
        return result;
    }

    public double totalOutstanding() {
        double total = 0;
        for (int i = 0; i < count; i++) {
            total += students[i].getFeeBalance();
        }
        return total;
    }
}