import java.util.*;
public class Lozi{
  public static void main(String[] args) {
      Scanner sc = new Scanner(System.in);
      int tedadKhat = sc.nextInt();
      int n = tedadKhat%2 == 0 ? tedadKhat/2 : tedadKhat/2 + 1;
      for(int k =1 ; k <= n; k++) // be ezae har khat
    	{
    		for(int f = 0; f < n-k; f++)
    			System.out.print(" ");
    		for(int s = 0; s < (2*k) - 1; s++)
    			System.out.print("*");
        for(int f = 0; f < n-k; f++)
    			System.out.print("  ");
    		for(int s = 0; s < (2*k) - 1; s++)
    			System.out.print("*");

    		System.out.println();
    	}
    	/*
    		hala baraye nime paeen moshabeh hamin amal mikonim
    		inbar tedad khat ha  yeki kam tare
    		mi tounim ein code bala ro copy konim vali inbar az akhar ejra konim (tartib khat ha baraks)
    	*/
    	for(int k = n-1 ; k >0; k--) // be ezae har khat
    	{
    		for(int f = 0; f < n-k; f++)
    				System.out.print(" ");
    		for(int s = 0; s < (2*k) - 1; s++)
    				System.out.print("*");
        for(int f = 0; f < n-k; f++)
    				System.out.print("  ");
    		for(int s = 0; s < (2*k) - 1; s++)
    				System.out.print("*");
    			System.out.println();
    	}
  }
}
