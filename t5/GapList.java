import java.util.*;

public class GapList{
  private static java.util.Scanner sc = new java.util.Scanner(System.in);
  private static  User [] users = new User[2000];
  private static int lastUser = 0;

  static String sortBy;

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
    while (sc.hasNextLong()) {
      String num = sc.next();
      if(searchByNum(num) != -1){
        System.out.println("joinError");
        return false;
      }
      temp.addNum(num);
    }
    if(name2ind(fName,lName) != -1 ){ // users exists
      System.out.println("joinError");
      return false;
    }

    users[lastUser++] = temp;
    System.err.println("user added! " + lastUser + " is " + temp);
    return true;
  }

  private static int searchByNum(String num){
    for (int i = 0 ; i < lastUser; i++) {
      for (String n : users[i].number) {
        if(n==null) continue;
        long l1 = Long.parseLong(n);
        long l2 = Long.parseLong(num);
        if(l1==l2) return i;
      }
    }
    return -1;
  }

  private static int searchByName(){
    String fName = sc.next();
    String lName = sc.next();
    int last = lName.length()-1;
    if(lName.charAt(last) == ':') lName = lName.substring(0,last);
    return name2ind(fName,lName);
  }


  private static int search(){
    int index;
    if(sc.hasNextLong()) {
      String num = sc.next();
      index = searchByNum(num);
    }
    else index = searchByName();
    return index;
  }

  private static boolean remove(){
    int userIndex = search();
    if(userIndex == -1){
      System.out.println("addContactError");
      return false;
    }
    User toDel = users[userIndex];
    for (int i = lastUser; i > userIndex; i-- ) {
      users[i-1] = users[i];
    }
    lastUser--;
    for (int i = 0 ; i < lastUser; i++) {
      if(users[i] == null) continue;
      for (int j = 0; j < users[i].friends.length; j++) {
        if(users[i].friends[j] == null) continue;
        if(users[i].friends[j].contact == toDel){
          for (int l = users[i].friendCount; l>j; l-- ) {
            users[i].friends[l-1] = users[i].friends[l]; //TODO-
          }
        }
      }
    }
    return true;
  }

  private static boolean addContact(){
    int userIndex = search();
    int friendIndex = search();
    if(userIndex == -1 || friendIndex == -1 || friendIndex == userIndex || users[userIndex].isFriend(users[friendIndex])){
      System.out.println("addContactError");
      return false;
    }
    users[userIndex].addFriend(users[friendIndex]);
    return true;
  }

  private static boolean searchPrint(){
    int index = search();
    if(index == -1) {
      System.out.println("searchError");
      return false;
    }
    System.out.println(users[index]);
    return true;
  }


  private static void listUsers(){
    sortBy = sc.next();
    System.err.println(lastUser+" listing users : "+sortBy);
    for (User u: users) {
      if(u!=null) System.out.println(u);

    }
    System.out.println(" - - - ---------");
    Arrays.sort(users, new Comparator<User>() {
    @Override
    public int compare(User o1, User o2) {

        if (o1 == null && o2 == null) { return 0; }
        if (o1 == null) { return 1; }
        if (o2 == null) { return -1;}

        if (sortBy.equals("first-name")){
          if(o1.getFName().equalsIgnoreCase(o2.getFName())) return o1.getLName().compareTo(o2.getLName());
          return o1.getFName().compareTo(o2.getFName());
        }
        if(o1.getLName().equalsIgnoreCase(o2.getLName())) return o1.getFName().compareTo(o2.getFName());
        return o1.getLName().compareTo(o2.getLName());

    }});

    for (User u: users) {
      if(u!=null) System.out.println(u);
    }
  }

  public static void main(String[] args) {
    while (sc.hasNext()) {
      String order = sc.next();
      if(order.equals("join")) join();
      if(order.equals("search")) searchPrint();
      if(order.equals("addContact")) addContact();
      if(order.equals("remove")) remove();
      if(order.equals("listUsers")) listUsers();

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
          Friend[] friends = new Friend[1000];
          int friendCount = 0;
  public User(String fName,String lName){
    this.fName = fName;
    this.lName = lName;
  }
  public String getFName(){ return fName;}
  public String getLName(){ return lName;}
  public void addNum(String num){ this.number[numberCount++] = num; }
  public void addFriend(User friend){ this.friends[friendCount++] = new Friend(friend); }

  public boolean isFriend(User friend){
    for (Friend f : friends) {
      if(f==null) continue;
      if(friend == f.contact) return true; //TODO
    }
    return false;
  }


  @Override
  public String toString(){
    String numS = "[";
    for (int i=0;i<numberCount;i++ ) {
      numS = numS + number[i] + ", ";
    }
    int goodLen = (numS.length()>2)?numS.length()-2 : numS.length();
    numS = numS.substring(0,goodLen) + "]";
    return fName + " " + lName + " " + numS;
  }



}

class Friend{
  private boolean special = false;
  private boolean blocked = false;
  User contact;
  Friend(User contact){
    this.contact = contact;
  }
  public boolean isSpecial(){ return special; }
  public void makeSpecial(){

  }
  public void makeUnSpecial(){

  }
  public boolean isBlocked() { return blocked; }
  public void block(){

  }
  public void unBlock(){

  }

}
