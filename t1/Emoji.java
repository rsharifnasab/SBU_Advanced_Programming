import java.util.Scanner;
public class Emoji
{
    public static void main(String [] args)
    {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        int n = str.codePointAt(0);
        //char   chars[] = Character.toChars(cp);
        //  System.err.printf("%s\n", new String(chars));
        System.out.println(n);
        //pos += Character.charCount(cp);
       if (n >= 1536 && n<= 1791) System.out.println("persian");
             else System.out.println("not-persian");
   }
}
