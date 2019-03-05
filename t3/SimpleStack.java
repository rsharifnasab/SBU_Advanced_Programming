public class SimpleStack{
  private String[] db = new String[101];
  private int size = 0;

  public boolean empty(){
    return size==0;
  }

  public int size(){
    return size;
  }

  public String push(String element){
    db[size++] = element;
    return element;
  }

  public String pop(){
    if (size()==0) return "error";
    String temp = db[size-1];
    db[size-1] = null;
    size--;
    return temp;
  }

  public String peek(){
    if (size()==0) return "error";
    return db[size-1];
  }

  public int search(String element){
    for (int i=0; i < size; i++) {
      if(db[i].equals(element)) return i;
    }
    return -1;
  }
  public void clear(){
    for (int i=0; i < size; i++) {
      db[i] = null;
    }
    size = 0;
  }

  public String toString(){
    if (size() ==0 ) return "{}";
    if (size() ==1 ) return "{" + db[0] + "}";

    String ans = "{" + db[0];
    for (int i=1; i < size; i++) {
      ans = ans + ", " + db[i];
    }
    ans = ans + "}";
    return ans;
  }

  public void pushAll(String... elements){
    for (String i : elements) {
      push(i);
    }
  }
/*
  public static void main(String[] args) {
    SimpleStack stack = new SimpleStack();
    System.out.println(stack.empty()); // true
    stack.push("1");
    System.out.println(stack.toString().equals("{1}")); // true
    for (int i = 2; i <= 5; i++) {
      stack.push(String.valueOf(i));
    }
    System.out.println(stack.toString().equals("{1, 2, 3, 4, 5}")); // true
    System.out.println(stack.peek()); // 5
    System.out.println(stack.pop()); // 5
    System.out.println(stack.pop()); // 4
    System.out.println(stack.toString()); // {1, 2, 3}
    System.out.println(stack.empty()); // false
    System.out.println(stack.size()); // 3
    System.out.println(stack.search("3")); // 2
    System.out.println(stack.search("5")); // -1
    stack.clear();
    System.out.println(stack.toString()); // {}
      System.out.println(stack.size()); // 0
      System.out.println(stack.empty()); // true
      System.out.println(stack.pop()); // error
      System.out.println(stack.peek()); // error

      // requirement: Slide 8
      stack.pushAll("Ali", "ali", "aLi", "alI", "ALI");
      System.out.println(stack.toString()); // {Ali, ali, aLi, alI, ALI}
      System.out.println(stack.peek().equals("Ali")); // false
      System.out.println(stack.peek().equals("ALi")); // false
      System.out.println(stack.peek().equals("ALI")); // true
    }
    */
  }
