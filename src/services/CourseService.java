package services;

import entities.CourseRecord;
import interfaces.Manageable;
import interfaces.Searchable;

public class CourseService implements Manageable, Searchable {

    private CourseRecord[] records = new CourseRecord[100];
    private int count = 0;

    // --- Manageable Implementation ---
    @Override
    public boolean add(Object entity) {
        if (entity instanceof CourseRecord && count < records.length) {
            records[count++] = (CourseRecord) entity;
            return true;
        }
        return false;
    }

    @Override
    public boolean removeById(String id) {
        for (int i = 0; i < count; i++) {
            if (records[i].getRecordId() != null && records[i].getRecordId().equals(id)) {
                records[i] = records[--count];
                records[count] = null;
                return true;
            }
        }
        return false;
    }

    @Override
    public Object[] getAll() {
        CourseRecord[] result = new CourseRecord[count];
        for (int i = 0; i < count; i++) {
            result[i] = records[i];
        }
        return result;
    }

    // --- Searchable Implementation ---
    @Override
    public Object[] search(String keyword) {
        CourseRecord[] temp = new CourseRecord[count];
        int matches = 0;
        for (int i = 0; i < count; i++) {
            if (records[i].getRemarks() != null && records[i].getRemarks().toLowerCase().contains(keyword.toLowerCase())) {
                temp[matches++] = records[i];
            }
        }
        CourseRecord[] result = new CourseRecord[matches];
        for (int i = 0; i < matches; i++) {
            result[i] = temp[i];
        }
        return result;
    }

    @Override
    public Object searchById(String id) {
        for (int i = 0; i < count; i++) {
            if (records[i].getRecordId() != null && records[i].getRecordId().equals(id)) {
                return records[i];
            }
        }
        return null;
    }

    public CourseRecord[] listByTerm(String term) {
        CourseRecord[] temp = new CourseRecord[count];
        int matches = 0;
        for (int i = 0; i < count; i++) {
            if (records[i].getTerm() != null && records[i].getTerm().equalsIgnoreCase(term)) {
                temp[matches++] = records[i];
            }
        }
        CourseRecord[] result = new CourseRecord[matches];
        for (int i = 0; i < matches; i++) {
            result[i] = temp[i];
        }
        return result;
    }

    public int countFinalized() {
        int finalizedCount = 0;
        for (int i = 0; i < count; i++) {
            if (records[i].isFinalized()) {
                finalizedCount++;
            }
        }
        return finalizedCount;
    }
}