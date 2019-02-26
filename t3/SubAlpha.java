import java.util.*;
class SubAlpha{

  public static ArrayList<Character> ToSubAlpha(String inp){
    ArrayList<Character> ans = new ArrayList<Character>();
    int len = inp.length();

    for (int i=0; i<len; i++) {
       char c = Character.toUpperCase(inp.charAt(i));
       ans.add(c);
    }

    java.util.Collections.sort(ans);

    len = ans.size();
    for (int i=len-1; i>0; i--) {
       if(ans.get(i)==ans.get(i-1) ){
         ans.remove(i);
         //i++;
       }
    }
    return ans;
  }

  public static void main(String[] args){
    java.util.Scanner sc = new java.util.Scanner(System.in);
    int n = sc.nextInt();
    String main = sc.next();
    List<Character> clean = ToSubAlpha(main);
    System.err.println(clean.toString());
    for (int i=0; i<n; i++) {
      List<Character> temp = ToSubAlpha(sc.next());
      boolean sahih = temp.equals(clean);
      System.out.println(sahih?"Yes":"No");
    }


  }
}
