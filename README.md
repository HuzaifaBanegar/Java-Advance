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
</br>
<hr/>
</br>

**2. PROCESS AND THREADS:**
</br>
_Parellelism Vs Concurrency: Parellelism is a process where multiple process runs in parellel to each other, whereas concurrency is a process where a lots of process happens at once_ </br>

_►Threads:</br>_

<img alt="Multithreading" src="https://i.ytimg.com/vi/P38y6zvfb-s/maxresdefault.jpg"
         />
### What are Threads?
A **thread** is the smallest unit of execution within a process. Threads are often referred to as lightweight processes because they allow multiple tasks to run concurrently within the same application. While a **process** is an instance of a running program, a **thread** is a path of execution within a process.

### Why Are Threads Used?
Threads are used to improve application performance through **parallelism** and **concurrency**. They allow tasks within a program to be executed independently, helping with:
- **Responsiveness**: For instance, in a web browser, separate threads allow background tasks like page loading and video streaming to run without freezing the interface.
- **Efficiency**: Threads share resources of the process they belong to, making them more memory-efficient than processes.
- **Resource Sharing**: Threads within the same process share memory space and system resources, allowing for more efficient communication.

### Key Concepts Related to Threads

1. **Processes**: A process is an independent unit of execution that has its own memory space. It represents a running instance of a program and can contain multiple threads. Each process runs in its own separate address space, meaning one process generally cannot access another process’s memory.

2. **Program Counter (PC)**: The program counter is a register in the CPU that holds the address of the next instruction to be executed for a particular process or thread. In multi-threaded applications, each thread maintains its own program counter, as they may be executing different parts of code.

3. **Multithreading**: The ability of a CPU or single-core processor to manage multiple threads of execution at the same time. In a multi-core processor, true parallelism can occur, where multiple threads run simultaneously on different cores.

4. **Context Switching**: Switching the CPU from one thread or process to another. Each thread has its own program counter, stack, and local variables. During context switching, the CPU saves the current state (e.g., program counter and registers) of the thread and loads the state of another thread.

5. **Concurrency vs. Parallelism**: 
   - **Concurrency** is when multiple tasks make progress within overlapping time frames (e.g., threads taking turns in a single-core CPU).
   - **Parallelism** is when tasks are executed simultaneously (e.g., multiple threads running on a multi-core CPU).

6. **Thread Lifecycle**: A thread goes through different states in its lifecycle:
   - **New**: Thread is created but not yet started.
   - **Runnable**: Thread is ready to run, waiting for CPU time.
   - **Blocked/Waiting**: Thread is waiting for a resource or another thread.
   - **Timed Waiting**: Thread is waiting for a specific amount of time.
   - **Terminated**: Thread has finished executing.

### Advantages and Disadvantages of Threads
**Advantages**:
- **Improved Responsiveness**: Applications can remain responsive while doing background tasks.
- **Resource Sharing**: Threads within the same process can share memory and resources, which is efficient.
- **Efficient Communication**: Threads in a process can easily communicate with each other since they share memory.

**Disadvantages**:
- **Complexity**: Writing multi-threaded programs can be complex and requires careful handling of synchronization.
- **Synchronization Issues**: Shared data must be synchronized, leading to potential issues like **race conditions** and **deadlocks**.

### Summary
Threads allow concurrent execution within a process, improving application responsiveness and efficiency. Each thread within a process has its own program counter and can run independently, making multi-threading an essential concept in modern programming for managing multiple tasks simultaneously.

_Key Steps to Create a Thread_
1. Define a class that implements the Runnable interface.
2. Implement the run method in your class.
3. Create an object of the Thread class, passing your Runnable object to the constructor.
4. Start the thread using the start method of the Thread object.

_Code 1:Print 1-100 by different Threads_
```
//Runnable class NumberPrinter with a constructor that take a number
//Then in run() method it prints along with the thread that is printing it
public class NumberPrinter implements Runnable {
    private int number;

    public NumberPrinter(int number) {
        this.number = number;
    }

    @Override
    public void run() {
        System.out.println("Number "+this.number + " Is Printed by:" + Thread.currentThread().getName());
    }
}

// New Thread is created and an Object instantiated using NumberPrinter class is passed to it.
// start() method is used which internally calles the run() method
public class Client1 {
    public static void main(String[] args) {
        // Manual thread creation:
        for(int i=1; i<=100; i++){
            Thread thread = new Thread(new NumberPrinter((i)));
            thread.start();
        }
    }
}
```

_►Static variable:_ </br>
A variable which is shared by all the instances of the class. It is basically a class level variable and not object level variable.
```
public class StaticCount {
    public static int count = 0;

    private String name;

    public StaticCount(String name) {
        this.name = name;
        count++;
    }

    // Static count is related to the class and not the instace of it.
    // When an object is instatiated, the count is getting incremented.
    // We can call it as st1.count, but it doesn't matter
    // as it is class level and not object level

    public static void main(String[] args) {
        StaticCount st = new StaticCount("test");
        StaticCount st1 = new StaticCount("test1");
        System.out.println(StaticCount.count);

    }

    static void printElements(){
        System.out.println(count);
//        System.out.println(name); -- Static methods can only access static variables
    }

}
```
_►Debugging Threads:_ </br>

To understand thread behavior during execution using logging and thread dump analysis, follow these steps:
1. Add Logging to Your Application:
Implement logging in your application to capture key events, especially around thread creation, execution, and termination. Use a logging framework like SLF4J, Log4j, or java.util.logging.
Log relevant information, such as thread IDs, start and end times for thread tasks, and any exceptions encountered. Use log levels (INFO, DEBUG, ERROR) appropriately to categorize your logs.
2. Configure Logging Level:
Set a sufficient logging level (e.g., DEBUG) for detailed information during development or testing. In production, be cautious to avoid excessive logging that could impact performance.
3. Gather Thread Dumps:
During execution, especially if you detect issues like high CPU usage or unresponsive behavior, gather thread dumps.
This can usually be done by sending specific signals to the Java process. For example, on UNIX-like systems, you can use:
kill -3 <process_id> for Java applications to generate a thread dump.
On Windows, you can use tools like jconsole or VisualVM, or the Java Mission Control (JMC) tool.
4. Analyze Thread Dumps:
Use tools like Thread Dump Analyzer, VisualVM, or JProfiler to analyze the thread dumps.
Look for:
Thread states (e.g., RUNNABLE, BLOCKED, WAITING).
Stack traces to understand what each thread is doing at the time of the dump.
Signs of contention (e.g., multiple threads waiting for a lock) or deadlocks.
5. Correlate Logs and Thread Dumps:
Relate the timestamps in your logs with the thread states and stack traces in the thread dumps. This will help you identify the specific actions or events leading to any issues.
Look for patterns or anomalies, such as threads that consistently take too long to execute or that are frequently blocked.
6. Identify Bottlenecks or Issues:
Based on your analysis, identify potential bottlenecks, where threads are being delayed or blocked, and examine areas of code that require optimization.
Consider profiling your application to understand thread usage more thoroughly if needed.
7. Implement Fixes and Monitor:
After identifying issues, make necessary code changes or optimizations, such as reducing lock contention, optimizing algorithms, or improving thread pool management.
Continue to monitor your application with logging and periodically take thread dumps during high-load scenarios for ongoing analysis.
By following these steps, you can effectively use logging and thread dump analysis to understand and improve thread behavior in your application.

► _Threads vs. Processes:_ </br>
Threads share the same memory space, making data sharing easier but requiring careful synchronization.
Processes have separate memory spaces, making them more isolated but harder to share data efficiently

### For more detailed explanation of threads i have posted a blog of 4 parts on it. Please go through it here:
https://medium.com/@huzaifaBanegar/multithreading-in-java-basics-to-in-depth-guide-part1-22d70f270a8a

</br>
<hr/>
</br>

**3. Generics:** </br>
Generics in a very powerful feature in programming languages such as Java and C# that enables you to write code that is more flexible, reusable and type-safe.
They allow different classes, interface, methods with a placholder for types ( referred to as parameters) which can be specified when you create an instance or call methods.
This help you create code duplications and improve type safety.

► _Generics Classes_ </br>
```
class Box <T>{
    private T item;
    public void pack(T item){
        this.item = item;
    }
    public T unpack(){
       return item;
    }

}

//usage:
Box<String> stringBox = new Box();
stringBox.pack("Hello Generics");
System.out.println(stringBox.unpack); 
```
► _Generics Interface_ </br>
```
public interface GenericInterface <T, Q>{
    public T getFirstValue();
    public Q getSecondValue();
}

// implementation:
public class GenericCalss<T, Q> implements GenericInterface <T, Q>{
    private T first;
    private Q second;
    public GenericClass (T first, Q second){
        this.first = first;
        this.second = second;
    }

    public T getFirstValue() {return first;}

    public Q getSecond() {return second;}
}
```

► _Generics Methods_ </br>
```
public class GenericClassMethodExample{
    public static <T> void printArray(T[] array){
        for(T element: array){
           System.out.print(element + " ");  
        }  
        System.out.println(); 
    }

    public static void main(String[] args){
        Integer[] array1 = {1,2,3,4};
        String[] array2 = {"A", "B", "C", "D"};
        printArray(array1);
        printArray(array2);
    } 
}
```
► _Bounded Type Parameters_ </br>
You can restrict the type that can be used using type parameters by using Bounds. This ensures that the type paramter satisfies certain constraints.

```
class Calculator<T extends Number>{ 
 // This ensures that the the type will be Number or child of number, and not Strings , Boolean etc.
    public double add (T a, T b){
        return a.doubleVlaue() + b.doubleValue();
    }
}

//usage:
Calculator<Integer> calc = new Calculator<>();
System.out.println(cal.add(5,10)); // output: 15.0
```
<hr/>
</br>

**4. Collections:** </br>

**Collections** in Java refer to a group of objects, known as elements. They are part of the Java Collections Framework (JCF) and provide a way to store, retrieve, manipulate, and communicate aggregate data. Collections can be categorized into various types, such as lists, sets, and maps, which serve different purposes depending on the requirements of the application.

_►Collection Framework_ </br>
The **Collection Framework** is a unified architecture for representing and manipulating collections in Java. It provides a set of interfaces and classes that allow developers to work with groups of objects in a standard way. The main interfaces in the collection framework are:
- **Collection**: The root interface for all collections.
- **List**: An ordered collection (also known as a sequence).
- **Set**: A collection that does not allow duplicate elements.
- **Map**: An object that maps keys to values, where each key is unique.

_►_Hierarchy of Collection Framework__ </br>
The hierarchy of the Collection Framework can be summarized as follows:

- **Collection Interface**
  - **List Interface**
    - **ArrayList**
    - **LinkedList**
    - **Stack**
    - **Vector**
  - **Set Interface**
    - **EnumSet**     
    - **HashSet**
    - **LinkedHashSet**
    - **TreeSet**
  - **Queue Interface**
    - **ArrayDeque**     
    - **PriorityQueue**
    - **LinkedList** (also implements Queue)
  - **Map Interface**
    - **HashMap**
    - **LinkedHashMap**
    - **TreeMap**
    - **ConcurrentHashMap**

_►4. List_ </br>
A **List** is an ordered collection that allows duplicate elements. It maintains the order of insertion, which means elements can be accessed by their index. Common implementations of the List interface include:
- **ArrayList**: A resizable array implementation that allows for fast random access but can be slower for insertions and deletions.
- **LinkedList**: A doubly-linked list implementation that allows for efficient insertions and deletions but has slower access times compared to ArrayList.
- **Vector**: Similar to ArrayList but synchronized, making it thread-safe but generally slower due to the overhead of synchronization.

_►Set_ </br>
A **Set** is a collection that does not allow duplicate elements. It models the mathematical set abstraction and is used when uniqueness is required. Common implementations include:
- **HashSet**: Uses a hash table for storage and provides constant-time performance for basic operations (add, remove, contains).
- **LinkedHashSet**: Maintains a linked list of the entries in the set, preserving the order of insertion.
- **TreeSet**: Implements a sorted set using a red-black tree, which means it keeps its elements in sorted order.

_►Queue_ </br>
A **Queue** is a collection designed for holding elements prior to processing. It follows the First-In-First-Out (FIFO) principle. Implementations include:
- **PriorityQueue**: Orders its elements based on their natural ordering or a specified comparator, allowing for priority-based retrieval.
- **LinkedList**: Can also be used as a queue since it implements the Queue interface, allowing for efficient insertions and deletions at both ends.

_►HashSet vs HashMap_ </br>
- **HashSet**: A collection that implements the Set interface. It stores unique elements and does not allow duplicates. It uses a hash table for storage, which provides fast access.
- **HashMap**: Implements the Map interface and stores key-value pairs. Each key is unique, and it allows for one null key and multiple null values. HashMap is also backed by a hash table, providing efficient retrieval.

► _TreeMap_ </br>
**TreeMap** is a map that implements the SortedMap interface and uses a red-black tree structure to store its entries. It maintains the natural ordering of its keys or uses a specified comparator. TreeMap provides efficient performance for operations like insertion, deletion, and lookup, all in O(log n) time.

_►LinkedHashMap_ </br>
**LinkedHashMap** is a hash table and linked list implementation of the Map interface. It maintains a doubly-linked list of the entries in the map, which allows it to preserve the order of insertion. This means that when iterating over the keys or entries, they will be returned in the order they were added.

_►Vector_ </br>
**Vector** is a resizable array implementation of the List interface. Unlike ArrayList, it is synchronized, making it thread-safe. However, this synchronization makes it slower than ArrayList in scenarios where thread safety is not a concern. Vectors can grow dynamically as elements are added.

_►ConcurrentHashMap_ </br>
**ConcurrentHashMap** is a thread-safe variant of HashMap designed for concurrent access. It allows multiple threads to read and write without locking the entire map, improving performance in multi-threaded environments. It divides the map into segments, allowing for concurrent updates to different segments.


_►Internal Implementation of HashMap_ </br>
- Structure
   - Array of Buckets:
       - The fundamental structure of a HashMap is an array of buckets (also referred to as "nodes"). Each bucket can hold a linked list (or a     balanced tree, depending on the number of elements in that bucket) of entries for keys that hash to the same index (known as a collision).
    - Entry Class: Each bucket contains instances of the Entry class (or Node class in some newer implementations). Each Entry holds:
        - Key: The key for the entry.
        - Value: The value associated with the key.
        - Hash: The hash code of the key, used for quick comparisons.
        - Next: A pointer/reference to the next entry in case of a collision. This forms a linked list for entries whose keys hash to the same index.
```
// Here’s a simplified version of the Entry class:

static class Node<K, V> implements Map.Entry<K, V> {  
    final K key;  
    V value;  
    final int hash;  
    Node<K, V> next;  

    Node(int hash, K key, V value, Node<K, V> next) {  
        this.hash = hash;  
        this.key = key;  
        this.value = value;  
        this.next = next;  
    }  
}
```
- How Hashing Works
    - Hashing Process:
    When a key is added to a HashMap, its hash code is computed using the hashCode() method of the key object, which is a method inherited from the Object class in Java. </br>
    The hash code is then processed through a hashing function to determine the index in the array of buckets. The process involves two main steps:
        - Computing the hash code: The hash code of the key is obtained using key.hashCode().
        - Index calculation: The actual index for the bucket is calculated as follows:</br>
          int index = (n - 1) & hash;  // where n is the length of the table and hash is the hash code
        - This ensures that the index wraps around if it goes beyond the size of the array (using bitwise AND with the array size minus one).
    - Collision Handling:
        - HashMap uses chaining to resolve collisions:
            - If two keys hash to the same index, their entries are stored in the same bucket as a linked list. This means that the bucket can hold multiple entries.
            - If the number of entries in a single bucket exceeds a certain threshold (usually 8), the linked list is transformed into a balanced tree (specifically a red-black tree) for improved performance in retrieval operations.
-Example of Adding Element:
    -  Calculate the hash:
        int hash = "apple".hashCode();
    -  Determine the bucket index:
      int index = (n - 1) & hash; // assuming n is the length of the array
    -  Insert into the bucket:
        - If the bucket at the calculated index is empty, the entry is simply placed there.
        - If there is already an entry, it checks for equality using the hash, key, and if they match, updates the value; if not, it adds the new entry to the front of the linked list.  

- Retrieving an Element
      - To retrieve a value associated with a key in a HashMap:
          - Calculate the hash for the key as before.
          - Find the bucket index.
          - Traverse the linked list (or tree, if applicable) in that bucket:
          - Compare the hash and the keys of the entries until the correct entry is found or the end of the list is reached.
- Resizing HashMap:
    - As elements are added, when the number of entries exceeds a threshold (commonly 75% of the capacity), the HashMap resizes:
        - A new, larger array is created (typically double the size).]
        - All existing entries are rehashed and redistributed into the new array using the same hashing process. This process is necessary because the index calculation depends on the current array size.
</br>
<hr/>
</br>


### 1. Garbage Collection in Java

**Garbage Collection (GC)** is an automatic memory management feature in Java that helps reclaim memory occupied by objects that are no longer reachable or used by an application. The Java Virtual Machine (JVM) takes care of garbage collection, meaning developers don’t have to manually free memory as they might in languages like C or C++.

#### How Garbage Collection Works:

- **Automatic Memory Management**: Java objects are allocated in a region of memory known as the **heap**. When an object is created, memory for it is allocated on the heap.
  
- **Reachability**: An object is considered **reachable** if it can be accessed via any chain of reference from a root reference (like local variables on the stack, active threads, etc.). When an object is no longer reachable, it becomes eligible for garbage collection.

- **Garbage Collector**: The JVM runs a garbage collector in the background that periodically identifies and disposes of unreachable objects to reclaim memory.

#### Types of Garbage Collectors:

Java provides several types of garbage collectors, each with its own strengths:

1. **Serial Garbage Collector**:
   - Designed for single-threaded environments.
   - Uses a simple approach where all garbage collection occurs in a single thread, making it suitable for small applications.

2. **Parallel Garbage Collector**:
   - Uses multiple threads for garbage collection.
   - Aimed at maximizing throughput, making it suitable for applications requiring high performance.

3. **Concurrent Mark-Sweep (CMS) Collector**:
   - Aims to minimize pause times by doing most of the work concurrently with the application threads.
   - Good for applications sensitive to latency.

4. **G1 Garbage Collector**:
   - A more recent addition that divides the heap into regions and performs garbage collection in a way that minimizes pause times.
   - Aims to provide a predictable pause time that can be configured.

5. **Z Garbage Collector (ZGC)** and **Shenandoah**:
   - Low-latency garbage collectors designed for large heaps, allowing for garbage collection with minimal pauses.

#### Process of Garbage Collection:

The garbage collection process generally includes several steps:

1. **Marking phase**: The garbage collector identifies which parts of the heap contain reachable objects.
2. **Sweeping phase**: It then collects the objects that are unreachable, freeing up memory space.
3. **Compacting phase** (optional): To reduce fragmentation, the collector may move objects around and reduce the size of the allocation space, which makes allocation of new objects faster.

#### Finalization:

Before an object is garbage collected, its `finalize()` method may be called, allowing cleanup operations (like closing files or database connections) to occur. However, using `finalize()` is generally discouraged in favor of other resource management practices (like try-with-resources).

### 2. Memory Management in Java

Memory management in Java involves the lifecycle of objects and how memory is allocated, used, and deallocated during a program’s execution. The JVM handles memory management, which includes several components:

#### Memory Areas in Java:

1. **Heap Memory**:
   - The primary storage area for objects. When an object is created using `new`, memory for that object is allocated in the heap.
   - Managed by the garbage collector.

2. **Stack Memory**:
   - Each thread has its own stack, which stores method call frames, local variables, and method arguments.
   - Memory allocation on the stack is very fast and follows the Last In, First Out (LIFO) principle. When a method call is completed, its stack frame is removed.

3. **Method Area** (also known as the MetaSpace in Java 8 and above):
   - Stores class structure, including metadata, constants, and static variables.
   - The *JVM* allocates method area memory at startup.

4. **Native Method Stack**:
   - Contains all the native method information for the application.
   - Similar in structure to the stack memory used for Java methods, but specifically for native methods.

#### Memory Allocation:

- **New Object Creation**: When an object is created using the `new` keyword, the memory is allocated on the heap.
- **Reference Variables**: Variables that refer to the objects are stored either on the stack (if they're local variables) or in the heap (if they are class or instance variables).

#### Memory Leaks:

- A memory leak occurs when a program does not release the memory it no longer requires. This can be caused by holding references to objects that are no longer needed, preventing the garbage collector from reclaiming that memory.

#### Conclusion:
Java's garbage collection and memory management systems allow developers to focus more on writing code rather than handling memory allocation and deallocation, leading to increased productivity and reduced likelihood of memory-related bugs. However, understanding these concepts can still help developers write efficient Java applications and troubleshoot performance issues.

