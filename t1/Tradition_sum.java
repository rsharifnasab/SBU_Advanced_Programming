import java.util.Scanner;
public class Tradition_sum
{
   public static void main(String [] args)
	 {
		Scanner s = new Scanner(System.in);
		int finger = s.nextInt();
		int hands = s.nextInt();

		int a = s.nextInt();
		int b = s.nextInt();

		int sum = a+b;
		int all_fingers = finger * hands;

		int ans = sum % all_fingers;
		if (sum!=0 && ans == 0 ) ans = all_fingers;

		System.out.println(ans);
   }
}
