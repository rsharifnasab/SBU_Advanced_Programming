// Is_prime;
import java.util.*;

public class ARS_Prime 
{
public static void main(String[] args)
{
 Scanner input= new Scanner(System.in);
 int n=input.nextInt();
 //int a[]=new int[100];
 ArrayList<Integer> list=new ArrayList();
 for (int i = 0; i < 10000; i++) {
  if(Super_Prime(i))
   list.add(i);
  
 }
 System.out.print(list.get(n));

}

public static boolean Prime(int a)
{
 int k=0;
 if(a==1)
  return false;
 for (int i = 2; i <=a/2; i++) 
 {
  if(a%i==0)
  {
   k++;
   break;
  }
 }
 if(k==0)
  return true;
 else 
  return false;
}
public static boolean Super_Prime(int a)
{
 int k=0;
 int digit_Counter=0;
 int b=a;
 int c=a;
 
while(b>0)
{
 digit_Counter++;
 b=b/10;
 
}
Boolean array[]=new Boolean[digit_Counter];
for (int i = digit_Counter-1; i >=0; i--) 
{
 
 c=(int) (a/Math.pow(10, i));
 array[i]=(Prime(c));
 
}
for (int i = array.length-1; i >=0; i--)
{
 if(array[i]!=true)
  k=1;
}
if(k==0)
 return true;
else
 return false;
}
}
