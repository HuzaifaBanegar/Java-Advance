package Inheritance;

public class Main {
    public static void main(String[] args) {
        Student s1 = new Student("John", 27);
        s1.getStudentDetails();

        GraduatedStudent s2 = new GraduatedStudent();
        s2.setDetails("Alice", 23 );
        s2.setBatch("WEB 24");
        s2.getDetails();

    }

}
