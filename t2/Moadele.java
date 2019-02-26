import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Moadele{
  public static int max = 99_999_999;
  public static boolean valid = false;
  public static String[] par;
  public static int xDar;

  public static boolean add(int a,String s,int b,int c){
    String regex  = par[xDar].replaceAll("#","[0-9]*");
    boolean ok = false;
    if (xDar ==0 )
      if(Integer.toString(a).matches(regex)) ok = true;
    if (xDar ==1 )
      if(Integer.toString(b).matches(regex)) ok = true;
    if (xDar ==2 )
      if(Integer.toString(c).matches(regex)) ok = true;

    if (!ok) return false;

    System.out.println(a + " " + s + " " + b + " = " + c );
    valid = true;
    return true;
  }
  public static void main(String[] args){

    String inp = new java.util.Scanner(System.in).nextLine();
    String[] list = inp.split(" ");
    par = new String[3];
    par[0] = list[0];
    par[1] = list[2];
    par[2] = list[4];

    for (int i=0;i<par.length;i++ )
      if(par[i].contains("#")) xDar = i;

    if (xDar==0){
      int b = Integer.parseInt(par[1]);
      int c = Integer.parseInt(par[2]);
      for (int i = 0;i<max ;i++ ) {
        int a = i; //Integer.parseInt(par[xDar].replaceAll("#",Integer.toString(i)));
        if(a+b==c) add(a,"+",b,c);
      }
      for (int i = 0;i<max ;i++ ) {
        int a = i; // Integer.parseInt(par[xDar].replaceAll("#",Integer.toString(i)));
        if(a-b==c) add(a,"-",b,c);
      }
      for (int i = 0;i<max ;i++ ) {
        int a = i; //Integer.parseInt(par[xDar].replaceAll("#",Integer.toString(i)));
        if(a*b==c) add(a,"*",b,c);
      }
      for (int i = 0;i<max ;i++ ) {
        int a = i; //Integer.parseInt(par[xDar].replaceAll("#",Integer.toString(i)));
        if(a/b==c && a%b ==0) add(a,"/",b,c);
      }
    }


    if (xDar==1){
      int a = Integer.parseInt(par[0]);
      int c = Integer.parseInt(par[2]);

      for (int i = 0;i<max ;i++ ) {
        int b = i; //Integer.parseInt(par[xDar].replaceAll("#",Integer.toString(i)));
        if(a+b==c) add(a,"+",b,c);
      }
      for (int i = 0;i<max ;i++ ) {
        int b = i; // Integer.parseInt(par[xDar].replaceAll("#",Integer.toString(i)));
        if(a-b==c) add(a,"-",b,c);
      }
      for (int i = 0;i<max ;i++ ) {
        int b = i; //Integer.parseInt(par[xDar].replaceAll("#",Integer.toString(i)));
        if(a*b==c) add(a,"*",b,c);
      }
      for (int i = 1;i<max ;i++ ) {
        int b = i; //Integer.parseInt(par[xDar].replaceAll("#",Integer.toString(i)));
        if(a/b==c && a%b ==0) add(a,"/",b,c);
      }
    }



    if (xDar==2){
      int a = Integer.parseInt(par[0]);
      int b = Integer.parseInt(par[1]);
      for (int i = 0;i<max ;i++ ) {
        int c = i; //Integer.parseInt(par[xDar].replaceAll("#",Integer.toString(i)));
        if(a+b==c) add(a,"+",b,c);
      }
      for (int i = 0;i<max ;i++ ) {
        int c = i; // Integer.parseInt(par[xDar].replaceAll("#",Integer.toString(i)));
        if(a-b==c) add(a,"-",b,c);
      }
      for (int i = 0;i<max ;i++ ) {
        int c = i; //Integer.parseInt(par[xDar].replaceAll("#",Integer.toString(i)));
        if(a*b==c) add(a,"*",b,c);
      }
      for (int i = 0;i<max ;i++ ) {
        int c = i; //Integer.parseInt(par[xDar].replaceAll("#",Integer.toString(i)));
        if(a/b==c && a%b ==0) add(a,"/",b,c);
      }
    }

    if(valid == false) System.out.println(-1);

  }
}
