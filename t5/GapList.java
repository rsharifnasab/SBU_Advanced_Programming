public class GapList{
  private static java.util.Scanner sc = new java.util.Scanner(System.in);
  private static  User [] users = new User[2000];
  private static int lastUser = 0;
  private static int name2ind(String fName,String lName){
    for (int i = 0 ; i < lastUser; i++) {
      if(users[i].getFName().equals(fName) && users[i].getLName().equals(lName)) return i;
    }
    return -1;
  }
  private static boolean join(){
    String fName = sc.next();
    String lName = sc.next();
    if(name2ind(fName,lName) != -1 ){ // users exists
      System.out.println("joinError");
      return false;
    }
    users[lastUser] = new User(fName,lName);
    while (sc.hasNextInt()) {
      lastUser.addNum(sc.next());
    }
    lastUser++;
    return true;
  }


  public static void main(String[] args) {
    while (sc.hasNext()) {
      String order = sc.next();
      if(order.equals("join")) join();

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
  private String[] Number = new String[10];
  private int numberCount = 0;
  private Friend[] friends = new Friend[1000];
  private int friendCount = 0;
  public User(String fName,String lName){
    this.fName = fName;
    this.lName = lName;
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
