import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Moadele2{
  public static boolean valid = false;
  public static String[] par;
  public static int xDar;

  public static boolean add(int a,String s,int b,int c){
    if( (a * b * c) < 0) return false;
    String regex  = par[xDar].replaceAll("#","[0-9]*");

    if (xDar ==0 )
      if(!Integer.toString(a).matches(regex)) return false;
    if (xDar ==1 )
      if(!Integer.toString(b).matches(regex)) return false;
    if (xDar ==2 )
      if(!Integer.toString(c).matches(regex)) return false;

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
      add(c-b,"+",b,c); // a+b = c || a = c - b
      add(c+b,"-",b,c); // a-b = c || a = b + c
      if(c%b ==0) add(c/b,"*",b,c); // a*b = c || a = c / b
      add(c*b,"/",b,c); // a/b = c || a = b * c
    }

    if (xDar==1){
      int a = Integer.parseInt(par[0]);
      int c = Integer.parseInt(par[2]);
      add(a,"+",c-a,c); // a+b = c || b = c - a
      add(a,"-",a-c,c); // a-b = c || b = a - c
      if(c%a ==0) add(a,"*",c/a,c); // a*b = c || b = c / a
      if(a%c ==0) add(a,"/",a/c,c); // a/b = c || b = a * c
    }



    if (xDar==2){
      int a = Integer.parseInt(par[0]);
      int b = Integer.parseInt(par[1]);
      add(a,"+",b,a+b); // a+b = c || a = c - b
      add(a,"-",b,a-b); // a-b = c || a = b + c
      add(a,"*",b,a*b); // a*b = c || a = c / b
      if(a%b ==0)add(a,"/",b,a/b); // a/b = c || a = b * c
    }

    if(valid == false) System.out.println(-1);
  }
}
