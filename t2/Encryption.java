public class Encryption{

  public static void main(String[] args){
    StringBuilder inp = new StringBuilder(new java.util.Scanner(System.in).next());
    while (inp.length()>0){
      int len = inp.length() , index = (len+1)/2 -1 ;
      System.out.print(inp.charAt(index));
      inp.deleteCharAt(index);
      if((len)%2==0) // zoj boude hala fard shode!
        inp = inp.reverse();
    }
  }
}
