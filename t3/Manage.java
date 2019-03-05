public class Manage{

  public static Emplo[] db = new Emplo[400];
  public static java.util.Scanner sc ;
  public static int last = 0;
  public static void hire(){
    String name = sc.next();
    String degree = sc.next();
    db[last++] = new Emplo(name,degree);
  }


  public static void pay(){
    String name = sc.next();
    int ind = name2index(name);
    db[ind].pay();
  }

  public static void get(){
    String name = sc.next();
    int ind = name2index(name);
    long quan = sc.nextInt();
    if(db[ind].get(quan) == false)
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
      if(db[i].promote()) cermony = true;
    if(cermony) cermony(); //TODO
  }


  public static void regress(){
    for (int i = 0; i < last; i++ )
      db[i].regress();
  }

  public static void cermony(){
    for (int i = 0;i < last ;i++ )
      db[i].revam();//TODO
  }

  public static void report(){
    String degree = sc.next();
    for (int i = 0;i < last ;i++ )
      db[i].report(degree);
  }

  public static int name2index(String name){
    for (int i = 0;i < 400 ; i++ ) {
      if(db[i].getName().equals(name)) return i;
    }
    return -1; //raise error
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
    }while(sc.hasNext());
  }

}

class Emplo{
  private String degree;
  private String name;
  private boolean Special;
  private long money;
  private boolean vamed;
  private boolean fired;
  private boolean retired;

  public Emplo(String name,String degree){
    money = 0;
    Special = false;
    fired = false;
    retired = false;
    vamed = false;
    this.name = name;
    this.degree = degree;
  }

  public String getName(){ return name; }

  public long getSalary(){
    if (retired || fired) return 0;
    if(degree.equals("Worker")) return 100;
    if(degree.equals("Foreman")) return 300;
    if(degree.equals("Supervisor")) return 700;
    if(degree.equals("Leader")) return 900;
    return 0;
  }

  public void pay(){
      if (retired || fired) return;
      money += getSalary();
   }

  public boolean promote(){
    if (fired || retired) return false;
    if(money <= 2* getSalary())return false;
    if(degree.equals("Worker")) degree = "Foreman";
    else if(degree.equals("Foreman")) degree = "Supervisor";
    else if(degree.equals("Supervisor")) degree = "Leader";
    else if(degree.equals("Leader")) {
      this.retired = true;
      if(Special) return true;
      return false;
    }
    return false;
  }

  public void report(String degree){
    if ( (fired && degree.equals("Fired")) || (retired & degree.equals("Retired")) )
    {
      if(Special) System.out.print("special ");
      System.out.print(getName());
      if (fired) System.out.print("(Fired)");
      else if (retired) System.out.print("(Retired)");
      System.out.print(" "+getMoney());
      System.out.println();
      return; //end of reporting fired and retired
    }
    if(this.degree.equals(degree) == false) return;
    if(retired || fired) return;
    if(Special) System.out.print("special ");
    System.out.print(getName());
    System.out.print("("+degree+")");
    System.out.print(" "+getMoney());
    System.out.println();
  }


  public void regress(){
    if (retired || fired) return;
    if(money >=  (getSalary() / 2) )return; // TODO
    if(degree.equals("Worker")) fired = true;//or degree = "Fired";
    else if(degree.equals("Foreman")) degree = "Worker";
    else if(degree.equals("Supervisor")) degree = "Foreman";
    else if(degree.equals( "Leader")) degree = "Supervisor";
  }


  public boolean loan(){
    if(retired || retired) return false;
    if(vamed) return false;
    if(!Special) return false;
    vamed = true;
    money = money + getSalary()*3;
    return true;
  }


  public void revam(){
    if (fired || retired) return;
    if (Special) vamed = false;  //TODO
  }

  public boolean get(long quan){
    if(money - quan >= 0){
      money-=quan;
      return true;
    }
    return false;
  }

  public void makeSpecial(){ Special = true;}
  public long getMoney(){ return money; }
}
