import java.net.*;
import java.util.*;
import java.io.*;
public class xxx{
  public static void main(String[] args) {

    try(
      Socket socket = new Socket("localhost",1234);
      OutputStream socketOut = socket.getOutputStream();
      ObjectOutputStream objOut = new ObjectOutputStream(socketOut);
    ){
        yyy a = new yyy(); // important
        objOut.writeObject(a);
    }
    catch (Exception e) {
      System.out.println("send erorr");
      e.printStackTrace();
    }
  }
}
