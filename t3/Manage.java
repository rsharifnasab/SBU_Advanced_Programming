public class Manage{

  public static Emplo[] db = new Emplo[300];
  public static int last =0;

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
      int quan = sc.nextInt();
      if(!db[ind].get(quan))
        System.out.println("NotEnoughMoney");

    }

        public static void special(){
          String name = sc.next();
          int ind = name2index(name);
          db[ind].makeSpecial();
        }

  public static int name2index(String name){
    for (int i = 0;i < 300 ;  i++ ) {
      if(db[i].getName().equals(name)) return i;
    }
  }


  public static void main(String[] args) {
    java.util.Scanner sc = new java.util.Scanner(System.in);

    do{
      String order = sc.next();

      if(order.equals("hire") ) hire();
      if(order.equals("pay")) pay();
      if(order.equals("get")) get();
      if(order.equals("special")) get();
      //
      //System.out.println(db[0].getMoney());
      while(!order!.equals("exit"));
    }


    public static class Emplo{
      public static String degree;
      private static String name;
      private static boolean Special;
      private static int money;
      public Emplo(String name,String degree){
        money = 0;
        Special = false;
        this.name = name;
        this.degree = degree;
      }
      public static String getName(){ return name;}
      public int getSalary(){
        if(degree == "Worker") return 100;
        if(degree == "Foreman") return 300;
        if(degree == "Supervisor") return 700;
        if(degree == "Leader") return 900;
        return -1;
      }
      public void pay(){
        money = money + getSalary();
      }
      public static boolean get(int quan){
        if(money > quan){
          money-=quan;
          return true;
        }
        return false;
      }

      public static boolean special(){ return Special;}
      public static makeSpecial(){ Special = true;}
      public static int getMoney(){
        return money;
      }


    }


  }
// still god enough
