public class BigNum{
  private byte[] num;
  private boolean minus;
  private static final int TR = 50000;

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
      num[i-1] = (byte) (value.charAt(i) - '0');
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
    if (isMinus()) ans = "-";
    int tedad = tedadRagham();
    for (int i = 0; i < tedad; i++) {
      ans = ans + num[i];
    }
    return ans;
  }

  private int tedadRagham(){
    int meanFul = 1;
    for (int i =0; i < TR ; i++ ) {
      if(num[i] != 0 ) meanFul = i+1;
    }
    return meanFul;
  }

  /*
  boolean swap = false;
for(int j = 0; j < number1.length && negative; j++){
    if(number2[j] > number1[j]){
        swap = true;
        int temp[] = number1;
        number1 = number2;
        number2 = temp;
        break;
    } else if(number1[j] > number2[j]){
        break;
    }
}

int[] result = new int[number1.length];
int carry = 0;
for(int i = number1.length - 1; i >= 0; i--) {
    int newDigit = (negative ? number1[i] - number2[i] : number1[i] + number2[i]);

    newDigit += carry;
    if (newDigit >= 10) {
        carry = 1;
        newDigit -= 10;
    } else if (newDigit < 0) {
        carry = -1;
        newDigit += 10;
    } else {
        carry = 0;
    }
    result[i] = newDigit;
}

// Convert result back into a string.
String resultString = "";
for(int j = 0; j <result.length; j++){
    resultString += (result[j] + "");
}

// Apply carry.
if(carry == 1) {
    return "1" + resultString;
} else if(carry == -1 || swap) {//if swap is set sign is -
    return "-" + resultString;
} else {
    return resultString;
}

*/

  public BigNum add(BigNum value){ //TODO
    BigNum ans = new BigNum();
    byte carr = 0;
    for (int i = 0; i+1<TR; i++ ) {
      byte temp = (byte) (this.M() * this.num[i] + value.M() * value.num[i] + carr);
      ans.num[i] = (byte) (temp%10);
      if (temp > 9) carr = (byte) (temp - 10);
      else carr = 0;
    }
    num[TR-1] = carr;
    return ans;
  }

}
