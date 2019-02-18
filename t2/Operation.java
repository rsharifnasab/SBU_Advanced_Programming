public class Operation{

  public static StringBuilder cleaner(StringBuilder inp){
    StringBuilder ans = new StringBuilder("");
    for(int i=0;i<inp.length();i++){
      char c = inp.charAt(i);
      if(c>='A' && c<='z') ans.append(c);
      else if(c>='0' && c<='9') ans.append(c);
    }
    return ans;
  }
  public static void main(String[] args){
    StringBuilder inp = new StringBuilder(new java.util.Scanner(System.in).next());
    inp = cleaner(inp);
    System.out.println(inp);
  }
}
