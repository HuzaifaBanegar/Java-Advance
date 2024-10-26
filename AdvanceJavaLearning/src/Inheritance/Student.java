package Inheritance;

public class Student {
    private  String name;
    private int age;
    public Student(String name, int age){
        this.name = name;
        this.age = age;
    }

    public Student() {
    }

    public void setDetails(String name, int age){
        this.name = name;
        this.age = age;
    }

    public void getStudentDetails(){
        System.out.println("Name:"+ this.name );
        System.out.println("Age:" + this.age);
    }


}
