public class Table{

  public static < E > void printA( E[] inputArray ) {
      // Display array elements
      for(E element : inputArray) {
         System.out.printf("%s ", element);
      }
      System.out.println();
   }

   public static < E > void print( E input ) {
       System.out.println(input);
    }

  public static < E > void print2A( E[][] input2Array ) {
      // Display array elements
      for (E[] input:input2Array ) {
          for(E element : input) {
            System.out.printf("%s ", element);
          }
        System.out.println();
      }
   }


  public static void main(String[] args){
    java.util.Scanner sc = new java.util.Scanner(System.in);

    int m = sc.nextInt();
    int n = sc.nextInt();
    Character [][]s = new Character[m][];
    for (int i=0;i<m ;i++ ) {
        s[i] = new Character[n];
        for (int j=0;j<n;j++ ) {
            s[i][j] = sc.next().charAt(0);
        }
    }
    sc.close();


    


  }
}
