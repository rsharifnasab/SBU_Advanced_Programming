public class A{
  public final String method1(){
    String className = getClass().getName();
    if(this instanceof B) return "A1";
    return className+"1";
  }
  public String method2(){
    String ans = getClass().getName();
    ans = ans + "2";
    return ans;
  }
}
