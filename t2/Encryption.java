
import java.lang.*;
public class Encryption{

  public static void main(String[] args){
    java.util.Scanner scanner = new java.util.Scanner(System.in);
    StringBuilder inp = new StringBuilder(scanner.next());

    while (inp.length()>=1){
      int len = inp.length();
      int index = (len+1)/2 -1 ;
      System.out.print(inp.charAt(index));
      inp.deleteCharAt(index);
      if((len)%2==0){
        inp = inp.reverse();
      }

    }

  }


}
