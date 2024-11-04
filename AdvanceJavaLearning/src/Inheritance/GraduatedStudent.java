package Inheritance;

public class GraduatedStudent extends  Student{

    private String batch;

    public GraduatedStudent(){};

    public void setBatch(String batch){
        this.batch = batch;
    }

    public void display(){
        System.out.println("Child Display");
    }

    public void getDetails(){
        getStudentDetails();
        System.out.println("Batch name:"+ batch);
    }
}
