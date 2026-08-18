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
    private int slotCount = 0;
    private int classCount = 0;

    //constructor calling super(...) first
    public Teacher(String personId, String firstName, String lastName, String dateOfBirth, String gender, int phoneNumber, String email, String address, int nationalId, int age, String activeStatus) {
        super(personId, firstName, lastName, dateOfBirth, gender, phoneNumber, email, address, nationalId, age, activeStatus);
        this.subject = subject;
        this.experienceYears = experienceYears;
        this.salary = salary;
        this.timeSlots = new String[10];
        this.classId =  new String[10];
        this.isFormTeacher = isFormTeacher;
    }

    //Getters & setters
    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public int getExperienceYears() {
        return experienceYears;
    }

    public void setExperienceYears(int experienceYears) {
        if(experienceYears < 0){
            System.out.println("The experience can't be below 0");
        }
        this.experienceYears = experienceYears;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        if(salary<0){
            System.out.println("The salary can't be below 0");
        }
        this.salary= salary;
    }

    public String[] getTimeSlots() {
        return timeSlots;
    }

    public void setTimeSlots(String[] timeSlots) {
        this.timeSlots = timeSlots;
    }

    public String[] getClassId() {
        return classId;
    }

    public void setClassId(String[] classId) {
        this.classId = classId;
    }

    public boolean isFormTeacher() {
        return isFormTeacher;
    }

    public void setFormTeacher(boolean formTeacher) {
        isFormTeacher = formTeacher;
    }

    public int getSlotCount() {
        return slotCount;
    }

    public void setSlotCount(int slotCount) {
        this.slotCount = slotCount;
    }

    public int getClassCount() {
        return classCount;
    }

    public void setClassCount(int classCount) {
        this.classCount = classCount;
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

    //assignClass(...) and getClassLoad()
    public void assignClass(String classAssign){
        if(classAssign != null && classCount < classId.length){
            classId[classCount] = classAssign;
            classCount++;
        }
    }

    public int getClassLoad(){
        return classCount;
    }

    //raiseSalary(...) — increase salary by an amount, with validation
    public void raiseSalary(double amount){
        if(amount > 0){
            this.salary+=amount;
        }else{
            System.out.println("Invalid raised salary");
        }
    }
}
