public class Operation{

  public static StringBuilder cleaner(StringBuilder inp){
    StringBuilder ans = new StringBuilder("");
    for(int i=0;i<inp.length();i++){
      char c = inp.charAt(i);
      if(c>='A' && c<='Z') ans.append(c);
      else if(c>='a' && c<='z') ans.append(c);
      else if(c>='0' && c<='9') ans.append(c);
    }
    return ans;
  }

  public static void main(String[] args){
    StringBuilder inp = new StringBuilder(new java.util.Scanner(System.in).next());
    inp = cleaner(inp);
    int maxPal = 0 , len = inp.length();
    for (int i=0;i<len;i++ ) {
      for (int j =i;j<=len;j++ ) {
        String mainSubStr = inp.substring(i,j);
        String revSubStr = new StringBuilder(inp.substring(i,j)).reverse().toString();
        if(mainSubStr.equals(revSubStr))
          maxPal = (maxPal < j-i)? j-i : maxPal;
      }
    }
    System.out.println(inp);
    System.out.println(maxPal);
  }
}
