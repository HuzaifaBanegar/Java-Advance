package Inheritance;

public class Student {
    private  String name;
    private int age;
    public Student(String name, int age){
        this.name = name;
        this.age = age;
    }

    public void display(){
        System.out.println("Parent Display");
    }

    //Copy Constructor - 
    public Student(Student student){
        this.name = student.name;
        this.age = student.age;
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
