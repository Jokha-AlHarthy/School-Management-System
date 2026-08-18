package main;

import entities.*;

public class SchoolApp {

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
                headTeacherCount++
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
