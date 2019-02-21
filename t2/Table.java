public class Table{

  public static int  m,n;
  public static java.util.Scanner sc;
  public static char [][] s;
  public static boolean [][] isV;
  public static void main(String[] args){
    sc = new java.util.Scanner(System.in);
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

    for(int l=0; l<m;l++){
      for (int i=0; i<n; i++ ) {
        for (int j=i+2; j<=n; j++) {
          tedad+=(wordCheckS(i,j,l))?1:0;
        }
      }
    }

    for(int l=0; l<n;l++){
      for (int i=0; i<m; i++ ) {
        for (int j=i+2; j<=m; j++) {
          tedad+=(wordCheck2(i,j,l))?1:0;
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

  public static boolean wordCheckS(int  begin,int  end, int  satr){
    int  len =  end - begin;
    char [] word = new char [len];
    for (int i =0; i<len;i++ )  word[i] = s[satr][i+begin];

    for (int i =0; i+1<len;i++ ){
        if(word[i]==word[i+1]) return false;
        if(isV[satr][i+begin] && isV[satr][i+1+begin] ) return false;
    }
      return true;
  }



  public static boolean wordCheck2(int  begin,int  end, int  sot){
    int  len =  end - begin;
    char [] word = new char [len];
    for (int i =0; i<len;i++ )  word[i] = s[i+begin][sot];

    for (int i =0; i+1<len;i++ ){
        if(word[i]==word[i+1]) return false;
        if( isV[i+begin][sot] && isV[i+1+begin][sot] ) return false;
    }
    return true;
  }
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
