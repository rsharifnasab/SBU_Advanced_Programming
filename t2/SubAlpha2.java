import java.util.*;
class SubAlpha2{

  public static char[] ToSubAlpha(String inp){

    int len = inp.length();
    char[] ans = new char[len];
    //Arrays.fill(ans,'-');
    for (int i=0; i<len; i++) {
       char c = Character.toUpperCase(inp.charAt(i));
       ans[i]=c;
    }

    Arrays.sort(ans);

    int por = len;
    for (int i=len-1; i>0; i--) {
       if(ans[i]==ans[i-1]){
         ans[i]='-';
         por--;
       }
    }

    char [] ansFinal = new char[por];
    int index = 0;
    for (int i=0;i<len;i++) {
      if (ans[i] == '-') continue;
      ansFinal[index] = ans[i];
      index++;
    }
    Arrays.sort(ansFinal);

    for (char c : ansFinal ) {
      ///System.out.println(c);
    }
    return ansFinal;
  }

  public static void main(String[] args){
    java.util.Scanner sc = new java.util.Scanner(System.in);
    char c = '\0';
    int n = sc.nextInt();
    String main = sc.next();
    char[] clean = ToSubAlpha(main);
    //System.err.println("main clean is : "+clean.toString());
    for (int i=0; i<n; i++) {
      char[] temp = ToSubAlpha(sc.next());
      boolean sahih = Arrays.equals(temp,clean);
      System.out.println(sahih?"Yes":"No");
    }


  }
}
