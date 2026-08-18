package entities;

import java.util.Arrays;

public class HeadTeacher extends Teacher{
    //Attributes
    private int teachersManaged;
    private boolean adminOfficeAccess;
    private String [] upcomingMeeting;
    private int meetingCount;


    public HeadTeacher(String personId, String firstName, String lastName, String dateOfBirth, String gender, int phoneNumber, String email, String address, int nationalId, int age, String activeStatus) {
        super(personId, firstName, lastName, dateOfBirth, gender, phoneNumber, email, address, nationalId, age, activeStatus);
        this.teachersManaged = teachersManaged;
        this.adminOfficeAccess = adminOfficeAccess;
        this.upcomingMeeting = new String[10];
        this.meetingCount = 0;
    }

    //@Override displayInfo()
    @Override
    public void displayInfo() {
        System.out.println("HeadTeacher{" +
                "teachersManaged=" + teachersManaged +
                ", adminOfficeAccess=" + adminOfficeAccess +
                ", upcomingMeeting=" + Arrays.toString(upcomingMeeting) +
                ", meetingCount=" + meetingCount +
                '}');
    }

    //Getters & Setters
    public int getTeachersManaged() {
        return teachersManaged;
    }

    public void setTeachersManaged(int teachersManaged) {
        if(teachersManaged < 0){
            System.out.println("Teacher managed can't be less than 0");
        }
        this.teachersManaged = teachersManaged;
    }

    public boolean isAdminOfficeAccess() {
        return adminOfficeAccess;
    }

    public void setAdminOfficeAccess(boolean adminOfficeAccess) {
        this.adminOfficeAccess = adminOfficeAccess;
    }

    public String[] getUpcomingMeeting() {
        return upcomingMeeting;
    }

    public void setUpcomingMeeting(String[] upcomingMeeting) {
        this.upcomingMeeting = upcomingMeeting;
    }

    public int getMeetingCount() {
        return meetingCount;
    }

    public void setMeetingCount(int meetingCount) {
        this.meetingCount = meetingCount;
    }

    //addManagedTeacher()
    public void addManagedTeacher(){
        this.teachersManaged++;
        System.out.println("The new teacher has been added..");
    }

    //scheduleMeeting(...)
    public void scheduleMeeting(String meetingDate){
        if(meetingDate==null || meetingDate.trim().isEmpty()){
            System.out.println("The meeting can't be empty..");
        }
        if(meetingCount < upcomingMeeting.length){
            upcomingMeeting[meetingCount] = meetingDate;
            meetingCount++;
            System.out.println("Meeting scheduled for: "+meetingDate);
        }else{
            System.out.println("Meeting scheduled is full..");
        }
    }

    //getUpcomingCount()
    public int getUpcomingCount(){
        return meetingCount;
    }
}
