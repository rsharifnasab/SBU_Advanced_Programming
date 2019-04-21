//5
//1  unoptomized_imports   remove java.util before declearing scanner
//2 bad_name    u and p are not suitable names, rename to good names: testValue1,testValue2
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

    final static String testValue1 = "value1";
    final static String testValue2 = "value2";
    final static int maxTries = 3;

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
      } while(!input.equals(toGet) && ++counter <= maxTries);
      if (counter > maxTries) fail();
    }

    public static void loginCheck(Scanner myScanner) throws Exception {

      stringGet(testValue1,myScanner);
      stringGet(testValue2,myScanner);
      System.out.println("Hello");
    }

    public static void main(String[] args) {
        try {
            Scanner myScanner = new Scanner(System.in);
            loginCheck(myScanner);
        } catch (Exception e) {}
    }

}
