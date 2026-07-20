package multithreading;

import java.io.IOException;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Application1 implements Runnable{
    static ServerSocket serverSocket;
    static Socket socket;

    public void run(){
       String name = Thread.currentThread().getName();
       while(true){
           try{
               System.out.println("Thread - " + name + " is ready to accept....");
               socket = serverSocket.accept();
               System.out.println("Thread - " + name + " is connected to client");
               PrintStream printStream = new PrintStream(socket.getOutputStream());
               printStream.println("Hello from " + name);
               printStream.close();
               socket.close();
           }catch (IOException e){}


       }
    }

    //curl telnet://127.0.0.1:8080


    public static void main(String[] args) throws IOException {
        serverSocket = new ServerSocket(8080);
        Thread t1 = new Thread(new Application1(), "one");
        Thread t2 = new Thread(new Application1(), "two");
        t1.start();
        t2.start();
    }
}
