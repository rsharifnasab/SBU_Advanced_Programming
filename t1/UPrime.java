import java.util.Scanner;
public class UPrime
{
  public static int [] db = new int[70];

  public static int index=0;
  public static boolean is_prime(int x)
   {
      if(x==1) return false;
      for(int i = 2;i<x-1;i++)
       if(x%i == 0)  return false;
       return true;
    }

    public static int pow(int a,int b)
    {
      if(b<=0) return 1;
      return a*pow(a,b-1);
    }

    public static void S_find(int t_r,int this_n,int miin)
    {
        if (t_r<=0)
        {
            if(this_n < miin) return ;
            //std :: cout << this_n << std :: endl;
            db[index] = this_n;
            index++;
            return;
        }
        for(int i =0;i<=9;i++)
           if(is_prime(this_n*10+i)) S_find(t_r-1,this_n*10+i,miin);
    }

    public static void counter()
    {
        for(int i =0; i < 7; i++)
        {
          S_find(i,0,pow(10,i-1));
        }
    }
    public static void main(String [] args)
	  {
        for(int i =0; i < 70; i++) db[i] = 0;
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        counter();
        System.out.println(db[n-1]);
   }
}

