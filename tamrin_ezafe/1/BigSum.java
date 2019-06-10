import java.util.Scanner;
/**
 * custom class to handle very big integers
 * same as biginteger or big decimal
 * simple use: BigNum a = new BigNum("123");
 */
class BigNum{
    private byte[] num;
    private boolean minus;
    private static final int TR = 5000; // max number of digits

    /**
     * get a String from input
     * and add + to first if it is neccesary
     */
    private static String signHandle(String handle){
        char signChar = handle.charAt(0);
        if(signChar == '+' || signChar == '-') return handle;
        return "+" + handle;
    }

    /**
     * get a value(string) as a parametr
     * and check if it is minus or not
     */
    public static boolean isMinus(String input){
        input = signHandle(input);
        return input.charAt(0) == '-';
    }

    /**
     * check whenever bignum is minus or not
     */
    public boolean isMinus(){
        return minus;
    }

    /**
     * check whenever bignum is zero or not
     */
    public boolean isZero(){
        for (int i = 0; i < num.length; i++) {
            if(num[i] != 0) return false;
        }
        return true;
    }

    /**
     * main constructor
     * construct a BigNum with a value of string and handle first + or -
     */
    public BigNum(String value){
        this();
        value = signHandle(value);
        minus = isMinus(value);
        for (int i = 1; i < value.length(); i++ ) {
            num[value.length() - (i+1)] = (byte) (value.charAt(i) - '0');
        }
    }


    /**
     * a private (internal method) constructor
     * it will set Bignum to zero
     * same as calling BigNum("0")
     */
    private BigNum(){
        this((byte)0);
    }


    /**
     * a private (internal method) constructor
     * it will set every bignum digit Bignum to value
     */
    private BigNum(byte value){
        num = new byte [TR];
        for (int i = 0; i < TR; i++ ) {
            num[i] = value;
        }
    }

    /**
     * make a string from sign and all digits of bignum to print it!
     */
    public String toString(){
        String ans = "";
        int tedad = tedadRagham();
        for (int i = 0; i < tedad; i++) {
            ans = num[i] + ans;
        }
        if (isMinus() && !isZero()) ans = "-" + ans;
        return ans;
    }

    /**
     * count digits of bignum and return an int
     */
    public int tedadRagham(){
        int meanFul = 1;
        for (int i = 0; i < TR ; i++ ) {
            if(num[i] != 0 ) meanFul = i+1;
        }
        return meanFul;
    }

    /**
     * give 2 bignums and sort them and return an array
     * to make sure that s[0] is bigger than s[1]
     */
    private BigNum[] sort2 ( BigNum a, BigNum b){
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

    /**
     * check if this is bigger than other or not
     * if boolean is true, it will ignore signs (compare abs's)
     */
    private boolean bt(BigNum other,boolean ignoreSign){
        if(!ignoreSign){
            if(this.isMinus() &&  !other.isMinus() ) return false;
            if(!this.isMinus() &&  other.isMinus() ) return true;
        }
        for (int i=TR -1; i>=0 ;i-- ) {
            if(this.num[i] > other.num[i] ) return !this.isMinus();
            if(this.num[i] < other.num[i] ) return this.isMinus();
        }
        return false;
    }

    /**
     * same as sort2 but ignore signs
     */
    private BigNum[] sort2IgnoreMinus ( BigNum a, BigNum b){
        BigNum[] ans = new BigNum[2];
        if(a.bt(b,true)){
            ans[0] = a;
            ans[1] = b;
        }
        else{
            ans[0] = b;
            ans[1] = a;
        }
        return ans;
    }

    /**
     * simplest add submethod
     * adding 2 positive bignums
     * digit by digit and carry return to next digit
    */
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

    /**
     * add 2 negative bignums
     * it will use add2plus with abs(a) and abs(b) and negative the answer
     */
    private BigNum add2minus(BigNum a , BigNum b){
        a.minus =  false;
        b.minus =  false;
        BigNum ans = add2plus(a,b);
        ans.minus = true;
        return ans;
    }

    /**
     * add  a positive and negative bignum
     * first of all make sure that s[0] is bigger in abs
     * subtract digit by digit
     */
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

    /**
     * simply add value to this and return the ans
     * not change this
     * use few submethods to manage adding
     */
    public BigNum add(BigNum value){
        BigNum[] s = sort2(this,value);
        if(!s[1].isMinus()) return add2plus(s[0],s[1]); // both are positive
        if(s[0].isMinus()) return add2minus(s[0],s[1]); // both are negative
        return add2O(s[0],s[1]);
    }

    /**
     * subtract value from this
     * it will not change this at all
     * it use add with minus of value ( a-b -> a+(-b) )
     */
    public BigNum subtract(BigNum value){
        BigNum value2 = new BigNum(value.toString());
        value2.minus = !value2.minus;
        return add(value2);
    }

    /**
     * multiply this and value digit by digit and handle the carry
     * it will not change this at all
     */
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

    /**
     * calculate and return  this remainder of value
     * create a copy of this in ans
     * subtract value from ans until ans is less than zero
     * add value to ans one time
     * return ans
     */
    public BigNum remainder(BigNum value){
        BigNum ans  = this;
        if(this.isMinus() || value.isMinus()) return ans; // error, less than zero!
        while(!ans.isMinus()){
            ans = ans.subtract(value); // handle zero answer
            if(ans.isZero()) return ans;
        }
        ans = ans.add(value);
        return ans;
    }
}


public class BigSum{
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    BigNum sum = new BigNum("0");
    for(int i =0; i < n; i++){
        BigNum t = new BigNum(sc.next());
        sum  = sum.add(t);
    }
    System.out.println(sum);


  }
}
