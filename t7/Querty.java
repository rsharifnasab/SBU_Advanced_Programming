import java.util.*;
import java.util.regex.*;
public class Querty{

  private static String setIndex2String(SortedSet<String> s,int index){
    Iterator<String> it = s.iterator();
    String ans = null;
    for(int i =0; i < index; i++){
      ans = it.next();
    }
    return ans;
  }
  public static String printKey(String key){
    SortedSet<String> set = map.get(key);
    String ans = "";
    ans+=("'" + key + "' = ");
    if(set.size()<2) ans+=("'" + setIndex2String(set,0) + "'");
    else{
      ans+=("[");
      for (String value : set) {
        ans+=("'" + value + "' , ");
      }
      ans = ans.substring(0,ans.length()-3);
      ans+=("]");
    }
    return (ans);
  }


  final static Integer MAX = 100;
  static SortedMap<String,SortedSet<String>> map = new TreeMap<>();

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    String inputString = scanner.nextLine();
    scanner.close();
    String [] queryAndParam = inputString.split("&");
    String [][] QP = new String[queryAndParam.length][2];
    for (int i =0; i< queryAndParam.length;i++ ) {
      QP[i] = queryAndParam[i].split("=");
      SortedSet<String> temp = map.get(QP[i][0]);
      if(temp == null) temp = new TreeSet<String>();
      temp.add(QP[i][1]);
      map.put(QP[i][0],temp);
    }
    String ans = ("{");
    for (String key : map.keySet()) {
      ans+= printKey(key);
    }
    //ans = ans.substring(0,ans.length()-3) + "}";
    System.out.println(ans);

  }

}
