import java.util.regex.Matcher;
import java.util.regex.Pattern;
//import javax.mail.internet.InternetAddress;
public class Email{

  public static boolean isValid(String email)
    {
        String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\."+
                            "[a-zA-Z0-9_+&*-]+)*@" +
                            "(?:[a-zA-Z0-9-]+\\.)+[a-z" +
                            "A-Z]{2,7}$";

        Pattern pat = Pattern.compile(emailRegex);
        if (email == null)
            return false;
        return pat.matcher(email).matches();
    }

  public static void main(String[] args){
    String inp = new java.util.Scanner(System.in).nextLine();
    String[] list = inp.split(":", 2);
    //System.out.println(list[0] + "   " + list[1]);
    boolean valid = isValid(list[0]);
    if (!valid) System.out.println(-1);
    else{
      String mail =  list[0] ;
      String other = " " + list[1] + " " ;

      String replaced = other.replaceAll("[\\s:,!]+"+mail+"[\\s:,!]+", "");

      int count = other.length() - replaced.length();

      System.err.println(replaced);
      System.err.println(other.length() + " converted to : "+replaced.length());
      System.out.println(count/mail.length());
    }
  }
}
