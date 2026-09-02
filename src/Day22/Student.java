package Day22;

import java.sql.SQLOutput;

public class Student {
    String name;
    int age;
    int id;
    public Student(String name,int age,int id){
        this.name=name;
        this.age=age;
        this.id=id;
    }

    static void displayInfo(Student s){
        System.out.println("Student Name:-"+s.name);
        System.out.println("Student id:-"+s.id);
        System.out.println("Student age:-"+s.age);
    }
    static void main() {
       Student no1=new Student("ali",20,11);
       Student no2=new Student("dj",21,12);
       displayInfo(no1);
       displayInfo(no2);
    }
}
