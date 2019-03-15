/**
 * custom class to handle very big integers
 * same as biginteger or big decimal
 * simple use: BigNum a = new BigNum("123");
 */
public class BigNum{
    private int[] num;
    private boolean sign;
    private static final int TR = 5000; // max number of digits

    /**
     * get a String from input
     * and add + to first if it is neccesary
     */
    private static String signHandle(String handle){
      if(handle.charAt(0) != '+' &&  handle.charAt(0) != '-' ) handle = "+" + handle;
      return handle;
    }


    /**
     * check whenever bignum is zero or not
     */
    public boolean isZero(){
      long sum = 0;
      for (int i : this.num)
        sum+= i;
      return sum==0;
    }

    /**
     * main constructor
     * construct a BigNum with a value of string and handle first + or -
     */
    public BigNum(String value){
      this();
      value = signHandle(value);
      int len = value.length();
      int numi = 0;
      for (int i=len-1; i>0;i-- ) {
        num[numi++] = value.charAt(i)-'0';
      }
      sign = value.charAt(0)=='-';
    }



    /**
     * a private (internal method) constructor
     * it will set Bignum to zero
     * same as calling BigNum("0")
     */
    private BigNum(){
      sign = false;
      num = new int[TR];
      for (int i =0;i < TR ; i++ ) {
        num[i]=0;
      }
    }


    /**
     * make a string from sign and all digits of bignum to print it!
     */
    public String toString(){

      int mean = tedadRagham();
      String ans = "";
      for (int i=0; i<mean; i++ ) {
        ans = num[i] + ans;
      }
      ans = (sign?"-":"") + ans;
      return ans;
    }

    /**
     * count digits of bignum and return an int
     */
    public int tedadRagham(){
      int mean = 1;
      for (int i=0; i<TR; i++ ) {
        if(num[i]!=0) mean = i;
      }
      return mean;
    }

    /**
     * simply add value to this and return the ans
     * not change this
     * use few submethods to manage adding
     */
    public BigNum add(BigNum value){
      return new BigNum("0");
    }

    /**
     * subtract value from this
     * it will not change this at all
     * it use add with minus of value ( a-b -> a+(-b) )
     */
    public BigNum subtract(BigNum value){
      value.sign = !value.sign;
      return add(value);
    }

    /**
     * multiply this and value digit by digit and handle the carry
     * it will not change this at all
     */
    public BigNum multiply(BigNum value){
      return new BigNum("0");
    }

    /**
     * calculate and return  this remainder of value
     * create a copy of this in ans
     * subtract value from ans until ans is less than zero
     * add value to ans one time
     * return ans
     */
    public BigNum remainder(BigNum value){
      return new BigNum("0");
    }

}
