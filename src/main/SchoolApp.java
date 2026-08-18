package main;

import entities.Person;

public class SchoolApp {

    //printAll(...) — loop once, call displayInfo() on each Person
    public static void printAll(Person[] people, int count){
        for(int i= 0; i < count; i++){
            people[i].displayInfo();
        }
    }
}
