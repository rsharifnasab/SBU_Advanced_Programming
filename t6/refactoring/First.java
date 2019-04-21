//1  unoptomized_imports   remove java.util before declearing scanner
//2 bad_name    u and p are not suitable names, rename to good names: value1,value2
//3 bad name    scanner s is not a good name, changed to myScanner
//4  final variables are not final     string values changed to final
//5  duplicate coed    extracted method stringGet for removing duplicate code
//6 bad_name  changed a,b name to: input
//7 bad_name  changed c int  to counter for better code understanding
//8 magic number    3 changed max number of tries changed to maxTries
//9 long method :  mathod fail extracted
//10 bad_name  method f changed to loginCheck
import java.util.Scanner;

public class First {

    final static String value1 = "value1";
    final static String value2 = "value2";
    final static int maxTries = 4;

    private static void fail() throws Exception{
      System.out.println("misuse");
      throw new Exception();
    }

    private static void stringGet(String toGet,Scanner myScanner) throws Exception{
      String input;
      int counter = 0;
      do{
        input = myScanner.next();
        if (!input.equals(toGet))
            System.out.println("invalid");
        else return;
        counter++;
      } while(counter < maxTries);
      fail();
    }

    public static void loginCheck(Scanner myScanner) throws Exception {
      stringGet(value1,myScanner);
      stringGet(value2,myScanner);
      System.out.println("Hello");
    }

    public static void main(String[] args) {
        try {
            Scanner myScanner = new Scanner(System.in);
            loginCheck(myScanner);
        } catch (Exception e) {}
    }

}
