public class RotbeBand{

  public static int[] rank(String word, int prefix, int postfix, String[] documents){
    int[] a = {1,2};
    return a;
  }

  public static void main(String[] args){
    java.util.Scanner sc = new java.util.Scanner(System.in);
    int n = sc.nextInt();
    String word = sc.next();
    int p = sc.nextInt();
    int q = sc.nextInt();
    String[] documents = new String[n];
    //list[1].split("(,|:| )+");
    for (int i = 0;i<n ;i++ ) {
      documents[i] = sc.nextLine();
    }
    int [] ans = rank(word,p,q,documents);
    System.out.println(java.util.Arrays.toString(ans));
  }
}
