import java.util.*;

public class GapList{
  private static Scanner sc = new Scanner(System.in);
  private static  User [] users = new User[2000];
  private static int lastUser = 0;

  private static int name2ind(String fName,String lName){
    for (int i = 0; i < lastUser; i++) {
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
      if(searchByNum(num) == -1){ /* ok */ }
      else{
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
    return true;
  }

  private static int searchByNum(String num){
    for (int i = 0; i < lastUser; i++) {
      for (String n : users[i].number) {
        if(n==null) continue;
        if(num.equals(n)) return i;
      }
    }
    return -1;
  }

  private static int searchByName(){
    String fName = sc.next();
    String lName = sc.next();
    int last = lName.length()-1;
    if(lName.charAt(last) == ':') lName = lName.substring(0,last); //TODO
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
      System.out.println("removeError");
      return false;
    }
    User toDel = users[userIndex];
    users[userIndex] = null;
    for (int i = userIndex; i < lastUser; i++ ) {
      users[i] = users[i+1];
    }
    users[lastUser] = null;
    lastUser--;
    for (int i = 0 ; i < lastUser; i++) {
      //if(users[i] == null) continue;
      for (int j = 0; j < users[i].friends.length; j++) {
        if(users[i].friends[j] == null) continue;
        if(users[i].friends[j].contact == toDel){
          for (int l = j; l<users[i].friendCount; l++ ) {
            users[i].friends[l] = users[i].friends[l+1]; //TODO-
          }
          users[i].friendCount--;
        }
      }
    }
    return true;
  }


  private static boolean isNum(String s) {
    try {
        Long.parseLong(s);
    } catch(NumberFormatException e) {
        return false;
    } catch(NullPointerException e) {
        return false;
    }
    return true;
  }

  private static int search2(){
      String inp = sc.next();
      String inp2 = null;
      int last = inp.length()-1;
      if(inp.charAt(last)==':'){
        inp = inp.substring(0,last); //TODO
        //if(isNum(inp))
        return searchByNum(inp);
      }
      inp2 = sc.next();
      last = inp2.length()-1;
      inp2 = inp2.substring(0,last);
      return name2ind(inp,inp2);
  }

  private static boolean addContact(){ //TODO
    int userIndex = search2();
    int friendIndex = search();

    if(userIndex == -1 || friendIndex == -1 || friendIndex == userIndex){
      System.out.println("addContactError");
      return false;
    }

    if(users[userIndex].isFriend(users[friendIndex])) {
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

  public static boolean listContacts(){
    String sortBy = sc.next();
    int userIndex = search();
    if( userIndex == -1 ){
      System.out.println("listContactsError");
      return false;
    }

    Arrays.sort(users[userIndex].friends, new Comparator<Friend>() {
      @Override
      public int compare(Friend o1, Friend o2) {

          if (o1 == null && o2 == null) { return 1; }
          if (o1 == null) { return 1; }
          if (o2 == null) { return -1;}

          if(o1.isSpecial() && !o2.isSpecial()) return -1;
          if(!o1.isSpecial() && o2.isSpecial()) return +1;

          if (sortBy.equals("first-name")){
            if(o1.contact.getFName().equalsIgnoreCase(o2.contact.getFName())) return o1.contact.getLName().compareToIgnoreCase(o2.contact.getLName());
            return o1.contact.getFName().compareToIgnoreCase(o2.contact.getFName());
          }

          if(o1.contact.getLName().equalsIgnoreCase(o2.contact.getLName())) return o1.contact.getFName().compareToIgnoreCase(o2.contact.getFName());
          return o1.contact.getLName().compareToIgnoreCase(o2.contact.getLName());

      }});

    for (Friend f : users[userIndex].friends) {
      if(f == null) continue;
      if (f.isBlocked()) continue;
      System.out.println(f.contact);
    }
    return true;
  }


  private static void listUsers(){
    String sortBy = sc.next();

    Arrays.sort(users, new Comparator<User>() {
    @Override
    public int compare(User o1, User o2) {

        if (o1 == null && o2 == null) { return 1; }
        if (o1 == null) { return 1; }
        if (o2 == null) { return -1;}

//compareToIgnoreCase()
        if (sortBy.equals("first-name")){
          if(o1.getFName().equalsIgnoreCase(o2.getFName())) return o1.getLName().compareToIgnoreCase(o2.getLName());
          return o1.getFName().compareToIgnoreCase(o2.getFName());
        }
        if(o1.getLName().equalsIgnoreCase(o2.getLName())) return o1.getFName().compareToIgnoreCase(o2.getFName());
        return o1.getLName().compareToIgnoreCase(o2.getLName());

    }});

    for (User u: users) {
      if(u!=null) System.out.println(u);
    }
  }

  private static boolean block(){
    int userIndex = search2();
    int friendIndex = search();
    if( userIndex == -1 || friendIndex == -1 || friendIndex == userIndex){
      System.out.println("blockError");
      return false;
    }
    if(users[userIndex].isFriend(users[friendIndex]) == false){
      System.out.println("blockError");
      return false;
    }
    int fIndex = users[userIndex].friend2ind(users[friendIndex]);
    users[userIndex].friends[fIndex].block();
    return true;
  }
  private static boolean unBlock(){
    int userIndex = search2();
    int friendIndex = search();
    if( userIndex == -1 || friendIndex == -1 || friendIndex == userIndex){
      System.out.println("unblockError");
      return false;
    }
    if(users[userIndex].isFriend(users[friendIndex]) == false){
      System.out.println("unblockError");
      return false;
    }
    int fIndex = users[userIndex].friend2ind(users[friendIndex]);
    users[userIndex].friends[fIndex].unBlock();
    return true;
  }


private static boolean special(){
  int userIndex = search2();
  int friendIndex = search();
  if( userIndex == -1 || friendIndex == -1 || friendIndex == userIndex){
    System.out.println("specificError");
    return false;
  }
  if(users[userIndex].isFriend(users[friendIndex]) == false){
    System.out.println("specificError");
    return false;
  }
  int fIndex = users[userIndex].friend2ind(users[friendIndex]);
  users[userIndex].friends[fIndex].makeSpecial();
  return true;
}
private static boolean unSpecial(){
  int userIndex = search2();
  int friendIndex = search();
  if( userIndex == -1 || friendIndex == -1 || friendIndex == userIndex){
    System.out.println("unspecificError");
    return false;
  }
  if(users[userIndex].isFriend(users[friendIndex]) == false){
    System.out.println("unspecificError");
    return false;
  }
  int fIndex = users[userIndex].friend2ind(users[friendIndex]);
  users[userIndex].friends[fIndex].makeUnSpecial();
  return true;
}


  public static void main(String[] args) {
    while (sc.hasNext()) {
      String order = sc.next();
      if(order.equalsIgnoreCase("join")) join();
      if(order.equalsIgnoreCase("search")) searchPrint();
      if(order.equalsIgnoreCase("addContact")) addContact();
      if(order.equalsIgnoreCase("remove")) remove();
      if(order.equalsIgnoreCase("listUsers")) listUsers();
      if(order.equalsIgnoreCase("block")) block();
      if(order.equalsIgnoreCase("unblock")) unBlock();
      if(order.equalsIgnoreCase("specific")) special();
      if(order.equalsIgnoreCase("unspecific")) unSpecial();
      if(order.equalsIgnoreCase("listContacts")) listContacts();
    }
  }
}

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
  public int friend2ind(User f){
    for(int i = 0; i < friendCount; i++){
      if(friends[i].contact == f) return i;
    }
    return -1;
  }

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
    blocked = false;
    special = true;
  }
  public void makeUnSpecial(){
    special = false;
  }
  public boolean isBlocked() { return blocked; }
  public void block(){
    special = false;
    blocked = true;
  }
  public void unBlock(){
  //  special = false;
    blocked = false;
  }

}
// file is over
