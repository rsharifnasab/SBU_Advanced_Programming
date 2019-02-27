public class Manage{

  public static Emplo[] db = new Emplo[100];
  public static int last =0;
  public static void main(String[] args) {

    do{
      db[last++] = new Emplo("Worker");
      System.out.println(db[0].getMoney());
    while(order!="exit");
  }


  public static class Emplo{
    public static String degree;
    private static String name;

    private static int money;
    public Emplo(String name,String degree){
      money = 0;
      this.name = name;
      this.degree = degree;
    }
    public int getSalary(){
      if(degree == "Worker") return 100;
      if(degree == "Foreman") return 300;
      if(degree == "Supervisor") return 700;
      if(degree == "Leader") return 900;
      return -1;
    }
    public int getMoney(){
      return money;
    }


  }


}
