package services;

import entities.CourseRecord;
import entities.Enrollment;
import entities.Student;
import interfaces.Manageable;
import interfaces.Searchable;

public class EnrollmentService implements Manageable, Searchable {

    private Enrollment[] enrollments = new Enrollment[50];
    private int count = 0;

    // --- Manageable Implementation ---
    @Override
    public boolean add(Object item) {
        if (item instanceof Enrollment && count < enrollments.length) {
            enrollments[count++] = (Enrollment) item;
            return true;
        }
        return false;
    }

    @Override
    public boolean removeById(String id) {
        for (int i = 0; i < count; i++) {
            if (enrollments[i].getEnrollmentId() != null && enrollments[i].getEnrollmentId().equals(id)) {
                enrollments[i] = enrollments[--count];
                enrollments[count] = null;
                return true;
            }
        }
        return false;
    }

    @Override
    public Object[] getAll() {
        Enrollment[] result = new Enrollment[count];
        for (int i = 0; i < count; i++) {
            result[i] = enrollments[i];
        }
        return result;
    }

    // --- Searchable Implementation ---
    @Override
    public Object[] search(String keyword) {
        Enrollment[] temp = new Enrollment[count];
        int matches = 0;
        for (int i = 0; i < count; i++) {
            if (enrollments[i].getStatus() != null && enrollments[i].getStatus().toLowerCase().contains(keyword.toLowerCase())) {
                temp[matches++] = enrollments[i];
            }
        }
        Enrollment[] result = new Enrollment[matches];
        for (int i = 0; i < matches; i++) {
            result[i] = temp[i];
        }
        return result;
    }

    @Override
    public Object searchById(String id) {
        for (int i = 0; i < count; i++) {
            if (enrollments[i].getEnrollmentId() != null && enrollments[i].getEnrollmentId().equals(id)) {
                return enrollments[i];
            }
        }
        return null;
    }


    // 1. IDs + date
    public boolean enroll(String studentId, String courseId, String enrollDate) {
        String id = "ENR" + (count + 1);
        Enrollment e = new Enrollment(id, studentId, courseId, enrollDate, "Active", "Standard", false);
        return add(e);
    }

    // 2. IDs + date + term
    public boolean enroll(String studentId, String courseId, String enrollDate, String term) {
        String id = "ENR" + (count + 1);
        Enrollment e = new Enrollment(id, studentId, courseId, enrollDate, "Active", "Term: " + term, false);
        return add(e);
    }

    // 3. Full objects + reason
    public boolean enroll(Student student, CourseRecord course, String reason) {
        if (student != null && course != null) {
            String id = "ENR" + (count + 1);
            Enrollment e = new Enrollment(id, student.getStudentId(), course.getRecordId(), "08-Aug-26", "Active", reason, false);
            return add(e);
        }
        return false;
    }

    public boolean cancel(String id) {
        Enrollment e = (Enrollment) searchById(id);
        if (e != null) {
            e.cancel();
            return true;
        }
        return false;
    }

    public boolean complete(String id) {
        Enrollment e = (Enrollment) searchById(id);
        if (e != null) {
            e.complete();
            return true;
        }
        return false;
    }

    public boolean transfer(String id, String newCourseId, String newDate) {
        Enrollment e = (Enrollment) searchById(id);
        if (e != null) {
            e.transfer(newCourseId, newDate);
            return true;
        }
        return false;
    }

    public Enrollment[] listByStatus(String status) {
        Enrollment[] temp = new Enrollment[count];
        int matches = 0;
        for (int i = 0; i < count; i++) {
            if (enrollments[i].getStatus() != null && enrollments[i].getStatus().equalsIgnoreCase(status)) {
                temp[matches++] = enrollments[i];
            }
        }
        Enrollment[] result = new Enrollment[matches];
        for (int i = 0; i < matches; i++) {
            result[i] = temp[i];
        }
        return result;
    }

    public Enrollment[] listByStudent(String studentId) {
        Enrollment[] temp = new Enrollment[count];
        int matches = 0;
        for (int i = 0; i < count; i++) {
            if (enrollments[i].getStudentId() != null && enrollments[i].getStudentId().equalsIgnoreCase(studentId)) {
                temp[matches++] = enrollments[i];
            }
        }
        Enrollment[] result = new Enrollment[matches];
        for (int i = 0; i < matches; i++) {
            result[i] = temp[i];
        }
        return result;
    }
}