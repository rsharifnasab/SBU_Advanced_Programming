import java.util.*;
class Product{
  int id;
  String name;
  int price;
}
public class VendingMachine {
  int id;
  int salesCount;
  int salesAmount;
  HashMap<Product,Integer> products = new HashMap<Product,Integer>();

  public boolean buy (Product product) {
    int mojoudi = products.get(product);
    if(mojoudi<=0) return false;
    products.put(product,mojoudi-1);
    salesCount++;
    salesAmount += product.price;
    return true;
  }

  public void addProduct(Product p, int amount){
    products.put(p,amount);
  }


  public static void main(String[] args) {
    //ArrayList<Integer>  = new ArrayList<Integer>(n);

    Scanner s = new Scanner(System.in);
    int m = s.nextInt();
    Product [] allP = new Product[m];
    int [] allPC = new int[m];

    for (int i=0;i<m ;i++ ) {
      Product temp = new Product();
      temp.id = s.nextInt();
      System.err.println("s ok");
      s.nextLine();
      temp.name = s.nextLine();
      temp.price = s.nextInt();
      allP[i] = temp;
      allPC[i] = 0;
    }

    int n = s.nextInt();
    VendingMachine [] allV = new VendingMachine[n];
    for (int i=0;i<n ;i++ ) {
      allV[i] = new VendingMachine();
      allV[i].id = i+1;
      allV[i].salesCount = 0;
      allV[i].salesAmount = 0;

      int t = s.nextInt();
      for (int j=0;i<m ;i++ ) {
        allPC[i] = 0;
      }

      for (int j=0; j<t ;j++ ) {
        int proId = s.nextInt()-1;
        allPC[proId]++;
      }
      for (int j=0;i<m ;i++ ) {
        allV[i].addProduct(allP[j],allPC[j]);
      }
    }

    int b = s.nextInt();
    for (int i=0;i<b ;i++ ) {
      int shD = s.nextInt()-1;
      int shP = s.nextInt()-1;
      allV[shD].buy(allP[shP]);
    }
    for (int i = 0; i < n ; i++ ) {
      String id = Integer.toString(i+1);
      System.out.println(id + ":" + allV[i].salesCount + "," + allV[i].salesAmount );
    }
  }
}
