import java.util.Scanner;
public class BitWise
{
    public static int bc(String number,int from)
    {
      return Integer.parseInt(number,from);
        //return Integer.toString(Integer.parseInt(number,from),to);
    }
    public static void main(String [] args)
	  {
        Scanner sc = new Scanner(System.in);
		    int p = sc.nextInt();
		    int q = sc.nextInt();
        int s = bc(sc.next(),p);
        int x = bc(sc.next(),q);

        int tedad_ans = 0;
        for (int i = 1; i<s; i++ )
        {
          int j = s-i;
          if( (i^j) == x) tedad_ans++;
        }
        System.out.println(tedad_ans);
   }
}
