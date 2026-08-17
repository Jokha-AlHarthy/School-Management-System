package entities;

import java.util.Arrays;

public class Teacher extends Person{
    //Attributes
    private String subject;
    private int experienceYears;
    private double salary;
    private String[] timeSlots;
    private String[]classId;
    private boolean isFormTeacher;
    private int slotCount;

    //constructor calling super(...) first
    public Teacher(String personId, String firstName, String lastName, String dateOfBirth, String gender, int phoneNumber, String email, String address, int nationalId, int age, String activeStatus) {
        super(personId, firstName, lastName, dateOfBirth, gender, phoneNumber, email, address, nationalId, age, activeStatus);
    }

    //@Override displayInfo()
    @Override
    public void displayInfo() {
        System.out.println("Teacher{" +
                "subject='" + subject + '\'' +
                ", experienceYears=" + experienceYears +
                ", salary=" + salary +
                ", timeSlots=" + Arrays.toString(timeSlots) +
                ", classId=" + Arrays.toString(classId) +
                ", isFormTeacher=" + isFormTeacher +
                '}');
    }

    //addSlot(...) and removeSlot(...)
    public void addSlot(String slot){
        if(slot != null && slotCount<timeSlots.length){
            timeSlots[slotCount] = slot;
            slotCount++;
        };
    }

    public void removeSlot(String slot){
        if(slot==null){
            return;
        }
        for(int i=0; i<slotCount; i++){
            if(timeSlots[i].equalsIgnoreCase(slot)){
                for(int j = i; j<slotCount-1; j++){
                    timeSlots[j] = timeSlots[j+1];
                }
                timeSlots[slotCount - 1] = null;
                slotCount--;
                return;
            }
        }
    }

    //hasSlot(...) — is a given slot free/listed
    public boolean hasSlot(String slot){
        if(slot==null){
            return false;
        }
        for(int i=0; i < slotCount; i++){
            if(timeSlots[i].equalsIgnoreCase(slot)){
                return true;
            }
        }
        return false;
    }

}
