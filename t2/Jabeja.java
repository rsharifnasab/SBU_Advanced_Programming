import java.util.Scanner;

/**
 * Q3
 */
public class Jabeja {

    public static void main(String[] args) {
      
        Scanner sc = new Scanner(System.in);
        StringBuilder s = new StringBuilder(sc.next());
        String u = sc.next(), v = sc.next();
        int firstV = s.indexOf(v);
        int lastU = s.lastIndexOf(u);
        if (firstV != -1 && lastU != -1) {
            s.replace(firstV, firstV + v.length(), u);
            s.replace(lastU + (u.length() - v.length()), lastU + (u.length() - v.length()) + u.length(), v);
        } else if (firstV == -1 && lastU != -1) {
            s.replace(lastU, lastU + u.length(), v);
        } else if (lastU == -1 && firstV != -1) {
            s.replace(firstV, firstV + v.length(), u);
        }

        System.out.print(s);
    }
}
