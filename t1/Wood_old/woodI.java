import java.util.Scanner;
class woodI
{
  public static int maxWeight = 0; //tool wood
  public static int[] w;           //tool har kodam (1 to n)
  public static int[] v;           //value of each piece
  public static int[] a;           //maximum value each split
  public static int[] l;           //last item each

  public static void set_all(int[] arr, int val)
  {
    for (int i=0;i<arr.length;i++) arr[i] = val;
    return;
  }


  public static int[] tarkib()
  {
    int[] comb = new int[w.length];

    int postTracker = l.length-1;
    int itemTracker = l[postTracker];

    while (itemTracker != -1 && postTracker > 0)
    {
      comb[itemTracker]++;
      postTracker = postTracker - w[itemTracker];
      itemTracker = l[postTracker];
    }

    return comb;
  }

  public static void split_wood()
  {
    int   n = w.length;         //number of items

    a = new int[1+maxWeight];
    set_all(a,  0);

    l = new int[1+maxWeight];
    set_all(l, -1);

    for (int i=1;i<a.length;i++)
    {
      for (int j=0;j<n;j++)
      {
        if ( (w[j] <= i) &&  (v[j] + a[i - w[j]]) > a[i] )
        {
          l[i] = j;
          a[i] = v[j] + a[i - w[j]];

        }
      }
    }
  }


  public static void main(String[] args)
  {
    Scanner s = new Scanner(System.in);
    int m = s.nextInt();

    w = new int[m];
    for (int i=0;i<m;i++)
    w[i] = i+1;

    v = new int[m];
    for (int i=0;i<m;i++)
    v[i] = s.nextInt();

    maxWeight = s.nextInt();

    split_wood();
    int[] best = tarkib();


    System.err.print("best option : ");
    System.out.println(a[a.length-1]);
    System.err.print("tool ha : ");
    for (int i=0;i<best.length;i++)
    for (int j=0;j < best[i] ; j++ )
    System.out.print(i+1 + " ");

    System.out.println();
  }

}
