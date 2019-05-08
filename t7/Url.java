import java.util.*;
import java.util.regex.*;
public class Url{
  final static Integer MAX = 100;
  static String[] keys;
  static String[][] values;
  static int[] valueCount;
  static Integer lastKey = 0;

  public static Integer key2Index(String key){
    for (int i =0; i < MAX; i++ ) {
      if(key.equals(keys[i])) return i;
    }
    return -1;
  }

  public static Boolean addValue2Index(String value,Integer index){
    for (int i = 0;i < valueCount[index]; i++ ) {
      if(value == null ) System.err.println("va;ue is null");
      if(values[index] == null ) System.err.println("va;ue is null");
      if(value.equals(values[index][i])) return false;
    }

    values[index][valueCount[index]++] = value;
    return true;
  }

  public static String printKey(int index){
    String key = keys[index];
    String ans = "";
    ans+=("'" + key + "' = ");
    if(values[index][1] == null) ans+=("'" + values[index][0] + "'");
    else{
      ans+=("[");
      for (String value : values[index]) {
        if(value ==null) break;
        ans+=("'" + value + "' , ");
      }
      ans = ans.substring(0,ans.length()-3);
      ans+=("]");
    }
    return (ans);
  }

  public static void main(String[] args) {
    keys = new String[MAX];
    values = new String[MAX][MAX];
    valueCount = new int[MAX];

    Scanner scanner = new Scanner(System.in);
    String input = scanner.nextLine();
    Pattern pattern = Pattern.compile("(\\w+)=?([^&]+)?");
    pattern = Pattern.compile("(\\w+)=?([^&]+)?");
    Matcher matcher = pattern.matcher(input);

    while (matcher.find()) {
      String tempKey = matcher.group(1);
      String tempValue = matcher.group(2);
      Integer index = key2Index(tempKey);
      if(index == -1) {
        keys[lastKey] = tempKey;
        addValue2Index(tempValue,lastKey++);
      }
      else addValue2Index(tempValue,index);
    }
    String ans = ("{");
    for (int i =0;i  < MAX ;i++ ) {
      if(keys[i] == null) break;
      ans += printKey(i) + " , ";
    }
    ans = ans.substring(0,ans.length()-3) + "}";
    System.out.println(ans);
  }
}
