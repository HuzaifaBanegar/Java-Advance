package CopyObject;


// DEEP COPY
public class Student implements Cloneable {
    private String name;
    private int age;

    public Student(String name, int age){
        this.name = name;
        this.age = age;
    }
    //Deep Copy:
    //The clone() method is overridden to provide a deep copy.
    //It first creates a shallow copy by calling super.clone().
    //For the name attribute (which is a reference type), a new String object is created to ensure the cloned Student instance has its own name rather than a reference to the original's name.
    //The age attribute is a primitive type (int), so it is safely copied as part of the cloning process.
    @Override
    public Object clone() throws CloneNotSupportedException{
        Student clonedStudent = (Student) super.clone();
        clonedStudent.name = new String(this.name);
        return clonedStudent;
    }

    @Override
    public String toString(){
        return "Student: { name: "+ name + ", age: "+ age +"}";
    }


    public static void main(String[] args) {
        try{

            System.out.println("Before Modifying------ ");
            Student original = new Student("John Doe", 24);
            System.out.println("Original Student: "+ original);

            Student cloned = (Student) original.clone();
            System.out.println("Cloned Student: "+ cloned);

            //Modify
            cloned.name = "Bob";
            cloned.age = 27;

            System.out.println("After Modifying------ ");
            System.out.println("Original Student: "+ original);
            System.out.println("Cloned Student: "+ cloned);

            //

        }catch (CloneNotSupportedException ex){
            ex.getMessage();
        }
    }
}
