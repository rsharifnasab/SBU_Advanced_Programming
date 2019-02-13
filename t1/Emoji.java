import java.util.Scanner;
public class Emoji
{
    public static boolean isPersian(int n)
    {
      if(n > 1569 && n < 1610 ) return true;
      if(n==1688 || n==1670 || n==1711 || n==1662) return true;
      if(n >= 1776 && n <= 1785 ) return true;
      System.err.println("n is:"+n);
      return false;
    }

    public static void main(String [] args)
    {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        int n = str.codePointAt(0);
        System.out.println(n);
       System.out.println(isPersian(n)?"persian":"not-persian");
   }
}
