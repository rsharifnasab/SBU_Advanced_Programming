import java.util.*;
class Node{
  String name;
  List<Node> nexts = new ArrayList<Node>();
  Node before = null;
  public Node(String value){
    name = value;
  }
}

public class Shajare{

  static final Integer max = 110;
  static SortedSet<String> names = new TreeSet<String>();
  static String[][] db = new String[max][];
  static Scanner sc = new Scanner(System.in);
  static int n;
  static List<Node> nodes = new ArrayList<Node>();


  public static Node name2node(String name){
    for (int i=0;i < nodes.size() ; i++) {
      if(name.equals(nodes.get(i).name)) return nodes.get(i);
    }
    return null;
  }
  public static void main(String[] args) {

    n = Integer.parseInt(sc.nextLine()); // number of lines
    for (int i = 0;i < n ;i++ ) { // get data from user
      String temp = sc.nextLine();
      db[i] = temp.split(" ");
      names.add(db[i][0]);
      names.add(db[i][1]);
    }
    for (String s : names) { // create node of each name
      Node n = new Node(s);
      nodes.add(n);
    }
    for (int i = 0; i<n; i++ ) { // find relations
      Node father = name2node(db[i][1]);
      Node son = name2node(db[i][0]);
      father.nexts.add(son);
      son.before = father;
    }
    for (Node n : nodes ) {
      if (n.before == null)System.out.println(" father of fathers,  this : " + n.name);
      else System.out.println(" father : "+ n.before.name + " this : " + n.name);
    }
    Node [][] toPrint = new Node[max][max];
    Node n = nodes.get(0);
    while(n.before != null) n = n.before; //finad father of fathers
    for(int i = 1;i<nodes.size();i++){
      
    }


  }
}
