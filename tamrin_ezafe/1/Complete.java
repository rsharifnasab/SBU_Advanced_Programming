import java.util.*;
public class Complete{
 public static int mmaCalc(int num){
 	 int result = 0; 
 	        
 	         // find all divisors which divides 'num' 
 	         for (int i = 2; i <= Math.sqrt(num); i++) 
 	         { 
 	             // if 'i' is divisor of 'num' 
 	             if (num % i == 0) 
 	             { 
 	                 // if both divisors are same then  
 	                 // add it only once else add both 
 	                 if (i == (num / i)) 
 	                     result += i; 
 	                 else
 	                     result += (i + num / i); 
 	             } 
 	         } 
 	        
 	         // Add 1 to the result as 1 is also 
 	         // a divisor 
 	         return (result + 1); 
 }
 public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int mma = mmaCalc(n);
    boolean complete = n == mma;
    System.out.println(complete?"YES":"NO");
  }

}