package services;

import entities.Teacher;
import entities.HeadTeacher;
import interfaces.Manageable;
import interfaces.Searchable;

public class TeacherService implements Manageable, Searchable {

    private Teacher[] teachers = new Teacher[100];
    private int count = 0;

    // --- Manageable Implementation ---

    @Override
    public boolean add(Object entity) {
        if (entity instanceof Teacher && count < teachers.length) {
            teachers[count++] = (Teacher) entity;
            return true;
        }
        return false;
    }

    @Override
    public boolean removeById(String id) {
        for (int i = 0; i < count; i++) {
            if (teachers[i].getClassId() != null && teachers[i].getClassId().equals(id)) {
                teachers[i] = teachers[--count];
                teachers[count] = null;
                return true;
            }
        }
        return false;
    }

    @Override
    public Object[] getAll() {
        Teacher[] result = new Teacher[count];
        for (int i = 0; i < count; i++) {
            result[i] = teachers[i];
        }
        return result;
    }

    // --- Searchable Implementation ---
    @Override
    public Object[] search(String keyword) {
        Teacher[] temp = new Teacher[count];
        int matches = 0;
        for (int i = 0; i < count; i++) {
            String fullName = teachers[i].getFirstName() + " " + teachers[i].getLastName();
            if (fullName.toLowerCase().contains(keyword.toLowerCase())) {
                temp[matches++] = teachers[i];
            }
        }
        Teacher[] result = new Teacher[matches];
        for (int i = 0; i < matches; i++) {
            result[i] = temp[i];
        }
        return result;
    }

    @Override
    public Object searchById(String id) {
        for (int i = 0; i < count; i++) {
            if (teachers[i].getClassId() != null && teachers[i].getClassId().equals(id)) {
                return teachers[i];
            }
        }
        return null;
    }

    public boolean addHeadTeacher(HeadTeacher headTeacher) {
        return add(headTeacher);
    }

    public boolean assignClass(String teacherId, String classId) {
        Teacher t = (Teacher) searchById(teacherId);
        if (t != null) {
            t.assignClass(classId);
            return true;
        }
        return false;
    }

    public Teacher[] listBySubject(String subject) {
        Teacher[] temp = new Teacher[count];
        int matches = 0;
        for (int i = 0; i < count; i++) {
            if (teachers[i].getSubject() != null && teachers[i].getSubject().equalsIgnoreCase(subject)) {
                temp[matches++] = teachers[i];
            }
        }
        Teacher[] result = new Teacher[matches];
        for (int i = 0; i < matches; i++) {
            result[i] = temp[i];
        }
        return result;
    }

    public Teacher[] availableTeachers() {
        Teacher[] temp = new Teacher[count];
        int matches = 0;
        for (int i = 0; i < count; i++) {
            if (teachers[i].getClassLoad() < 5) {
                temp[matches++] = teachers[i];
            }
        }
        Teacher[] result = new Teacher[matches];
        for (int i = 0; i < matches; i++) {
            result[i] = temp[i];
        }
        return result;
    }
}