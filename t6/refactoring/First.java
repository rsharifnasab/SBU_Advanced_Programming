//1 bad_name  rename
//2  duplicate code    extracted method
//3 magic number   final variable
//4 long method  mathod extract

import java.util.Scanner;

public class First {

    final static String value1 = "value1";
    final static String value2 = "value2";

    private static void fail() throws Exception{
      System.out.println("misuse");
      throw new Exception();
    }

    private static void stringGet(String toGet,Scanner myScanner) throws Exception{
      final int maxTries = 4;
      for (int i = 0;i < maxTries ;i++ ) {
        String input = myScanner.next();
        if (!input.equals(toGet))
            System.out.println("invalid");
        else return;
      }
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
