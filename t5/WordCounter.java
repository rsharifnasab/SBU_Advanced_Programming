public class WordCounter{

  public static void main(String[] args) {
    java.util.Scanner sc = new java.util.Scanner(System.in);
    String all = sc.nextLine();
    String[] arr = all.split(" ");

    java.util.Arrays.sort(arr);

    java.util.ArrayList<DB> db = new java.util.ArrayList<DB>();

    for (int i=0;i<arr.length;i++ ) {
      if(arr[i] == null) continue;
      int tedad = 1;
      for (int j=i+1;j<arr.length;j++ ) {
        if (arr[j]!=null && arr[i].equals(arr[j])) {
          arr[j] = null;
          tedad++;
        }
      }
      db.add(new DB(arr[i],tedad));
    }
    System.out.print("{");
    for (int i=0;i < db.size() -1 ;i++ ) {
      System.out.print(db.get(i) + " , ");
    }
    System.out.print(db.get(db.size()-1));
    System.out.println("}");

    //System.out.println(db);


  }
}

class DB{
  public String word;
  public int tedad;
  public DB(String word,int tedad){
    this.word = word;
    this.tedad = tedad;
  }
  public String toString(){
    return "\'"+word + "\'" + " = " + tedad;
  }
}
