public class Manage{

  public static Emplo[] db = new Emplo[300];
  public static int last =0;
  public static java.util.Scanner sc ;
  public static void hire(){
    String name = sc.next();
    String degree = sc.next();
    db[last++] = new Emplo(name,degree);
  }


  public static void pay(){
    String name = sc.next();
    int ind = name2index(name);
    System.err.println("paying "+ind);
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
      for (int i = 0;i < last ;i++ )
        db[i].promote();
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


    public static class Emplo{
      public static String degree;
      private static String name;
      private static boolean Special;
      private static int money;
      private static boolean vam;
      private static boolean fired;
      private static boolean retired;
      public Emplo(String name,String degree){
        money = 0;
        Special = false;
        fired = false;
        retired = false;
        vam = false;
        this.name = name;
        this.degree = degree;

      }
      public static String getName(){ return name;}
      public int getSalary(){
        if(degree.equals("Worker")) return 100;
        if(degree.equals("Foreman")) return 300;
        if(degree.equals("Supervisor")) return 700;
        if(degree.equals("Leader")) return 900;
        return 0;
      }

      public void pay(){
        money = money + getSalary();
        System.err.println("saalry = "+getSalary()+ " deg = "+degree);
      }

      public void promote(){
        if(money <= 2* getSalary())return;
        System.err.println("promoting" + getName());
        if(degree.equals("Worker")) degree = "Foreman";
        else if(degree.equals("Foreman")) degree = "Supervisor";
        else if(degree.equals("Supervisor")) degree = "Leader";
        else if(degree.equals("Leader")) {
          retired = true;
          if(Special) cermony();
        }
      }



      public void report(String degree){
        if (this.degree.equals(degree) == false) return;
        if(Special) System.out.print("special ");
        System.out.print(getName()+" ");
        if(!fired)System.out.print("("+degree+") "); // TODO
        System.out.print(getMoney()+" ");
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

      public static boolean get(int quan){
        if(money > quan){
          money-=quan;
          return true;
        }
        return false;
      }

      public static boolean special(){ return Special;}
      public static void makeSpecial(){ Special = true;}
      public static int getMoney(){
        return money;
      }


    }


  }
  // still god enough
