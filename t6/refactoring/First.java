//5
import java.util.Scanner;

public class First {

    static String u = "value1";
    static String p = "value2";

    public static void f(Scanner s) throws Exception {
        String a, b;
        int c = 0;
        do {
            a = s.next();
            if (!a.equals(u))
                System.out.println("invalid");
        } while (!a.equals(u) && ++c <= 3);
        if (c > 3) {
            System.out.println("misuse");
            throw new Exception();
        }
        c = 0;
        do {
            b = s.next();
            if (!b.equals(p))
                System.out.println("invalid");
        } while (!b.equals(p) && ++c <= 3);
        if (c > 3) {
            System.out.println("misuse");
            throw new Exception();
        }
        System.out.println("Hello");
    }

    public static void main(String[] args) {
        try {
            Scanner s = new java.util.Scanner(System.in);
            f(s);
        } catch (Exception e) {}
    }

}