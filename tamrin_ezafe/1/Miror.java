import java.util.*;
public class Miror{
  static boolean isPalindrome(String s){
    StringBuilder sb = new StringBuilder(s);
    sb.reverse();
	String rev = sb.toString();
    return rev.equals(s);
  }
  static String bc (String number,int from, int to){
    return Integer.toString(Integer.parseInt(number,from),to);
  }
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    String ab = sc.next();
    int b = sc.nextInt(), c = sc.nextInt();
    String x = bc(ab,b,c);
    boolean palin = isPalindrome(x);
    System.out.println(palin?"YES":"NO");
  }

}
