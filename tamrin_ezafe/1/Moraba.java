import java.util.*;
public class Moraba{
   public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    for(int i=0; i < n; i++){
    	boolean nime2 = false;
    	for(int j =0 ; j < n ; j++)
    	{
    		char c = ' ';
    		if(i*j == 0) c = '#';
    		if(i == n-1 || j == n-1 ) c = '#';
    		if(i == j) c = '#';
    		if (i == n-j-1) c = '#';
    		if (i == n-j-1 && i <= n/2 ){ nime2 = true;}
    		if (i == j && i >= n/2 ){ nime2 = true;}
    		if(nime2) c = '#';
    		System.out.print(c);
    	}
    	System.out.println();
    }
  }

}
