public class GapList{
  private static java.util.Scanner sc = new java.util.Scanner(System.in);
  private static  User [] users = new User[2000];
  private static int lastUser = 0;

  private static int name2ind(String fName,String lName){
    for (int i = 0 ; i < lastUser; i++) {
      if(users[i].getFName().equalsIgnoreCase(fName) && users[i].getLName().equalsIgnoreCase(lName)) return i;
    }
    return -1;
  }



  private static boolean join(){
    String fName = sc.next();
    String lName = sc.next();
    User temp = new User(fName,lName);
    while (sc.hasNextInt()) {
      temp.addNum(sc.next());
    }
    if(name2ind(fName,lName) != -1 ){ // users exists
      System.out.println("joinError");
      return false;
    }
    users[lastUser++] = temp;
    //System.err.println("user added!");
    return true;
  }

  private static int searchByNum(){
    String num = sc.next();
    for (int i = 0 ; i < lastUser; i++) {
      for (String n : users[i].number) {
        if(num.equals(n)) return i;
      }
    }
    return -1;
  }

  private static int searchByName(){
    String fName = sc.next();
    String lName = sc.next();
    return name2ind(fName,lName);
  }

  private static boolean search(){
    int index;
    if(sc.hasNextInt()) index = searchByNum();
    else index =  searchByName();
    if(index == -1) {
      System.out.println("searchError");
      return false;
    }
    System.out.println(users[index]);
    return true;
  }

  public static void main(String[] args) {
    while (sc.hasNext()) {
      String order = sc.next();
      if(order.equals("join")) join();
      if(order.equals("search")) search();
    }
  }
}

/*
  Arrays.sort(myTypes, MyType::compareThem);
  public static int compareThem(MyType a, MyType b) {
    return a.name.compareTo(b.name);
  }
*/
class User{
  private String fName;
  private String lName;
  String[] number = new String[10];
  private int numberCount = 0;
  private Friend[] friends = new Friend[1000];
  private int friendCount = 0;
  public User(String fName,String lName){
    this.fName = fName;
    this.lName = lName;
  }
  public String getFName(){ return fName;}
  public String getLName(){ return lName;}
  public void addNum(String num){ number[numberCount++] = num; }
  public String toString(){
    String [] tempNum = new String[numberCount];
    for (int i=0;i<numberCount;i++ ) {
      tempNum[i] =number[i];
    }
    return fName + " " + lName + " " + tempNum;
  }

}

class Friend{
  boolean special = false;
  boolean blocked = false;
  User contact;
  Friend(User contact){
    this.contact = contact;
  }
}
