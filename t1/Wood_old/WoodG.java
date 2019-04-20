import java.io.*;
import java.util.*;
public class WoodG
{

    private static int max(int i, int j)
    {
            return (i > j) ? i : j;
    }

    // Returns the maximum value with knapsack
    // of W capacity
    private static int knapSack(int W, int n,
                                int[] val, int[] wt)
    {
        int dp[] = new int[W + 1];
        for(int i = 0; i <= W; i++)
        {
            for(int j = 0; j < n; j++)
            {
                if(wt[j] <= i)
                    dp[i] = max( dp[i] , dp[ i-wt[j] ] + val[j] );
            }
        }
        return dp[W];
    }

  public static void main(String args[])
  {

    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int [] val = new int[n];
    int [] wt = new int[n];
    for (int i=0; i<n; i++)
    {
      val[i] = sc.nextInt();
      wt[i]= i+1;
    }
    int W = sc.nextInt();
    System.out.println( knapSack(W,n,val,wt) );
  }


}
