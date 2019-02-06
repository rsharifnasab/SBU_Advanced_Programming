import java.util.Scanner;
public class Clock
{
    public static void main(String [] args)
    {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] db = new int[n][n];
        for (int i=0; i<n; i++)
          for (int j=0; j<n; j++)
            db[i][j] = sc.nextInt();

        System.out.println("not-persian");
   }
}
