import java.io.*;
import java.util.*;
public class Clock
{
    public static void main(String [] args)
    {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] a = new int[n][n];
        for (int i=0; i<n; i++)
          for (int j=0; j<n; j++)
            a[i][j] = sc.nextInt();
        ArrayList<Integer> scores = new ArrayList<Integer>();
        for (int i=1; i<(n-1); i++)
          for (int j=1; j<(n-1); j++)
          {
            int ans = a[i-1][j-1]+a[i-1][j]+a[i-1][j+1]+a[i][j]+a[i+1][j-1]+a[i+1][j] +a[i+1][j+1];
            scores.add(ans);
          }
        System.out.println(Collections.max(scores));
   }
}
