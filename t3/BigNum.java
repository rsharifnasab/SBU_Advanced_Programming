public class BigNum{
  private byte[] num;
  private boolean minus;
  private static final int TR = 5000; //TODO

  private String signHandle(String handle){
    char signChar = handle.charAt(0);
    if(signChar == '+' || signChar == '-') return handle;
    return "+" + handle;
  }

  private boolean isMinus(String input){
    input = signHandle(input);
    return input.charAt(0) == '-';
  }

  public boolean isMinus(){
    return minus;
  }

  public byte M(){
    if(isMinus()) return -1;
    return 1;
  }


  private boolean isZero(){
    for (int i = 0; i < num.length; i++) {
      if(num[i] != 0) return false;
    }
    return true;
  }

  public BigNum(String value){
    value = signHandle(value);
    minus = isMinus(value);
    num = new byte [TR];
    for (int i = 1; i < value.length(); i++ ) {
      num[value.length() - (i+1) ] = (byte) (value.charAt(i) - '0');
      //System.err.println("i-1 :" + (i-1) + " num[i-1] :" + num[i-1]);
    }
  }


  public BigNum(){
    this( (byte) 0);
  }

  public BigNum(byte value){
    num = new byte [TR];
    for (int i = 0; i < TR; i++ ) {
      num[i] = value;
    }
  }

  public String toString(){
    String ans = "";
    int tedad = tedadRagham();
    for (int i = 0; i < tedad; i++) {
      ans = num[i] + ans;
    }
    if (isMinus() && !isZero()) ans = "-" + ans;
    return ans;
  }

  private int tedadRagham(){
    int meanFul = 1;
    for (int i = 0; i < TR ; i++ ) {
      if(num[i] != 0 ) meanFul = i+1;
    }
    return meanFul;
  }

  public boolean bt(BigNum other){ //check if this is bigger than other(true) or not(false)
    if(this.isMinus() &&  !other.isMinus() ) return false;
    if(!this.isMinus() &&  other.isMinus() ) return true;
    for (int i=TR -1; i>=0 ;i-- ) {
      if(this.num[i] > other.num[i] ) return !this.isMinus();
      if(this.num[i] < other.num[i] ) return this.isMinus();
    }
    return false;
  }

  public BigNum[] sort2 ( BigNum a, BigNum b){
    BigNum[] ans = new BigNum[2];
    if(a.bt(b)){
      ans[0] = a;
      ans[1] = b;
    }
    else{
      ans[0] = b;
      ans[1] = a;
    }
    return ans;
  }

  public boolean bt(BigNum other,boolean ignore){ //check if (abs)this is bigger than other(true) or not(false)
    if(!ignore) bt(other);
    for (int i=TR -1; i>=0 ;i-- ) {
      if(this.num[i] > other.num[i] ) return !this.isMinus();
      if(this.num[i] < other.num[i] ) return this.isMinus();
    }
    return false;
  }


  public BigNum[] sort2IgnoreMinus ( BigNum a, BigNum b){
    BigNum[] ans = new BigNum[2];
    if(a.bt(b,false)){
      ans[0] = a;
      ans[1] = b;
    }
    else{
      ans[0] = b;
      ans[1] = a;
    }
    return ans;
  }

  private BigNum add2plus(BigNum a , BigNum b){
    BigNum ans = new BigNum();
    byte carr = 0;
    for (int i = 0; i<TR; i++ ) {
      byte temp = (byte) ( a.num[i] + b.num[i] + carr);
      ans.num[i] = (byte) (temp%10);
      carr = (byte) (temp/10);
    }
    return ans;
  }

  private BigNum add2minus(BigNum a , BigNum b){
    a.minus =  false;
    b.minus =  false;
    BigNum ans = add2plus(a,b);
    ans.minus = true;
    return ans;
  }


  private BigNum add2O(BigNum a , BigNum b){
    // a is positive , b is negative
    BigNum []  s = sort2IgnoreMinus(a,b);
    BigNum ans = new BigNum();
    byte carr = 0;
    for (int i = 0; i<TR; i++ ) {
      byte temp = (byte) ( s[0].num[i] - s[1].num[i] + carr);
      if(temp < 0){
        temp+=10;
        carr = -1;
      } else carr = 0;
      ans.num[i] = (byte) (temp);
    }
    ans.minus = s[0].minus;
    return ans;
  }


  public BigNum add(BigNum value){
    BigNum[] s = sort2(this,value);

    if(!s[1].isMinus()) return add2plus(s[0],s[1]); // both are positive
    if(s[0].isMinus()) return add2minus(s[0],s[1]); // both are negative
    return add2O(s[0],s[1]);
  }

  public BigNum subtract(BigNum value){
    BigNum value2 = new BigNum(value.toString());
    value2.minus = !value2.minus;
    return add(value2);
  }


  public BigNum multiply(BigNum value){
    BigNum ans = new BigNum();

    for (int i = 0; i<TR/2; i++ ) {
      BigNum row = new BigNum();
      byte carr = (byte) 0;
      for (int j = 0; j<TR/2; j++ ) {
        byte temp = (byte) ( value.num[i] * this.num[j] + carr);
        row.num[i+j] = (byte) (temp%10); //TODO
        carr = (byte) (temp/10);
      }
      ans = ans.add(row);
    }
    ans.minus = (this.isMinus() ^ value.isMinus());
    return ans;
  }

  public BigNum remainder(BigNum value){
    BigNum ans = new BigNum();

    return ans;
  }

  public static void main(String[] args) {
    do{
      BigNum bigNum1 = new BigNum("-123");
      BigNum bigNum2 = new BigNum("456");
      System.out.println(bigNum1.multiply(bigNum2));
      System.out.println();
    }while(false);


    BigNum bigNum1 = new BigNum("123");
    BigNum bigNum2 = new BigNum("456");
    System.out.println(bigNum1.add(bigNum2));
    System.out.println(bigNum1.multiply(bigNum2));
    System.out.println(bigNum1.subtract(bigNum2));
    System.out.println(bigNum2.remainder(bigNum1));
    System.out.println(bigNum1);
    System.out.println(bigNum2);
    System.out.println();

    bigNum1 = new BigNum("+1234567");
    bigNum2 = new BigNum("-987654");
    System.out.println(bigNum1.add(bigNum2));
    System.out.println(bigNum1.multiply(bigNum2));
    System.out.println(bigNum1.subtract(bigNum2));
    System.out.println(bigNum1);
    System.out.println(bigNum2);
    System.out.println();

    bigNum1 = new BigNum("-123");
    bigNum2 = new BigNum("123");
    System.out.println(bigNum1.add(bigNum2));
  }

}
