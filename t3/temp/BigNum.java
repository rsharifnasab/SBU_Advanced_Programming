/**
 * custom class to handle very big integers
 * same as biginteger or big decimal
 * simple use: BigNum a = new BigNum("123");
 */
public class BigNum{
    private byte[] num;
    private boolean minus;
    private static final int TR = 5000; // max number of digits

    /**
     * get a String from input
     * and add + to first if it is neccesary
     */
    private static String signHandle(String handle){

    }


    /**
     * check whenever bignum is zero or not
     */
    public boolean isZero(){
    }

    /**
     * main constructor
     * construct a BigNum with a value of string and handle first + or -
     */
    public BigNum(String value){

    }


    /**
     * a private (internal method) constructor
     * it will set Bignum to zero
     * same as calling BigNum("0")
     */
    private BigNum(){

    }


    /**
     * a private (internal method) constructor
     * it will set every bignum digit Bignum to value
     */
    private BigNum(byte value){

    }

    /**
     * make a string from sign and all digits of bignum to print it!
     */
    public String toString(){

    }

    /**
     * count digits of bignum and return an int
     */
    public int tedadRagham(){
    }

    /**
     * simply add value to this and return the ans
     * not change this
     * use few submethods to manage adding
     */
    public BigNum add(BigNum value){
    }

    /**
     * subtract value from this
     * it will not change this at all
     * it use add with minus of value ( a-b -> a+(-b) )
     */
    public BigNum subtract(BigNum value){
    }

    /**
     * multiply this and value digit by digit and handle the carry
     * it will not change this at all
     */
    public BigNum multiply(BigNum value){

    }

    /**
     * calculate and return  this remainder of value
     * create a copy of this in ans
     * subtract value from ans until ans is less than zero
     * add value to ans one time
     * return ans
     */
    public BigNum remainder(BigNum value){

}
