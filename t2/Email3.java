import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Email3{

  public static boolean isValid(String email)
  {
    //System.err.println("cheacking : "+email);
    int atCount = 0;
    for (char c : email.toCharArray() ) {
      if(c=='@') atCount++;
      if(c=='!' || c==':' || c==',') return false;
    }
    //System.err.println("! , :  passed");
    if(atCount!=1) return false;
    //System.err.println("@  passed");

    int ats = email.indexOf('@');
    String local = email.substring(0,ats);
    //System.err.println("local is " + local);
    if(local.length()<1) return false;

    int dot = email.lastIndexOf('.');
    String domain = email.substring(dot+1,email.length());
    //System.err.println("domain is " + domain);
    if(domain.length()<1) return false;
    for (char c : domain.toCharArray() ){
      if(c>='A' && c<='Z') continue;
      if(c>='a' && c<='z') continue;
      return false;
    }

    String dom_name = email.substring(ats+1,dot);
    //System.err.println("dom_name is " + dom_name);
    if(dom_name.length()<1) return false;

    return true;
  }


  public static void main(String[] args){
    String inp = new java.util.Scanner(System.in).nextLine();
    String[] list = inp.split(":", 2);

    boolean valid = isValid(list[0]);
    if (!valid) System.out.println(-1);
    else{
      int counter = 0;
      String mail =  list[0];
      String[] others = list[1].split("(,|:| )");


      for (String s :others ) {
        String temp = s;
        if(temp.equals(mail)) {
          counter++;
          //System.err.println(s);
        }
      }
      System.out.println(counter);

    }
  }
}
