import java.io.*;
import java.util.*;
public class WoodR
{
    public static Long pow(int a,int b)
    {
      if(b<=0) return 1L;
      return a*pow(a,b-1);
    }

    public static ArrayList<Integer> scores = new ArrayList<Integer>();
    public static int[] db;



    public static void main(String [] args)
    {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        db = new int[n];
        for (int i=0; i<n; i++)
            db[i] = sc.nextInt();
        int tool_wood = sc.nextInt();

        for (int i=0; i<n; i++)
        {
          int sum = 0;
          for (int j=0; j<n; j++)
           {

          }
        }
        System.out.println(wood(tool_wood));
        for (Integer a : scores )
        {
          System.out.print(a+" ");
        }
   }
}
