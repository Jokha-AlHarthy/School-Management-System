package entities;

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
}
