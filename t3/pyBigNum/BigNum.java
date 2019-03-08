import org.python.util.*;
public class BigNum{
  private String value;
  private PythonInterpreter interpreter = new PythonInterpreter();

  public BigNum(String value){
    this.value = value;
    interpreter.exec("from operator import *");
  }


  public String toString(){
    return this.value;
  }

  public String add(BigNum other){
    PyObject someFunc = interpreter.get("add");
    PyObject result = someFunc.__call__(new PyString(this.value) , new PyString(other.value));
    String realResult = (String) result.__tojava__(String.class);
    return realResult;
  }


public static void main(String[] args) {
    BigNum bigNum1 = new BigNum("123");
    BigNum bigNum2 = new BigNum("456");
    System.out.println(bigNum1.add(bigNum2));
    System.out.println(bigNum1);
    System.out.println(bigNum2);
    System.out.println();

    bigNum1 = new BigNum("+1234567");
    bigNum2 = new BigNum("-987654");
    System.out.println(bigNum1.add(bigNum2));
    System.out.println(bigNum1);
    System.out.println(bigNum2);
    System.out.println();

    bigNum1 = new BigNum("-123");
    bigNum2 = new BigNum("123");
    System.out.println(bigNum1.add(bigNum2));
}

}
