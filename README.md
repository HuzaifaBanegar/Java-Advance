**1. OOPS:**

_Introduction:_ </br>
    OOPS (Object oriented programming) is a paradigm rooted in the principle of deriving software behavior from real-world entities.
    Instead of dividing a program into data structure and functions as i Procedural Programming, OOP treats data as object that have inherent characteristics and behaviours.

_Advantages of OOPs:_</br>
    Modularity: Objects stored in different files and modules, promoting reusibility.
    Reusability: Inheritance allows new objects to take property of existing ones , reducing redundancy.
    Easy Debugging.
    Maintenance.

_►Classes:</br>_
     A blueprint for creating object. It defines data type by bundling data and methods
```
class Student{
    private String name;
    private int age;

    //Constructor:
    public Student (String name, int age){
        this.name = name;
        this.age = age;
    }

    public void printName(){
        System.out.println("Name: " + this.name);
    }    
}
```
_►Objects:</br>_
    An instance of a clas. If student is class then object John is object (instance) of that class
```
Student john = new Student("John", 24) 
```
_►Encapsulation:_ </br>
Encapsulation is mechanism of restricting access to certain details and showing only essential features.
Its like a medical capsule that holds various medicins inside while protecting it from external environment.

```
class Student{
    private String name;//Encapsulation if attributes
    private int age;

    //Constructor:
    public Student (String name, int age){ // Public method tos et up the attributes
        this.name = name;
        this.age = age;
    }

    public void printName(){ // Public method to get the name attribiutes
        System.out.println("Name: " + this.name);
    }    
}
```

_►Inheritance:_ </br>
Inheritance is a mechanism where the new class is derived from existing class. 
The new class is known as subclass, inherits the attributes and behaviour(methods) from the parent class.

```
class GraduatedStudent extends Student{
    private String batch;

    public void setBatchName(String batch){
        this.batch = batch;
    }

    public void getBatchName(){
        System.out.println("Batch name: " + this.batch);
    }
}

//Creating object of inherited class

GraducatedStudent alice = new Student("Alice" , 23);//Constructor inherited from parents.
alice.setBatchName("WEB15");//setBatchName method of subclass

```

_►Polymorphism:_ </br>
Ploymorphism allows methods to do differnt things based on the object it is acting upon.
```
class Animal{
    public void makeSound(){
        System.out.println("Animal makes a sound");
    }
}

class Dog extends Animal{
    public void makeSound(){
        System.out.println("Dog Barks");
    }
}
```

_►Abstraction:_ </br>
Abstraction is a concept of hiding complex reality while exposing only necessary parts.
It simplifies the complex details to ease user interaction with the system.

For example, when you drive a car you dont need to know the complexity of internal combustion or engine. You just need to drive a car.
```
abstract class Car{
    abstract void accelerate();
    abstract void brake();
}

class Sedan extends Car{
    void accelerate(){
         System.out.println("Sedan is accelerating");
    }

    void brake(){
         System.out.println("Sedan is braking");
    }
}
```
_►Constructor:_ </br>
A constructor is a Java block of code that initializes a newly created Object. It does using _new_ keyword.
Types: 
1. Default Constructor: If no constructor is defined, Java provides a default constructor with no parmeter.
2. Parameterized Constructor: A constructor that accepts parameter to initialize an object with specific values.
3. Copy Constructr: Create new Objects as copy of existing object. Takes another object of the same class as parameter and copies its value.

```
class Student{
    private String name;
    
    //Parameterized constructor
    public Student(String name){
        this.name = name;
    }
    //Copy constructor
    public Student (Student student){
        this.name = student.name
    }
}
```

_►Shalow Copy vs Deep Copy:_ </br>
1. Shallow copy: </br>
Shalow copy creats a new object, but fields of new object reference the same memory location as the original object.
Change in one object reflects in the other.
```
Student stud1 = new Student("Alice", 20);
Student stud2 = stud1;
```

2. Deep copy: </br>
In Deep copy all the fields are copy from first object, but with new memory allocation for each one of them. 
Change in one object does not reflects in the other.
```
class Student implements Cloneable {  
    String name;  
    int age;  

    public Student(String name, int age) {  
        this.name = name;  
        this.age = age;  
    }  

    // Deep Copy  
    @Override  
    public Object clone() throws CloneNotSupportedException {  
        // Create a shallow copy using the super.clone() method  
        Student clonedStudent = (Student) super.clone();  
        // Create a new String for the name to ensure it's a deep copy  
        clonedStudent.name = new String(this.name);   
        // Age is a primitive type, so it is automatically copied  

        return clonedStudent;  
    }  

    @Override  
    public String toString() {  
        return "Student{name='" + name + "', age=" + age + "}";  
    }  

    public static void main(String[] args) {  
        try {  
            // Create an original Student object  
            Student original = new Student("Alice", 20);  
            System.out.println("Original: " + original);  

            // Clone the original object  
            Student cloned = (Student) original.clone();  
            System.out.println("Cloned: " + cloned);  

            // Modify the cloned object's name  
            cloned.name = "Bob";  

            // Show that changing the cloned object does not affect the original  
            System.out.println("After modifying cloned object:");  
            System.out.println("Original: " + original);  
            System.out.println("Cloned: " + cloned);  
        } catch (CloneNotSupportedException e) {  
            e.printStackTrace();  
        }  
    }  
}  
```

_►Access Modifiers: <br/>_
1. Public: The member is accessible from any other class.
2. Private: The member is accessible from inside its own class.
3. Protected: The member is accessible withing its package and subclass.
4. Default / Package-private: The member is accessible only within its own package

NOTE: In java Methods Parameter are passed by value 
```
void modifyStudent(Student st) {
    st.age = 22;
}

Student st1 = new Student("Alice", 20);
modifyStudent(st1);  // The age of st1 will be changed to 22
```

_►Abstract classes: <br/>_
An abstract class is a class that cannot be intatiated on its own and may contain both abstract methods (methods without implementtation) and complete methods (methods with implementtation).
It is necessary to implement the abstract methods in child class of an Abstract class. </br>
Members:
1. Can have fields to hold state
2. Can have abstract methods and complete methods
3. Can define constructor
4. Basically it is same as a class , but can hold abstract methods in it and cannot be instantaited.

```
//ABSTRACT CLASS VEHICLE
abstract public class Vehicle {
    //For all the abstract methods it is necessary to provide implementation in the child class when created
    abstract void startEngine();

    // Abstract class can have its own members
    private boolean created;

    //Abstract method can have constrctor
    public Vehicle(){
        System.out.println("A vehicle is being constructed");
        created = true;
        System.out.println("Is Vehicle constructed? "+ created);
    }

    //It can also have complete methods
    void stopEngine(){
        System.out.println("Engine stopped");
    }

}

//CLASS CAR
public class Car extends  Vehicle{

    public Car(){
        System.out.println("Car is constrcted");
    }
    void startEngine(){
        System.out.println("Car Engine started");
    }

    public static void main(String[] args) {
        Car car = new Car();
        car.startEngine();
        car.stopEngine();
    }
}
```

_►Interfaces: </br>_
Interface is a contract that defines a set of abstract methods that needs to be defined by the class that implements it.
It contains only abstract methods and no complete methods.</br>
Members:
1. Cannot have instance fields.
2. Only abstract methods (After Java8 they can have some default static methods)
3. Cannot define constrctor
4. Cannot be instantiated.

```
//INTERFACE ANIMAL
public interface Animal {
    void eat();
    void sleep();
    void makeSound();
    
    //Cannot be called by instantiated object by the class that implements interface Animal.
    //Should directly be called as Animal.play()
    public static void play(){
        System.out.println("Animal is playing");
    }
}

//CLASS DOG
public class Dog implements Animal {
    //It is mandatory to provide implementation for all the methods without it there will be an error
    @Override
    public void eat() {
        System.out.println("Dog eats");
    }

    @Override
    public void sleep() {
        System.out.println("Dog sleeps");
    }

    @Override
    public void makeSound() {
        System.out.println("Dog barks");
    }


    public static void main(String[] args) {
        Dog dog = new Dog();
        dog.eat();
        dog.sleep();
        dog.makeSound();
        Animal.play();
    }
}
```

_►Abstract Classes vs Inteface:_ </br>

<table>  
    <thead>  
        <tr>  
            <th>Feature</th>  
            <th>Abstract Class</th>  
            <th>Interface</th>  
        </tr>  
    </thead>  
    <tbody>  
        <tr>  
            <td>Instantiation</td>  
            <td>Cannnot be instantiated</td>  
            <td>Cannnot be instantiated</td>  
        </tr>  
        <tr>  
            <td>Type of Methods</td>  
            <td>Can have abstract and concrete</td>  
            <td>Primarily abstract; can have default methods (from Java 8)</td>  
        </tr>  
        <tr>  
            <td>Fields</td>  
            <td>Can have fields</td>  
            <td>Cannot have fields</td>  
        </tr>  
        <tr>  
            <td>Constructors</td>  
            <td>Can have constructors</td>  
            <td>Cannot have constructors</td>  
        </tr>  
        <tr>  
            <td>Access Modifiers</td>  
            <td>Can have any access modifier</td>  
            <td>All members are implicitly public</td>  
        </tr>  
        <tr>  
            <td>Inheritance</td>  
            <td>Single inheritance</td>  
            <td>Multiple inheritance</td>  
        </tr>  
        <tr>  
            <td>Use Case</td>  
            <td>To provide a base class with shared code</td>  
            <td>To define a contract for unrelated classes</td>  
        </tr>  
    </tbody>  
</table>
