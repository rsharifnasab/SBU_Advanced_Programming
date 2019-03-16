public class Main{
  public static void main(String[] args) {
    A[] elements = { new D(), new A(), new C(), new B() };
    for (int i = 0; i < elements.length; i++) {
        System.out.println(elements[i].method1());
        System.out.println(elements[i].method2());
        System.out.println();
    }
}
}
