public class Manage{

  public static void main(String[] args) {

  }


}

private class emplo{
  public String degree;
  private String name;

  private int money = 0;

  public int getSalary(){
    if(degree == "Worker") return 100;
    if(degree == "Foreman") return 300;
    if(degree == "Supervisor") return 700;
    if(degree == "Leader") return 900;
  }
  

}
