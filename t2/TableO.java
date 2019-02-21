public class TableO{

  public static int  m,n;
  public static char [][] s;
  public static boolean [][] isV;

  public static void main(String[] args){

    java.util.Scanner sc = new java.util.Scanner(System.in);
    m = sc.nextInt();
    n = sc.nextInt();
    s = new char[m][];
    isV = new boolean[m][n];
    for (int i=0; i<m; i++ ) {
        s[i] = new char[n];
        for (int j=0;j<n;j++ ) {
            s[i][j] = sc.next().charAt(0);
            isV[i][j] = isVowel(s[i][j]);
        }
    }
    sc.close();

    int tedad = 0;

    sat:for(int satr=0; satr<m;satr++){
      beg:for (int begin=0; begin<n; begin++) {
        end:for (int end=begin+1; end<n; end++) {
          if(s[satr][end]==s[satr][end-1]) continue beg;
          if(isV[satr][end] && isV[satr][end-1] ) continue beg;
          tedad+=1;
        }
      }
    }

    sot:for(int sot=0; sot<n;sot++){ // sot
      beg:for (int begin=0; begin<m; begin++ ) {
        end:for (int end=begin+1; end<m; end++) {
            if( s[end][sot]==s[end-1][sot]) continue beg;
            if( isV[end][sot] && isV[end-1][sot] ) continue beg;
            tedad+=1;
        }
      }
    }
    System.out.println(tedad);
  }

  public static boolean isVowel (char c)
  {
    char[] v = {'a','e','i','o','u'};
    for (char i : v)
      if (c==i) return true;
    return false;
  }

/*

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


*/
