import java.util.*;

class Adder implements Runnable{
  DB db;
  public Adder(DB db){ this.db = db; }
  @Override
  public void run(){
    while(true){
      Random rand = new Random();
      Integer next = rand.nextInt() % 100;
      db.addToFirst(next);
      System.out.println(next  + " added to list");
      System.out.flush();
      try{
        Thread.sleep(5000);
      } catch(Exception e){
        System.out.println("error in remover");
        System.out.flush();
      }
    }
  }
}


class Remover implements Runnable{
  DB db;
  public Remover(DB db){ this.db = db; }
  @Override
  public void run(){
    while(true)
    {
      if(db.size()> 0){
        Integer next = db.removeFromEnd();
        System.out.println(next  + " removed from list");
        System.out.flush();
      }else{
        System.out.println("not enoough element to remove from list");
        System.out.flush();
      }

      try{
        Thread.sleep(5000);
      } catch(Exception e){
        System.out.println("error in remover");
        System.out.flush();
      }
    }
  }
}



class DB{
  private ArrayList<Integer> innerList = new ArrayList<>();
  public void print(){
    System.out.print("list is:");
    for (Integer i : innerList )
      System.out.print(i + " ");
    System.out.println();
    System.out.flush();

  }
  public synchronized  void addToFirst(Integer element){  print(); innerList.add(element);  }
  public synchronized Integer removeFromEnd() { print(); return  innerList.remove(innerList.size()-1 ); }
  public synchronized int size() {return innerList.size();}
}


public class PC{
  static DB db = new DB();

  public static void main(String[] args) throws InterruptedException{
    System.out.println("before run");
    System.out.flush();
    Thread a = new Thread(new Adder(db));
    Thread b = new Thread(new Adder(db));
    Thread c = new Thread(new Adder(db));
    a.start();
    Thread.sleep(1000);
    b.start();
    Thread.sleep(1000);
    c.start();
    Thread.sleep(1000);
    System.out.println("after running a to  c");
    System.out.flush();
    Thread x = new Thread(new Remover(db));
    Thread y = new Thread(new Remover(db));
    Thread z = new Thread(new Remover(db));
    x.start();
    Thread.sleep(1000);
    y.start();
    Thread.sleep(1000);
    z.start();
    Thread.sleep(1000);

  }
}
