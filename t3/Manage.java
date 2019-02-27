public class Manage{

  public static Emplo[] db = new Emplo[300];
  public static int last =0;
  public static java.util.Scanner sc ;
  public static void hire(){
    String name = sc.next();
    String degree = sc.next();
    db[last] = new Emplo(name,degree);
    last++; //TODO

  }


  public static void pay(){
    String name = sc.next();
    int ind = name2index(name);
    db[ind].pay();
  }

  public static void get(){
    String name = sc.next();
    int ind = name2index(name);
    int quan = sc.nextInt();
    if(!db[ind].get(quan))
    System.out.println("NotEnoughMoney");
  }

  public static void loan(){
    String name = sc.next();
    int ind = name2index(name);

    if(db[ind].loan())
      System.out.println("accepted");
    else
      System.out.println("rejected");
  }

  public static void special(){
    String name = sc.next();
    int ind = name2index(name);
    db[ind].makeSpecial();
  }


  public static void promote(){
    boolean cermony = false;
    for (int i = 0;i < last ;i++ )
      cermony = (db[i].promote() | cermony);
    if(cermony) cermony();
  }


  public static void regress(){
    for (int i = 0;i < last ;i++ )
    db[i].regress();
  }


  public static void cermony(){
    for (int i = 0;i < last ;i++ )
    db[i].revam();
  }

  public static void report(){
    String degree = sc.next();
    for (int i = 0;i < last ;i++ )
    db[i].report(degree);
  }

  public static int name2index(String name){
    for (int i = 0;i < 300 ;  i++ ) {
      if(db[i].getName().equals(name)) return i;
    }
    return -1; //TODO
  }

  public static void main(String[] args) {
    sc = new java.util.Scanner(System.in);

    do{
      String order = sc.next();
      if(order.equals("hire") ) hire();
      if(order.equals("pay")) pay();
      if(order.equals("get")) get();
      if(order.equals("special")) special();
      if(order.equals("loan")) loan();
      if(order.equals("promote")) promote();
      if(order.equals("regress")) regress();
      if(order.equals("report")) report();
      //System.out.println(db[0].getMoney());
    }while(sc.hasNext());
  }

}
// still god enough


class Emplo{
  public String degree;
  private String name;
  private boolean Special;
  private int money;
  private boolean vam;
  private boolean fired;
  private boolean retired;

  public Emplo(String name,String degree){
    money = 0;
    Special = false;
    fired = false;
    retired = false;
    vam = false;
    this.name = name;
    this.degree = degree;
  }

  public String getName(){ return name;}

  public int getSalary(){
    if(degree.equals("Worker")) return 100;
    if(degree.equals("Foreman")) return 300;
    if(degree.equals("Supervisor")) return 700;
    if(degree.equals("Leader")) return 900;
    return 0;
  }

  public void pay(){
    money = money + getSalary();
  }

  public boolean promote(){
    boolean cermony = false;
    if(money <= 2* getSalary())return cermony;
    if(degree.equals("Worker")) degree = "Foreman";
    else if(degree.equals("Foreman")) degree = "Supervisor";
    else if(degree.equals("Supervisor")) degree = "Leader";
    else if(degree.equals("Leader")) {
      retired = true;
      if(Special) cermony = true;
    }
    return cermony;
  }

  public void report(String degree){
    if (this.degree.equals(degree) == false) return;
    if(Special) System.out.print("special ");
    System.out.print(getName());
    if(!fired)System.out.print("("+degree+")"); // TODO
    System.out.print(" "+getMoney()+" ");
    System.out.println();
  }


  public void regress(){
    if(money >=  getSalary() / 2 )return; // TODO
    if(degree.equals("Worker")) fired = true;//degree = "Fired";
    else if(degree.equals("Foreman")) degree = "Worker";
    else if(degree.equals("Supervisor")) degree = "Foreman";
    else if(degree.equals( "Leader")) degree = "Supervisor";
  }


  public boolean loan(){
    if(vam) return false;
    vam = true;
    money= money + getSalary()*3;
    return true;
  }


  public void revam(){
    if (Special) vam = false;
  }

  public boolean get(int quan){
    if(money > quan){
      money-=quan;
      return true;
    }
    return false;
  }

  public boolean special(){ return Special;}
  public void makeSpecial(){ Special = true;}
  public int getMoney(){
    return money;
  }
}
