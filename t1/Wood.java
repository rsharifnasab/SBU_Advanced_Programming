import java.io.*;
import java.util.*;
public class Wood
{
    public static Long pow(int a,int b)
    {
      if(b<=0) return 1L;
      return a*pow(a,b-1);
    }

    public static ArrayList<Integer> scores = new ArrayList<Integer>();
    public static int[] db;

    public static Long wood(int n) // n=5
    {
      Long max = 0L;
      int cut_count = n-1; // =4
      Long tt = pow(2,cut_count+1);   // = 1111  = 15
      for(Long i =0L; i < tt; i++) // 0000 to 1111
      {
        Long value = 0L;
        Long t = i; // 0000 to 1111 make a copy of i
        int temp=0;
        while(t>0)
        {
          if (t%2==0)
            temp++;
          if (t%2==1)
          {
            value+=db[temp];
            temp = 0;
          }
          t/=2;
        }
        if (max<value)
        {
          max = value;
          t = i;
          scores.clear();
          while(t>0)
          {
            if (t%2==0) temp++;
            else
            {
              scores.add(temp+1);
              temp = 0;
            }
            t/=2;
          }
        }
      }
  //    System.out.println(scores);
      return max;
    }
    public static void main(String [] args)
    {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        db = new int[n];
        for (int i=0; i<n; i++)
            db[i] = sc.nextInt();
        int tool_wood = sc.nextInt();
        System.out.println(wood(tool_wood));
        for (Integer a : scores )
        {
          System.out.print(a+" ");
        }
   }
}
