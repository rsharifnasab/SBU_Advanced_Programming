import java.net.*;
import java.util.*;
import java.io.*;
import java.nio.*;
import java.nio.charset.Charset;
import java.nio.file.*;


public class Main{
  public static String nameCounter = "z";
  public static void main(String[] args) throws Exception {

    Object p2 = instantiate("Person");
    System.out.println("made person");
    Person p = (Person) p2;
    System.out.println(" i get : "+p.name);

    Object o = instantiate("java.lang.String");
    String s = (String) o;
    System.out.println(" i get string : "+s);

    Object p3 = instantiate("Person");
    System.out.println("made person");
    Person p4 = (Person) p3;
    System.out.println(" i get : "+p4.name);

  }


  public static void makeOtherJava(String address) throws Exception{

    String templateCode = "";
    for (String i : Files.readAllLines(Paths.get("Template.java")))
      templateCode += i + "\n";
    String newCode = templateCode.replace("yyy",address);
    newCode = newCode.replace("xxx",nameCounter);
    PrintWriter out = new PrintWriter(nameCounter+".java");
    out.println(newCode);
    out.close();

  }

  public static void compiler(){
      try {
        Runtime rt = Runtime.getRuntime();
        Process pr = rt.exec("javac "+nameCounter+"java");
        System.out.println("wating for compile");
        pr.waitFor();
        pr = rt.exec("java "+nameCounter);
        System.out.println("run complete");
        nameCounter+="z";
      }
      catch(Exception e) {
        System.out.println("compile error");
        e.printStackTrace();
      }
  }

  public static Object instantiate(String address) throws Exception{
    makeOtherJava(address);
    compiler();
    System.out.println("opning serveer socket");
    try(
      ServerSocket server = new ServerSocket(1234);
      Socket socket = server.accept();
      InputStream sockInp = socket.getInputStream();
      ObjectInputStream objIn = new ObjectInputStream(sockInp);
    ){
      System.out.println(" make socket ok, wrintg");
      return objIn.readObject();
    }
    catch (Exception e) {
      System.out.println("REAding error");
      e.printStackTrace();
    }
    return null;
  }
}
